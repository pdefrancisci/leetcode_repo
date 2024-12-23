class Solution {
    ArrayList<String> ret;
    public List<String> wordBreak(String s, List<String> wordDict) {
        ret = new ArrayList<String>();
        dfs(s,wordDict,0,new ArrayList<Integer>());
        return ret;
    } 
    public void dfs(String s, List<String> wordDict, int i, ArrayList<Integer> prev){
        if(i==s.length()){
            ret.add(addNewSolution(s,prev));
            return;
        }
        for(String word : wordDict){
            if(match(s,word,i)){
                // System.out.println(word+" matched at "+i);
                prev.add(i+word.length());
                dfs(s,wordDict,i+word.length(),prev);
                prev.remove(prev.size()-1);
            }
        }
    }
    public String addNewSolution(String s, ArrayList<Integer> prev){
        StringBuilder sb = new StringBuilder(s);
        // for(int offset : prev){
        for(int i = prev.size()-2; i>=0; i--){
            int offset = prev.get(i);
            sb.insert(offset,' ');
        }
        return sb.toString();
    }
    //does s at i contain all of word!
    public boolean match(String s, String word, int i){
        return i+word.length() <= s.length() && word.equals(s.substring(i,i+word.length()));
    }
}
/*
wordBreak invokes dfs and returns ret

so, what do we have given this match function
we can generate multiple simultaneous problem states, like:
cats anddog
    cats and dog
cat sanddog
    cat sand dog
so, dfs with multiple problem states.

catsanddog
cat cats and sand dog
so the thing is, we can match cat and cats!
cat sanddog
cats anddog
hooray!

so, for each word in the dict. we try to match
for each successful match, a new problem is created
imagine we had catsa, we would create
catsa nddog
but, no further word would match :+(
*/
