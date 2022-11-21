package controller;

import java.util.ArrayList;

public class MathMain {
    public static void main(String[] args) {
        int cntsix = 0, cntfive = 0, cntfour = 0, cntthree = 0, balls = 6;
        ArrayList<Integer> lottoWin = new ArrayList<Integer>();
        for (int i = 0; i < balls; i++) {
            lottoWin.add((int) (Math.random() * 45) + 1);
            if (lottoWin.isEmpty()) {
                continue;
            } else {
                for (int j = 0; j < i; j++) {
                    if (lottoWin.get(i) == lottoWin.get(j)) {
                        lottoWin.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < lottoWin.size(); i++) {
            for (int j = i; j < lottoWin.size(); j++) {
                if (lottoWin.get(i) > lottoWin.get(j)) {
                    int temp = lottoWin.get(j);
                    lottoWin.set(j, lottoWin.get(i));
                    lottoWin.set(i, temp);
                }
            }
        }
        long it = 0;
        while (true) {
            ArrayList<Integer> lotto = new ArrayList<Integer>();
            int winCount = 0;
            for (int i = 0; i < balls; i++) {
                lotto.add((int) (Math.random() * 45) + 1);
                if (lotto.isEmpty()) {
                    continue;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (lotto.get(i) == lotto.get(j)) {
                            lotto.remove(i);
                            i--;
                            break;
                        }
                    }

                }
            }
            for (int i = 0; i < lotto.size(); i++) {
                for (int j = i; j < lotto.size(); j++) {
                    if (lotto.get(i) > lotto.get(j)) {
                        int temp = lotto.get(j);
                        lotto.set(j, lotto.get(i));
                        lotto.set(i, temp);
                    }
                }
            }
            for (int i = 0; i < lotto.size(); i++) {
                for (int j = i; j < lotto.size(); j++) {
                    if (lottoWin.get(i) == lotto.get(j)) {
                        winCount++;
                    }
                }
            }
            switch (winCount) {
                case 6: {
                    cntsix++;
                    break;
                }
                case 5: {
                    cntfive++;
                    break;
                }
                case 4:
                    cntfour++;
                    break;
                case 3:
                    cntthree++;
                    break;
            }
            it++;
            double sixp = (double) it / (double) cntsix, fivep = (double) it / (double) cntfive,
                    fourp = (double) it / (double) cntfour, threep = (double) it / (double) cntthree;
            if (it != 0 && it % 10000000 == 0) {
                    System.out.printf("%d회 추측 완료. 현재 확률: 1/%.0f 1/%.0f 1/%.0f 1/%.0f\n", it, sixp, fivep, fourp, threep);
            }
        }
    }
}
