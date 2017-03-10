package annotationdemo;

/**
 * Created by Basil on 2017/2/25.
 */
@MyFirstAnnotation(name = "Some name", description = "Some description")
public class UsingMyFirstAnnotation {

    // 在构造器的注解
    // The value of the element name is "John"
    // Value element description is "Write by John".
    @MyFirstAnnotation(name = "John", description = "Write by John")
    public UsingMyFirstAnnotation() {

    }

    // 在方法上方的注解
    // The value of the element name is "Tom"
    // Description element is not declared, it will be assigned a default value
    @MyFirstAnnotation(name = "Tom")
    public void someMethod() {

    }

    // 在方法参数钱前的注解
    public void todo(@MyFirstAnnotation(name = "none") String job) {

        // 在局部变量前上的注解
        @MyFirstAnnotation(name = "Some name")
        int localVariable = 0;

    }

}