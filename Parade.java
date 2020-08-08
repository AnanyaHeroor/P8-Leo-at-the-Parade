/**
 * This class represents floats at a parade
 * @author Ananya Heroor
 */
public class Parade{
    public static void main (String[] args){
    //     System.out.println(findBestFloat(new int[] {4,5,2,5,4}));
    //     System.out.println(findBestFloat(new int[] {1,5,10,1}));
    //     System.out.println(findBestFloat(new int[] {1,10,22,40,100,40000,40001}));
    //     System.out.println(findBestFloat(new int[] {1000,1001,1002,1005}));
    //     System.out.println(findBestFloat(new int[] {5,4,3,2,1}));
    //     System.out.println(findBestFloat(new int[] {1,1,1,1}));
    //     System.out.println(findBestFloat(new int[] {1,0,2,7}));
    //     System.out.println(findBestFloat(new int[] {1,1,9,1}));
    //     System.out.println(findBestFloat(new int[] {1,1,10000,1}));
    //     System.out.println(findBestFloat(new int[] {23984,99999999,9888879,78923}));
    //     System.out.println(findBestFloat(new int[] {-4,75,75757,1993859287}));
        // System.out.println(findTallestGroup(new int[] {5,2,4,4,100,100,100,100,100,2,3,4,2,3}));
        // System.out.println(findTallestGroup(new int[] {500,100,200,300,200,4,3,2,1,500,200,300,100,200}));
        // System.out.println(findTallestGroup(new int[] {500,100,200,300,200,4,3,2,1,500,200,300,100,201}));
        // findNovelFloats(new int [] {10,5,6,7,8,11});
        // findNovelFloats(new int [] {1,2,3,4,5,5});
        // findNovelFloats(new int [] {10,9,10});
        // findNovelFloats(new int [] {2,5,4,8,6,7,8,10});
        // System.out.println(findLongestIncreasingSequence(new int []{10,5,6,7,8,11}));
        // int [] returnArray = findLongestIncreasingSequence(new int[]{10,5,6,7,8,11});
        // int [] returnArray = findLongestIncreasingSequence(new int[]{1,2,5,4,6,4,7,8,9,10,11,12});
        // int [] returnArray = findLongestIncreasingSequence(new int[]{1,2,3,4,3,4,5,4,5,6});
        // int [] returnArray = findLongestIncreasingSequence(new int[]{1,100,1000000,2,3,4,5,1,2});
        // int [] returnArray = findLongestIncreasingSequence(new int[]{10,9,8,7,6,5,4,3,2,1});
        // int [] returnArray = findLongestIncreasingSequence(new int[]{1000,9090,10,4,5,6,7});
        // int i=0;
        // for(i=0; i < returnArray.length; i++) {
        //     System.out.println(returnArray[i]);
    }
    /**
     * This function finds the float with the largest apparent height
     * apparent height of float i = height between float i and float i-1
     * apparent height of the first float is always 0
     * Ex: array {4, 10, 1, 8} the apparent heights are 0, 6, -9 and 7
     */
    public static int findBestFloat(int[] heights){
        int i = 0;
        int largestApparentHeight = 0;
        int apparentHeight = 0;
        int bestI = 0;
        for (i=1; i<heights.length; i++){
            apparentHeight = heights[i]-heights[i-1];
                    if (apparentHeight>largestApparentHeight){
                        largestApparentHeight=apparentHeight;
                        bestI = i;
                    }
        }
                    return bestI;
    } 
    /**
     * This function finds which 5 floats in a row have the largest average height
     */
    public static int findTallestGroup (int[] heights){
        int i = 0;
        double tallestGroup = 0.0;
        double currentAverage = 0.0;
        int bestMiddleI = 0;
        for (i=2; i<=heights.length-3;i++){
            currentAverage = ((heights[i-2]+heights[i-1]+heights[i]+heights[i+1]+heights[i+2])/5.0);
            if (currentAverage>tallestGroup){
                tallestGroup = currentAverage;
                bestMiddleI = i;
            }
        }
        return bestMiddleI;
    }
    /**
     * This function prints out the index of each float that is taller than all floats that came before it
     */
    public static void findNovelFloats(int[] heights){
        int i = 0;
        int previousTopHeight = 0;
        for (i=0; i<heights.length;i++){
            if (heights[i]>previousTopHeight){
                previousTopHeight = heights[i];
                System.out.println(i);

            }
        }
    }
    /**
     * This function prints the longest sequence of floats where each is taller than the last
     */
    public static int [] findLongestIncreasingSequence(int[] heights){
        int iStart= 0;
        int iEnd = 0;
        int seq = 0;
        int bestSeq = 0;
        int bestIStart = 0;
        int bestIEnd = 0;
        int i = 0;
        for(i=0;i<heights.length-1;i++){
            if(heights[i+1] > heights[i]) {
                iEnd = i+1;
                seq = seq+1;
             } else if ( seq>bestSeq ) {
                 bestIStart=iStart;
                 bestIEnd=iEnd;
                 bestSeq=seq;
                 seq=0;
                 iStart=i+1;
             } else {
                 iStart=i+1;
                 iEnd=i+1;
                 seq=0;
             }
         }
         if(seq>bestSeq){
             bestIStart=iStart;
             bestIEnd=iEnd;
         }
        return (new int[] {bestIStart, bestIEnd});
    }
}