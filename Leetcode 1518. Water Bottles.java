class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank= numBottles;
        while(numBottles>= numExchange){
            drank+= numBottles / numExchange;
            numBottles= (numBottles / numExchange)+(numBottles % numExchange);
        }

        return drank;
    }
}
