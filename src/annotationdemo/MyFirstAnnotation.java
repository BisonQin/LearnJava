package annotationdemo;

/**
 * Created by Basil on 2017/2/25.
 */
public @interface MyFirstAnnotation {

    // element name.
    public String name();

    // Element description, default value "".
    public String description() default "";
}