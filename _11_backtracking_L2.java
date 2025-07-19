import java.util.*;
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

}