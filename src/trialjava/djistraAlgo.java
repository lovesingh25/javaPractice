package trialjava;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by losandhu on 05-Jun-16.
 */
public class djistraAlgo {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[] n = new int[t];
        int[] m = new int[t];
        int[] S = new int[t];
        djistraAlgo d = new djistraAlgo();
        djistraAlgo.graph[] g = new djistraAlgo.graph[t];
        int i = 0;
        while (i < t) {
            n[i] = s.nextInt();
            m[i] = s.nextInt();
            g[i] = d.new graph(n[i]);
            int k = 0;
            while (k < m[i]) {
                int a = s.nextInt();
                int b = s.nextInt();
                g[i].addEdge(a - 1, b - 1);
                k++;
            }
            S[i] = s.nextInt() - 1;
            i++;
        }

        i = 0;
        while (i < t) {
            int[] dist = djistraAlgoFinaly(g[i], S[i]);
            for (int j = 0; j < dist.length; j++) {
                if (j != S[i]) {
                    if (dist[j] == Integer.MAX_VALUE) {
                        System.out.print(-1 + " ");
                    } else {
                        System.out.print(dist[j] + " ");
                    }
                }
            }
            System.out.println();
            i++;
        }
    }

    private static int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < dist.length; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    private static int[] djistraAlgoFinaly(graph g, int start) {
        int dist[] = new int[g.v];

        Boolean sptSet[] = new Boolean[dist.length];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[start] = 0;
        // Find shortest path for all vertices
        for (int count = 0; count < dist.length; count++) {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;
            Iterator l = g.adj[u].listIterator();
            while (l.hasNext()) {
                int temp = (int) l.next();
                //System.out.print("Indexes are  = "+temp+" ");
                if (!sptSet[temp] &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + 6 < dist[temp]) //hardcoded as per problem
                    dist[temp] = dist[u] + 6;
            }
        }
        return dist;
    }

    class graph {
        int v;
        LinkedList<Integer>[] adj;

        graph(int a) {
            this.v = a;
            this.adj = new LinkedList[a];
            for (int i = 0; i < a; i++) {
                this.adj[i] = new LinkedList();
            }
        }

        void addEdge(int v, int a) {
            adj[v].add(a);
            adj[a].add(v);
        }
    }
}
