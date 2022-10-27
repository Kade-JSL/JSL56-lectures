package javastudy;

import java.util.Scanner;

public class Java31 {
    
    public static void main(String[] args) {
        // int[] arr = {21, 64, 98, 35, 75, 14, 62, 10, 48, 30, 98, 74, 65, 58, 19, 64, 81};
        // 어떤 배열이든 상관 없음

        // 숙제: 배열에 저장하는 초기화 값 5개를 키보드로부터 입력받기
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1 + "번째 정수 입력: ");
            arr[i] = sc.nextInt();
        }

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
        System.out.println("최솟값: " + arr[0] + ", 최댓값: " + arr[arr.length - 1]);
        // 출력 첫째 줄: 최솟값과 최댓값

        int sum = 0;
        for (int i = 0; i < arr.length; i++) { // 출력 둘째 줄: arr이 잘 정렬되었는지 확인
            System.out.print(arr[i] + " ");
            sum += arr[i]; // 합계 구하기를 꼽사리 끼움
        } 
        System.out.println();

        double avg = (double)sum / (double)arr.length; // 평균은 정확해야 한다는 개인의 취향 반영
        System.out.println("합계: " + sum + ", 평균: " + avg);
        // 출력 셋째 줄: 합계와 평균

        sc.close();
    }
}