import java.util.Arrays;

public class PodiumFinder {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score >= third) {
                third = score;
            }
        }

        return new int[] {first, second, third};
    }

    public static void main(String[] args) {
        int[] scores1 = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(Arrays.toString(findTopThreeScores(scores1)));

        int[] scores2 = {10, 20, 30};
        System.out.println(Arrays.toString(findTopThreeScores(scores2)));

        int[] scores3 = {100, 100, 100, 50};
        System.out.println(Arrays.toString(findTopThreeScores(scores3)));

        int[] scores4 = {5, 1, 9, 9, 3, 7, 9};
        System.out.println(Arrays.toString(findTopThreeScores(scores4)));
    }
}