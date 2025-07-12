import java.util.HashMap;
public class _02_Array_EleOnceInArray{
    public static void main(String[] args) {
        int arr[]={2,3,5,4,5,3,4}; 
        System.out.println("ele appear once in array : "+ EleAppearOnce(arr));
        
    }

    public static int EleAppearOnce(int[]arr){
        HashMap <Integer,Integer> map = new HashMap<>();

        for(int n : arr){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        for(var n : map.entrySet()){
            if(n.getValue()==1){
                return n.getKey() ;
            }
        }

        return -1;
    }
}