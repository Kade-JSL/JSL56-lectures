package controller;

import java.util.ArrayList;

public class CollectionMain {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(); 
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println(arrayList.size());
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
            sum += arrayList.get(i);
        }
        System.out.println("\nsum = " + sum);
    }
}
