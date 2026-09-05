import java.util.Arrays;

public class Shortlist {

    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double compositeScore() {
            return (cgpa * 10) + (codingScore * 0.5);
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            if (isEligible(cgpa)) {
                return true;
            }
            return cgpa >= 6.5 && codingScore >= 60;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore(), this.compositeScore());
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        int count = 0;
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa, c.codingScore)) {
                count++;
            }
        }

        Candidate[] shortlisted = new Candidate[count];
        int index = 0;
        for (Candidate c : candidates) {
            if (Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted[index++] = c;
            }
        }

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ")
                  .append(shortlisted[i].name)
                  .append(" (").append(shortlisted[i].compositeScore()).append(")");

            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String result1 = shortlistAndRank(new Candidate[] {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        });
        System.out.println(result1);

        String result2 = shortlistAndRank(new Candidate[] {
            new Candidate("Dev", 9.0, 80),
            new Candidate("Priya", 5.0, 95),
            new Candidate("Sam", 7.0, 50)
        });
        System.out.println(result2);
    }
}