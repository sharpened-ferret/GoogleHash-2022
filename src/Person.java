import java.util.HashMap;

public class Person {
    public String name;
    public HashMap<String, Integer> skills;

    public Person(String name, HashMap<String, Integer> skills) {
        this.name = name;
        this.skills = skills;
    }
}
