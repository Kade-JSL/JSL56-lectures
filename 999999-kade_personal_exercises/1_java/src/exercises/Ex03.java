package exercises;

import java.util.Scanner;

import java.util.Stack;

public class Ex03 {
    private static int[] stackinput(int stop) { // 입력받은 정수를 배열로 만들어서 돌려줌
        System.out.println("엔터를 누르면 정수가 입력됩니다. " + stop + "(을)를 눌러서 입력을 중지하세요.");
        Stack<Integer> stk = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            stk.push(sc.nextInt());
            if (stk.peek() == stop) {
                stk.pop();
                break;
            }
        }
        System.out.println("입력한 정수 갯수: " + stk.size());
        int[] arr = stktoarr(stk);
        sc.close();
        return arr;
    }

    private static int[] stktoarr(Stack<Integer> stk) { // 정수 스택을 정수 배열로 변환
        int[] arr = new int[stk.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = stk.pop();
        }
        return arr;
    }

    private static int[] selsort(int[] arr) { // 배열에 있는 정수를 오름차순으로 정렬
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // 가장 작은 값을 배열 i번째에 놓음
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // 그 작업을 arr의 길이만큼 반복
        }
        return arr;
    }
    
    public static void main(String[] args) {
        int[] arr = stackinput(-9999);// 스택을 사용해서 무한정 입력받기
        arr = selsort(arr);

        for (int i = 0; i < arr.length; i++) {
            // arr이 잘 정렬되었는지 확인
            System.out.print(arr[i] + " ");
        } 
    }
}
