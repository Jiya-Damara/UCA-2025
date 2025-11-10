import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Graph {
  Map<Integer, Set<Integer>> edgeMap;
  Set<Integer> checkSet;

  Graph() {
    edgeMap = new HashMap<>();
  }

  void addEdge(int a, int b) {
    if (!edgeMap.containsKey(a)) {
      edgeMap.put(a, new HashSet<>());
    }

    if (!edgeMap.containsKey(b)) {
      edgeMap.put(b, new HashSet<>());
    }

    edgeMap.get(a).add(b);
    edgeMap.get(b).add(a);
  }

  List<String> getAllPaths(int startNode) {
    List<String> allPaths = new ArrayList<>();

    dfs(startNode, new StringBuilder().append(startNode), null, allPaths);
    return allPaths;
  }

  private void dfs(int startNode, StringBuilder currentPath, Integer parentNode, List<String> allPaths) {
  boolean isLeafNode = true;

  for (Integer edgeNode : edgeMap.getOrDefault(startNode, new HashSet<>())) {
    if (!edgeNode.equals(parentNode)) {
      isLeafNode = false;
      dfs (edgeNode, new StringBuilder(currentPath).append("->").append(edgeNode), startNode, allPaths);
      }
    }

    if (isLeafNode) {
      allPaths.add(currentPath.toString());
    }
  }

  public static void main(String[] args) {
    Graph g = new Graph();

    g.addEdge(1, 2);
    g.addEdge(2, 5);
    g.addEdge(2, 3);
    g.addEdge(3, 6);
    g.addEdge(3, 7);
    g.addEdge(3, 4);

    System.out.println(g.getAllPaths(1));
  }
}
