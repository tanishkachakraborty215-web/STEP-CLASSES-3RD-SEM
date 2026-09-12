import java.util.*;

public class WordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        // Stop words
        Set<String> stopWords = new HashSet<>();

        stopWords.add("the");
        stopWords.add("was");
        stopWords.add("and");
        stopWords.add("a");
        stopWords.add("is");
        stopWords.add("of");
        stopWords.add("in");

        // Convert to lowercase
        String cleaned = feedback.toLowerCase();

        // Remove punctuation
        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");

        // Split into words
        String[] words = cleaned.split("\\s+");

        // Store word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            // Skip stop words
            if (stopWords.contains(word)) {
                continue;
            }

            // Count frequency
            frequency.put(
                word,
                frequency.getOrDefault(word, 0) + 1
            );
        }

        // Convert map entries to list
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by count in descending order
        list.sort((a, b) -> b.getValue() - a.getValue());

        // Print result
        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}