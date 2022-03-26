package com.geely.design.principle.singleresponsibility;

/**
 * 单一职责原则
 */
public class Test {

    public static void main(String[] args) {
//        Bird bird = new Bird();
//        bird.mainMoveMode("daye");
//        bird.mainMoveMode("tuoniao");

        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("daye");

        WalkBird walkBird = new WalkBird();
        walkBird.mainMoveMode("tuoniao");
    }
}
