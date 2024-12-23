class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1,(a,b)->a[0]-b[0]);
        Arrays.sort(slots2,(a,b)->a[0]-b[0]);
        int one_idx=0;
        int two_idx=0;
        while(one_idx<slots1.length && two_idx<slots2.length){
            if(slots1[one_idx][0]>slots2[two_idx][1]){
                two_idx++;
                continue;
            }
            if(slots1[one_idx][1]<slots2[two_idx][0]){
                one_idx++;
                continue;
            }
            if(smallDiff(slots1[one_idx],slots2[two_idx])>=duration){
                ArrayList<Integer> ret = new ArrayList<Integer>();
                ret.add(Math.max(slots1[one_idx][0],slots2[two_idx][0]));
                ret.add(Math.max(slots1[one_idx][0],slots2[two_idx][0])+duration);
                return ret;
            }
            else{
                if(slots1[one_idx][1]>=slots2[two_idx][1]){
                    two_idx++;
                    continue;
                }
                if(slots1[one_idx][1]<slots2[two_idx][1]){
                    one_idx++;
                    continue;
                }
            }
        }
        return new ArrayList<Integer>();
    }
    private int smallDiff(int[] s1, int[] s2){
        int start = Math.max(s1[0],s2[0]);
        int end = Math.min(s1[1],s2[1]);
        return end-start;
    }
}
/*
60,120
60,70
d=8

10,50:
    0,15: 10,15
60,120:
    60,70: 60, 70

ok so 2 options
bf, no sorting: slots1.length * slots2.length
sorting: nlogn of slots1 + slots2, + time to kinda linearly go thru it

sort slots1 and slots1
for slot1
    while slot1[0] <= slot2[0] <= slot1[1] or vv
        add int{Math.max(slot1[0],slot2[0]), Math.min(slot1[1],slot2[1])}

*/
