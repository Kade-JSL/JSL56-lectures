package controller;

import java.text.*;
import java.util.Calendar;
// import java.util.Date;

public class SimpleDateFormatMain {

    public static void main(String[] args) {

        // Date today = new Date();
        Calendar today = Calendar.getInstance();
        System.out.println(today.getTime());

        // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일");
        SimpleDateFormat sdf1 = new SimpleDateFormat("오늘은 M월의 W번째 주 d번째 날이며, F번째 E요일입니다.");

        // System.out.println(sdf1.format(today));
        System.out.println(sdf1.format(today.getTime()));
    }
}
