package trialjava;

/**
 * Created by losandhu on 21-Jun-16.
 */
public class Solution {
    public static void main(String[] arg) {
        heapSort hs = new heapSort();
        heapSort hs2 = new heapSort();
        System.out.println(hs.equals(hs2));
        System.out.println(hs.hashCode());
        System.out.println(hs2.hashCode());
        graph g = new graph(1);
        System.out.println(g.hashCode());
        System.out.println('0' | '1');

    }
}
