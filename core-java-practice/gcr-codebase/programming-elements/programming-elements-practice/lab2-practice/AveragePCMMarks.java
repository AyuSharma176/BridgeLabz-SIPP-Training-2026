class AveragePCMMarks {

    public static void main(String[] args) {

        String name = "Sam";

        int mathsMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;

        double averageMarks =
                (mathsMarks + physicsMarks + chemistryMarks) / 3.0;

        System.out.println(name +
                "'s average mark in PCM is " + averageMarks);
    }
}