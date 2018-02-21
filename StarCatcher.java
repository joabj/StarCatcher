

/**
 * @author Joab Jackson
 */

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;


public class StarCatcher {

      public static void main(String[] args) throws IOException {
      int countLine = 0;

        JFileChooser fileChooser = new JFileChooser();
      if (fileChooser.showOpenDialog(null) ==
              JFileChooser.APPROVE_OPTION ) {
          java.io.File musicFile = fileChooser.getSelectedFile();
      
  

      /**File musicFile = new File("iTunes Music Library.xml");**/
      Scanner musicFileIn = new Scanner(musicFile);

          java.io.File outputFile = new java.io.File("StarRatings.txt");

      if (outputFile.exists()){
          System.out.println("Output file already exists. Please delete it!");
          System.exit(0);
       }

      java.io.PrintWriter output = new java.io.PrintWriter(outputFile);


          String song = " ";
          String artist = " ";
          String rating = " ";
          String lineHolder = " ";
          String lineHolder2 = " ";


      while (musicFileIn.hasNext()) {
    	  String line = musicFileIn.nextLine();

    	  		if (line.matches(".*<key>Name</key>.*")) {
                    	lineHolder = line;
                        lineHolder2 = lineHolder.substring(26);
                        lineHolder = lineHolder2.replace("</string>", "");
                        song = ("\"" + lineHolder + "\"");
    	  			}
                else if (line.matches(".*<key>Artist</key>.*")) {
    	  				lineHolder = line;
                        lineHolder2 = lineHolder.substring(28);
                        artist = lineHolder2.replace("</string>", " ");
    	  			}

                else if (line.matches(".*<key>Rating</key>.*")){
                            if (line.matches(".*100.*"))
                            {rating = " *****";
                            }
                            else if (line.matches(".*80.*"))
                            {rating = " ****";
                            }
                            else if (line.matches(".*60.*"))
                            {rating = " ***";
                            }
                             else if (line.matches(".*40.*"))
                            {rating = " **";
                            }
                             else if (line.matches(".*20.*"))
                            {rating = " *";
                             }
                        output.printf("%-40s%-30s%-5s\n", artist,  song,  rating);
                           }
/****Need return line***/


            }

      musicFileIn.close();
      /**output.close();**/
      }

}
}
