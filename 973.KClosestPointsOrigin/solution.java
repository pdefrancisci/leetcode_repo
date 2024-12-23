class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
            new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    double aDist=Math.sqrt(Math.pow(a[0],2)+Math.pow(a[1],2));
                    double bDist=Math.sqrt(Math.pow(b[0],2)+Math.pow(b[1],2));
                    return ((aDist-bDist)>0)?1:-1;
                }
            });
        for(int[] point : points){
            heap.add(point);
        }
        int[][] ret = new int[k][];
        for(int i=0; i<k;i++){
            ret[i]=heap.poll();
        }
        return ret;
    }
}
/*
pretty clear heap/priorityqueue use case
*/
