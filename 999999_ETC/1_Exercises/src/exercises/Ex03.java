package exercises;

import java.util.Scanner;

import java.util.Stack;

public class Ex03 {
    /**
     * Gets a bunch of integers, and makes them to an array.
     * 
     * @param stop Specifies the integer input to stop. When it's 0<=stop<=100, the param sets to default -9999.
     * @param m Default: null. Bunch of console messages. 
     * m[0]: first message before stop param(e.g. "Type an integer to input. When the input was "<br>
     * m[1]: message after stop param(e.g. ", this function will stop and return the integers that has input.")<br>
     * m[2]: indicator for the length of the array(e.g. "Integers typed: ")
     * @return An array that contains all integer inputs, <b>excluding</b> the stop param.
     */
    private static int[] stackinput(int stop, String[] m) { // 입력받은 정수를 배열로 만들어서 돌려줌
        if (stop <= 100 && stop >= 0) { stop = -9999; }
        String[] msg = new String[3];
        if (m == null) {
            msg[0] = "엔터를 누르면 정수가 입력됩니다. ";
            msg[1] = "(을)를 눌러서 입력을 중지하세요.";
            msg[2] = "입력한 정수 갯수: ";
        } else {
            msg[0] = m[0]; msg[1] = m[1]; msg[2] = m[2];
        }
        System.out.println(msg[0] + stop + msg[1]);
        Stack<Integer> stk = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            stk.push(sc.nextInt());
            if (stk.peek() == stop) {
                stk.pop();
                break;
            }
        }
        System.out.println(msg[2] + stk.size());
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

    private static void selsort(int[] arr) { // 선택 정렬(Selection sort)
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
    }
    
    public static void main(String[] args) {
        int[] arr = stackinput(-9999, null);// 스택을 사용해서 무한정 입력받기
        selsort(arr);
        for (int i = 0; i < arr.length; i++) {
            // arr이 잘 정렬되었는지 확인
            System.out.print(arr[i] + " ");
        } 
    }
}
