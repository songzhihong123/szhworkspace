package com.imooc.datastructure1.array;

/**
 * @ClassName Student
 * @Description Student
 * @Author szh
 * @Date 2023年07月09日
 */
public class Student {

    private String name;

    private int score;

    public Student(String name , int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s , socrs: %d)" , name , score);
    }

     public static void main(String[] args) {
         Array<Student> arr = new Array<>();
         Student a = new Student("Alice", 100);
         arr.addLast(a);
         arr.addLast(new Student("Bob", 66));
         arr.addLast(new Student("Charlie", 88));
         System.out.println(arr);

         System.out.println(arr.contains(a));

         arr.removeElement(a);
         System.out.println(arr);

    }



}
