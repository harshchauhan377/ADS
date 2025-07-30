import java.util.Arrays;
public class _18_mergeSortRec{
    public static void main(String[] args){
        int[] arr = {5, 2, 8, 4, 1, 7};
        System.out.println("Original: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted:   " + Arrays.toString(arr));
    }

    public static void mergeSort(int arr[] , int low , int high ){
        if(low>=high){
            return ;
        }

        int mid = low + (high - low)/2;

        mergeSort(arr , low , mid);
        mergeSort(arr , mid+1 , high);

        merge(arr , low , mid , high);
    }

    public static void merge(int[] arr , int low , int mid , int high){
        int temp[] = new int[high - low + 1];
        int i = low ; 
        int j = mid+1 ; 
        int k = 0 ;

        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=high){
            temp[k++]=arr[j++];
        }

        for(int a = 0 ; a<temp.length ; a++){
            arr[low + a]=temp[a];
        }
    }
}
