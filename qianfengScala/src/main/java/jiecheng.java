public class jiecheng {
    public static void main(String[] args){
        System.out.println(generaltest(5));
        System.out.println(digui(3));
        System.out.println(digui1(6));
    }

    public static int generaltest(int a){
        int sum = 1;
        while(a != 0) {
            if (a <= 1) {
                return sum;
            } else {
                sum = sum * a;
                a--;
            }
        }
        return sum;
    }

    static int sum = 1;
    public static int digui(int a){

        sum = sum * a;
        a --;
        if(a == 1){
            return sum;
        }else{
            digui(a);
        }

        return sum;
    }

    public static int digui1(int a){
        if(a == 1){
            return a;
        }else{
            return a*digui1(a - 1);
        }
    }



}
