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
    private char gender;
    private String name;
    private Date dateOfBirth;
    private double weight;
    private double height;
    private Mother mum;

    public static List<Child> extension = new ArrayList<>();

    public Child(int childId, char gender, String name, Date dateOfBirth, double weight, double height) {
        this.childId = childId;
        this.gender = gender;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;

        extension.add(this);
    }

//TODO  a) Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.
    public static Child tollestChildByGender(List<Child> list, char gender) {
        Child tollestChild = list.get(0);

        for (Child c : list) {
            if ((c.getHeight() > tollestChild.getHeight()) && c.getGender() == gender){
                tollestChild = c;
            }
        }

        return tollestChild;
    }

    public static void readChildren(File noworodki) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(noworodki))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 7) {
                    int childId = Integer.parseInt(parts[0]);
                    char gender = parts[1].charAt(0);
                    String name = parts[2];

                    try {
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
        for (Mother mother : Mother.extension) {
            if (mother.getMotherId() == id) {
                return mother;
            }
        }
        return null;
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

    public void setGender(char gender) {
        this.gender = gender;
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

    public String getFormattedDateOfBirth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Mother getMum() {
        return mum;
    }

    public void setMum(Mother mum) {
        if(!mum.getChildren().contains(this)) {
            this.mum = mum;
            mum.getChildren().add(this);
        } else {
            throw new IllegalArgumentException("Ta matka ma juz przypisane to dziecko");
        }
    }

    public static List<Child> getExtension() {
        return extension;
    }

    public static void setExtension(List<Child> extension) {
        Child.extension = extension;
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


