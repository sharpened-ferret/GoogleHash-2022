import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MainAsinsa {

    public static void main(String[] args) {
        String[] inputFilepath = {"a_an_example", "b_better_start_small", "c_collaboration", "d_dense_schedule", "e_exceptional_skills", "f_find_great_mentors"};
        ArrayList<Person> inUsePerson;
        for (int i = 0; i < inputFilepath.length; i++) {
            Parser parse = new Parser("src/input/" + inputFilepath[i] + ".in.txt");

            try {
                PrintWriter printWriter = new PrintWriter(new FileWriter("src/output/" + inputFilepath[i] + ".out.txt"));
                StringBuilder outputString = new StringBuilder();
                int completedProjects = 0;
                parse.projects.sort(Comparator.comparing(Project::getDuration));
                //Collections.shuffle(parse.projects);

                for (Project project : parse.projects) {
                    Collections.shuffle(parse.people);
                    inUsePerson = new ArrayList<>();
                    //System.out.println(project.name);
                    StringBuilder members = new StringBuilder();
                    int rolesToFill = project.roles;
                    ArrayList<String> mentorSkills = new ArrayList<>();
                    for (ReqSkill requiredSkills : project.reqSkills) {

                        boolean everybodyUsed = false;

                        for (Person person : parse.people) {
                            if (person.alreadyUsed) {
                                everybodyUsed = true;
                            }
                        }

                        if (everybodyUsed) {
                            for (Person person : parse.people) {
                                person.alreadyUsed = false;
                            }
                        }
                        for (Person person : parse.people) {
                            //String[] skill = person.skills.containsKey().split("=");
                            //skill=num
                            //skill



                            if (!person.alreadyUsed && !(inUsePerson.contains(person)) && (person.skills.containsKey(requiredSkills.name))) {
                                //                        System.out.println();
                                if (person.skills.get(requiredSkills.name) >= requiredSkills.level
                                        || (person.skills.get(requiredSkills.name) >= requiredSkills.level - 1 && mentorSkills.contains(requiredSkills.getName()))) {
                                    //                            System.out.println(project.name + person.name + requiredSkills.name);
                                    members.append(person.name + " ");
                                    for (int j = 0; j < project.reqSkills.size(); j++) {
                                        if (person.skills.get(project.reqSkills.get(j)) != null) {
                                            if (person.skills.get(project.reqSkills.get(j)) > project.reqSkills.get(j).getLevel()
                                                    && project.reqSkills.get(j).getName() != requiredSkills.getName()) {
                                                mentorSkills.add(project.reqSkills.get(j).getName());
                                            }
                                        }

                                    }
                                    rolesToFill--;
                                    inUsePerson.add(person);
                                    person.alreadyUsed = true;
//                                    if (person.skills.get(requiredSkills.name) <= requiredSkills.level){
//                                        person.learn(requiredSkills.name);
//                                    }
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
