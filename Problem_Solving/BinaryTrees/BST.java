public class BST<Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    Key key;
    Value value;
    Node left;
    Node right;

    Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }

  public Key min() {
  }

  public Key max() {
  }

  public Key floor(Key key) {
  }

  public Key ceil(Key key) {
  }

  public Key floor(Key key) {
  }
  
  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node x, Key key) {
    if (x == null) return null;

    int cmp = key.compareTo(x.key);

    if (cmp == 0) return x.value;
    else if (cmp < 0) return get(x.left, key);
    else return get(x.right, key);
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node x, Key key, Value value) {
    if (x == null) return new Node(key, value);

    int cmp = key.compareTo(x.key);

    if (cmp == 0) x.value = value;
    else if (cmp < 0) x.left = put(x.left, key, value);
    else x.right = put(x.right, key, value);

    return x; 
  }

  public static void main(String[] args) {
    BST<Integer, String> bst = new BST<Integer, String>();

    bst.put(5, 'A');
    bst.put(1, 'X');
    bst.put(3, 'Y');
    bst.put(4, 'Z');
    bst.put(7, 'A');

    assert bst.get(5).equals("A") : "Test failed for key 5";
    assert bst.get(1).equals("X") : "Test failed for key 1";
    assert bst.get(3).equals("Y") : "Test failed for key 3";
    assert bst.get(4).equals("Z") : "Test failed for key 4";
    assert bst.get(7).equals("A") : "Test failed for key 7";

    assert bst.get(10) == null : "Test failed for missing key 10";

    System.out.println("All BST tests passed successfully!");
  }  
}





