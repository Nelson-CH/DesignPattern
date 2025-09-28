package DecoratorPattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

abstract class Beverage {
    String description = "Base Beverage";

    //接下來使用可以擴充 description, 比如加哪種咖啡
    //這個情境不需要改成 abstract, 敘述只差在字串不需要每個子類都重新寫一個方法
    public String getDescription() {
        return description;
    }

    //計算費用
    public abstract double cost();

}

class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast";
    }

    public double cost() {
        return 250;
    }
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 150;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
    }

    public double cost() {
        return 350;
    }
}

class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    public double cost() {
        return 120;
    }
}


//------------------------------------------------------------------

abstract class Decorator extends Beverage {

    protected Beverage beverage;

}

class Mocha extends Decorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        //功能擴展(修飾)
        return this.beverage.cost() + 50;
    }

    @Override
    public String getDescription() {
        //功能擴展(修飾)
        return this.beverage.getDescription() + ", Mocha";
    }

}

class Soy extends Decorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        //功能擴展(修飾)
        return this.beverage.cost() + 20;
    }

    @Override
    public String getDescription() {
        //功能擴展(修飾)
        return this.beverage.getDescription() + ", Soy";
    }

}

class Whip extends Decorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        //功能擴展(修飾)
        return this.beverage.cost() + 10;
    }

    @Override
    public String getDescription() {
        //功能擴展(修飾)
        return this.beverage.getDescription() + ", Whip";
    }

}

class Milk extends Decorator {

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return this.beverage.cost() + 70;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Milk";
    }

}

public class Main {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription());
        System.out.println(espresso.cost());
        System.out.println("-----------------------------------------");
        espresso = new Milk(espresso);
        System.out.println(espresso.getDescription());
        System.out.println(espresso.cost());

        //Java I/O 舉例
        try {
            //Component
            InputStream fileInputStream = new FileInputStream("A.txt");
            //Decorator, BufferedInputStream 擴展 FileInputStream 功能
            fileInputStream = new BufferedInputStream(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
