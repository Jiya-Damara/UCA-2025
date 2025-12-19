class Dijkastra {

  static class QueueNode {
    int currNode;
    int currDist;

    QueueNode(int currNode, int currDist) {
      this.currNode = currNode;
      this.currDist = currDist;
    }  
  }

  static class Graph {

    Integer[][] adj;
    int N;

    Graph(int N) {
      this.N = N;
      this.adj = new Integer[N][N];

      for (int i = 0; i < N; i++) {
        adj[i][i] = 0;
      }
    }

    public void addEdge(int a, int b, int dist) {
      adj[a][b] = dist;
    }

    public Integer[] shortestDistanceFromGivenNode(int a) {
      Integer[] shortestDistances = new Integer[N];

      Queue<QueueNode> q = new LinkedList<>();
      q.add(new QueueNode(a, 0));

      while (!q.isEmpty()) {
        QueueNode qNode = q.poll();

        if (shortestDistances[qNode.currNode] == null || shortestDistances[qNode.currNode] > qNode.currDist) {
           shortestDistances[qNode.currNode] = qNode.currDist;
        } else {
          continue;
       }

       int newNode = qNode.currNode;

       for (int i = 0; i < N; i++) {
         if (newNode != i && this.adj[newNode][i] != null) {
           q.add(new QueueNode(i, this.adj[newNode][i] + qNode.currDist));
        }
       }
      }

      return shortestDistances;
    }

    public static void main(String[] args) {
      Graph g = new Graph();

      
    }

  }
}
