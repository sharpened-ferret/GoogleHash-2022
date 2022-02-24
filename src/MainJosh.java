import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

public class MainJosh {

    public static void main(String[] args) {
        Parser parse = new Parser("src/input/a_an_example.in.txt");
        //Parser parse = new Parser("src/input/b_better_start_small.in.txt");
        //Parser parse = new Parser("src/input/c_collaboration.in.txt");
        //Parser parse = new Parser("src/input/d_dense_schedule.in.txt");
        //Parser parse = new Parser("src/input/f_find_great_mentors.in.txt");

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("src/output/output.txt"));
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
                                members.append(person.name+" ");
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
