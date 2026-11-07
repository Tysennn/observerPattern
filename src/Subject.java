public interface Subject {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers();

    default void attach(Subscriber subscriber) {
        subscribe(subscriber);
    }

    default void detach(Subscriber subscriber) {
        unsubscribe(subscriber);
    }
}
