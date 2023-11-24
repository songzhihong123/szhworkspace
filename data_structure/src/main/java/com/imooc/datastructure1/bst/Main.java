package com.imooc.datastructure1.bst;

/**
 * @ClassName Main
 * @Description TODO
 * @Author szh
 * @Date 2023年09月10日
 */
public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        bst.preOrder();

        System.out.println();

        bst.perOrderNR();

//        System.out.println(bst);

//        bst.inOrder();
//
//        System.out.println();
//
//        bst.postOrder();

    }


}
