public class _06_recursion_b1{
    public static void main(String[]args){
        //1. print no. from 1 to N ;
        System.out.println("1. print no. from 1 to 10 ");
        print1ToN(1,10);
        System.out.println("\n");

        //2. print no. fron N to 1 ;
        System.out.println("2. print no. from 10 to 1 ");
        printNTo1(10);
        System.out.println("\n");

        //3. factorial of N using recursion
        System.out.println("3. factorial of 5 ");
        System.out.println("Factorial of 5 is "+fact(5));
        System.out.println("\n");

        //4.Sum of N Natural No.
        System.out.println("4. Sum of 5 natural no.");
        System.out.println("Sum of 5 natural no. is "+sum(5));
        System.out.println("\n");

        //5. print fibonacci series up to N 
        System.out.println("5. print fibonacci series up to 6");
        for (int i = 0; i < 6; i++) {
        System.out.print(fibonnacci(i) + " ");
        }
        System.out.println("\n");
    }
    public static void print1ToN(int i , int n){
        if(i>n) return ;
        System.out.print(i+" ");
        print1ToN(i+1,n);
    }
    public static void printNTo1(int n){
        if(n==0) return ;
        System.out.print(n+" ");
        printNTo1(n-1);
    }
    public static int fact(int n ){
        if(n==0||n==1) return 1;
        return n*fact(n-1);
    }
    public static int sum(int n){
        if(n==0) return 0 ;
        return n+sum(n-1);
    }
    public static int fibonnacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonnacci(n-1)+fibonnacci(n-2);
    }
}