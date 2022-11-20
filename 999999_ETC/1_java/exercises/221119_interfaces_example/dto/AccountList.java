package dto;

/* 계좌 리스트 */
public class AccountList { // 싱글톤 객체
    private static AccountList accountList = new AccountList(); // 하나뿐인 인스턴스 생성

    private AccountList() {
        listLength = 0;
    } // private 생성자로 새로운 객체 생성도 막음

    public static BankAccount[] getList() {
        return accountList.accList;
    }
    // ↑ 다른 싱글톤 객체와 다른 부분. 굳이 인스턴스를 넘겨줄 필요를 못 느껴서, 간단하게 리스트만 넘겨주는 형태로 하였습니다.
    // 여기까지가 모두 싱글톤 객체로서의 특성.

    private static int listLength;

    // ↑ 리스트 길이를 알기 쉽게 멤버변수로 설정. 하나뿐인 인스턴스가 생성될 때 0을 초기화된다.
    public static int getLength() {
        return listLength;
    }
    // ↑ 캡슐화. 어떤 멤버든 getter나 setter로 접근하게 하기. 길이 자체에 접근하는 경우가 꽤 있을 느낌이라 public으로 구현.

    private BankAccount[] accList = new BankAccount[1000];
    // ↑ 객체의 핵심이 되는 계좌 리스트. ArrayList를 활용하면 조금 더 코드가 유연해지지만 일단은 그냥 1000명까지 수용이 가능한
    // 리스트로.

    public static void addList(BankAccount a) {
        getList()[listLength] = a;
        listLength++;
    } // 리스트가 private이므로 리스트에 추가하는 부분을 간단하게 메서드로 만들어서 구현.

    public static void removeList(BankAccount a) {
        for (int i = 0; i < getLength(); i++) {
            if (getList()[i].equals(a)) {
                getList()[i] = null;
            }
        }
    }

    public static void sortItAndPrintIt() {
        BankAccount[] b = new BankAccount[getLength()];
        for (int i = 0; i < b.length; i++) {
            b[i] = getList()[i];
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = i; j < b.length; j++) {
                if (b[i].getAccountNum() > b[j].getAccountNum()) {
                    BankAccount temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.printf("일반\t%d\t\t%s\t%d\n", b[i].getAccountNum(), b[i].getOwnerName(), b[i].getBalance());
        }
    }
}
