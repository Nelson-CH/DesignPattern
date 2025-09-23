package StrategyPattern;

//策略 interface
interface FlyStrategy {
    void fly();
}

interface QuackStrategy {
    void quack();
}

//實現 FlyStrategy interface
class FlyNoWay implements FlyStrategy{
    @Override
    public void fly() {
        System.out.println("不能飛");
    }
}

class FlyWithWings implements FlyStrategy{
    @Override
    public void fly() {
        System.out.println("用翅膀飛");
    }
}

class FlyWithRockets implements FlyStrategy{
    @Override
    public void fly() {
        System.out.println("用火箭飛");
    }
}

//實現 QuackStrategy interface
class Quack implements QuackStrategy{
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}

class MuteQuack implements QuackStrategy{
    @Override
    public void quack() {
        System.out.println("無法發出聲音");
    }
}

//使用策略的物件
class Duck {

    private FlyStrategy flyStrategy;
    private QuackStrategy quackStrategy;

    public void performFly() {
        flyStrategy.fly();
    }

    public void performQuack() {
        quackStrategy.quack();
    }

    public void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    public void setQuackStrategy(QuackStrategy quackStrategy) {
        this.quackStrategy = quackStrategy;
    }
}

public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setFlyStrategy(new FlyWithRockets());
        duck.setQuackStrategy(new MuteQuack());
        duck.performFly();
        duck.performQuack();
    }
}
