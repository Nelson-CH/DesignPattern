package CommandPattern;


import java.util.Stack;

//Command 介面：定義命令的共通介面
interface Command {

    void execute();
    void undo();

}

//Receiver：實際執行動作的物件（電燈）
class Light {
    public void on(){
        System.out.println("Light on");
    }

    public void off(){
        System.out.println("Light off");
    }
}

//ConcreteCommand：具體命令（開燈）
class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

//ConcreteCommand：具體命令（開燈）
class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

//Invoker（Caller）：觸發命令執行的控制器（遙控器）
class RemoteControl {

    private Command lightOnCommand;
    private Command lightOffCommand;
    //用來記錄所有過程使用的動作
    private Stack<Command> stack = new Stack<>();

    public RemoteControl(Command lightOnCommand, Command lightOffCommand) {
        this.lightOnCommand = lightOnCommand;
        this.lightOffCommand = lightOffCommand;
    }

    public Stack getStack() {
        return stack;
    }

    public void buttonOnePressed() {
        lightOnCommand.execute();
        stack.add(lightOnCommand);
    }

    public void buttonTwoPressed() {
        lightOffCommand.execute();
        stack.add(lightOffCommand);
    }

    public void buttonUndoPressed() {
        if (!stack.isEmpty()) {
            Command lastCommand = stack.pop();
            lastCommand.undo();
        } else {
            System.out.println("No command to undo");
        }
    }
}

//Client：設定命令與接收者的地方（main 方法）
public class Undo {
    public static void main(String[] args) {
        // Receiver
        Light light = new Light();

        // ConcreteCommands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Invoker
        RemoteControl remoteControl = new RemoteControl(lightOn, lightOff);

        // 操作流程
        remoteControl.buttonOnePressed();  // 開燈
        remoteControl.buttonTwoPressed();  // 關燈
        remoteControl.buttonUndoPressed(); // 復原關燈 → 開燈
        remoteControl.buttonUndoPressed(); // 復原開燈 → 關燈
    }
}
