class Solution {
    public long numberOfWays(String s) {
        long [] arr = new long[6];
        /*
        0:1
        1:10
        2:101
        3:0
        4:01
        5:010
        so, if we find a 1
        [0]++
        [2]+=[4]
        [1]+=[3]
        if we find a 0
        [3]++
        [4]+=[0]
        [5]+=[1]
        */
        for(char c : s.toCharArray()){
            if(c=='1'){
                arr[0]++;
                arr[1]+=arr[3];
                arr[2]+=arr[4];
            }
            else{
                arr[3]++;
                arr[4]+=arr[0];
                arr[5]+=arr[1];
            }
        }
        return arr[2]+arr[5];
    }
}
/*


or dp?
0 0 1 1 0 1
6 4 2 1 0 0

bfs basically
how about
2 2 1 1
so we can make 2 selections, then 2 selections, then 1 selection
could do it with the odd and even numbered sections
*/
