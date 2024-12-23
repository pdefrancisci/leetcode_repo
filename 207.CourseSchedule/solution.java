class Solution {
    Map<Integer, List<Integer>> adjacency;
    Map<Integer, Boolean> cache;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //construct the adjacency list
        this.adjacency = new HashMap<>();
        this.cache = new HashMap<>();
        for(int[] prereq : prerequisites){
            List<Integer> val;
            if(adjacency.containsKey(prereq[0])){
                val = adjacency.get(prereq[0]);
            }
            else{
                val = new ArrayList<Integer>();
            }
            val.add(prereq[1]);
            adjacency.put(prereq[0],val);
        }
        //navigate it recursively with a seen hashset
        for(int i=0; i<numCourses; i++){
            if(!dfs(i,new HashSet<Integer>())){
                System.out.print(i);
                return false;
            }
        }
        return true;
    }
    public boolean dfs(Integer i, HashSet<Integer> seen){
        if(cache.containsKey(i)){
            return cache.get(i);
        }
        if(seen.contains(i)){
            cache.put(i,false);
            return false;
        }
        else{
            seen.add(i);
        }
        List<Integer> val = adjacency.get(i);
        if(val==null){
            cache.put(i,true);
            return true;
        }
        // for(int idx = 0; idx<val.size(); idx++){
        for(int v : val){
            if(!dfs(v,new HashSet<Integer>(seen))){
                cache.put(i,false);
                return false;
            }
        }
        cache.put(i,true);
        return true;
    }
}
/*
dfs cycle detection
make and adjacency list
navigate it recursively with a seen hashset
*/
