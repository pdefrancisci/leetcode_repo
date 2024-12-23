class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()+1];
        for(int i = 0; i<triangle.size(); i++){
            dp[triangle.size()-1][i]=
                triangle.get(triangle.size()-1).get(i);
        }
        /*
        for each level of the tri
        bottom up
        go from 0:size-(size-i) and do the below rr
        */
        for(int level=triangle.size()-2; level>=0; level--){
            for(int idx=0; idx<triangle.get(level).size(); idx++){
                dp[level][idx]=
                    triangle.get(level).get(idx) + 
                    Math.min(dp[level+1][idx],dp[level+1][idx+1]);
            }
        }
        return dp[0][0];
    }
}
/*
we want the limit at 0 to be 1
size=4
level=0
limit=4

we want the max at 2 to be 3
size=4
level=2


bounds are dp[depth][depth+1]
state could be depth + i
so
[2][0]=triangle[2][0]+min([3][0],[3][1])
[3][0]=4
[3][1]=1
[3][2]=8
[3][3]=3

so for dp[i] = min(triangle[i])+dp[i+1]

so for dp[depth]
11 9 6 1
overlapping sp, opt sub
state: depth, sum(?)

from the beginning...
we can do dfs
recursive function takes the depth, and the current sum, generate all the new sums basically
while calling min()
slow, 2^n I think?
*/
