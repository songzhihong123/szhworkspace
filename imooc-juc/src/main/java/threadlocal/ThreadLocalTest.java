package threadlocal;

/**
 * 场景一：每个线程需要一个独享的对象（通常是工具类，典型需要使用的类有SimpleDateFormat和Random）
 * 场景二：每个线程内需要保存全局变量（例如在拦截器中获取用户信息），可以让不同的方法直接使用，避免参数传递的麻烦
 */
public class ThreadLocalTest {
}
