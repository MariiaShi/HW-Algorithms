package org.example.algorithms.homework8;

public class EmptyStackException extends Throwable {

    public class SpecialStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public SpecialStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) throws EmptyStackException {
            dataStack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public int pop() throws EmptyStackException {
            if (dataStack.isEmpty()) {
                throw new EmptyStackException();
            }
            int popped = dataStack.pop();
            if (popped == minStack.peek()) {
                minStack.pop();
            }
            return popped;
        }

        public int getMin() throws EmptyStackException {
            if (minStack.isEmpty()) {
                throw new EmptyStackException();
            }
            return minStack.peek();
        }

        public boolean isEmpty() {
            return dataStack.isEmpty();
        }

        public int peek() throws EmptyStackException {
            return dataStack.peek();
        }
    }

    // Предполагаемая реализация Stack (примерная)
    class Stack<T> {
        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> top;

        public void push(T data) {
            Node<T> newNode = new Node<>(data);
            newNode.next = top;
            top = newNode;
        }

        public T pop() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            T data = top.data;
            top = top.next;
            return data;
        }

        public T peek() throws EmptyStackException {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }
}
