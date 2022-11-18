package controller;

abstract class Cat {

    int meow;
    String catName;

    public abstract int catProperties(int age, int breedIndex);
    public abstract int stroke(int strokeRate, int duration);
    public abstract double meowIndex(int... a);

    public void meow() {
        System.out.println("Meow");
    }
}

class BlueCat extends Cat {

    @Override
    public int catProperties(int age, int breedIndex) {
        String[] msgs = new String[] { "st", "nd", "th" };
        String msg = null;
        if (breedIndex % 10 == 1) {
            msg = msgs[0];
        } else if (breedIndex % 10 == 2) {
            msg = msgs[1];
        } else {
            msg = msgs[2];
        }
        System.out.println("They are an blue cat, aged " + age + ", and their breed is " + breedIndex + msg + " type.");
        return age + breedIndex;
    }
    
    @Override
    public int stroke(int strokeRate, int duration) {
        System.out.print("Stroked an blue cat " + strokeRate + " times per an hour, for " + duration + " hours. ");
        System.out.println("A total of " + strokeRate * duration + " strokes.");
        return strokeRate * duration;
    }

    @Override
    public double meowIndex(int... a) {
        System.out.print("IDK, someone needs some numbers. So we added the following numbers to a method\n: Which is ");
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            sum += a[i];
        }
        System.out.println(".\nThat yielded a number: " + sum);
        return (double)sum / (double)a.length;
    }
}

public class AbstractMain {
    public static void main(String[] args) {
        BlueCat b = new BlueCat();
        b.catProperties(3, 72);
        b.stroke(10, 24);
        double meowIndex = b.meowIndex(3, 72, 10, 24);
        System.out.println("Then, the blue cat's Meow Index is: " + meowIndex);
        b.meow();
    }
}
