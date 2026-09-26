public class ExamQuestionGrader {

    static abstract class Question {
        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected int points;

        public Question(String questionText, String correctAnswer, String studentAnswer, int points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public abstract double getScore();
        public abstract String getType();
    }

    static class MCQ extends Question {
        public MCQ(String questionText, String correctAnswer, String studentAnswer, int points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        public double getScore() {
            return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
        }

        public String getType() {
            return "MCQ";
        }
    }

    static class TrueFalse extends Question {
        public TrueFalse(String questionText, String correctAnswer, String studentAnswer, int points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        public double getScore() {
            return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0;
        }

        public String getType() {
            return "TF";
        }
    }

    static class Essay extends Question {
        public Essay(String questionText, String correctAnswer, String studentAnswer, int points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        public double getScore() {
            String[] keywords = correctAnswer.split(",");
            int matchCount = 0;
            String lowerStudentAnswer = studentAnswer.toLowerCase();

            for (String keyword : keywords) {
                if (lowerStudentAnswer.contains(keyword.trim().toLowerCase())) {
                    matchCount++;
                }
            }

            if (matchCount >= 2) {
                return points * 0.75;
            } else if (matchCount == 1) {
                return points * 0.50;
            } else {
                return 0;
            }
        }

        public String getType() {
            return "ESSAY";
        }
    }

    public static void main(String[] args) {
        Question[] questions = {
            new MCQ("What is the capital of France?", "Paris", "Paris", 10),
            new TrueFalse("The Earth is flat?", "False", "True", 5),
            new Essay("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20),
            new Essay("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15)
        };

        double total = 0;
        for (Question q : questions) {
            double score = q.getScore();
            total += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}