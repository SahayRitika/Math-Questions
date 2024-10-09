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

class Solution {
    public int nthUglyNumber(int n) {
      int arr[]= new int[n+1];
        arr[1]= 1;

        int i2=1, i3=1, i5=1, ugly=0;
        for(int i=1; i<n; i++){
            arr[i+1]= Math.min(Math.min(arr[i2]*2, arr[i3]*3), arr[i5]*5);
            ugly= arr[i+1];

            if(arr[i2]* 2==ugly)
            i2++;
            if(arr[i3]* 3==ugly)
            i3++;
            if(arr[i5]* 5==ugly)
            i5++;
        }
        System.out.println(Arrays.toString(arr));
        return arr[n];
    }
}
