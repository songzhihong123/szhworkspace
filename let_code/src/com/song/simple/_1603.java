package com.song.simple;

/**
 * Created by Zhihong Song on 2021/3/19 10:34
 */

public class _1603 {



    public static void main(String[] args){
        ParkingSystem parkingSystem = new ParkingSystem(0,0,2);
        System.out.println(parkingSystem.addCar(1));
    }


    public static class ParkingSystem{

        private int big;
        private int medium;
        private int small;

        public ParkingSystem(){
            this(0,0,0);
        }

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType){
                case 1:
                    if(big > 0){
                        big --;
                        return true;
                    }
                    break;
                case 2:
                    if(medium > 0){
                        medium --;
                        return true;
                    }
                    break;
                case 3:
                    if(small > 0){
                        small --;
                        return true;
                    }
                    break;
            }

            return false;
        }




    }

}
