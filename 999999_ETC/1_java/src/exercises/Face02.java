package exercises;

interface KadeFace {
    public void kade();
}

interface NekoFace {
    public void neko();
}

class Faces implements KadeFace, NekoFace { // 두 개의 인터페이스를 동시에 구현
    public void kade() {
        System.out.println("Kade says: Niiramekko shimashou!");
    }
    public void neko() {
        System.out.println("Neko says: App pu pu!");
    }
}

public class Face02 {
    public static void main(String[] args) {
        Faces kao = new Faces();
        kao.kade();
        kao.neko();
    }
}
