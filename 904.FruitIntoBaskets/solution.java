class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int r=0;
        int max=0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        while(r<fruits.length){
            hm.put(fruits[r],hm.getOrDefault(fruits[r],0)+1);
            while(hm.size()>2){
                int key = fruits[l];
                int val = hm.get(key);
                if(val==1){
                    hm.remove(key);
                }
                else{
                    hm.put(key,hm.get(key)-1);
                }
                l++;
            }
            r++;
            max=Math.max(max,r-l);
        }
        return max;
    }
}
/*
1 2 3 2 2
  l
          r
max=5-1=4
2:3
3:1

sliding window hashmap
while (r<fruits.length)
    r++
    fruits.put(fruit, hm.getOrDefault(fruit,0)+1)
    while(fruitz.size()>2)
        //lfruit is the count I guess idk
        lfruit = hm.get(fruits[l])
        if(lfruit==1)
            hm.remove(lfruit)
        else
            hm.put(fruits[l],hm.get(fruits[l])-1)
*/

