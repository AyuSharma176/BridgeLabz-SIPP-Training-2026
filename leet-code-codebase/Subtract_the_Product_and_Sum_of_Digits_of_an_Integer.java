class Solution {
    public int subtractProductAndSum(int n) {
        int x=n;
        int y=n;
        int mul=1;
        while(x>0){
            int a=x%10;
            mul*=a;
            x/=10;
        }
        int sum=0;
        while(y>0){
            int a=y%10;
            sum+=a;
            y/=10;
        }
        return (mul-sum);
    }
}