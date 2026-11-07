import java.util.HashSet;
import java.util.Set;

public class NewsSubscriber implements Subscriber {
    private String name;
    private final Set<String> preferredCategories;

    public NewsSubscriber(String name) {
        this.name = name;
        this.preferredCategories = new HashSet<>();
        this.preferredCategories.add("ALL");
    }

    public NewsSubscriber(String name, String... categories) {
        this.name = name;
        this.preferredCategories = new HashSet<>();
        for (String cat : categories) {
            this.preferredCategories.add(cat.toUpperCase());
        }
    }

    @Override
    public void update(String news) {
        System.out.println("  >> [Notification] " + name + " received breaking news: " + news);
    }

    @Override
    public void update(String category, String news) {
        if (preferredCategories.contains("ALL") || preferredCategories.contains(category.toUpperCase())) {
            System.out.println("  >> [Notification] " + name + " (" + category + " alert): " + news);
        }
    }

    public void modifyPreferences(String... newCategories) {
        this.preferredCategories.clear();
        for (String cat : newCategories) {
            this.preferredCategories.add(cat.toUpperCase());
        }
        System.out.println("[Preference Update] " + name + " updated preferences to: " + preferredCategories);
    }

    public String getName() {
        return name;
    }

    public Set<String> getPreferredCategories() {
        return preferredCategories;
    }

    @Override
    public String toString() {
        return name;
    }
}
