public class Main {
    static int findPeak(int[] array, int low, int high) {
        int length = array.length;
        int mid = low + (high - low)/2;
        if ((mid == 0 || array[mid-1] <= array[mid]) && (mid == length-1 || array[mid+1] <= array[mid]))
            return mid;
        else if (mid > 0 && array[mid-1] > array[mid])
            return findPeak(array,low,mid-1);
        else
            return findPeak(array,(mid+1),high);
    }
    public static void main(String[] args) {
        int array[] = {15,24,18,16,13,10,15,21,12};
        System.out.println("Peak found at index "+findPeak(array,0,array.length-1)+": "+array[findPeak(array,0,array.length-1)]);
    }
}
