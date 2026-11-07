import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsAgency implements Subject {
    private final List<Subscriber> subscribers;
    private String latestNews;

    public NewsAgency() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        if (subscriber != null && !subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            System.out.println("[NewsAgency] New subscriber added: " + subscriber);
        }
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        if (subscribers.remove(subscriber)) {
            System.out.println("[NewsAgency] Subscriber removed: " + subscriber);
        }
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : new ArrayList<>(subscribers)) {
            subscriber.update(latestNews);
        }
    }

    public void notifySubscribers(String category, String news) {
        for (Subscriber subscriber : new ArrayList<>(subscribers)) {
            subscriber.update(category, news);
        }
    }

    public void publishNews(String news) {
        this.latestNews = news;
        System.out.println("\n------------------------------------------------------------");
        System.out.println("[NEWS AGENCY - BREAKING NEWS PUBLISHED]");
        System.out.println("Headline: " + news);
        System.out.println("------------------------------------------------------------");
        notifySubscribers();
    }

    public void publishNews(String category, String news) {
        this.latestNews = "[" + category + "] " + news;
        System.out.println("\n------------------------------------------------------------");
        System.out.println("[NEWS AGENCY - " + category.toUpperCase() + " NEWS PUBLISHED]");
        System.out.println("Headline: " + news);
        System.out.println("------------------------------------------------------------");
        notifySubscribers(category, news);
    }

    public void setLatestNews(String news) {
        publishNews(news);
    }

    public String getLatestNews() {
        return latestNews;
    }

    public List<Subscriber> getSubscribers() {
        return Collections.unmodifiableList(subscribers);
    }

    public int getSubscriberCount() {
        return subscribers.size();
    }
}
