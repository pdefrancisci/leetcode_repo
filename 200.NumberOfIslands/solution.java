class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[row].length; col++){
                if(grid[row][col]=='1'){
                    // System.out.println("1");
                    dfs(grid,row,col);
                    islands++;
                }
            }
        }
        return islands;
    }
    final int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}};
    public void dfs(char[][] grid, int row, int col){
        if(row<0||row>=grid.length){
            return;
        }
        if(col<0||col>=grid[0].length){
            return;
        }
        if(grid[row][col]!='1'){
            return;
        }
        grid[row][col]='2';
        for(int[] dir : DIRS){
            dfs(grid,row+dir[0],col+dir[1]);
        }
    }
}
/*
full search of the space
if we find land, flood and mark the whole
    thing as seen, inc. the total num islands by 1
*/
