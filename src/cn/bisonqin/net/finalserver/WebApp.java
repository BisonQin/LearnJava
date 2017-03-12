package cn.bisonqin.net.finalserver;

import cn.bisonqin.net.finalserver.servlet.Servlet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Basil on 2017/3/11.
 */
public class WebApp {

    private static ServletContext context;

    static {
        //获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //获取解析器
        SAXParser sax = null;
        try {
            sax = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        //指定XML处理器
        WebHandler handler = new WebHandler();
        try {
            sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/bisonqin/net/finalserver/web.xml"), handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将List转成Map
        context = new ServletContext();

        Map<String, String> servlet = context.getServelet();
        for(Entity entity : handler.getEntityList()) {
            servlet.put(entity.getName(), entity.getCla());
        }

        Map<String, String> mapping = context.getMapping();
        for(Mapping map : handler.getMappingList()) {
            List<String> urls = map.getUrlPattern();
            for(String url : urls) {
                mapping.put(url, map.getName());
            }
        }
    }

    public static Servlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(null == url || url.trim().equals("")) {
            return null;
        }
        //根据字符串（完整路径）创建对象
        String name = context.getServelet().get(context.getMapping().get(url));
        return (Servlet)Class.forName(name).newInstance();      //确保空构造
    }
}
