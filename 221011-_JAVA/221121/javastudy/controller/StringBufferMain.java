package controller;

import java.util.StringTokenizer;

public class StringBufferMain {
    public static void main(String[] args) {
        
        /* StringBuffer */
        StringBuffer sb = new StringBuffer("a");
        sb.append(" pencil");
        System.out.println(sb);
        sb.insert(2, "nice ");
        System.out.println(sb);
        sb.replace(2, 6, "bad");
        System.out.println(sb);

        // System.out.println(sb.length());
        // System.out.println(sb.charAt(3));
        // sb.setLength(4);
        // System.out.println(sb);

        sb.delete(8, 12);
        System.out.println(sb);

        /* StringTokenizer */
        String query = "name=홍길동&age=100&address=대전광역시";
        StringTokenizer stk = new StringTokenizer(query, "&");
        while(stk.hasMoreTokens()) {
            System.out.println(stk.nextToken());
        }
    }
}
