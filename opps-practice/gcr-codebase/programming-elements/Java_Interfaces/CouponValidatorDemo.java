public class CouponValidatorDemo {
    public static void main(String[] args) {
        String[] coupons = {"SAVE10", "INVALID", "WELCOME20", "ABC", "SUMMER50", "WRONGCODE123456", "FLAT25OFF", "TEST"};
        
        ShoppingCart cart = new ShoppingCart(coupons);
        
        System.out.println("Available Valid Coupons:");
        for (String coupon : cart.getValidCoupons()) {
            System.out.println("  • " + coupon);
        }
        
        System.out.println("\n");
        cart.validateAllCoupons();
    }
}
