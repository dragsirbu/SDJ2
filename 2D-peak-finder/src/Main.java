import java.util.Random;

public class Main {

    static int findPeakUtil(int[] array, int low, int high, int arrSize) {
        //find the middle element of the array
        int mid = low + (high-low)/2;

        if ((mid == 0 || array[mid] >= array[mid-1]) &&
                (mid == arrSize-1 || array[mid]>=array[mid+1]))
            return mid;
        else if (mid > 0 && array[mid] < array[mid-1])
            return findPeakUtil(array,low,mid-1,arrSize);
        else
            return findPeakUtil(array,mid+1, high,arrSize);
    }

    // A wrapper over recursive function findPeakUtil()
    static int findPeak(int array[], int n)
    {
        return findPeakUtil(array, 0, n-1, n);
    }

    static int findMaxIndex(int[] array) {
        int maxIndex = 0;
        for (int i = 1;i < array.length;i++) {
            if (array[i] > array[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
    static int[] getColumn(int[][] array,int index) {
        int[] column = new int[array[0].length];
        for (int i=0;i < column.length;i++) {
            column[i] = array[i][index];
        }
        return column;
    }

    static int find2DPeak(int[][] array, int rows, int columns) {



        //pick middle column
        int mid = columns/2;

        //find the global maximum on that column
        int maxIndex = findMaxIndex(getColumn(array,mid));
        int max = array[maxIndex][mid];

        //if column is first or last, the column max is already a peak
        if (mid == 0 || mid == columns-1)
            return max;

        //if the elements to the left or right of the column max are not higher, the column max is a peak
        if (max >= array[maxIndex][mid-1] && max >= array[maxIndex][mid+1])
            return max;

        //if the left element is higher, study only the left half
        if (max < array[maxIndex][mid-1])
            return find2DPeak(array,rows,mid-mid/2);

        //if the right element is higher, study only the right half
        return find2DPeak(array,rows,mid+mid/2);
    }

    public static void main(String[] args) {
//        int[] array = {8,25,69,58,64,75,78,81,24,87,99};
//        int peakIndex = findPeak(array,array.length);
//        System.out.println("Peak "+array[peakIndex]+" found at index "+peakIndex);
        Random rand = new Random();
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(100) + 1;
            }
        }
        System.out.println("The 2D array is\n");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("One peak is " + find2DPeak(array, array.length, array[0].length));
    }
}
