import java.util.Arrays;

public class ScoreCurve {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores1 = {70, 85, 60};
        curveScores(scores1, 10);
        System.out.println(Arrays.toString(scores1));

        int[] scores2 = {50, 60, 70, 80};
        curveScores(scores2, 5);
        System.out.println(Arrays.toString(scores2));

        int[] scores3 = {100, 90, 80};
        curveScores(scores3, 0);
        System.out.println(Arrays.toString(scores3));

        int[] scores4 = {45};
        curveScores(scores4, 20);
        System.out.println(Arrays.toString(scores4));
    }
}