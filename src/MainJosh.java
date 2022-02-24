import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

public class MainJosh {

    public static void main(String[] args) {
        String[] inputFilepath = {"a_an_example", "b_better_start_small", "c_collaboration", "d_dense_schedule", "e_exceptional_skills", "f_find_great_mentors"};

        for (int i = 0; i < inputFilepath.length; i++) {
            Parser parse = new Parser("src/input/" + inputFilepath[i] + ".in.txt");

            try {
                PrintWriter printWriter = new PrintWriter(new FileWriter("src/output/" + inputFilepath[i] + ".out.txt"));
                StringBuilder outputString = new StringBuilder();
                int completedProjects = 0;

                for (Project project : parse.projects) {
                    //System.out.println(project.name);
                    StringBuilder members = new StringBuilder();
                    int rolesToFill = project.roles;
                    for (ReqSkill requiredSkills : project.reqSkills) {
                        for (Person person : parse.people) {
                            //String[] skill = person.skills.containsKey().split("=");
                            //skill=num
                            //skill
                            if (person.skills.containsKey(requiredSkills.name)) {
                                //                        System.out.println();
                                if (person.skills.get(requiredSkills.name) >= requiredSkills.level) {
                                    //                            System.out.println(project.name + person.name + requiredSkills.name);
                                    members.append(person.name + " ");
                                    rolesToFill--;
                                    person.learn(requiredSkills.name);
                                    break;
                                }
                            }
                        }
                    }
                    if (rolesToFill == 0) {
                        completedProjects++;
                        outputString.append(project.name + "\n" + members.toString() + "\n");
                    }
                }
                printWriter.print(completedProjects + "\n" + outputString.toString());
                printWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }
    }
}
