import java.util.ArrayList;
public class _12_backtracking_L3{
    public static void main(String[] args){
        // Rat in A Maze Problem (BACKRACKING)
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        ArrayList<String>res = new ArrayList<>();
        back1(maze, 0, 0, res, "");
        System.out.print("Rat in Maze : ");
        System.out.println(res);

        // rat in a maze 2nd approch (DFS)

        int [] ipath={1,0,0,-1};
        int[] jpath={0,-1,1,0};
        boolean[][] vis= new boolean[maze.length][maze[0].length];
        vis[0][0]=true;
        ArrayList<String> ans= new ArrayList<>();
        find(0,0,maze,ipath,jpath,"",ans, vis);
        System.out.print("Rat in Maze : ");
        System.out.println(ans);
        
    }

    // Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
    // Output: ["DDRDRR", "DRDDRR"]
    public static void back1(int maze[][] , int i , int j , ArrayList<String>res , String curr ){
        int n =maze.length ;
        int m = maze[0].length;

        if(i<0 || j<0 || i>=n || j>=m || maze[i][j]==0 || maze[i][j]==2 ){
            return;
        }

        if( i == n-1 && j == m-1 ){
            res.add(curr);
            return ;
        }

        // visit 
        int orig = maze[i][j];
        maze[i][j] = 2;
        // 4 option 
        // down 
        back1(maze, i+1, j, res, curr + "D");
        //up
        back1(maze, i-1, j, res, curr + "U");
        //right
        back1(maze, i, j+1, res, curr + "R");
        //left
        back1(maze, i, j-1, res, curr + "L");

        //backtrack 
        maze[i][j] = orig;

    }

    // (DFS) APPROCH FOR RAT IN A MAZE

    public static void find(int i, int j, int [][] maze, int [] ipath, int []jpath, String temp, ArrayList<String> ans, boolean[][] vis )
    {
        if((i==maze.length-1) && (j== maze[0].length-1))
        {
            ans.add(new String (temp));
            return;
        }
        String choice="DLRU";
        for(int idx=0;idx<4;idx++)
        {
            int ii=i+ipath[idx];
            int jj= j+jpath[idx];
            
            if(ii>=0 && jj>=0 &&ii<maze.length && jj<maze[0].length && maze[ii][jj]!=0 && ! vis[ii][jj])
            {
                vis[ii][jj]=true;
                find(ii,jj,maze,ipath,jpath,temp+choice.charAt(idx), ans, vis);
                vis[ii][jj]=false;
            }
            
        }
    }

}