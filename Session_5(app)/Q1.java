import java.util.Arrays;

public class Q1 {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2;
        playerScores[viceCaptainIndex] *= 1.5;
    }
        public static void main(String[] args) {
        double[] scores1 = {40, 55, 30, 62};
        applyMultipliers(scores1, 1, 3);
        System.out.println(Arrays.toString(scores1));
        double[] scores2 = {10, 20, 30, 40, 50};
        applyMultipliers(scores2, 0, 4);
        System.out.println(Arrays.toString(scores2));
        double[] scores3 = {100, 90, 80};
        applyMultipliers(scores3, 2, 0);
        System.out.println(Arrays.toString(scores3));
        double[] scores4 = {5, 15, 25, 35, 45, 55};
        applyMultipliers(scores4, 3, 1);
        System.out.println(Arrays.toString(scores4));
    }
}
