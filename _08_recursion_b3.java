import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class _08_recursion_b3{
    public static void main(String[] args) {
        // all subset whose sum is dividible by k
        int arr1[]= {1,2,3}; int k1 = 3 ; int sum1 = 0;
        System.out.println("all subset whose sum is dividible by k ");
        List<Integer> ds1 = new ArrayList<>();
        printSubsequenceDivK(0,ds1,arr1,sum1,k1);

        // Combination  Sum - Repeated Allowed
        int arr2[]= {2,3,6,7};
        int target2 = 7;
        System.out.println("\nCombination Sum - Repeated Allowed");
        List<Integer> ds2 = new ArrayList<>();
        printCombinationSum(0,ds2,arr2,target2);

        // Combination  Sum  2 - No repetion , May contain Duplicates
        int arr3[]= {10,1,2,7,6,1,5};
        int target3 = 8;
        Arrays.sort(arr3);
        System.out.println("\nCombination Sum  2 - No repetion , May contain Duplicates ");
        List<Integer> ds3 = new ArrayList<>();
        printCombinationSum2(0,ds3,arr3,target3);
    }

    public static void printSubsequenceDivK(int idx , List<Integer>ds , int arr[] , int sum , int k){
        if(idx == arr.length){
            if(sum % k == 0){
                System.out.println(ds);
            }
            return;
        }

        ds.add(arr[idx]);
        printSubsequenceDivK(idx+1,ds,arr,sum+arr[idx],k);

        ds.remove(ds.size()-1);
        printSubsequenceDivK(idx+1, ds, arr, sum, k);
    }

    public static void printCombinationSum(int i , List<Integer>ds , int[]arr , int target){
        if(target==0){
            System.out.println(ds);
            return;
        }

        if (i == arr.length || target < 0)
        return;
        
        //pick 
        ds.add(arr[i]);
        printCombinationSum(i,ds,arr,target-arr[i]);
        ds.remove(ds.size()-1);

        //not pick 
        printCombinationSum(i+1,ds,arr,target);
    }

    public static void printCombinationSum2(int index , List<Integer> ds , int[]arr , int target){
        if(target==0){
            System.out.println(ds);
            return;
        }

        for(int i =index ; i<arr.length ; i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }

            if(arr[i]>target){
                break;
            }

            ds.add(arr[i]);
            printCombinationSum2(i+1,ds,arr,target-arr[i]);
            ds.remove(ds.size()-1);
        }
    }
}