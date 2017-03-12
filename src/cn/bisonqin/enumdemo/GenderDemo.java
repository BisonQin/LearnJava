package cn.bisonqin.enumdemo;

/**
 * Created by Basil on 2017/2/25.
 */
public class GenderDemo {

    public static void main(String[] args) {

        Gender marryGender = Gender.FEMALE;                         //FEMALE("F", "Female")

        System.out.println("Code: " + marryGender.getCode());       //Code: F
        System.out.println("Text: " + marryGender.getText());       //Text: Female

        // Gender[].
        for (Gender gender : Gender.values()) {
            System.out.println(gender.getText());                   //Male       Female
        }


        String code ="M";
        Gender gender= Gender.getGenderByCode(code);

        System.out.println("Gender by code: "+ gender);             //Gender by code: MALE
    }
}