import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class _07_recursion_b2{
    public static void main(String[]args){
        //1. Sum of N by parameterised way 
        System.out.println("Sum of N by parameterised way : ");
        paramSum(5,0);

        //2. Print all subsequence of Array 
        System.out.println("\nPrint all subsequence of Array  : ");  
        int arr[]={1,2,3};
        List<Integer> ds = new ArrayList<>();
        printSubsequence(0,ds,arr);
        
        //2. Print all subsequence of Array 
        System.out.println("\nPrint all subsequence of Array without duplicate : ");
        int[] nums = {1, 2, 2};
        Arrays.sort(nums); // Important to handle duplicates
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, current, result);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }

        //2. Print all subsequence of Array 
        System.out.println("\nPrint all subsequence of Array with sum k  : ");  
        int arr1[]={1,2,1}; int k1 = 2; int sum1 =0;
        List<Integer> ds1 = new ArrayList<>();
        printSubsequenceKSum(0,ds1,arr1,k1,sum1);

        //2. Print only one subsequence of Array  
        System.out.println("\nPrint only one of Array with sum k  : ");  
        int arr2[]={1,2,1}; int k2 = 2; int sum2 =0;
        List<Integer> ds2 = new ArrayList<>();
        printOneSubsequenceKSum(0,ds2,arr2,k2,sum2);
    }
    public static void paramSum(int n,int sum){
        if(n<1){
            System.out.println(sum);
            return;
        }
        paramSum(n-1, sum+n);
    }
    public static void printSubsequence(int idx , List<Integer> ds , int[]arr){
        if(idx == arr.length){
            System.out.println(ds);
            return ;
        }
        //pick curr ele 
        ds.add(arr[idx]);
        printSubsequence(idx+1 , ds , arr);

        //no pick curr ele 
        ds.remove(ds.size()-1);
        printSubsequence(idx+1 , ds , arr);
    }

    public static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void printSubsequenceKSum(int idx , List<Integer> ds , int[]arr , int k , int sum){
        if(idx == arr.length){
            if(sum==k){
                System.out.println(ds);
            }
            return;
        }
        // pick 
            ds.add(arr[idx]);
            printSubsequenceKSum(idx+1 , ds , arr , k , sum+arr[idx]);

        // non pick 
        ds.remove(ds.size()-1);
        printSubsequenceKSum(idx+1 , ds , arr , k , sum);
    }

    public static boolean printOneSubsequenceKSum(int idx , List<Integer> ds , int[]arr , int k , int sum){
        if(idx == arr.length){
            if(sum==k){
                System.out.println(ds);
                return true;
            }
            return false ;
        }
        // pick 
        ds.add(arr[idx]);
        if(printOneSubsequenceKSum(idx+1 , ds , arr , k , sum+arr[idx])) return true;

        // non pick 
        ds.remove(ds.size()-1);
        if(printOneSubsequenceKSum(idx+1 , ds , arr , k , sum)) return true;

        return false ;
    }
}