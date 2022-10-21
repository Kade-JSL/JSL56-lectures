package javastudy;

import java.text.DecimalFormat;

public class Java20 {
    
    // 숫자 세 자리마다 ","를 사용하시오
    public static void main(String[] args) {
        double tot = 123456789.77789;
        // int cnt = 1000000;
        DecimalFormat fmt = new DecimalFormat("￦#,###.000원");//안에는 패턴 문자열을 입력하면 된다
        System.out.println(fmt.format(tot));
    }
}
