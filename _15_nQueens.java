public class _15_nQueens{
    public static void main(String[] args) {
        int n = 4;
        // we will keep the array as zero
        int sol[][] = new int[n][n];

        if(NQ(0,sol,n)==true){
            print(sol);
        }else{
            System.out.println("Sollution does not exist");
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

    public static boolean iSafe(int[][]sol , int col , int row , int n){
        // left side of same rowz 
        for(int c = 0 ; c < col ; c++ ){
            if(sol[row][c]==1){
                return false;
            }
        }

        // upper diagonal used not nested to save from timeComplexity and lessCode
        for(int i = row , j = col ; i >= 0 && j >= 0 ; i-- , j--){
            if(sol[i][j]==1){
                return false;
            }
        }

        // lower diagonal
        for(int i = row ,j = col ; i<n && j>=0 ; i++ , j--){
            if(sol[i][j]==1){
                return false;
            }
        }
        return true;
    }

    public static boolean NQ(int col,int sol[][],int n){
        if(col >= n){
            return true;
        }

        for(int row = 0 ; row <n ; row++){
            if(iSafe(sol, col, row , n)){
                sol[row][col]=1;
                if(NQ(col+1,sol,n)==true){
                    return true;
                }else{
                    sol[row][col]=0;
                }
            }
        }
        return false;
    }
}