package ObserverPattern;

public interface TickSubject {
    //addObserver
    void register(TickListener listener);
    //removeObserver
    void unregister(TickListener listener);
    //notifyObserver
    void notifyTick();
}
