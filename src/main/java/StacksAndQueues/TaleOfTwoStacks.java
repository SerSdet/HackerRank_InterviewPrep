package StacksAndQueues;

import java.util.Stack;

public class TaleOfTwoStacks {
    public static void main(String[] args) {

    }
    public static class MyQueue<T>{
        Stack<Integer>stackNewestOnTop = new Stack<>();
        Stack<Integer>stackOldestOnTop = new Stack<>();

        public void enqueue (Integer value){
            stackNewestOnTop.push(value);
        }

        public Integer peek(){
            shiftStacks();
            return stackOldestOnTop.peek();
        }

        public Integer dequeue(){
            shiftStacks();
            return stackOldestOnTop.pop();
        }

        private void shiftStacks(){
            if(stackOldestOnTop.isEmpty()){
                while(!stackNewestOnTop.isEmpty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }
}
