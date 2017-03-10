package regexdemo;

/**
 * Created by Basil on 2017/2/26.
 */
public class SplitWithRegex {

    public static final String TEXT = "This is my text";

    public static void main(String[] args) {
        System.out.println("TEXT=" + TEXT);

        // White space appears one or more times.
        // The whitespace characters: \t \n \x0b \r \f
        // Combining rules: \ s and +
        String regex = "\\s+";                      //   \s表示空白字符的简写
        String[] splitString = TEXT.split(regex);
        // 4
        System.out.println(splitString.length);

        for (String string : splitString) {
            System.out.println(string);
        }
        // Replace all whitespace with tabs
        String newText = TEXT.replaceAll("\\s+", "\t");
        System.out.println("New text=" + newText);
    }
}