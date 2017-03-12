package cn.bisonqin.net.httpserver2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 封装响应信息
 * Created by Basil on 2017/3/10.
 */
public class Response {

    private static final String CRLF = "\r\n";      //换行符
    private static final String BLANK = " ";        //空格

    private StringBuilder headInfo;                 //请求头信息
    private StringBuilder content;                  //正文
    private int len;                                //正文长度

    private BufferedWriter bw;

    public Response() {
        this.headInfo = new StringBuilder();
        this.content = new StringBuilder();
        this.len = 0;
    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            headInfo = null;
        }
    }

    /**
     * 构建正文 + 回车
     * @param content
     */
    public Response println(String content) {
        this.content.append(content).append(CRLF);
        len += (content + CRLF).getBytes().length;
        return this;
    }

    private void createHeadInfo(int code) {
        //1、HTTP协议版本、状态代码、描述
        headInfo.append("HTTP/1.1").append(BLANK).append(code);
        switch(code) {
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("NOT FOUND");
                break;
            case 505:
                headInfo.append("SERVER ERROR");
                break;
        }

        headInfo.append(CRLF);

        //2、响应头
        headInfo.append("Server:Bison Server/1.0.0").append(CRLF);
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Content-type:text/html;charset=UTF-8").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF);    //长度为字节长度
        headInfo.append(CRLF);              //分隔符，分割响应头和正文的信息
    }

    public void pushToClient(int code) throws IOException {
        if(null == headInfo) {
            code = 500;
        }
        createHeadInfo(code);
        //头信息加分隔符
        bw.append(headInfo.toString());
        //正文
        bw.append(content.toString());
        bw.flush();
    }

    public void close() {
        CloseUtils.closeAll(bw);
    }
}
