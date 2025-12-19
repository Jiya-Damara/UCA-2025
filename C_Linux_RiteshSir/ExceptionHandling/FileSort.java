import java.io.BufferReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileSort {

  public void sort(File input, File output) throws FileNotFoundException {
    List<String> data = new ArrayList<>();

    BufferedReader br = new BufferedReader(new FileReader(input));
    String s = br.readLine();

    while (s != null) {
      data.add(s);
      s = br.readLine();
    }
    br.close();

    Colleactions.sort(data);

    BufferedWriter bw = new BufferedWriter(new FileWriter(output));
    for (String d : data) {
      bw.write(d);
      bw.newLine();
    }
  }

  

}
