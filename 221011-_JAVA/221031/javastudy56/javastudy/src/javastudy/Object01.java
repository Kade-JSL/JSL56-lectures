package javastudy;

import java.util.Arrays;

public class Object01 { // 設計図！
    public static void main(String[] args) { // これからがJava実務になります。
        // それでメモもなるべく日本語でするようにしました。
        // mainメソッドとは？ staticはなんなの？
        // 일본어 메모: 수업 필기에서의 주석을 직역하여 적었습니다.
        // メソッドとは：特定な作業を修行する一連の文を一つの結んだもの

        // main()メソッド
        // Javaプログラムの実行の始めを知らせるメソッド
        // 必ずstatic、必ずpublic、戻り値は必ずvoid、引数は必ずString型の配列
        // public: アクセス制御子(private, default, protected, public)
        // static: オブジェクトの生成なしで使用できるメソッド
        // void: 呼び出した所に返す値がない
        // 引数: main()を呼び出した時に受け取る値を保存する変数
        // 外部(コマンドライン)から実行する時に入力そるのが引数

        // 例え int[] kbs = {10, 20, 30}; と初期化したところで外部からこの配列を受け取ったことではならない。

        // java.utilパッケージの中のクラス(またはメソッド)はオブジェクトを生成せずにすぐ呼び出すことができる
        // java.util: ユーティリティ・パッケージの略

        /*
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        */

        System.out.println(Arrays.toString(args));
        Arrays.sort(args); // 昇順に並べ替え
        System.out.println(Arrays.toString(args)); // 並べ替えた配列をまた出力
    }
}