package com.song.medium;

import java.util.*;

/**
 * Created by Zhihong Song on 2021/3/23 11:20
 */

public class _341 {

    public static void main(String[] args){

    }

    public class NestedIterator implements Iterator<Integer> {

        private List<Integer> integers;

        private Iterator<Integer> cur;

        public NestedIterator(List<NestedInteger> nestedList) {
            integers = new ArrayList<>();
            dfs(nestedList);
            cur = integers.iterator();
        }

        private void dfs(List<NestedInteger> nestedIntegers){
            for (NestedInteger nest: nestedIntegers ) {
                if (nest.isInteger()){
                    integers.add(nest.getInteger());
                }else{
                    dfs(nest.getList());
                }
            }
        }
        @Override
        public Integer next() {
            return cur.next();
        }

        @Override
        public boolean hasNext() {
            return cur.hasNext();
        }
    }


    public class NestedIterator1 implements Iterator<Integer> {

        private Deque<Iterator<NestedInteger>> stack;

        public NestedIterator1(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            stack.push(nestedList.iterator());
        }


        @Override
        public Integer next() {
            //由于保证调用next之前会调用hasNext，直接返回栈顶列表的当前元素
            return stack.peek().next().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()){
                Iterator<NestedInteger> it = stack.peek();
                if(!it.hasNext()){
                    stack.pop();
                    continue;
                }
                NestedInteger next = it.next();
                if(next.isInteger()){
                    List<NestedInteger> list = new ArrayList();
                    list.add(next);
                    stack.push(list.iterator());
                    return true;
                }
                stack.push(next.getList().iterator());
            }
            return false;
        }
    }





     public interface NestedInteger {
          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList();

        }


}
