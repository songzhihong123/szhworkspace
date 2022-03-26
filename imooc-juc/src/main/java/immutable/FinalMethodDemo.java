package immutable;

/**
 * final 的方法
 */
public class FinalMethodDemo {

    int a;

    FinalMethodDemo(){}
    /**
     * final 不能被用来修饰构造方法.
     */
    public /*final*/ FinalMethodDemo(int a){
        this.a = a;
    }

    public void drink(){

    }

    /**
     * 被final 修饰的方法不能被重写。
     */
    public final void eat(){

    }

    //被static修饰的方法不能被重写
    //子类可以拥有同名的方法.
    public static void sleep(){

    }

}

class SubClass extends FinalMethodDemo{

    @Override
    public void drink() {
        super.drink();
    }

//    public void eat(){
//
//    }

    //public void sleep(){}

    public static void sleep(){}
}