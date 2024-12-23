class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1; i<amount+1; i++){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                if(i-coin>=0&&dp[i-coin]!=-1){
                    min = Math.min(min,dp[i-coin]);
                }
            }
            if(min==Integer.MAX_VALUE){
                dp[i]=-1;
            }
            else{
                dp[i]=min+1;
            }
        }
        return dp[amount];
    }
}
/*
e1
so from 0, you can have 0 with 0 coins
from 1, you can have 0 with 1 coin, you use the 1 coin and you're there
from 2, much the same, but with the 2 coin
from 3, ...
from 4, you can use the 2 coin, which brings you to the 2 case, which is solved...
not every case can be solved though! mark with a sentinel val
*/
