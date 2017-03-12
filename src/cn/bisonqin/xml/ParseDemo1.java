package cn.bisonqin.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * 解析xml文件
 * Created by Basil on 2017/3/12.
 */
public class ParseDemo1 {

    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        //1、获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2、从解析工厂获取数据
        SAXParser parse = factory.newSAXParser();
        //3、加载文档Document注册处理器
        //4、编写处理器
        PersonHandler handler = new PersonHandler();
        parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/bisonqin/xml/person.xml"), handler);

        List<Person> persons = handler.getPersons();
        for(Person p : persons) {
            System.out.println(p.getName() + "-->" +p.getAge());
        }
    }
}
