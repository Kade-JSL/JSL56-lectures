package controller;

class Cat /* extends Object */{ // 아름다운 자바에 java.lang에 Object 클래스가 터 잡으시고
    int soundCount;
    int purrCount;

    Cat(int soundCount) {
        System.out.print("This cat says: ");
        this.soundCount = soundCount;
        purrCount = (int)(soundCount * Math.random());
    }

    @Override
    public String toString() {
        return "This cat has " + soundCount + " sounds, and gives " + purrCount + " purrs";
    }
}

class BlueCat extends Cat {
    BlueCat() {
        super(10);
        for (int i = 0; i < this.soundCount; i++) {
            System.out.print("Nyaa! ");
        }
        System.out.println();
    }
}

class GrayCat extends Cat {
    GrayCat() {
        super(7);
        for (int i = 0; i < this.soundCount; i++) {
            System.out.print("Meow... ");
        }
        System.out.println();
    }
}

class InvisibleCat extends Cat {
    InvisibleCat() {
        super(3);
        for (int i = 0; i < this.soundCount; i++) {
            System.out.print("(*invisible meowing*) ");
        }
        System.out.println();
    }
}

class Kade {
    int strokeCount = 100;
    int purrCount = 0;

    // void stroke(BlueCat j) {
    //     System.out.println("Stroked BlueCat " + j.soundCount + " times!");
    //     strokeCount -= j.soundCount;
    //     purrCount += j.purrCount;
    //     System.out.println("Kade earned: " + j.purrCount + " purrs!");
    // }
    // void stroke(GrayCat k) {
    //     System.out.println("Stroked GrayCat " + k.soundCount + " times!");
    //     strokeCount -= k.soundCount;
    //     purrCount += k.purrCount;
    //     System.out.println("Kade earned: " + k.purrCount + " purrs!");
    // }
    // void stroke(InvisibleCat n) {
    //     System.out.println("Stroked InvisibleCat " + n.soundCount + " times!");
    //     strokeCount -= n.soundCount;
    //     purrCount += n.purrCount;
    //     System.out.println("Kade earned: " + n.purrCount + " purrs!");
    // }
    // 근데 이거, 좀 불편하지 않나...? 고양이가 1000마리면 메서드가 1000개나 필요하다...

    void stroke(Cat c) { // 다형성 개념: 상위 클래스 타입의 참조로 하위 클래스를 받음
        if (strokeCount < c.soundCount) {
            System.out.println("Kade's arms are so tired that he can't stroke any cats...");
            return;
        }
        System.out.println("Stroked a cat " + c.soundCount + " times!"); // 그리고 클래스의 멤버에 접근함
        strokeCount -= c.soundCount; // 멤버에 또 접근함
        purrCount += c.purrCount; // 멤버에 또또 접근함
        System.out.println("Kade earned: " + c.purrCount + " purrs!"); // 멤버에 또*3 접근함
        // 요렇게 공통의 Cat 클래스를 상위 클래스로 가지는 하위 클래스들에게 공통으로 쓰이는 메서드를 정의할 수 있게 된다.
        // 이것이 다형성을 사용하는 이유. 코드의 반복성이 줄어든다.
    }
}

class Polymorphism02 {
    public static void main(String[] args) {

        Kade k = new Kade();

        // BlueCat jin = new BlueCat();
        GrayCat kyu = new GrayCat();
        InvisibleCat nan = new InvisibleCat();

        k.stroke(kyu);
        System.out.println(kyu.toString());
        k.stroke(new BlueCat());
        k.stroke(nan);

        System.out.println("Now Kade has " + k.strokeCount + " strokes left.");
        System.out.println("But he earned " + k.purrCount + " purrs of the cats!");
    }
}