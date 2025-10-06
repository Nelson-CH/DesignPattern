package AdapterPattern;

interface Duck {
    void quack();
    void fly();
}

class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("i am flying");
    }
}

interface Turkey {
    void gobble();
    void fly();
}

//Adapter 的命名慣例是：「被轉換的對象 + Adapter」
class TurkeyAdapter implements Duck {

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        if (turkey != null) {
            turkey.gobble();
        }
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}

class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble");
    }

    @Override
    public void fly() {
        System.out.println("i am flying a short distance");
    }
}

public class Main {
    public static void main(String[] args) {
        WildTurkey wildturkey = new WildTurkey();
        Duck fakeDuck = new TurkeyAdapter(wildturkey);
        fakeDuck.quack();
        fakeDuck.fly();
    }
}
