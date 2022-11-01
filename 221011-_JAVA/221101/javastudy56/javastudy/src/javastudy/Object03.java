package javastudy;

public class Object03 {
    /* Method
     * うどんを作るなら麺が必要。機能を作るならメソッド。
     * メソッドの名前から付けよう
     * 基本的なメソッ：定義：int foo(){}
     * int：戻り値が整数型
     * ()：引数を受け取る部分。これがないメソッドは存在しない。
     * {}：ブロック
     * static：「らしいね」と今は次に進もう
     * public：「らしいね」
     * 특히 프로그래밍에서는 "그런갑다" 하고 넘기는 것이 아주 중요합니다.
     * 드넓은 프로그램 세계의 모든 것을 알 수는 없어요. 어딘가의 문법은 모를 수밖에 없고, 어딘가의 인과관계는 이해가 안 될 수밖에 없습니다.
     * 그래서 알 수 있는 부분, 알아야 하는 부분이 어디까지인가를 알고 어디까지를 모른다고 말할 수 있는지가 굉장히 중요합니다.
     * 즉, 지금 이 한 클래스 안에서 메소드를 만들고 부르고 써야 할 뿐이라면 public과 static은 그닥 몰라도 된다는 겁니다.
     */
    public static int fooInt() {
    /* 
     * メソッド名の先頭は小文字、2語目からは先頭は大文字
     * そしてクラス名の先頭は大文字
     * コンパイルが出来ないわけではない。
     * これは不文律。プログラマー同士のルールである。
     */
        int price = 4500;
        return price;
    }

    public static String barStr() {
        String foodname = "짜장면";
        return foodname;
    }
    public static void main(String[] args) {
        String fName = barStr();
        int fPrice = fooInt();
        String result = fName + " 가격 " + fPrice + "원";
        System.out.println(result);
    }
}
