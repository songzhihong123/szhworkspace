package com.letcode.szh.bilibili.middle;

/**
 * @ClassName PreAndInArrayToPosArray
 * @Description PreAndInArrayToPosArray
 * @Author szh
 * @Date 2024年01月15日
 */
public class PreAndInArrayToPosArray {

    /*

    已知一颗二叉树中【没有重复节点】，并且给定了这棵树的中序遍历数组和先序遍历数组，
    返回后续遍历数组

    int[] pre = {1 ,2 ,3 ,5 ,3 ,6 ,7}
    int[] in = {4 ,2 ,5 ,1 ,6 ,3 ,7}

    返回：
    {4, 5, 2 ,6 ,7 , 3, 1}


     */

    public static int[] getPostArray(int[] pre , int[] in){
        if(pre == null){
            return null;
        }

        int N = pre.length;
        int[] post = new int[N];

        set(pre , in , post , 0 , N - 1 , 0 , N - 1 , 0 , N -1);

        return post;
    }


    public static void set(int[] pre , int[] in , int[] post , int prei , int prej , int ini , int inj , int posti , int postj){
        if(prei > prej){
            return;
        }

        if(prei == prej){
            post[posti] = pre[prei];
            return;
        }
        post[postj] = pre[prei];

        int find = ini;

        for(; find <= inj ; find ++){
            if(in[find] == pre[prei]){
                break;
            }
        }

        set(pre , in , post ,prei + 1 , prei + find - ini , ini , find - 1 , posti , posti + find - ini - 1);
        set(pre , in ,post , prei + find - ini + 1, postj , find + 1, inj , posti + find - ini , postj - 1);
    }


    public static void main(String[] args) {

        int[] pre = {1 ,2 ,4 ,5 ,3 ,6 ,7};
        int[] in = {4 ,2 ,5 ,1 ,6 ,3 ,7};

        int[] postArray = getPostArray(pre, in);

        // 4 5 2 6 7 3 1
        for(int i : postArray){
            System.out.print(i + " ");
        }


    }



}
