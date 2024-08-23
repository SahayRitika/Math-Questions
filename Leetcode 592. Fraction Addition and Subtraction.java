import java.math.BigInteger;

class Solution {
    public String fractionAddition(String expression) {
        BigInteger num= BigInteger.ZERO;
        BigInteger den= BigInteger.ONE;
        int i=0, n=expression.length();

        while(i< n){
            int sign= 1;

            //Determine if fraction is positive or negative
            if(expression.charAt(i)=='-'){
                sign= -1;
                i++;
            }else if(expression.charAt(i)== '+'){
                i++;
            }

            //get numerator
            int j=i;
            while(j<n && Character.isDigit(expression.charAt(j))){
                j++;
            }
            BigInteger numerator= new BigInteger(expression.substring(i,j)).multiply(BigInteger.valueOf(sign));

            //move passes '/'
            i=j+1;

            //get denominator
            j =i;
            while(j<n && Character.isDigit(expression.charAt(j))){
                j++;
            }
            BigInteger denominator= new BigInteger(expression.substring(i,j));

            //get the new fraction
            BigInteger comDen= den.multiply(denominator).divide(den.gcd(denominator));
            num= num.multiply(comDen.divide(den)).add(numerator.multiply(comDen.divide(denominator)));
            den= comDen;

            i=j;

        }

        BigInteger gcd= num.gcd(den);
        num= num.divide(gcd);
        den= den.divide(gcd);

        return num.toString()+"/"+den.toString(); 
    }
}
