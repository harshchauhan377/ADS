import java.util.Stack;
public class _16_reverseStack{
    public static void main(String[]args){
        // using recursion 3|| Leaf faith of recusion
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.print("Orignal stack : "+stack);
        reverse(stack);
        System.out.print("\nreverse stack : "+stack);
        
    }

    public static void reverse(Stack<Integer>stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverse(stack);
        insertAtBottom(stack,top);
    }

    public static void insertAtBottom(Stack<Integer>stack , int ele){
        if(stack.isEmpty()){
            stack.push(ele);
            return ;
        }
        int top = stack.pop(); // 2 1
        insertAtBottom(stack , ele); // []  2,1 || 3
        stack.push(top); // [3, 2, 1] 
    }
}