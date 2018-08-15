package com.javaclasses.ballot.tree;

public class Test {
    public static void main(String[] args) {

        System.out.println("Init ADT.BST...");
        BST bst1 = new BST();

        System.out.println("ADT.BST Insert... 30");
        bst1.insert(30, 1);
        bst1.increment(bst1.search(30));
        bst1.increment(bst1.search(30));
        bst1.increment(bst1.search(30));
        bst1.increment(bst1.search(30));
        bst1.increment(bst1.search(30));
        bst1.increment(bst1.search(30));
        int i = bst1.getValue(bst1.search(30));
        System.out.println("--------------------------------"+i);
        System.out.println("ADT.BST Insert... 50");
        bst1.insert(50, 2);
        bst1.increment(bst1.search(50));
        bst1.increment(bst1.search(50));
        System.out.println("ADT.BST Insert... 40");
        bst1.insert(40, 1);
        System.out.println("ADT.BST Insert... 60");
        bst1.insert(60, 1);
        System.out.println("ADT.BST Insert... 20");
        bst1.insert(20, 1);
        System.out.println("ADT.BST Insert... 25");
        bst1.insert(25, 1);
        System.out.println("ADT.BST Insert... 10");
        bst1.insert(10, 1);

      /*  System.out.println("\nADT.BST Min... should be 10");
        System.out.println(bst1.min());
        System.out.println("ADT.BST Max... should be 60");
        System.out.println(bst1.max());*/

        System.out.println("ADT.BST Search... should be Node");
        System.out.println(bst1.search(20));

        System.out.println("\nADT.BST inorder... should be 10, 20, 25, 30, 40, 50, 60");
        bst1.inorder();

        System.out.println("\nADT.BST preorder... should be 30, 20, 10, 25, 50, 40, 60");
        bst1.preorder();

        System.out.println("\nADT.BST postorder... should be 10, 25, 20, 40, 60, 50, 30");
        bst1.postorder();

        System.out.println("\n\nADT.BST Delete... 30");
        bst1.delete(30);
        System.out.println("ADT.BST inorder... should be 10, 20, 25, 40, 50, 60");
        bst1.inorder();
       /* System.out.println("\n\nADT.BST Delete... 30");
        bst.delete(30);
        System.out.println("ADT.BST inorder... should be 10, 20, 25, 40, 50, 60");
        bst.inorder();*/

        System.out.println("\n\nRead from array...");
        int[] array = {5, 10, 20, 25, 30, 40, 50, 60};
        BST bst_2 = new BST();
        bst_2.readFromArray(array);
        System.out.println("ADT.BST inorder... should be 5, 10, 20, 25, 30, 40, 50, 60");
        bst_2.inorder();
    }
}
