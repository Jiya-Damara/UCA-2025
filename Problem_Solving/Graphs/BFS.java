// Given number of nodes & adjacency list
// Solution of BFS on graph
// Works for both directed and undirected graph

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {

  public ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> res = new ArrayList<>();
    boolean[] visited = new boolean[V];
    Queue<Integer> q = new LinkedList<>();

    q.add(0);
    visited[0] = true;

    while (!q.isEmpty()) {
      Integer node = q.poll();
      res.add(node);

      // get all its neighbours
      for (Integer it : adj.get(node)) {
        if (!visited[it]) {
          visited[it] = true;
          q.add(it);
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int V = 5;

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    adj.get(0).add(1);
    adj.get(1).add(0);

    adj.get(1).add(2);
    adj.get(2).add(1);

    adj.get(2).add(3);
    adj.get(3).add(2);

    adj.get(0).add(4);
    adj.get(4).add(0);

    adj.get(4).add(3);
    adj.get(3).add(4);

    BFS obj = new BFS();
    ArrayList<Integer> ans = obj.bfs(V, adj);
    System.out.println(ans);
  }
}
