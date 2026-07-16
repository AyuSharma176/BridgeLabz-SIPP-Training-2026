// Program 8: Exception Propagation in Methods
class ExceptionPropagationDemo {

    // method1() throws ArithmeticException (10 / 0)
    public static int method1() {
        System.out.println("Inside method1() - attempting 10 / 0");
        return 10 / 0; // This throws ArithmeticException
    }

    // method2() calls method1() - exception propagates through here
    public static int method2() {
        System.out.println("Inside method2() - calling method1()");
        return method1(); // Exception propagates up from method1()
    }

    public static void main(String[] args) {
        System.out.println("Inside main() - calling method2()");
        try {
            method2(); // Exception propagates: method1() -> method2() -> main()
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
            System.out.println("Exception message: " + e.getMessage());
        }
    }
}
