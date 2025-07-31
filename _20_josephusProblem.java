import java.util.ArrayList;
public class _20_josephusProblem{
    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 1 ; i<=n ; i++){
            list.add(i);
        }
        int ans = solve(list , n , 0);
        System.out.println("josephus Problem : "+ans);

    }

    public static int solve(ArrayList<Integer>list ,int k , int idx){
        if(list.size()==1){
            return list.get(0);
        }

        idx = (idx + k - 1) % list.size();

        list.remove(idx);
        return solve(list , k , idx);
    }
}