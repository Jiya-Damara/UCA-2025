import java.util.Stack;

public class TopologicalSort {
  private boolean[] marked;
  private Stack<Integer> reversePostOrder;

  public TopologicalSort(DirectedGraph g) {
    reversePostOrder = new Stack<>();
    marked = new boolean[g.V()];

    for (int i = 0; i < g.V(); i++) {
      if (!marked[i]) {
        dfs(g, i);
      }
    }
  }

  private void dfs(DirectedGraph s, int v) {
    marked[v] = true;

    for (int w : g.adj(v)) {
      if (!marked[w]) {
        dfs(g, w);
      }
    }
    reversePostOrder.push(v);
  }

  public Stack<Integer> order() {
    return this.reversePostOrder;
  }

  public static void main(String[] args) {
    DirectedGraph dg = new DirectedGraph(7);
    dg.addEdge(0, 5);
    dg.addEdge(0, 2);
    dg.addEdge(0, 1);
    dg.addEdge(0, 5);
    dg.addEdge(0, 5);

    TopologicalSort ts = new TopologicalSort(dg);
    Stack<Integer> s = ts.order();

    while (!s.isEmpty()) System.out.print(s.pop() + " ");
  }
}
