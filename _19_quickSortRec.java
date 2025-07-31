import java.util.Arrays;
public class _19_quickSortRec{
    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        System.out.println("Original: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    public static void quickSort(int[]arr , int low , int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[]arr , int low , int high){
        int pivot = arr[high];
        int j = low - 1;
        for(int i = low ; i < high ; i++){
            if(arr[i] < pivot){
                j++;
                swap(arr , j , i);
            }
        }
        swap(arr , j + 1 , high);
        return j+1;
    }

    public static void swap(int[]arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
    }
}