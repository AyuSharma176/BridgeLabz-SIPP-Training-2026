public class ShoppingCart implements CouponValidator {
    private String[] validCoupons = {"SAVE10", "WELCOME20", "SUMMER50", "FLAT25OFF", "NEWYEAR100"};
    private String[] couponsToValidate;
    
    public ShoppingCart(String[] coupons) {
        this.couponsToValidate = coupons;
    }
    
    @Override
    public boolean validateCoupon(String code) {
        // Check length first using static method
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        
        // Check if code exists in valid coupons
        for (String validCoupon : validCoupons) {
            if (validCoupon.equals(code)) {
                return true;
            }
        }
        return false;
    }
    
    public void validateAllCoupons() {
        System.out.println("========== COUPON VALIDATION ==========\n");
        System.out.println("Checking " + couponsToValidate.length + " coupons...\n");
        
        int validCount = 0;
        int invalidCount = 0;
        
        for (String coupon : couponsToValidate) {
            boolean isValid = validateCoupon(coupon);
            String status = isValid ? "✓ VALID" : "✗ INVALID";
            System.out.println(coupon + " : " + status);
            
            if (isValid) {
                validCount++;
            } else {
                invalidCount++;
            }
        }
        
        System.out.println("\n========== SUMMARY ==========");
        System.out.println("Valid Coupons: " + validCount);
        System.out.println("Invalid Coupons: " + invalidCount);
    }
    
    public String[] getValidCoupons() {
        return validCoupons;
    }
}
