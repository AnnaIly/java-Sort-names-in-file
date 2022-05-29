import java.io.File;  
import java.io.FileWriter;  
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import java.util.Scanner; 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortnames {

  public static void main(String[] args) {
    try {
      if(args.length == 1) {
        String inputfilename = args[0];
        if(!Files.exists(Paths.get(inputfilename))) {
          System.err.println("file not exist: " + inputfilename);
          return;
        }
        String outputfilename = inputfilename + "-sorted";
        File   outputfile     = new File(outputfilename);
        if (!outputfile.createNewFile()) {
          System.out.println("File already exists. Overwriting...");
        }
        readSort(inputfilename, outputfilename);    
        System.out.println("Finished: created " + outputfilename);   
      } else {
        System.out.println("Wrong number of arguments or invalid filename");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void readSort(String ifilename, String ofilename) throws IOException {
    FileReader     fileReader     = new FileReader(ifilename);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    List<String>   lineList       = new ArrayList<String>();
    FileWriter     fileWriter     = new FileWriter(ofilename);
    PrintWriter    out            = new PrintWriter(fileWriter);
    String         inputLine;

    while ((inputLine = bufferedReader.readLine()) != null) {
      lineList.add(inputLine);
    }
    Collections.sort(lineList);
    for (String outputLine : lineList) {
      out.println(outputLine);
      System.out.println(outputLine);
    }
    out.flush();
    out.close();
    fileReader.close();
    fileWriter.close();
  }

}