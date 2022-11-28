package dao;

import java.util.Calendar;

public class CalendarDao {
    public void printMonthly(int year, int month) {
        Calendar today = Calendar.getInstance();
        System.out.printf("\t%d년 %d월\n", year, month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        today.set(year, month - 1, 1);
        int startDow = today.get(Calendar.DAY_OF_WEEK);
        for (int i = 0; i < startDow - 1; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= today.getActualMaximum(Calendar.DATE); i++) {
            System.out.printf("%d\t", i);
            if ((i + startDow - 1) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
