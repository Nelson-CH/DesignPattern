package CommandPattern;

import java.util.ArrayList;

interface CommandFP {
    void execute();
}

//達到類似 functional Programming, 把一個任務封裝在一個 Object
class PrintFiveTimesCommand implements CommandFP {
    @Override
    public void execute() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
        }
    }
}

class HelloWorldCommand implements CommandFP {
    @Override
    public void execute() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World");
        }
    }
}

public class LikeFunctionalProgramming {
    public static void main(String[] args) {

        ArrayList<CommandFP> commands = new ArrayList<CommandFP>();

        commands.add(new HelloWorldCommand());
        commands.add(new HelloWorldCommand());
        commands.add(new HelloWorldCommand());
        commands.add(new HelloWorldCommand());
        commands.add(new PrintFiveTimesCommand());
        commands.add(new PrintFiveTimesCommand());

        for (CommandFP command : commands) {
            command.execute();
        }
    }
}
