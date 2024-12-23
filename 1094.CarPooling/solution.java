class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        //hashMap<exitPoint,#pass> sum
        HashMap<Integer,Integer> currPass = new HashMap<Integer,Integer>();
        int sum=0;
        int prevStop=-1;
        //iterate thru trips
        for(int i=0; i<trips.length; i++){
            int pickupPoint = trips[i][1];
            //remove passengers who got off
            if(prevStop!=-1){
                for(int j=prevStop; j<=pickupPoint; j++){
                    if(currPass.containsKey(j)){
                        sum-=currPass.get(j);
                        currPass.remove(j);
                    }
                }
            }
            prevStop=pickupPoint;
            //add passengers getting on
            int passOn = trips[i][0];
            int dest = trips[i][2];
            sum+=passOn;
            //shared exit point edge case
            currPass.put(dest,currPass.getOrDefault(dest,0)+passOn);
            //check capacity
            if(sum>capacity)
                return false;
        }
        return true;
    }
}
/*
the total number of passengers can be represented just by the sum of people on the bus
so, the hard part is getting people off the bus!
the bus will not overflow between two pickup points, nobody is getting on!
So, for each pickup point, figure out who's gotten off the bus, and take them off
then, put the new passenger on, and check the capacity

sort the input by the time when the passengers get on
as we move between pickup points, figure out the guys who already have gotten off
*/
