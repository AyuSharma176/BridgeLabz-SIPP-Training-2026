import java.util.Scanner;

class FeeDiscountInput {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double fee;
        double discountPercent;

        System.out.print("Enter Fee: ");
        fee = input.nextDouble();

        System.out.print("Enter Discount Percentage: ");
        discountPercent = input.nextDouble();

        double discountAmount =
                (fee * discountPercent) / 100;

        double finalFee = fee - discountAmount;

        System.out.println(
                "The discount amount is INR " +
                discountAmount +
                " and final discounted fee is INR " +
                finalFee
        );

        input.close();
    }
}