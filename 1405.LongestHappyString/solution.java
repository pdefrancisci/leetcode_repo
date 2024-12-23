class Solution {
    class Letter{
        char c;
        int count;
        public Letter(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Letter> heap = 
            new PriorityQueue<Letter>((one,two)->two.count-one.count);
        String ret = "";
        Letter aPrime = new Letter('a',a);
        Letter bPrime = new Letter('b',b);
        Letter cPrime = new Letter('c',c);
        if(aPrime.count!=0)
            heap.add(aPrime);
        if(bPrime.count!=0)
            heap.add(bPrime);
        if(cPrime.count!=0)
            heap.add(cPrime);
        //quicker than making it null and checking null
        char prev = '-';
        while(!heap.isEmpty()){
            Letter hl = heap.poll();
            char highest = hl.c;
            int highCount = hl.count;
            if(prev!=highest){
                if(highCount==1){
                    ret=ret+highest;
                    highCount--;
                    prev=highest;
                    //do not put the element back, it's empty!
                    continue;
                }
                else{
                    ret=ret+highest+highest;
                    highCount=highCount-2;
                    prev=highest;
                }
            }
            else{
                if(heap.isEmpty()){
                    //what if we only printed one hl before?
                    return ret;
                }
                else{
                    Letter temp = heap.poll();
                    ret=ret+temp.c;
                    temp.count=temp.count-1;
                    if(temp.count!=0){
                        heap.add(temp);
                    }
                    prev=temp.c;
                }
            }
            hl.count=highCount;
            if(hl.count!=0){
                heap.add(hl);
            }
        }
        return ret;
    }
}
/*
O(n*log(3))

ccacc
prev:c
c:3
b:1

how do we know the highest letter
    for growth it's easy to track, cuz you grow one, compare to the max
    for degrowth it's hard, you go down, you have to compare to all letters and sizes
    so idk a heap

edge case:
    hl:1, others are 0, hl not prev
    basically, we need to check that hl does not run out

ok so let's try this
ccaccbcc
a:0
b:0
c:1

rough idea:
    we know the previous char
    we know the count of the highest letter
    #hl > others, and hl is not the prev
        2x hl
    #hl > others, hl is prev
        1x next hl
    two hls are equal
        place one of the counts
    hl > others, others == 0, previous char is hl
        is [len-2] hl? then return
        else, return ret + hl
    recalc hl, recalc prev


cannot proceed
a+3<c, for instance
in such an instance, consume until a,b=0 and c=3
print your cs and then stop, leave c=1

easy:
a=b=c
abcabcabc...
*/
