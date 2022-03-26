package myself;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Zhihong Song on 2020/11/30 15:20
 */

public class ShiftTest {


    public static void insertSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        insertSort(array,array.length);
        System.out.println(Arrays.toString(array));
    }

}
