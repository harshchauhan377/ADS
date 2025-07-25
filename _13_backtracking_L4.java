public class _13_backtracking_L4{
    public static void main(String[] args){
        // number of islands 
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        // now we will count the no. of islands 
        int count = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    Solve1(grid, i, j);  // mak echanges in this for using Solve or Solve2
                }
            }    
        }

        // number of ISlands ANS 
        System.out.print("NUmber of ISlands in grid is : ");
        System.out.println(count);
    }

    public static void Solve(char [][]grid , int i , int j) {
        int r = grid.length;
        int c = grid[0].length;

        // dead ends
        if(i<0 || j<0 || i>=r || j>=c || grid[i][j]=='0' || grid[i][j]=='2'){
            return ;
        }

        //marking visited
        grid[i][j]='2';

        // all four direction 
        Solve(grid, i+1, j); // down
        Solve(grid, i-1, j); // up
        Solve(grid, i, j+1); // right
        Solve(grid, i, j-1); // left

    }

    // another way for same ques is 

    public static void Solve1(char [][]grid , int i , int j) {
        int r = grid.length;
        int c = grid[0].length;

        // dead ends
        if(i<0 || j<0 || i>=r || j>=c || grid[i][j]=='0' || grid[i][j]=='2'){
            return ;
        }

        //marking visited
        grid[i][j]='2';

        int dx[]={1,-1,0,0};
        int dy[]={0,0,1,-1};

        for(int ind = 0 ; ind< dx.length ; ind++){
            int x = i + dx[ind] ;
            int y = j + dx[ind];
            Solve1(grid, y, x);

        }

        // all four direction 
        // Solve(grid, i+1, j); // down
        // Solve(grid, i-1, j); // up
        // Solve(grid, i, j+1); // right
        // Solve(grid, i, j-1); // left

    }

}