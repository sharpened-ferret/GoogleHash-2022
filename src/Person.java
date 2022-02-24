import java.util.HashMap;
import java.util.Objects;

public class Person {
    public String name;
    public HashMap<String, Integer> skills;
    public Boolean alreadyUsed;

    public Person(String name, HashMap<String, Integer> skills) {
        this.name = name;
        this.skills = skills;
        this.alreadyUsed = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(skills, person.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skills);
    }

    public void learn(String skill) {
        skills.replace(skill, skills.get(skill) + 1);
    }

}
