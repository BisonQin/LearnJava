package cn.bisonqin.net.httpserver3;

/**
 * 存储servlet的实体
 <servlet>
     <servlet-name>login</servlet-name>
     <servlet-class>net.httpserver3.LoginServlet</servlet-class>
 </servlet>
 * Created by Basil on 2017/3/12.
 */
public class Entity {

    private String name;
    private String cla;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
}
