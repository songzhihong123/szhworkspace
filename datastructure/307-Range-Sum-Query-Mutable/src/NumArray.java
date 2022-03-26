public class NumArray {

    private int[] sum; //sum[i] 就是存储前i个元素的和，sum[0] = 0
                        //sum[i] 存储的时候nums[0 ... i-1]的和

    private int[] data;

    public NumArray(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = nums[i];
        }
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }


    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}
