package controller;

// import java.util.Calendar;
import dao.*;

public class CalendarMain {
    public static void main(String[] args) {
        // Calendar today = Calendar.getInstance();
        // System.out.println("해당년도: "
        //     + today.get(Calendar.YEAR));
        // System.out.println("해당월: "
        //     + (today.get(Calendar.MONTH) + 1));
        // System.out.println("해당주차: "
        //     + today.get(Calendar.WEEK_OF_YEAR));
        // System.out.println("해당월 중 주차: "
        //     + today.get(Calendar.WEEK_OF_MONTH));
        // System.out.println("해당일자: "
        //     + today.get(Calendar.DAY_OF_MONTH)); // 또는 DATE
        // System.out.println("해당년도 중 일자: "
        //     + today.get(Calendar.DAY_OF_YEAR));
        // System.out.println("해당요일: "
        //     + today.get(Calendar.DAY_OF_WEEK));
        // System.out.println("오늘의 요일은 당월 몇 번째 요일인가: "
        //     + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        // System.out.println("오전[0]/오후[1]: "
        //     + today.get(Calendar.AM_PM));
        // System.out.println("현재 시간: "
        //     + today.get(Calendar.HOUR));
        // System.out.println("현재 시간(24시간제): "
        //     + today.get(Calendar.HOUR_OF_DAY));
        // System.out.println("현재 분: "
        //     + today.get(Calendar.MINUTE));
        // System.out.println("현재 초: "
        //     + today.get(Calendar.SECOND));
        // System.out.println("현재 밀리초: "
        //     + today.get(Calendar.MILLISECOND));
        // System.out.println("마지막 날은 며칠인가: "
        //     + today.getActualMaximum(Calendar.DATE));

        CalendarDao c = new CalendarDao();
        c.printMonthly(2017, 6);
    }
}