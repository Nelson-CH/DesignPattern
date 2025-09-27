package ObserverPattern;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;



public class Main extends JPanel implements TickListener{

    //放目標物件的 ArrayList
    private ArrayList<Charizard> charizards = new ArrayList<>();
    private ArrayList<Snorlax> snorlaxs = new ArrayList<>();
    //要設定每隔一段時間要做什麼事就需要一個 Timer
    private Timer timer;
    private int speed = 100;
    private TimerMission timerMission1 = new TimerMission(); //subject, 要在其中加入 Observer
    private TimerMission timerMission2 = new TimerMission(); //subject, 要在其中加入 Observer

    @Override
    public void tick() {
        repaint();
    }

    public Main() {

        charizards.add(new Charizard(10, 30));
        charizards.add(new Charizard(330, 30));
        charizards.add(new Charizard(650, 30));

        for (Charizard charizard : charizards){
            timerMission1.register(charizard);
        }

        timerMission1.register(this);

        snorlaxs.add(new Snorlax(1030, 30));
        snorlaxs.add(new Snorlax(1430, 30));
        snorlaxs.add(new Snorlax(1790, 30));

        for (Snorlax snorlax : snorlaxs){
            timerMission2.register(snorlax);
        }

        timerMission2.register(this);

        timer = new Timer();
        //參數1: TimerTask 參數2: 程式啟動後延遲多久 Timer 才開始計時 參數3: 間隔多久
        timer.scheduleAtFixedRate(timerMission1, 0, speed);
        timer.scheduleAtFixedRate(timerMission2, 0, speed + 300);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        for(Charizard charizard : charizards) {
            charizard.draw(g);
        }
        for(Snorlax snorlax : snorlaxs) {
            snorlax.draw(g);
        }
    }

    //建立 JFrame視窗
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setContentPane(new Main());
        frame.setVisible(true);
    }

}
