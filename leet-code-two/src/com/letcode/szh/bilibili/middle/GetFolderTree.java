package com.letcode.szh.bilibili.middle;

import java.util.TreeMap;

/**
 * @ClassName GetFolderTree
 * @Description GetFolderTree
 * @Author szh
 * @Date 2024年01月14日
 */
public class GetFolderTree {


    /*

    给一个字符川类型的数组arr , 譬如
    String[] arr = ["b\cst" , "d\\" , "a\\d\\e] , "a\\b\\c]

    把这些路径中蕴含的目录结构给画出来， 于目录直接列在父目录下面，并比父目录向右进两格

    同一级的需要按字母顺序排列， 不能乱

     */

    public static class Node {
        public String name;
        public TreeMap<String, Node> nextMap;

        public Node(String name){
            this.name = name;
            nextMap = new TreeMap<>();
        }

    }


    public static void print(String[] folderPaths){

        Node node = generateFolderTree(folderPaths);

        printProcess(node , 0);

    }



    // 构造Trie
    public static Node generateFolderTree(String[] folderPaths){
        Node head = new Node("");

        for(String folderPath : folderPaths){
            String[] paths = folderPath.split("\\\\");
            Node cur = head;
            for(int i = 0 ; i < paths.length ; i++){
                if(!cur.nextMap.containsKey(paths[i])){
                    cur.nextMap.put(paths[i] , new Node(paths[i]));
                }
                cur = cur.nextMap.get(paths[i]);
            }

        }
        return head;
    }


    public static void printProcess(Node node , int level){
        if(level != 0){
            System.out.println(gen2nSpace(level) + node.name);
        }

        for(Node next : node.nextMap.values()){
            printProcess(next , level + 1);
        }




    }

    public static String gen2nSpace(int level){
        String str = "";
        for(int i = 1 ; i < level ; i ++){
            str += "  ";
        }
        return str;
    }



}
