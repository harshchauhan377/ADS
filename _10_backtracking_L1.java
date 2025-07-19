import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class _10_backtracking_L1{
    public static void main(String[] args) {

        // Permutation
        int [] arr = {1,2,3};
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        permutation(arr, 0, res);
        System.out.println(res);

        ////////////////////////////////////////////////////////////////////////////////////////
        
        //palindeom partioning 
        String s = "aab"; int n = s.length();
        List<String> curr = new ArrayList<>();
        List<List<String>> res1 = new ArrayList<List<String>>();
        rec(s , 0 , n , curr , res1);
        System.out.println(res1);


        ////////////////////////////////////////////////////////////////////////////////////////
        
        // Letter Combinations of a Phone Number
        String input = "23";
        ArrayList<String> res2 = new ArrayList<>();
        HashMap<Character,String>map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        letterCombinations(input , 0  , "" , map , res2);
        System.out.println(res2);
        ///////////////////////////////////////////////////////////////////////////////////////
    }
    
    //permutation of array
    public static void permutation(int[] arr, int idx , List<List<Integer>> res ) {
        int n = arr.length;
        // base case
        if(idx == n-1){
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i< n ; i++){
                list.add(arr[i]);
            }
            res.add(list);
            return;
        }

        // task
        for(int i = idx ; i< n ; i++){
            // swap
            swap(arr , i , idx);
            // recursive call
            permutation(arr, idx+1, res);
            // backtrack
            swap(arr , i ,idx);

        }
    }

    public static void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//////////////////////////////////////////////////////////////////////////////////

// Palindrome Partitioning
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

public static void rec(String s , int idx , int n ,List<String>curr , List<List<String>> res){
    if(idx == n){
        res.add(new ArrayList<String>(curr));
        return ;
    }

    for(int i = idx ; i < n ; i++){
        // task
        if(isPalindrom(s , idx , i )){
            curr.add(s.substring(idx,i+1));
            rec(s , i+1 , n , curr , res);
            curr.remove(curr.size()-1);
        }
    }
}

public static boolean isPalindrom(String s , int i , int j){
    while(i<j){
        if(s.charAt(i)!=s.charAt(j)){
            return false ;
        }
        i++; j--;
    }
    return true;
}

//////////////////////////////////////////////////////////////////////////////////
// Letter Combinations of a Phone Number
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    public static void letterCombinations(String digit , int idx  , String curr , HashMap<Character,String>map ,ArrayList<String>res){
        if(idx == digit.length()){
            res.add(curr);
            return ;
        }

        char currDigit = digit.charAt(idx);
        String letters = map.get(currDigit);

        for(int i = 0 ; i < letters.length() ; i++){
            // task
            curr += letters.charAt(i);
            letterCombinations(digit , idx+1 , curr , map , res);
            curr = curr.substring(0 , curr.length()-1);
        }
    }

}