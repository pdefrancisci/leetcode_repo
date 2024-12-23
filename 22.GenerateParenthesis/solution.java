class Solution {
    List<String> ret;
    int n;
    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<String>();
        this.n = n;
        dfs("",0,0);
        return ret;
    }
    public void dfs(String curr, int open, int close){
        if(open==close&&open==this.n){
            ret.add(curr);
            return;
        }
        if(open==close){
            dfs(curr+"(",open+1,close);
        }
        else if(open==n){
            dfs(curr+")",open,close+1);
        }
        else{
            dfs(curr+"(",open+1,close);
            dfs(curr+")",open,close+1);
        }
    }
}
/*
backtracking to populate the ret field
*/
