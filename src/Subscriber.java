public interface Subscriber {
    void update(String news);

    default void update(String category, String news) {
        update("[" + category + "] " + news);
    }
}
