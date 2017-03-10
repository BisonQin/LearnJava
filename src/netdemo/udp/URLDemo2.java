package netdemo.udp;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络连接
 * Created by Basil on 2017/3/8.
 */
public class URLDemo2 {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com");          //主页默认资源

//        try {
//            InputStream is = url.openStream();
//            byte[] flush = new byte[1024];
//            int len = 0;
//            while(-1 != (len = is.read(flush))) {
//                System.out.println(new String(flush, 0 , len));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),  "utf-8"));
            String msg = null;
            while (null != (msg = br.readLine())){
                System.out.println(msg);
                bw.append(msg);
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
