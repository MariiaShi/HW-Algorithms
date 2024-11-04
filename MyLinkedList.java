package org.example.algorithms.ArrayList;

    class MyLinkedList<T> {
        private Node<T> head;
        private int size;

        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        // конструктор
        public MyLinkedList() {
            this.head = null;
            this.size = 0;
        }


        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        // метод удаления
        public T remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

            Node<T> current = head;
            if (index == 0) { // If removing the head
                T removedData = head.data;
                head = head.next;
                size--;
                return removedData;
            }

            Node<T> prev = null;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }

            T removedData = current.data;
            prev.next = current.next;
            size--;
            return removedData;
        }

        // получить элемент
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        // получить размер
        public int size() {
            return size;
        }


        public void printList() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        public static void main(String[] args) {
            MyLinkedList<Integer> list = new MyLinkedList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.printList();

            System.out.println("Element at index 2: " + list.get(2));
            System.out.println("Removing element at index 1: " + list.remove(1));
            list.printList();
            System.out.println("Size of the list: " + list.size());
        }
    }

