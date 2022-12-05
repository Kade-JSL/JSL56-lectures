package javastudy;

class StudentArraySort { // 기본적인 선택 정렬 알고리즘을 구현했을 뿐이라 별다른 주석을 적지 않음

    static void calcRankByAvg(Student[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].avg < arr[j].avg)
                    arr[i].rank++;
            }
        }
    }

    static void sortElementsByRank(Student[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i].rank > arr[j].rank) {
                    Student temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
