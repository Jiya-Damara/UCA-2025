class EnglishDictionary {
  private static class TrieNode {
    private String value;
    private TrieNode[] children;

    public TrieNode() {
      children = new TrieNode[26];
    }
  }

  private final TrieNode root;

  public EnglishDictionary() {
    this.root = new TrieNode();
  }

  public void insert(String key, String value) {
    TrieNode t = root;
    for (char c : key.toCharArray()) {
      int index = c - 'a';
      if (t.children[index] == null) t.children[index] = new TrieNode();
      t = t.children[index];
    }
    t.value = value;
  }

  private TrieNode find(String key) {
    TrieNode t = root;
    for (char c : key.toCharArray()) {
      int index = c - 'a';
      if (t.children[index] == null) return null;
      t = t.children[index];
    }
    return t;
  }

  public String search(String key) {
    TrieNode t = find(key);
    return t == null ? null : t.value;
  }

  public boolean startsWith(String key) {
    TrieNode t = find(key);
    return t != null;
  }

  public void delete(String key) {
    delete(root, key, 0);
  }

  private boolean deletable(TrieNode t) {
    return t.value == null && !hasChild(t);
  }

  private boolean hasChild(TrieNode t) {
    for (TrieNode n : t.children) {
      if (n != null) return false;
    }
    return true;
  }

  private boolean delete(TrieNode t, String key, int level) {
    if (t == null) return false;
    if (key.length() == level) {
      t.value = null;
      return deletable(t);
    }
    int index = key.charAt(level) - 'a';
    boolean canDelete = delete(t.children[index], key, level + 1);
    if (canDelete) {
      t.children[index] = null;
      return deletable(t);
    }
    return false;
  }

  public static void main(String[] args) {
    EnglishDictionary t = new EnglishDictionary();
    System.out.println(t.startsWith("app")); // false;
    System.out.println(t.startsWith("apple")); // false;
    System.out.println(t.search("app")); // null;
    System.out.println(t.search("apple")); // null;
    System.out.println("*************");
  
    t.insert("apple", "a fruit");

    System.out.println(t.startsWith("app")); // true;
    System.out.println(t.startsWith("apple")); // true;
    System.out.println(t.search("app")); // null;
    System.out.println(t.search("apple")); // a fruit;
    System.out.println("*************");

    t.insert("app", "application");

    System.out.println(t.startsWith("app")); // true;
    System.out.println(t.startsWith("apple")); // true;
    System.out.println(t.search("app")); // application;
    System.out.println(t.search("apple")); // a fruit;
    System.out.println("*************");

    t.delete("apple");

    System.out.println(t.startsWith("app")); // true;
    System.out.println(t.startsWith("ap")); // true;
    System.out.println(t.startsWith("apple")); // false;
    System.out.println(t.startsWith("appl")); // false;
    System.out.println(t.search("app")); // application;
    System.out.println(t.search("apple")); // null;
    System.out.println("*************");  
  }

}
