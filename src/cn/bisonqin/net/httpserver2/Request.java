package cn.bisonqin.net.httpserver2;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * 封装Request
 * Created by Basil on 2017/3/10.
 */
public class Request {

    private static final String CRLF = "\r\n";      //换行符

    private String method;                  //请求的方法
    private String url;                     //请求的路径
    private Map<String, List<String>> parameterMapValue;        //请求的参数

    //内部
    private InputStream is;
    private String requestInfo;

    public Request() {
        method = "";
        url = "";
        parameterMapValue = new HashMap<>();
        requestInfo = "";
    }

    public Request(InputStream is) {
        this();
        this.is = is;
        byte[] data = new byte[20480];              //指定缓冲数组大小
        try {
            int len = is.read(data);                //读取流的内容到缓冲字节数组中
            requestInfo = new String(data, 0, len); //读取请求信息
            System.out.println(requestInfo);
        } catch (IOException e) {
            return;
        }
        //分析头信息
        parseRequestInfo();
    }

    /**
     * 分析请求信息
     */
    private void parseRequestInfo() {
        if(null == requestInfo || (requestInfo = requestInfo.trim()).equals("")) {
            return;
        }

        /**
         * ===========================================================
         * 从信息的首行分解出：请求方式，请求路径，请求参数（GET可能存在）
         * 如：GET /index.html?name=123&psw=123 HTTP/1.1
         *
         * 如果为POST方式，请求参数可能在正文中
         * ===========================================================
         */
        String paramString = "";            //接收请求参数

        //1、获取请求参数
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));         //截取首字符到第一行结束的换行符为止

        //获取请求方法
        int idx = requestInfo.indexOf("/");         //第一个"/"的位置
        this.method = firstLine.substring(0, idx).trim();

        //获取请求路径
        String urlStr = firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
        if(this.method.equals(RequestMethod.POST.toString())) {
            this.url = urlStr;
            paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF.trim()));
        }else if(this.method.equals(RequestMethod.GET.toString())) {
            if(urlStr.contains("?")) {                              //是否存在参数
                String[] urlArray = urlStr.split("\\?");            //？属于特殊字符
                this.url = urlArray[0];                             //获取资源路径
                paramString = urlArray[1];                          //获取参数
            }else {
                this.url = urlStr;
            }
        }

        //2、将请求参数封装进Map中
        if(paramString.equals("")) {                    //不存在请求参数
            return;
        }else {
            parseParams(paramString);
        }

    }

    /**
     * 分割请求参数并传进Map
     * @param paramString
     */
    public void parseParams(String paramString) {
        //将字符串转为数组
        StringTokenizer token = new StringTokenizer(paramString, "&");
        while(token.hasMoreTokens()) {
            String keyValue = token.nextToken();
            String[] keyValues = keyValue.split("=");
            if(keyValues.length == 1) {                     //只有键的情况下
                keyValues = Arrays.copyOf(keyValues, 2);    //扩大该键值的数组长度为2
                keyValues[1] = null;                        //置值为空
            }

            //转换成Map
            String key = keyValues[0].trim();
            String value = null == keyValues[1] ? null : decodeString(keyValues[1].trim(), "GBK");
            if(!parameterMapValue.containsKey(key)) {
                parameterMapValue.put(key, new ArrayList<String>());
            }

            List<String> values = parameterMapValue.get(key);               //一个键可能有多个值
            values.add(value);
        }
    }

    /**
     * 解决中文乱码的问题
     * @param value
     * @param code
     * @return
     */
    private String decodeString(String value, String code) {
        try {
            return URLDecoder.decode(value, code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据页面的name获取对应的多个值
     * @param name
     * @return 返回一个String数组，因为底层很多都是用数组的
     */
    public String[] getParameterValues(String name) {
        List<String> values = parameterMapValue.get(name);
        if(values == null) {
            return null;
        }else {
            return values.toArray(new String[0]);
        }
    }

    /**
     * 根据页面的name获取对应的值
     * @param name
     * @return
     */
    public String getParameter(String name) {
        String[]  values = getParameterValues(name);
        if(null == values) {
            return null;
        }
        return values[0];
    }

    public String getUrl() {
        return this.url;
    }
}
