package trialjava;

import java.util.LinkedList;

public class graph {
    int v;
    LinkedList<Integer>[] adj;

    public graph(int a) {
        this.v = a;
        this.adj = new LinkedList[a];
        for (int i = 0; i < a; i++) {
            this.adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int a) {
        adj[v].add(a);
    }
}
