import java.util.HashMap;
public class _04_Array_prefixSum{
    public static void main(String[] args) {
        int [] arr = {10,2,-2,-20,10};
        int [] ans = createPrefix(arr);
        // create prefix sum array 
        for(int n : ans){
            System.out.println(n+" ");
        }
        //check if subarray with sum K exist ;
        int target = -10;
        System.out.println("total subarray with sum K : "+countSubarray(arr,target));

        //check if subarray with sum K exist ;
        int [] arr1 = {1,7,3,6,5,6};
        System.out.println("Pivot index : "+pivotIndex(arr1));
    }

    public static int[] createPrefix(int[] arr){
        int prefix[] = new int[arr.length];
        prefix[0]=arr[0];
        for(int i = 1 ; i <arr.length ; i++){
            prefix[i]=prefix[i-1]+arr[i];
        } 
        return prefix;
    }

    public static int countSubarray(int[] arr, int target){
        HashMap<Integer,Integer> prefixSum = new HashMap<>();

        int cnt = 0;
        int currSum = 0;

        for(int i=0; i< arr.length ; i++){
            //curr sum me array of i ki value add ki  
            currSum += arr[i];
            // fir check karte h ki , kya vo value target ke equal tho nahi 
            if(currSum == target){
                cnt++ ;
            }
            // check kar lete h kya pata vo prefixSum m ho to uski frq valo ko add kar denge  
            if(prefixSum.containsKey(currSum - target )){
                cnt += prefixSum.get(currSum - target);
            }
            // agar vo ele nahi h prefixSum me , tho usko add kar dete h , agar h tho uski freq value inc kar dete h 
            prefixSum.put(currSum , prefixSum.getOrDefault(currSum,0)+1);
        }

        return cnt;

    }

    public static int pivotIndex(int[]nums ){
        int total = 0;
        for(int num : nums) total+=num;

        int ls = 0;
        for(int i =0; i<nums.length; i++){
            if(ls==total -ls -nums[i]) return i;
            ls += nums[i];
        }

        return -1;
    }
}
