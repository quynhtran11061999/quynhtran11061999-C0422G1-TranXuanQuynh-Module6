package day1;

import java.util.Arrays;

public class Character {
    public static void main(String[] args) {
        String string1 = "aabacsdc";
        String string2;
        int count;
            while (!string1.equals("")){
                string2 = String.valueOf(string1.charAt(0));
                count = 0;
                for (int j = 0; j <string1.length() ; j++) {
                    if (String.valueOf(string1.charAt(j)).equals(string2)){
                        count++;
                    }
                }
                string1 = string1.replace(string2,"");
                System.out.println(count + "" + string2);
            }
    }
}
