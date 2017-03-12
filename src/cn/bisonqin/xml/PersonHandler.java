package cn.bisonqin.xml;

import jdk.internal.org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储对象
 * Created by Basil on 2017/3/12.
 */
public class PersonHandler extends DefaultHandler{

    private List<Person> persons;
    private Person person;
    private String tag;             //记录标签名

    public List<Person> getPersons() {
        return persons;
    }

    /**
     * 处理文档开始
     * @throws SAXException
     */
    @Override
    public void startDocument() throws org.xml.sax.SAXException {
        persons = new ArrayList<>();
    }

    /**
     * 开始一个元素
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws org.xml.sax.SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        //System.out.println("开始一个元素" + qName);
        if(null != qName) {
            tag = qName;
            if(qName.equals("person")) {
                person = new Person();
            }
        }
    }

    /**
     * 内容
     * @param chars
     * @param i
     * @param i1
     * @throws SAXException
     */
    @Override
    public void characters(char[] chars, int i, int i1) throws org.xml.sax.SAXException {
        String str = new String(chars, i, i1);
        if(null != tag && tag.equals("name")) {
            person.setName(str);
        }else if(null != tag && tag.equals("age")) {
            Integer age = Integer.valueOf(str);
            person.setAge(age);
        }
    }

    /**
     * 结束一个元素
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        //System.out.println("结束一个元素" + qName);
        if(qName.equals("person")) {
            this.persons.add(person);
        }
        tag = null;
    }

    /**
     * 文档处理结束
     * @throws SAXException
     */
    @Override
    public void endDocument() throws org.xml.sax.SAXException {
    }
}
