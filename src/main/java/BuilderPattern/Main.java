package BuilderPattern;

//多屬性複雜物件
class  Pizza {
    private String dough;
    private String sauce;
    private String topping;
    private String style;
    private String cheese;

    public Pizza() {}

    public Pizza(String dough, String sauce, String topping, String style, String cheese) {
        this.dough = dough;
        this.sauce = sauce;
        this.topping = topping;
        this.style = style;
        this.cheese = cheese;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                ", style='" + style + '\'' +
                ", cheese='" + cheese + '\'' +
                '}';
    }
}

// Abstract Builder
abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizza() {
        this.pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
    public abstract void buildStyle();
    public abstract void buildCheese();
}

// Concrete Builder
class HawaiianPizzaBuilder extends PizzaBuilder {

    //每一個 Concrete Builder 可以設定自己這個種類的參數
    @Override
    public void buildDough() {
        this.pizza.setDough("cross");
    }

    @Override
    public void buildSauce() {
        this.pizza.setSauce("mild");
    }

    @Override
    public void buildTopping() {
        this.pizza.setTopping("pineapple");
    }

    @Override
    public void buildStyle() {
        this.pizza.setStyle("Hawaiian");
    }

    @Override
    public void buildCheese() {
        this.pizza.setCheese("cheese");
    }
}

class SpicyPizzaBuilder extends PizzaBuilder {

    //每一個 Concrete Builder 可以設定自己這個種類的參數
    @Override
    public void buildDough() {
        this.pizza.setDough("pan baked");
    }

    @Override
    public void buildSauce() {
        this.pizza.setSauce("hot");
    }

    @Override
    public void buildTopping() {
        this.pizza.setTopping("pepperoni");
    }

    @Override
    public void buildStyle() {
        this.pizza.setStyle("Spicy");
    }

    @Override
    public void buildCheese() {
        this.pizza.setCheese("cheese");
    }
}

// Director
class Director {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructorPizza(){
        pizzaBuilder.createNewPizza();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
        pizzaBuilder.buildStyle();
        pizzaBuilder.buildCheese();
    }
}

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        PizzaBuilder hawaiianBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyBuilder = new SpicyPizzaBuilder();
        director.setPizzaBuilder(hawaiianBuilder);
        director.constructorPizza();
        System.out.println(director.getPizza());
        director.setPizzaBuilder(spicyBuilder);
        director.constructorPizza();
        System.out.println(director.getPizza());
    }
}

