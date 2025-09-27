package ObserverPattern;

import java.util.ArrayList;
import java.util.TimerTask;

public class TimerMission extends TimerTask implements TickSubject {
    private ArrayList<TickListener> tickListeners = new ArrayList<>();

    @Override
    public void register(TickListener tickListener) {
        tickListeners.add(tickListener);
    }

    @Override
    public void unregister(TickListener tickListener) {
        tickListeners.remove(tickListener);
    }

    @Override
    public void notifyTick() {
        for(TickListener tickListener : tickListeners) {
            tickListener.tick();
        }
    }

    @Override
    public void run() {
        notifyTick();
    }
}
