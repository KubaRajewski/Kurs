package testy.test2.zadanie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Child {
    private int childId;
    private final char gender;
    private String name;
    private final Date dateOfBirth;
    private final double weight;
    private final double height;
    private Mother mum;

    public static List<Child> extension = new ArrayList<>();

    public Child(int childId, char gender, String name, Date dateOfBirth, double weight, double height) {
        for (Child child : extension) {
            if (child.childId == childId){
                throw new IllegalArgumentException("Child with this id already exists");
            }
        }

        this.childId = childId;
        this.gender = gender;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;

        extension.add(this);
    }

    //TODO 0) zaimplementuj relacje oraz wczytaj pliki
    public static void readChildren(File noworodki) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(noworodki))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 7) {
                    try {
                        int childId = Integer.parseInt(parts[0]);
                        char gender = parts[1].charAt(0);
                        String name = parts[2];
                        Date dateOfBirth = dateFormat.parse(parts[3]);
                        double weight = Double.parseDouble(parts[4]);
                        double height = Double.parseDouble(parts[5]);
                        int idMatki = Integer.parseInt(parts[6]);

                        Mother mother = findMotherById(idMatki);

                        Child child = new Child(childId, gender, name, dateOfBirth, weight, height);
                        if (mother == null){
                            throw new IllegalArgumentException("Mother not found for baby with id:" + childId);
                        }
                        child.setMum(mother);
                        mother.getChildren().add(child);
                    } catch (NumberFormatException | ParseException e) {
                        System.err.println("Error occured while transforming line: " + line);
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Mother findMotherById(int id) {
        if (Mother.extension.isEmpty()) {
            throw new IllegalArgumentException("List of mothers is empty");
        }
        for (Mother mother : Mother.extension) {
            if (mother.getMotherId() == id) {
                return mother;
            }
        }
        return null;
    }

    //TODO  a) Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.
    public static Child tollestChildByGender(List<Child> children, char gender) {
        if (children.isEmpty()) {
            throw new IllegalArgumentException("List of children is empty");
        }
        Child tollestChild = children.get(0);

        for (Child c : children) {
            if ((c.getHeight() > tollestChild.getHeight()) && c.getGender() == gender){
                tollestChild = c;
            }
        }

        return tollestChild;
    }

    //TODO b) W którym dniu tygodnia urodziło się najwięcej dzieci? Podaj dzien tygodnia i liczbe dzieci.
    public static Map.Entry<String, Integer> mostPopularDay() {
        if (extension.isEmpty()) {
            throw new IllegalArgumentException("List of children is empty");
        }

        Map<String, Integer> dayOfWeekCount = new HashMap<>();

        for (Child child : extension) {
            Date dateOfBirth = child.getDateOfBirth();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateOfBirth);

            String dayOfWeek = new SimpleDateFormat("EEEE").format(dateOfBirth);

            dayOfWeekCount.put(dayOfWeek, dayOfWeekCount.getOrDefault(dayOfWeek, 0) + 1);
        }

        return Collections.max(dayOfWeekCount.entrySet(), Map.Entry.comparingByValue());
    }

    //TODO d) Podaj imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce.
    public static List<Child> girlsWithTheSameNameAsMother(List<Child> children) {
        if (children.isEmpty()) {
            throw new IllegalArgumentException("List of children is empty");
        }

        List<Child> girlsWithTheSameNameAsMother = new ArrayList<>();

        for (Child child : children) {
            if (child.getName().equalsIgnoreCase(child.getMum().getName())) {
                girlsWithTheSameNameAsMother.add(child);
            }
        }

        return girlsWithTheSameNameAsMother;
    }

    public String getFormattedDateOfBirth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateOfBirth);
    }

    public void setMum(Mother mum) {
        if(!mum.getChildren().contains(this)) {
            this.mum = mum;
        }
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public char getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public Mother getMum() {
        return mum;
    }

    public static List<Child> getExtension() {
        return extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return childId == child.childId && gender == child.gender && Double.compare(child.weight, weight) == 0 && Double.compare(child.height, height) == 0 && Objects.equals(name, child.name) && Objects.equals(dateOfBirth, child.dateOfBirth) && Objects.equals(mum, child.mum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childId, gender, name, dateOfBirth, weight, height, mum);
    }

    @Override
    public String toString() {
        return "Id: " + childId + ", name: " + name + ", birthday: " + getFormattedDateOfBirth();
    }
}


