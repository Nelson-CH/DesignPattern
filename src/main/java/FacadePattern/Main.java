package FacadePattern;

class CPU{
    public void movePointer(){}
    public void jump(){}
    public void freeze(){}
}

class Memory {
    public void load(){}
}

class HardDrive {
    public byte[] read(long position){
        return null;
    }
}

//Facade
class Computer {
    CPU cpu = new CPU();
    HardDrive hardDrive = new HardDrive();
    Memory memory = new Memory();

    //使用者不需要知道電腦的硬體管理細節, 封裝在這
    public void startComputer(){
        cpu.jump();
        cpu.movePointer();
        hardDrive.read(100);
        memory.load();
    }
}


public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        //使用者需要做的操作
        computer.startComputer();
    }
}
