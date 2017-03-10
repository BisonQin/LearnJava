package netdemo.udp;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL基本方法
 * Created by Basil on 2017/3/8.
 */
public class URLDemo1 {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html?username=bison");
        System.out.println("协议" + url.getProtocol());
        System.out.println("域名" + url.getHost());
        System.out.println("端口" + url.getPort());
        System.out.println("资源" + url.getFile());
        System.out.println("相对路径" + url.getPath());
        System.out.println("锚点" + url.getRef());
        System.out.println("参数" + url.getQuery());      //如果存在锚点，返回null；不存在返回正确
    }
}
