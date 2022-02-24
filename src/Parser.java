import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {
    public int numProjects;
    public int numPeople;

    public ArrayList<Person> people = new ArrayList<>();
    public ArrayList<Project> projects = new ArrayList<>();

    public Parser(String filepath) {
        System.out.println(filepath);
        int lineNum = 0;
        int personNum = 0;
        int projectNum = 0;

        try {
            File input = new File(filepath);
            Scanner inputReader = new Scanner(input);

            while (inputReader.hasNextLine()) {
                String lineData = inputReader.nextLine();
                System.out.println(String.format("Line %d: %s", lineNum+1, lineData));

                if (lineNum == 0) {
                    String[] dataArray = lineData.split(" ");
                    this.numPeople = Integer.parseInt(dataArray[0]);
                    this.numProjects = Integer.parseInt(dataArray[1]);
                    lineNum ++;
                }
                else {
                    if (personNum < numPeople) {
                        String[] personDescription = lineData.split(" ");
                        lineNum++;
                        int numSkills = Integer.parseInt(personDescription[1]);
                        Person currentPerson = new Person(personDescription[0], new HashMap<>());
                        for (int i = 0; i < numSkills; i++) {
                            String skillLine = inputReader.nextLine();
                            String[] skillData = skillLine.split(" ");
                            lineNum++;
                            currentPerson.skills.put(skillData[0], Integer.parseInt(skillData[1]));
                        }
                        personNum++;
                        people.add(currentPerson);
                    }
                    else {
                        if (projectNum < numProjects) {
                            String[] projDesc = lineData.split(" ");
                            int numRoles = Integer.parseInt(projDesc[4]);
                            lineNum++;
                            Project currentProj = new Project(
                                        projDesc[0],
                                        Integer.parseInt(projDesc[1]),
                                        Integer.parseInt(projDesc[2]),
                                        Integer.parseInt(projDesc[3]),
                                        numRoles
                                    );
                            for (int i = 0; i < numRoles; i++) {
                                String roleLine = inputReader.nextLine();
                                String[] roleData = roleLine.split(" ");
                                lineNum++;
                                currentProj.addSkill(roleData[0], Integer.parseInt(roleData[1]));
                            }
                            projects.add(currentProj);
                            projectNum++;
                        }
                    }
                }

            }
            inputReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurrec:");
            ex.printStackTrace();
        }
    }

}
