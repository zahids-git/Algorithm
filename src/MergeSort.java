import java.util.Random;

public class MergeSort {

    public static void main(String[] args){
        int[] allRandom = /*new int[]{38, 9, 67, 53, 60, 70} ;*/getAllRandomData();
        /*for (int x=0;x<allRandom.length;x++)
            System.out.print(allRandom[x]+" ");*/

        System.out.println();

        long startTime = System.nanoTime();
        merge(allRandom);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.print("Millisecond - "+(duration/1000000));

        /*for (int x=0;x<allRandom.length;x++)
            System.out.print(allRandom[x]+" ");*/
    }

    public static void merge(int[] arrayData){
        int mainArraySize = arrayData.length;
        if(mainArraySize < 2) return ;
        else {
            int[] leftArray = new int[mainArraySize/2];
            int[] rightArray = new int[mainArraySize - leftArray.length];
            for(int x=0;x<leftArray.length;x++)
                leftArray[x] = arrayData[x];

            for(int y=0;y<rightArray.length;y++)
                rightArray[y] = arrayData[y+leftArray.length];

            merge(leftArray);
            merge(rightArray);
            recursive(leftArray,rightArray,arrayData);
        }
    }

    public static void recursive(int[] leftArray, int[] rightArray, int[] mainArray){
        int leftArraySize = leftArray.length;
        int rightArraySize = rightArray.length;
        int leftInit,rightInit,mainInit;
        leftInit = rightInit = mainInit = 0;
        while(leftInit < leftArraySize && rightInit < rightArraySize){
            if(leftArray[leftInit] <= rightArray[rightInit])
                mainArray[mainInit] = leftArray[leftInit++];
             else
                mainArray[mainInit] = rightArray[rightInit++];
            mainInit++;
        }

        while (leftInit < leftArraySize)
            mainArray[mainInit++] = leftArray[leftInit++];

        while (rightInit < rightArraySize)
            mainArray[mainInit++] = rightArray[rightInit++];
    }

    static int[] getAllRandomData(){
        Random rand = new Random();
        int randomDataSize = 100000;
        int[] allData = new int[randomDataSize];
        for (int x=0;x<randomDataSize;x++) {
            allData[x] = rand.nextInt(1000000) + 1;
        }
        return allData;
    }
}
