import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
public class _11_backtracking_L2{
    public static void main(String[] args){
        ///////////////////////////////////////////////////////////////////////////////////
        //print all Subsequence of String in lexicographically order
        String s = "abc";
        List<String> res = new ArrayList<>();
        int n = s.length();
        back(s, 0, res, "", n);

        // ✅ Sort the result lexicographically
        Collections.sort(res);
        System.out.print("print all Subsequence of String in lexicographically order :- ");
        System.out.println(res);

        ///////////////////////////////////////////////////////////////////////////////////
        //print all Subsequence of Array of Integer
        int arr1[]= {1,2,3};
        ArrayList<Integer> res2 = new ArrayList<>();
        System.out.println("print all Subsequence of Array in Integer :- ");
        back2(arr1 , 0 , res2);

        ///////////////////////////////////////////////////////////////////////////////////
        //print all Subsequence of Array of Integer equal to target 
        int arr2[]= {1,2,3}; int target1 = 3;
        ArrayList<Integer> res3 = new ArrayList<>();
        System.out.println("print all Subsequence of Array of Integer equal to target  :- ");
        back2(arr2 , 0 , res3 , target1);

        ///////////////////////////////////////////////////////////////////////////////////
        //combination 1
        int[]candidates = {2,3,6,7}; int target2 = 7;
        List<Integer>curr4 = new ArrayList<>();
        List<List<Integer>> res4 = new ArrayList<List<Integer>>();
        back3(candidates , 0 , target2 , curr4 , res4);
        System.out.print("combination 1 : ");
        System.out.println(res4);

        ///////////////////////////////////////////////////////////////////////////////////
        //  combination 2
        
        int[]candidate = {10,1,2,7,6,1,5}; int target3 = 8;
        Arrays.sort(candidate);
        List<Integer>curr5 = new ArrayList<>();
        List<List<Integer>> res5 = new ArrayList<List<Integer>>();
        back4(candidate , 0 , target3 , curr5 , res5);
        System.out.print("combination 2 : ");
        System.out.println(res5);

        ///////////////////////////////////////////////////////////////////////////////////
        //  combination 3
        int k6 = 3 ; int n6 = 7;
        List<Integer>curr6 = new ArrayList<>();
        List<List<Integer>>res6 = new ArrayList<List<Integer>>();
        back5(1 , k6 , n6 , curr6 , res6);
        System.out.print("combination 3 : ");
        System.out.println(res6);

        ///////////////////////////////////////////////////////////////////////////////////
        // COmbination 4
        int []nums = {1,2,3} ; int target = 4 ;
        int dp[] = new int[target+1];
        Arrays.fill(dp,-1);
        System.out.print("combination 4 : ");
        int ans = dpM(nums , target , dp);
        System.out.println(ans);



    }
    //print all Subsequence of String in lexicographically order
    public static void back(String s , int idx , List<String>res , String curr , int n){
        if(idx == n){
            if(!curr.isEmpty()){
                res.add(curr);
            }
            return ;
        }
        
        // pick 
        curr += s.charAt(idx);
        back(s , idx + 1 , res , curr , n);
        
        //nonPick
        curr = curr.substring(0 , curr.length()-1);
        back(s , idx + 1 , res , curr , n);
    }

    // print all Subsequence of Array of Integer
    public static void back2(int arr[] , int idx , ArrayList<Integer>res ){
        if(idx == arr.length){
            System.out.println(res);
            return;
        }

        // pick 
        res.add(arr[idx]);
        back2(arr , idx + 1 , res );

        // nonPick
        res.remove(res.size()-1);
        back2(arr , idx + 1 , res );
    }

    // print all Subsequence of Array of Integer equals to target 
    public static void back2(int arr[] , int idx , ArrayList<Integer>res , int target){
        if(idx == arr.length){
            if(target == 0){
                System.out.println(res);
            }
            return;
        }

        // pick 
        res.add(arr[idx]);
        back2(arr , idx + 1 , res , target - arr[idx]);

        // nonPick
        res.remove(res.size()-1);
        back2(arr , idx + 1 , res , target);
    }

    // combination 1 
    // Input: candidates = [2,3,6,7], target = 7
    // Output: [[2,2,3],[7]]
    public static void back3(int arr[] , int idx , int target , List<Integer>curr , List<List<Integer>>res ){
        if(target < 0) return ;

        if(idx == arr.length){
            if(!curr.isEmpty()){
                if(target == 0){
                res.add(new ArrayList<>(curr));
                }
            }
            
            return;
        }

        //pick
        curr.add(arr[idx]);
        back3(arr , idx , target - arr[idx] , curr , res );

        // nonPick
        curr.remove(curr.size()-1);
        back3(arr , idx + 1 , target , curr , res);

    }

    // combination 2    // no duplicate 
    //Input: candidates = [10,1,2,7,6,1,5], target = 8
    //Output: [[1,1,6],[1,2,5],[1,7],[2,6]]

    public static void back4(int arr[] , int idx , int target , List<Integer>curr , List<List<Integer>>res ){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return ;
        }

        // one way 

        // for(int i = idx ; i< arr.length ; i++){
        //     if( (i == idx || arr[i-1] != arr[i]) && arr[i] <= target ){
        //         curr.add(arr[i]);
        //         back4(arr ,  i + 1 , target - arr[i], curr , res );
        //         curr.remove(curr.size()-1);
        //     }
        // }

        // sec way 
        for(int i = idx ; i< arr.length ; i++){

            if(i > idx && arr[i] == arr[i-1]) continue ;
            if(arr[i] > target) break;

            curr.add(arr[i]);
            back4(arr ,  i + 1 , target - arr[i] , curr , res );
            curr.remove(curr.size()-1);
        }
    }

    // Combination 3
    //Input: k = 3, n = 7
    //Output: [[1,2,4]]
    //Explanation: 1 + 2 + 4 = 7

    public static void back5(int n , int k , int target , List<Integer>curr  , List<List<Integer>>res){
        if(target < 0 || k < 0) return ;

        if(target == 0 && k == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = n ; i <= 9 ; i ++){
            curr.add(i);
            back5(i+1 , k-1 , target - i , curr , res );
            curr.remove(curr.size()-1);
        }
    }

    // Combination 4
    // Input: nums = [1,2,3], target = 4
    // Output: 7
    // Explanation: The possible combination ways are:
    // [(1, 1, 1, 1),(1, 1, 2),(1, 2, 1),(1, 3),(2, 1, 1),(2, 2),(3, 1)]

    // public static int count = 0 ;
    public static int dpM(int arr[] , int target , int []dp){
        if(target == 0) return 1 ;
        if(target < 0) return 0 ;

        if(dp[target] != -1){
            return dp[target];
        }

        int count = 0 ;
        for(int i = 0 ; i< arr.length ; i++){
            count += dpM(arr , target - arr[i] , dp);
        }

        dp[target] = count ;
        return dp[target];
    }

}