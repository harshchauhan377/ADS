import java.util.HashMap;
public class _03_Array_frqArray_hasDuplicate{
    public static void main(String[] args) {
        String str = "harrrssh";
        System.out.println("String has duplicate  : "+hasDulpicate(str));
        System.out.println("Count of duplicate char : "+countDuplicateChars(str));
        System.out.println("First no repeating char At index : "+firstNonRepeatChar(str));
        System.out.print("NON reapeated char : ");
        printNonRepeatedChars(str);
        System.out.println("\nchar Appear most : "+mostfreqChar(str));
        String str1 = "paper";
        String str2 = "title";
        System.out.println("\nis two String are Isomorphic by frq  : "+isIsomorphicFrq(str1,str2));
        System.out.println("\nis two String are Isomorphic by hashMap : "+isIsomorphicHashMap(str1 ,str2));

    }

    public static boolean hasDulpicate(String str){
        int frq[] = new int[26];
        // for(char c : str.toCharArray()){
        //     if(++frq[c-'a'] > 1){
        //         return true;
        //     }
        // }
        for(char c : str.toCharArray()){
            frq[c-'a']++;
        }
        for(char c : str.toCharArray()){
            if(frq[c-'a'] > 1){
                return true;
            }
        }
        return false;
    } 

    public static int countDuplicateChars(String str){
        int[]frq = new int[26];
        for(char c: str.toCharArray()){
            frq[c-'a']++;
        }
        int cnt = 0;
        for(int f : frq){
            if(f>1) cnt++;
        }
        return cnt;
    }

    public static int firstNonRepeatChar(String s){
        int[] frq = new int[26];

        for(char c : s.toCharArray()){
            frq[c-'a']++;
        }

        for(int i=0 ; i<s.length() ; i++){
            if( frq[s.charAt(i)-'a'] == 1 ){
                return i ;
            }
        }

        return -1;
    }

    public static void printNonRepeatedChars(String s){
        int[] frq = new int[26];
        for(char c : s.toCharArray()){
            frq[c-'a']++;
        }

        for(char c : s.toCharArray()){
            if( frq[c-'a'] ==1 ){
                System.out.print(c+" ");
            }
        }
    }

    public static char mostfreqChar(String s) {
        int [] frq = new int[26];

        for(char c : s.toCharArray()){
            frq[c-'a']++;
        }
        int max  = 0 ;
        char r = '\0';
        for(int i =0 ; i<26 ; i++){
            if(frq [i]> max){
                max = frq[i];
                r = (char)(i +'a');
            }
        }

        return r ; 
    }

    public static boolean isIsomorphicFrq(String s , String t){
        //frq array not by hashmap 
        if(s.length() != t.length()) return false;
        
        int[]sMap = new int[256];
        int[]tMap = new int[256];

        for(int i =0; i<s.length() ; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(sMap[sc]!=tMap[tc]){
                return false ;
            }

            sMap[sc]=i+1;
            tMap[tc]=i+1;

        }
        return true;
    }

    public static boolean isIsomorphicHashMap(String s , String t){
        if(s.length() != t.length()) return false;

        HashMap<Character,Character> Smap = new HashMap<>();
        HashMap<Character,Character> Tmap = new HashMap<>();

        for(int i =0; i<s.length() ; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(Smap.containsKey(sc)){
                if(Smap.get(sc)!=tc) return false ;
            }else{
                Smap.put(sc,tc);
            }

            if(Tmap.containsKey(tc)){
                if(Tmap.get(tc)!=sc) return false;
            }else{
                Tmap.put(tc,sc);
            }
        }
        return true;
        
    }

}