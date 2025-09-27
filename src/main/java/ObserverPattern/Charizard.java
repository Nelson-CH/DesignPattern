package ObserverPattern;

import javax.swing.*;
import java.awt.*;

public class Charizard implements TickListener {
    private Point point;
    private ImageIcon icon = new ImageIcon("Charizard.png");

    public Charizard(int x, int y) {
        point = new Point(x, y);
    }

    @Override
    public void tick() {
        dance();
    }

    public void dance(){
        int newX = (int) (Math.random()*10 - 5);
        int newY = (int) (Math.random()*10 - 5);

        point.x += newX;
        point.y += newY;
    }

    public void draw(Graphics g) {
        icon.paintIcon(null, g, point.x, point.y);
    }
}
