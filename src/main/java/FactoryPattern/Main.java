package FactoryPattern;

import java.util.Scanner;

//Product
abstract class Cake {
    public abstract void aboutCake();
}

//Concrete Product
class BlueBerry extends Cake {
    @Override
    public void aboutCake() {
        System.out.println("BlueBerry Cake");
    }
}

class BlackForest extends Cake {
    @Override
    public void aboutCake() {
        System.out.println("BlackForest Cake");
    }
}

class Pineapple extends Cake {
    @Override
    public void aboutCake() {
        System.out.println("Pineapple Cake");
    }
}

//Factory interface
interface Factory {
    Cake createCake(String cakeName);
}

//Concrete Factory
class CakeFactory implements Factory {
    @Override
    public Cake createCake(String cakeName) {

        Cake cake = null;

        switch (cakeName) {
            case "blueberry":
                cake = new BlueBerry();
                break;
            case "blackforest":
                cake = new BlackForest();
                break;
            case "pineapple":
                cake = new Pineapple();
                break;
            default:
                break;
        }

        return cake;

    }
}

public class Main {

    public static void main(String[] args) {

        System.out.println("what cake do you like?");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toLowerCase();
        scanner.close();

        CakeFactory cakeFactory = new CakeFactory();
        Cake cake = cakeFactory.createCake(choice);

        if (cake != null){
            cake.aboutCake();
        }else {
            System.out.println("No cake found");
        }

    }

}
