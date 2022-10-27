package javastudy;

public class Java31 {
    
    public static void main(String[] args) {
        int[] arr = {21, 64, 98, 35, 75, 14, 62, 10, 48, 30, 98, 74, 65, 58, 19, 64, 81}; // 어떤 배열이든 상관 없음
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
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        } // arr이 잘 정렬되었는지 확인하는 출력부
    }
}