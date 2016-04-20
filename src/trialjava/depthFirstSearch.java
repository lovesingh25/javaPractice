package trialjava;
import java.util.Iterator;

public class depthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graph g = new graph(4);		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        DFS(g,3);
	}
	public static void DFS(graph g,int start){
		Boolean[] visited = new Boolean[g.v];
		actualDFS(visited,start,g);
	}
	private static void actualDFS(Boolean[] visited,int n,graph g){
		visited[n] = true;
		System.out.println(n);
		Iterator<Integer> i = g.adj[n].listIterator();
		while(i.hasNext()){
			int a = i.next();
			if(visited[a]==null || !visited[a]){
				actualDFS(visited,a,g);
			}	
		}
	}
}
