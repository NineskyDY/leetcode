import java.util.Arrays;

public class FindNumberAppearOnce {
    private int findNumberAppearOnce(int[] array){
        int a = 0;
        for (int x:array){
            a ^= x;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] array = new int[]{2,2,1};
        System.out.println(new FindNumberAppearOnce().findNumberAppearOnce(array));
    }
}
