package com.geely.design.principle.liskovsubstitution;

/**
 * 里式替换原则.
 */
public class Test {

    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth() + 1);
            System.out.println("width: "+ rectangle.getWidth() + " length: " + rectangle.getLength());
        }
        System.out.println("resize方法结束 width: "+ rectangle.getWidth() + " length: " + rectangle.getLength());
    }

//    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle();
//        rectangle.setWidth(10);
//        rectangle.setLength(20);
//        resize(rectangle);
//    }

    public static void main(String[] args) {
        Square square = new Square();
//        square.setWidth(10);
//        resize(square);
    }

}
