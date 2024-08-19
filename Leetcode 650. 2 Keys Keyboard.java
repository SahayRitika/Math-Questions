class Solution {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
    public int minSteps(int n) {
        int  dp[]= new int[n+1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[1]=0;
        for(int i=2; i<=n; i++){
            int c=2;
            if(isPrime(i)){
                dp[i]= i;
                while(i*c <=n){
                    dp[i*c]= dp[i]+dp[c];
                    c++;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
//O(n * sqrt(n))

Optimised approach
class Solution {
    public int minSteps(int n) {
       int ans=0;
       for(int i=2; i*i<=n;){
        if(n%i ==0){
            n/=i;
            ans+= i;
        }else{
            i++;
        }
       }

       if(n!= 1) ans+= n;
       return ans;
    }
}
