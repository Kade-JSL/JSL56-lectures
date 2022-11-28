package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {
    public static void main(String[] args) {
        
        String[] data = new String[] {
            "bat", "baby", "bonus", "cA", "co", "c.", "combat", "count"
        };

        Pattern p = Pattern.compile("c[A-z]*"); // 'c'로 시작하는 소문자 영어 단어

        for (String s : data) {
            Matcher m = p.matcher(s);
            if(m.matches()) {
                System.out.print(s + ", ");
            }
        }
    }
}
