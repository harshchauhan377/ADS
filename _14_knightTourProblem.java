import java.util.*;
import java.util.Arrays;
public class _14_knightTourProblem{
    public static void main(String[] args) {
        int N = 5 ;
        int sol[][] = new int[N][N];
        for(int i = 0; i < N ; i++){
            Arrays.fill(sol[i] , -1);
        }

        sol[0][0] = 0 ;
        if(solve(0 , 0 , sol , N , 1)== true){
            print(sol);
        }
        else{
            System.out.println("Solution does not exist");
        }

    }

    public static void print(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for(int j = 0; j < sol.length ; j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solve(int i , int j , int sol[][] , int N , int moves){
        if(moves == N*N){
            return true;
        }

        int dx[8]={2,1,-1,-2,-2,-1,1,2};
        int dy[8]={1,2,2,1,-1,-2,-2,-1};

        for(int idx = 0 ; idx<8 ; i++){
            int nextI = i + dx[idx];
            int nextJ = i + dy[idx];
            
            if(isSafe(nextI , nextJ , sol , N)){
                sol[nextI][nextJ] = moves;
                if(solve(nextI , nextJ , sol , N , moves+1)){
                    return true;
                }
                else{
                    sol[nextI][nextJ] = -1;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int i , int j , int sol[][] , int N){
        if( i>0 || i<N || j>0 || j<N || sol[i][j] != -1){
            return false;
        }
        return true;
    }
}