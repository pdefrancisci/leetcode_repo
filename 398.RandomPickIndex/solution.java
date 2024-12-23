class Solution {
    HashMap<Integer,ArrayList<Integer>> map;
    Random ran;
    public Solution(int[] nums) {
        this.map = new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0; i<nums.length; i++){
            int key = nums[i];
            ArrayList<Integer> val = new ArrayList<Integer>();;
            if(map.containsKey(key)){
                val = map.get(key);
            }
            val.add(i);
            map.put(key,val);
        }
        this.ran = new Random();
    }
    
    public int pick(int target) {
        ArrayList<Integer> val = map.get(target);
        int idx = ran.nextInt(val.size());
        // for(int i=0; i<val.size(); i++){
        //     System.out.print(val.get(i)+" ");
        // }
        // System.out.print("\n");
        return val.get(idx);
        // return 0;
    }
}
/*
1 2 3 3 3
1:0
2:1
3:2 3 4
pick(3)
val: 2 3 4
idx=mni(3)
return 

RANDOMNESS: avoid CLT by having one random event

how about this
hm<nums[i],list of indicies>
so for solution,
put or append lists in this hm
for pick, get all of the valid indicies, randomly pick an index, 0:n, selecting the original indicies randomly
solution:
O(n) to iterate and populate our hm
pick
o(1) to get the list
o(1) to gen the val
o(1) to generate the random number and do the index lookup

so O(n) to gen solution, O(1) to pick.
*/


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
