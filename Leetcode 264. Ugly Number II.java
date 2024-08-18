class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq= new PriorityQueue<>();
        Set<Long> visited= new HashSet<>();
        int primes[]=new int[]{2, 3, 5};
        pq.add(1L);
        visited.add(1L);

        long curr= 1L;
        for(int i=0; i<n; i++){
            curr=pq.poll();
            for(int prime: primes){
                long new_ugly= curr*prime;
                if(!visited.contains(new_ugly)){
                    pq.add(new_ugly);
                    visited.add(new_ugly);
                }
            }
        }

        return (int)curr;
    }
}
