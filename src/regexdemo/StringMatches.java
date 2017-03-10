package regexdemo;

/**
 * Created by Basil on 2017/2/26.
 */
public class StringMatches {

    public static void main(String[] args) {

        String s1 = "a";
        System.out.println("s1=" + s1);

        // Check the entire s1
        // Match any character
        // Rule .
        // ==> true
        boolean match = s1.matches(".");
        System.out.println("-Match . " + match);

        s1 = "abc";
        System.out.println("s1=" + s1);

        // Check the entire s1
        // Match any character
        // Rule .
        // ==> false (Because s1 has three characters)
        match = s1.matches(".");
        System.out.println("-Match . " + match);

        // Check the entire s1
        // Match with any character 0 or more times
        // Combine the rules . and *
        // ==> true
        match = s1.matches(".*");
        System.out.println("-Match .* " + match);

        String s2 = "m";
        System.out.println("s2=" + s2);

        // Check the entire s2
        // Start by m
        // Rule ^
        // ==> true
        match = s2.matches("^m");
        System.out.println("-Match ^m " + match);

        s2 = "mnp";
        System.out.println("s2=" + s2);

        // Check the entire s2
        // Start by m
        // Rule ^
        // ==> false (Because s2 has three characters)
        match = s2.matches("^m");
        System.out.println("-Match ^m " + match);

        // Start by m
        // Next any character, appearing one or more times.
        // Rule ^ and. and +
        // ==> true
        match = s2.matches("^m.+");
        System.out.println("-Match ^m.+ " + match);

        String s3 = "p";
        System.out.println("s3=" + s3);

        // Check s3 ending with p
        // Rule $
        // ==> true
        match = s3.matches("p$");
        System.out.println("-Match p$ " + match);

        s3 = "2nnp";
        System.out.println("s3=" + s3);

        // Check the entire s3
        // End of p
        // ==> false (Because s3 has 4 characters)
        match = s3.matches("p$");
        System.out.println("-Match p$ " + match);

        // Check out the entire s3
        // Any character appearing once.
        // Followed by n, appear one or up to three times.
        // End by p: p $
        // Combine the rules: . , {X, y}, $
        // ==> true

        match = s3.matches(".n{1,3}p$");
        System.out.println("-Match .n{1,3}p$ " + match);

        String s4 = "2ybcd";
        System.out.println("s4=" + s4);

        // Start by 2
        // Next x or y or z
        // Followed by any one or more times.
        // Combine the rules: [abc]. , +
        // ==> true
        match = s4.matches("2[xyz].+");

        System.out.println("-Match 2[xyz].+ " + match);

        String s5 = "2bkbv";

        // Start any one or more times
        // Followed by a or b, or c: [abc]
        // Next z or v: [zv]
        // Followed by any
        // ==> true
        match = s5.matches(".+[abc][zv].*");

        System.out.println("-Match .+[abc][zv].* " + match);
    }

}