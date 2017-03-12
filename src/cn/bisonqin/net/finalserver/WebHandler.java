package cn.bisonqin.net.finalserver;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * xml解析处理类
 * Created by Basil on 2017/3/12.
 */
public class WebHandler extends DefaultHandler {

    private List<Entity> entityList;
    private List<Mapping> mappingList;
    private Entity entity;
    private Mapping mapping;
    private String begingTag;
    private boolean isMap;

    public List<Entity> getEntityList() {
        return entityList;
    }

    public List<Mapping> getMappingList() {
        return mappingList;
    }

    @Override
    public void startDocument() {
        //文档解析开始
        entityList = new ArrayList<>();
        mappingList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        //元素解析开始
        if(null != qName) {
            begingTag = qName;

            if(qName.equals("servlet")) {
                isMap = false;
                entity = new Entity();
            }else if(qName.equals("servlet-mapping")) {
                isMap = true;
                mapping = new Mapping();
            }
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        //内容读取
        if(null != begingTag) {
            String str = new String(chars, start, length);

            if(!isMap) {
                if(begingTag.equals("servlet-name")) {
                    entity.setName(str);
                }else if(begingTag.equals("servlet-class")) {
                    entity.setCla(str);
                }
            }else {
                if(begingTag.equals("servlet-name")) {
                    mapping.setName(str);
                }else if(begingTag.equals("url-pattern")) {
                    mapping.getUrlPattern().add(str);
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        //元素解析结束
        if(null != qName) {
            if(qName.equals("servlet")) {
                entityList.add(entity);
            }else if (qName.equals("servlet-mapping")) {
                mappingList.add(mapping);
            }
        }

        begingTag = null;
    }

    @Override
    public void endDocument() {
        //文档解析结束
    }

//    public static void main(String[] args) throws ParserConfigurationException, org.xml.sax.SAXException, IOException {
//        //获取解析工厂
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        //获取解析器
//        SAXParser sax = factory.newSAXParser();
//        //指定XML处理器
//        WebHandler handler = new WebHandler();
//        sax.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/bisonqin/net/finalserver/web.xml"), handler);
//
//        System.out.println(handler.getEntityList());
//        System.out.println(handler.getMappingList());
//    }
}
