import java.util.ArrayList;

public class Project {
    public String name;
    public int duration;
    public int score;
    public int bestBefore;
    public int roles;
    public ArrayList<Person> people;

    public Project(String name, int duration, int score, int bestBefore, int roles) {
        this.name = name;
        this.duration = duration;
        this.score = score;
        this.bestBefore = bestBefore;
        this.roles = roles;
    }

    public void addPerson(Person person) {
        people.add(person);
    }
}
