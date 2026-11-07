public class Main {
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("   REAL-TIME NEWS SUBSCRIPTION SERVICE (OBSERVER PATTERN)   ");
        System.out.println("============================================================\n");

        NewsAgency agency = new NewsAgency();

        NewsSubscriber subscriber1 = new NewsSubscriber("Alice");
        NewsSubscriber subscriber2 = new NewsSubscriber("Bob");
        NewsSubscriber subscriber3 = new NewsSubscriber("Charlie", "SPORTS", "TECH");

        System.out.println("--- STEP 1: Subscribing Users ---");
        agency.subscribe(subscriber1);
        agency.subscribe(subscriber2);
        agency.subscribe(subscriber3);

        System.out.println("\n--- STEP 2: Publishing Breaking News ---");
        agency.publishNews("Magnitude 7.1 Earthquake Strikes off Coast; Tsunami Warning Issued");

        System.out.println("\n--- STEP 3: Dynamic Subscription Update (Unsubscribe) ---");
        agency.unsubscribe(subscriber2);

        System.out.println("\n--- STEP 4: Publishing News After Bob Unsubscribes ---");
        agency.publishNews("Global Climate Accord Signed by 150 Countries in Geneva");

        System.out.println("\n--- STEP 5: Modifying Preferences & Adding New Subscriber ---");
        NewsSubscriber subscriber4 = new NewsSubscriber("Diana");
        agency.subscribe(subscriber4);

        subscriber1.modifyPreferences("TECH");

        System.out.println("\n--- STEP 6: Publishing Categorized News (SPORTS & TECH) ---");
        agency.publishNews("SPORTS", "National Football Team Advances to Championship Finals!");
        agency.publishNews("TECH", "Breakthrough in Quantum Computing Achieves 1 Million Qubits!");

        System.out.println("\n============================================================");
        System.out.println("               DEMONSTRATION COMPLETED SUCCESSFULLY        ");
        System.out.println("============================================================");
    }
}
