public class Student implements Comparable<Student> {
  private int rollNumber;
  private String name;

  public int compareTo(Student other) {
    return this.rollNumber - other.rollNumber;
  }

  public static void main(String[] args) {
    BST<Student, String> bst = new BST<Student, String>();
  }
}
