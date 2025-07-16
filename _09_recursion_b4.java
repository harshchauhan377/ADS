public class _09_recursion_b4{
    public static void main(String[] args){
        // convert Decimal to Binary 
        int decimal = 100;
        System.out.print("Decimal to Binary: ");
        decimalToBinary(decimal);

        //reverse a number
        int number = 345; int res = 0 ;
        System.out.print("\nreverse of number without zero :");
        int ans = reverseNo(number , res);
        System.out.print(ans);

        //reverse a String containing number 
        String num = "123"; int indx = num.length() ; String ress = "";
        System.out.print("\nreverse of string containing number :");
        String a = rverseString(num , indx , ress);
        System.out.print(a);

        // reverse a Array using rec 
        char[] arr = {'a' , 'b' , 'c' , 'd' , 'h' , 'e' , 'f'};
        System.out.print("\nreverse of array using recursion :");
        rev(arr, 0);
        System.out.println(arr);

        //TOwer of Hanoi 
        int n = 3;
        int totalMoves = towerOfHanoi(n, 1, 3, 2, 0);
        System.out.println("TOwer of Hanoi , Total moves: " + totalMoves);


        //total No. of Ways
        int r = 3 ; int c = 3 ;
        int total = totalWays(r-1 , c-1);
        System.out.println("Total ways to fill the grid: " + total);


    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
    // convert decimal to Binary 
    public static void decimalToBinary(int n){
        if(n == 0) return ;

        decimalToBinary(n / 2);

        System.out.print(n % 2);
    }

    //reverse a number 
    public static int reverseNo(int n , int res ){
        if(n==0) return res;

        res = res * 10 + (n % 10);
        
        return reverseNo(n / 10 , res);

    }

    // reverse a String conraining number 
    public static String rverseString(String input , int idx , String res){
        if(idx == 0){
            return res;
        }

        res += input.charAt(idx-1) ;
        
        return rverseString(input , idx - 1 , res);
    }

    // reverse a Array in place by rec
    public static void rev(char word[] , int n ){
        if(n >= word.length / 2){
            return ;
        }

        
        rev(word , n + 1);
        swap( word , n , word.length - n- 1);
    }

    public static void swap(char[] arr , int i , int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Tower of Hanoi
    public static int towerOfHanoi(int n, int from, int to, int aux , int count){
        if(n==1){
            count++;
            return count;
        }

        count = towerOfHanoi( n-1 , from , aux , to , count );
        count++;
        count = towerOfHanoi( n-1 , aux , to , from , count );

        return count;
    }

    // Count total Ways in a matrix
    public static int totalWays(int r , int c){
        if(r == 0 && c == 0 ){
            return 1;
        }

        if(r < 0 || c < 0 ){
            return 0 ;
        }

        return totalWays(r , c-1) + totalWays(r -1 , c);
    }

    // //approch sec
    // public static int totalWays1(int r , int c){
    //     if(r == r-1 && c == c-1 ){
    //         return 1;
    //     }

    //     if(r > 0 || c > 0 ){
    //         return 0 ;
    //     }

    //     return totalWays(r , c+1) + totalWays(r+1 , c);
    // }
}