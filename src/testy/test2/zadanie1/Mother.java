package testy.test2.zadanie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mother {
    private int motherId;
    private String name;
    private int age;

    private List<Child> children = new ArrayList<>();

    public static List<Mother> extension = new ArrayList<>();

    public Mother(int motherId, String name, int age) {
        this.motherId = motherId;
        this.name = name;
        this.age = age;

        extension.add(this);
    }

//TODO  c) Podaj imiona kobiet w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g.
    public static List<Mother> mothersCertainAgeWithKidsCertainWeight(List<Mother> mothers, int age, double weight){
        List <Mother> mothersCertainAgeWithKidsCertainWeight = new ArrayList<>();

        for (Mother m : mothers) {
            if (m.getAge() < age) {
                for (Child c : m.getChildren()) {
                    if (c.getWeight() > weight) {
                        mothersCertainAgeWithKidsCertainWeight.add(m);
                    }
                }
            }
        }
        return mothersCertainAgeWithKidsCertainWeight;
    }

    public static void readMothers(File mamy) {
        try (BufferedReader br = new BufferedReader(new FileReader(mamy))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);

                    Mother mum = new Mother(id, name, age);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMotherId() {
        return motherId;
    }

    public void setMotherId(int motherId) {
        this.motherId = motherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public static List<Mother> getExtension() {
        return extension;
    }

    public static void setExtension(List<Mother> extension) {
        Mother.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mother mother = (Mother) o;
        return motherId == mother.motherId && age == mother.age && Objects.equals(name, mother.name) && Objects.equals(children, mother.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motherId, name, age, children);
    }

    @Override
    public String toString() {
        return "Id: " + motherId + ", name " + name + ", age: " + age + ", dzieci: " + children;
    }
}
