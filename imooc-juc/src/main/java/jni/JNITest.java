package jni;

/**
 * @description:
 * @author: szh
 * @create: 2021-05-17 10:21
 **/
public class JNITest {

    static {
        System.loadLibrary("JNITest");
    }

    public native void sayHelloWord(String msg);

    public static void main(String[] args){
        new JNITest().sayHelloWord("Hello JNI");
    }

}
