package StacksAndQueues;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String str = "{}[](){[({})]}";
        System.out.println(isBalanced(str));
    }

    /**
     * Method check the string that brackets are balanced or not
     * @param str input string with brackets
     * @return YES or NO according to test
     *
     * Method use stack (last in first out data structure) .push add element to stack, .pop get element
     * (element removed from the stack) from the stack
     *
     * First, create a stack.
     * Then, for next loop start from the first element of the string. In that loop
     *      First, we check character if it is is opening bracket add to the stack
     *      Else, (it is closing bracket) check the last added element to the stack,
     *          if that bracket is not same type with the character, then return NO,
     *          if they are same type continue for next character in string
     * After all the string characters are finished, check the stack,
     *      If stack is empty, it means all brackets are closed so return YES
     *      otherwise return NO
     *
     */
    private static String isBalanced(String str) {
        Stack<Character>stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '{'|| str.charAt(i) == '[' ||str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }else{
                if (stack.empty()){
                    return "NO";
                }else{
                    char tmp = stack.pop();
                    if(str.charAt(i) == ')' && tmp !='('){
                        return "NO";
                    }else if (str.charAt(i) == '}' && tmp !='{'){
                        return "NO";
                    }else if (str.charAt(i) == ']' && tmp !='['){
                        return "NO";
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }
    }
}
