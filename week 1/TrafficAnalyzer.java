public class TrafficAnalyzer {

    static void findLongestStreak(String signalLog) {

        int currentStreak = 1;
        int longestStreak = 1;
        char longestColor = signalLog.charAt(0);

        // Traverse the signal log
        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } else {
                currentStreak = 1;
            }

            // Check if current streak is the longest
            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + longestStreak + " times");
    }

    public static void main(String[] args) {

        String signalLog = "RRGGGYRR";

        findLongestStreak(signalLog);
    }
}