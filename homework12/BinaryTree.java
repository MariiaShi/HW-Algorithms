package lesson_12_20241105.homework12;
// Реализуйте методы: 
// find(value)
// insert(value)
// delete(value)
// print(node)

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void print() {
        System.out.println(root);
    }

    public void insert(int value) {
        Node newNode = new Node();
        newNode.setValue(value);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent = null;

            while (true) {
                parent = current;
                if (value == current.getValue()) { // такой узел уже есть
                    return;
                } else if (value < current.getValue()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    // вставка через рекурсию
    public Node insertRecursive(Node current, Node newNode) {
        if (root == null) {
            root = newNode;
            return newNode;
        }
        if (current == null) {
            return newNode;
        }

        if (newNode.getValue() < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), newNode));
        } else if (newNode.getValue() > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), newNode));
        } else {
            return current;
        }
        return current;
    }

    public Node find(int value) {
        Node current = root; // начинаем поиск с корневого узла

        while (current.getValue() != value) { // поиск пока не будет найден элемент или не будут перебраны все
            if (current.getValue() > value) { // движение влево?
                current = current.getLeft();
            } else {
                current = current.getRight(); //движение вправо
            }
            if (current == null) { // если потомка нет,
                return null;
            }
        }
        return current; // возвращаем найденный элемент
    }

    public boolean delete(int value) {
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        // ищем элемент в дереве по значению
        while (currentNode.getValue() != value) {
            parentNode = currentNode;
            if (value < currentNode.getValue()) {
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null)
                return false;
        }


        if (currentNode.getLeft() == null && currentNode.getRight() == null) {  // это лист
            if (currentNode == root)
                root = null;
            else if (isLeftChild)
                parentNode.setLeft(null);
            else
                parentNode.setRight(null);
        } else if (currentNode.getRight() == null) {  //справа нет дочерних
            if (currentNode == root)
                root = currentNode.getLeft();
            else if (isLeftChild)
                parentNode.setLeft(currentNode.getLeft());
            else
                parentNode.setRight(currentNode.getLeft());
        } else if (currentNode.getLeft() == null) {  //слева нет дочерних
            if (currentNode == root)
                root = currentNode.getRight();
            else if (isLeftChild)
                parentNode.setLeft(currentNode.getRight());
            else
                parentNode.setRight(currentNode.getRight());
        } else { // и справа и слева есть дочерние элементы
            Node heir = receiveHeir(currentNode);
            if (currentNode == root)
                root = heir;
            else if (isLeftChild)
                parentNode.setLeft(heir);
            else
                parentNode.setRight(heir);
        }
        return true;
    }

    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRight();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeft();
        }

        if (heirNode != node.getRight()) {
            parentNode.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
        }
        return heirNode;
    }
    //Представлено дерево BST. [13, 5, 15, 6, 3]
    //       13
    //    5       15
    // 6     3
    // Каким то образом оно сломалось?!
    // Написать метод, который будут определять корректно ли дерево
    // и метод, который позволит поменять местами ноды, размещенные некорректно,
    // чтобы дерево стало правильным и соотвествовало требованиям BST.


    public boolean isTreeCorrect() {
        List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        while (true) {
            List<Node> newLevel = new ArrayList<>();
            for (Node node : currentLevel) {
                if (node.getLeft() != null && node.getLeft().getValue() >= node.getValue()) {
                    return false;
                }
                if (node.getRight() != null && node.getRight().getValue() >= node.getValue()) {
                    return false;
                }
                if (node.getLeft() != null) {
                    newLevel.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    newLevel.add(node.getRight());
                }
            }
            if (newLevel.size() == 0) {
                break;
            }
            currentLevel = newLevel;

        }
        return true;

    }

    public void fixTree() {
        List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(root);
        while (true) {
            List<Node> newLevel = new ArrayList<>();
            for (Node node : currentLevel) {
                if (node.getLeft() != null && node.getRight() != null) {
                    if (node.getLeft().getValue() > node.getValue() && node.getRight().getValue() < node.getValue()) {
                        Node left = node.getLeft();
                        node.setLeft(node.getRight());
                        node.setRight(left);
                    }
                }
                if (node.getLeft() != null) {
                    newLevel.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    newLevel.add(node.getRight());
                }
            }
            if (newLevel.size() == 0) {
                break;
            }
            currentLevel = newLevel;
        }
    }
}


