package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import dao.HomeShoppingDao;
import dto.HomeShoppingDto;

public class HomeShoppingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        HomeShoppingDao dao = HomeShoppingDao.getInstance();
        HomeShoppingDto dto = null;
        int result = 0;
        while (run) {
            System.out.print("[1]회원등록 [2]회원목록 [3]회원수정 [4]회원매출조회 [0]종료\n>> ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    dto = new HomeShoppingDto();
                    int custno = dao.getCustNo() + 1;
                    System.out.println("회원번호 >> " + custno);
                    dto.setCustNo(custno);
                    System.out.print("회원이름 >> ");
                    dto.setCustName(sc.next());
                    System.out.print("회원전화 >> ");
                    dto.setPhone(sc.next());
                    System.out.print("성별(M: 남성, F: 여성, N: 그 외) >> ");
                    dto.setGender(sc.next().toUpperCase());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    String joindate = sdf.format(Calendar.getInstance().getTime());
                    System.out.println("가입일자 >> " + joindate);
                    dto.setJoinDate(joindate);
                    System.out.print("고객등급(A: VIP, B: 일반, C: 직원) >> ");
                    dto.setGrade(sc.next().toUpperCase());
                    System.out.print("도시코드 >> ");
                    dto.setCity(sc.next());

                    result = dao.insert(dto);
                    if (result > 0) { System.out.println("등록이 성공적으로 완료되었습니다."); }
                    else { System.out.println("등록이 정상적으로 완료되지 않았습니다. 다시 시도해 주세요."); }
                    break;
                case 2:
                    List<HomeShoppingDto> daoList = dao.selectAll();
                    for (HomeShoppingDto d : daoList) {
                        printDto(d);
                    }
                    break;
                case 3:
                    System.out.print("수정할 회원 번호 >> ");
                    dto = dao.select(sc.nextInt());
                    System.out.println("수정할 회원 ↓");
                    printDto(dto);
                    System.out.print("회원이름 >> ");
                    dto.setCustName(sc.next());
                    System.out.print("회원전화 >> ");
                    dto.setPhone(sc.next());
                    System.out.print("성별(M: 남성, F: 여성, N: 그 외) >> ");
                    dto.setGender(sc.next().toUpperCase());
                    System.out.print("고객등급(A: VIP, B: 일반, C: 직원) >> ");
                    dto.setGrade(sc.next().toUpperCase());
                    System.out.print("도시코드 >> ");
                    dto.setCity(sc.next());
                    result = dao.update(dto);
                    if (result > 0) {
                        System.out.println("수정이 성공적으로 완료되었습니다. 수정 결과 ↓");
                        printDto(dao.select(dto.getCustNo()));
                    }
                    else { System.out.println("등록이 정상적으로 완료되지 않았습니다. 다시 시도해 주세요."); }
                    break;
                case 4:
                    List<HomeShoppingDto> saleList = dao.selectSaleList();
                    for (HomeShoppingDto s : saleList) {
                        System.out.println(
                            s.getSaleNo() + "\t" + 
                            s.getCustName() + "\t" + 
                            s.getsDate() + "\t" + 
                            s.getpName() + "\t" + 
                            s.getAmount() + "\t" + 
                            s.getpCost() + "\t" + 
                            s.getAmountXcost()
                        );
                    }
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("올바른 메뉴 번호를 입력해 주세요.");
                    continue;
            }
        }
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

    static void printDto(HomeShoppingDto dto) {
        System.out.print(
            dto.getCustNo() + "\t" +
            dto.getCustName() + "\t" +
            dto.getPhone() + "\t");
        String gender = null;
        if (dto.getGender().equals("M")) {
            gender = "남자";
        } else if (dto.getGender().equals("F")) {
            gender = "여자";
        } else {
            gender = "그 외";
        }
        System.out.print(
            gender + "\t" +
            dto.getJoinDate() + "\t"
        );
        String grade = null;
        if (dto.getGrade().equals("A")) {
            grade = "VIP";
        } else if (dto.getGrade().equals("B")) {
            grade = "일반";
        } else if (dto.getGrade().equals("C")) {
            grade = "직원";
        }
        System.out.println(
            grade + "\t" +
            dto.getCity()
        );
    }
}
