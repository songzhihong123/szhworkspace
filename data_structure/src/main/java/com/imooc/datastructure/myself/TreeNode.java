package com.imooc.datastructure.myself;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private int id;
    private int pid;
    private String name;
    List<TreeNode> childNode;

    public TreeNode(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.childNode = childNode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public List<TreeNode> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<TreeNode> childNode) {
        this.childNode = childNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args){
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(new TreeNode(1, 0, "1"));
        list.add(new TreeNode(2, 0, "2"));
        list.add(new TreeNode(3, 2, "3"));
        list.add(new TreeNode(4, 3, "4"));
        list.add(new TreeNode(5, 4, "5"));
        list.add(new TreeNode(6, 5, "6"));


        List<TreeNode> treeNodes = listToTree1(list);
        TreeNode node = new TreeNode(0 , -1,"0");
        node.setChildNode(treeNodes);

    }

    private static List<TreeNode> listToTree1(List<TreeNode> list){
        List<TreeNode> res = new ArrayList<>();

        for(TreeNode node : list){
            if(node.getPid() == 0){
                res.add(node);
            }

            for(TreeNode cNode : list){
                if(cNode.pid == node.id){
                    if(node.getChildNode() == null){
                        node.setChildNode(new ArrayList<>());
                        node.getChildNode().add(cNode);
                    }else{
                        node.getChildNode().add(cNode);
                    }
                }


            }

        }


        return res;

    }





}
