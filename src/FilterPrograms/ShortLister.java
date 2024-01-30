package FilterPrograms;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
 public class ShortLister {


    public static void main(String args[])
    {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> allWords = new ArrayList<>();
        ShortWordFilter filter = new ShortWordFilter();

        try
        {
            // uses a fixed known path:
            //  Path file = Paths.get("c:\\My Documents\\data.txt");

            // use the toolkit to get the current working directory of the IDE
            // Not sure if the toolkit is thread safe...
            File workingDirectory = new File(System.getProperty("user.dir")+"/src");

            // Typiacally, we want the user to pick the file so we use a file chooser
            // kind of ugly code to make the chooser work with NIO.
            // Because the chooser is part of Swing it should be thread safe.
            chooser.setCurrentDirectory(workingDirectory);
            // Using the chooser adds some complexity to the code.
            // we have to code the complete program within the conditional return of
            // the filechooser because the user can close it without picking a file

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                InputStream input =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(input));

                // Finally we can read the file LOL!
                while(reader.ready())
                {
                    rec = reader.readLine();
                    allWords.addAll(List.of(rec.split("\s")));
                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("Data file read!");

                for (int i = 0; i < allWords.size(); i++) {
                    allWords.get(i).trim();
                    if (allWords.get(i).length() == 0){
                        allWords.remove(i);
                    }
                }
                System.out.println("Short Words:");

                for (String word : allWords){
                    boolean isShortWord = false;
                    isShortWord = filter.accept(word);
                    if(isShortWord == true){
                        System.out.println(word.trim());
                        Collector.collectsAll(word);
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}
