import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    public int numProjects;
    public int numPeople;

    public ArrayList<Person> people = new ArrayList<>();

    public Parser(String filepath) {
        System.out.println(filepath);
        int lineNum = 0;

        try {
            File input = new File(filepath);
            Scanner inputReader = new Scanner(input);

            while (inputReader.hasNextLine()) {
                String lineData = inputReader.nextLine();

                if (lineNum == 0) {
                    String[] dataArray = lineData.split(" ");
                    this.numPeople = Integer.parseInt(dataArray[0]);
                    this.numProjects = Integer.parseInt(dataArray[1]);
                    lineNum += 1;
                }


            }

        } catch (FileNotFoundException ex) {
            System.out.println("An error occurrec:");
            ex.printStackTrace();
        }
    }

}
