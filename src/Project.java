import java.util.ArrayList;

public class Project {
    public String name;
    public int duration;
    public int score;
    public int bestBefore;
    public int roles;
    public ArrayList<Person> people;
    public ArrayList<ReqSkill> reqSkills;

    public Project(String name, int duration, int score, int bestBefore, int roles) {
        this.name = name;
        this.duration = duration;
        this.score = score;
        this.bestBefore = bestBefore;
        this.roles = roles;
        this.reqSkills = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void addSkill(String skillName, int level) {
        ReqSkill newSkill = new ReqSkill(skillName, level);
        reqSkills.add(newSkill);
    }

    public int getDuration() {
        return duration;
    }

    public int getBestBefore() {
        return bestBefore;
    }
}
