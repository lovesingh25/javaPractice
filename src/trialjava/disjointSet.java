package trialjava;


import java.util.HashMap;

/**
 * Created by Sandhu on 17-Apr-16.
 */
public class disjointSet {

    public HashMap disMap = new HashMap();

    public static void main(String[] args) {
        disjointSet s = new disjointSet();
        s.makeSet(1);
        s.makeSet(5);
        s.makeSet(10);
        s.makeSet(11);
        s.union(1, 5);
        s.union(10, 11);
        disNode temp;
        temp = s.findSet(5);
        System.out.println(temp.data);
        temp = s.findSet(11);
        System.out.println(temp.data);
        s.union(5, 10);
        temp = s.findSet(11);
        System.out.println(temp.data);

    }

    public disNode findSet(int data) {
        disNode temp = null;
        if (disMap.containsKey(data)) {
            temp = (disNode) disMap.get(data);
            if (data != temp.parent.data) {
                temp.parent = findSet(temp.parent.data);
            }
        }
        if (temp != null)
            return temp.parent;
        else
            return temp;
    }

    public void union(int data1, int data2) {
        disNode temp1 = findSet(data1);
        disNode temp2 = findSet(data2);
        if (temp1 == temp2) {
            System.out.println("They are already in same set");
        } else {
            if (temp1.rank == temp2.rank) {
                temp2.parent = temp1;
                temp1.rank += 1;
            } else if ((temp1.rank > temp2.rank)) {
                temp2.parent = temp1;
            } else {
                temp1.parent = temp2;
            }
        }
    }

    public void makeSet(int data) {
        disMap.put(data, new disNode(data));
        disNode d = (disNode) disMap.get(data);
        d.parent = d;
    }

    public class disNode {
        public int data;
        public int rank;
        public disNode parent;

        public disNode(int a) {
            data = a;
            rank = 0;
            parent = null;
        }
    }
}
