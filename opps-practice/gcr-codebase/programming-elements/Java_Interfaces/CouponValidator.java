public interface CouponValidator {
    boolean validateCoupon(String code);
    
    // Static method - cannot be overridden
    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5 && code.length() <= 15;
    }
}
