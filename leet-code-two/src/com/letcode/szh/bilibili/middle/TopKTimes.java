package com.letcode.szh.bilibili.middle;

import java.util.HashMap;

/**
 * @ClassName TopKTimes
 * @Description TopKTimes
 * @Author szh
 * @Date 2024年01月12日
 */
public class TopKTimes {


    public static class Node{

        public String str;
        public int times;

        public Node(String str , int times){
            this.str = str;
            this.times = times;
        }

    }


    public static class TopKRecord{

        private Node[] heap;
        private int size;
        private HashMap<String , Node> strNodeMap;
        private HashMap<Node , Integer> nodeIndexMap;

        public TopKRecord(int size){
            heap = new Node[size];
            this.size = 0;
            strNodeMap = new HashMap<>();
            nodeIndexMap = new HashMap<>();
        }

        public void add(String str){
            Node curNode = null;
            int preIndex = -1;

            // 字符串从来没有出现过
            if(!strNodeMap.containsKey(str)){
                curNode = new Node(str , 1);
                strNodeMap.put(str , curNode);
                nodeIndexMap.put(curNode , -1);
            }else{
                curNode = strNodeMap.get(str);
                curNode.times ++;
                preIndex = nodeIndexMap.get(curNode);
            }

            // 字符串出现过，但是不在堆中
            if(preIndex == -1){
                // 堆满了
                if(size == heap.length){
                    // 检查堆定元素和当前元素的比较
                    if(heap[0].times < curNode.times){
                        nodeIndexMap.put(heap[0] , -1);
                        nodeIndexMap.put(curNode , 0);
                        heap[0] = curNode;
                        // 元素下浮
                        siftDown(0);
                    }
                }else{
                    nodeIndexMap.put(curNode , size);
                    heap[size] = curNode;
                    size++;
                    // 元素上浮
                    siftUp(size);
                }
            }else{
                siftDown(preIndex);
            }
        }

        public  void printTopK(){
            System.out.println("Top: ");
            for(int i = 0 ; i != heap.length ; i++){
                if(heap[i] == null){
                    break;
                }

                System.out.println("Str: " + heap[i].str);
                System.out.println("Times: " + heap[i].times);
            }
        }

        public int parent(int index){
            return (index - 1) / 2;
        }

        public int left(int index){
            return (index * 2) + 1;
        }

        public int right(int index){
            return (index * 2) + 2;
        }



        private  void siftUp(int index){
            while(index > 0 && heap[index].times < heap[parent(index)].times){
                swap(index , parent(index));
                index = parent(index);
            }

        }

        private  void siftDown(int index){

            while(left(index) < size){
                int j = left(index);

                if(j + 1 < size && heap[j].times < heap[j + 1].times){
                    j = right(index);
                }

                if(heap[index].times > heap[j].times){
                    swap(index , j);
                    index = j;
                }else{
                    break;
                }
            }

        }

        private void swap(int i , int j){
            nodeIndexMap.put(heap[i] , j);
            nodeIndexMap.put(heap[j] , i);

            Node temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }







    }











}
