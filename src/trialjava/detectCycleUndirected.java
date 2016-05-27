package trialjava;

import com.sun.org.apache.xerces.internal.impl.dv.xs.BooleanDV;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Iterator;

/**
 * Created by losandhu on 18-Apr-16.
 */
public class detectCycleUndirected {
    public static void main(String[] arg) {
        graph g = new graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(5, 0);
        System.out.println(detectCycle(g));
    }

    public static Boolean detectCycle(graph g) {
        disjointSet s = new disjointSet();
        for (int i = 0; i < g.v; i++) {
            s.makeSet(i);
        }
        for (int i = 0; i < g.v; i++) {
            Iterator<Integer> k = g.adj[i].listIterator();
            while (k.hasNext()) {
                int temp = k.next();
                if (s.findSet(i) == s.findSet(temp)) {
                    return true;
                }
                s.union(i, temp);
            }
        }
        return false;
    }
}
