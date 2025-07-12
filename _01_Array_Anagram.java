import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
public class _01_Array_Anagram{
    public static void main(String[] args){
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(isAnagram(str1,str2 ));

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagram(input);
        System.out.println("Grouped Anagrams: " + result);


    }

    public static boolean isAnagram(String str1 , String str2){
        if(str1.length() != str2.length()) return false ;

        int[]frq = new int[26];

        for(char c : str1.toCharArray()){
            frq[c-'a']++;
        }

        for(char c : str2.toCharArray()){
            frq[c-'a']--;
            if( frq[c-'a']< 0 ){
                return false ;
            }
        }

        // if(int x : frq){
        //     if(x!=0){
        //         return false ;
        //     }
        // }

        return true;

    }
    public static List<List<String>> groupAnagram(String[] strs ){
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String Key = new String(ch);
            if(map.containsKey(Key)){
                map.get(Key).add(str);

            }else{
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(Key,newList);
            }
        }
        return new ArrayList<>(map.values());
    }
}