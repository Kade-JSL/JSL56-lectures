package javastudy;

public class Java31 {
    
    public static void main(String[] args) {
        int[] arr = {21, 64, 98, 35, 75, 14, 62, 10, 48, 30, 98, 74, 65, 58, 19, 64, 81}; // 어떤 배열이든 상관 없음
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;   
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}