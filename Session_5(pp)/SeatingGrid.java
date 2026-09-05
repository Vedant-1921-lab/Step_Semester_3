public class SeatingGrid {

    static double rowAverage(int[] row) {
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";

            result.append("Row ").append(i).append(": ").append(zone);

            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] grid1 = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(grid1, 60));

        int[][] grid2 = {
            {70, 80},
            {10, 15, 20},
            {100, 100, 100, 100}
        };
        System.out.println(classifyRows(grid2, 50));

        int[][] grid3 = {
            {60, 60, 60}
        };
        System.out.println(classifyRows(grid3, 60));
    }
}