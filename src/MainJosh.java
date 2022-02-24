import java.lang.reflect.Array;

public class MainJosh {

    public static void main(String[] args) {
        Parser parse = new Parser("src/input/a_an_example.in.txt");
        //Parser parse = new Parser("src/input/b_better_start_small.in.txt");
        //Parser parse = new Parser("src/input/c_collaboration.in.txt");
        //Parser parse = new Parser("src/input/d_dense_schedule.in.txt");
        //Parser parse = new Parser("src/input/f_find_great_mentors.in.txt");

        while(!parse.projects.isEmpty()) {
            for (Project project : parse.projects) {
                //System.out.println(project.name);
                for (ReqSkill requiredSkills : project.reqSkills) {
                    for (Person person : parse.people) {
                        //String[] skill = person.skills.containsKey().split("=");
                        //skill=num
                        //skill
                        if (person.skills.containsKey(requiredSkills.name)) {
                            System.out.println();
                            if (person.skills.get(requiredSkills.name) >= requiredSkills.level) {
                                System.out.println(project.name + person.name + requiredSkills.name);
                                person.learn(requiredSkills.name);
                                parse.projects.remove(project);
                                break;
                            }
                        }
                    }
                }
            }
        }


    }
}
