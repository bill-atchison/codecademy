import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grep {
    public Grep() {}

    public static void main(String[] args) {
        String regex = null;

        if(args.length > 0) {
            regex = args[0];
        }
        else {
            System.out.println("Missing regular expression pattern.");
            return;
        }

        for(int i = 0; i < 5; i++) {
            Scanner reader = null;
            File textFile;
            try {
                //String currentPath = System.getProperty("user.dir");
                //System.out.println(currentPath);
                //System.out.println(Paths.get(currentPath).getRoot());
                String fileName = "..\\..\\TestFile" + (i + 1) + ".txt";
                //System.out.println(fileName);
                textFile = new File(fileName);
                reader = new Scanner(textFile);

                while(reader.hasNextLine()) {
                    String data = reader.nextLine();

                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(data);

                    if(matcher.find()) {
                        System.out.println(fileName + ":" + data);
                    }
                }
            }
            catch (FileNotFoundException e) {
                System.out.println(e);
            }
            finally {
                reader.close();
            }
        }

    }
}