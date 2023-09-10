package testy.test2.zadanie2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Doctor  extends Person{
    private final int doctorId;
    private String specialization;
    private final String nip;
    private List<Visit> visits = new ArrayList<>();

    private static List<Doctor> extension = new ArrayList<>();

    public Doctor(String surname, String name, String pesel, Date dateOfBirth, int doctorId, String specialization, String nip) {
        super(surname, name, pesel, dateOfBirth);
        for (Doctor doctor : extension) {
            if (doctor.doctorId == doctorId || doctor.nip.equals(nip)){
                throw new IllegalArgumentException("Doctor with this Id or nip already exists");
            }
        }
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.nip = nip;

        extension.add(this);
    }

    // Todo 0) zaimplementuj relacje oraz wczytaj pliki
    public static void readDoctors(File doctors) {
        try (BufferedReader reader = new BufferedReader(new FileReader(doctors))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split("\t");

                if (parts.length == 7) {
                    int doctorId = Integer.parseInt(parts[0]);
                    String surname = parts[1];
                    String name = parts[2];
                    String specialization = parts[3];
                    Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(parts[4]);
                    String nip = parts[5];
                    String pesel = parts[6];

                    Doctor doctor = new Doctor(surname, name, pesel, dateOfBirth, doctorId, specialization, nip);
                } else {
                    System.out.println("Skipping invalid data: " + line);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static Doctor findDoctorByID(int doctorId) {
        for (Doctor doctor : Doctor.getExtension()) {
            if (doctor.getDoctorId() == doctorId){
                return doctor;
            }
        }
        throw new IllegalArgumentException("Doctor with this ID not found: " + doctorId);
    }

    //TODO - znajdź lekarza ktory miał najwięcej wizyt
    public static Doctor busiestDoctor(){
        Doctor busiestDoctor = extension.get(0);
        for (Doctor doctor : extension) {
            if (doctor.getVisits().size() > busiestDoctor.getVisits().size()){
                busiestDoctor = doctor;
            }
        }
        return busiestDoctor;
    }


    //TODO - która specalizacja cieszy się największym powodzeniem?
    public static String mostPopularSpecialty() {
        Map<String, Integer> specialtyCounts = new HashMap<>();

        for (Doctor doctor : extension) {
            String specialty = doctor.getSpecialization();
            specialtyCounts.put(specialty, specialtyCounts.getOrDefault(specialty, 0) + doctor.getVisits().size());
        }

        int maxCount = 0;
        String mostPopularSpecialty = "";

        for (Map.Entry<String, Integer> entry : specialtyCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopularSpecialty = entry.getKey();
            }
        }

        return mostPopularSpecialty;
    }

    //TODO - wypisz top 5 najstarszych lekarzy
    public static List<Doctor> oldestDoctors(int limit) {
        Comparator<Doctor> birthDateComparator = Comparator.comparing(Doctor::getDateOfBirth);
        List<Doctor> extensionCopy = new ArrayList<>(extension);
        extensionCopy.sort(birthDateComparator);

        int resultSize = Math.min(limit, extensionCopy.size());
        return extensionCopy.subList(0, resultSize);
    }

    //TODO - wypisz top 5 lekarzy co mieli najwiecej wizyt
    public static List<Doctor> busiestDoctors(int limit) {
        Comparator<Doctor> visitsComparator = Comparator.comparingInt(doctor -> doctor.getVisits().size());
        List<Doctor> extensionCopy = new ArrayList<>(extension);
        extensionCopy.sort(visitsComparator.reversed());

        int resultSize = Math.min(limit, extensionCopy.size());
        return extensionCopy.subList(0, resultSize);
    }

    //TODO - zwroc lekarzy ktorzy przyjeli tylko jednego pacjenta
    public static List<Doctor> doctorsWithCertainAmountOfPatients(int num) {
        Map<Doctor, Integer> doctorToPatientCount = new HashMap<>();

        for (Visit visit : Visit.getExtension()) {
            Doctor doctor = visit.getDoctor();
            doctorToPatientCount.put(doctor, doctorToPatientCount.getOrDefault(doctor, 0) + 1);
        }

        List<Doctor> doctorsWithCertainAmountOfPatients = new ArrayList<>();

        for (Map.Entry<Doctor, Integer> entry : doctorToPatientCount.entrySet()) {
            if (entry.getValue() == num) {
                doctorsWithCertainAmountOfPatients.add(entry.getKey());
            }
        }

        return doctorsWithCertainAmountOfPatients;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getNip() {
        return nip;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public static List<Doctor> getExtension() {
        return extension;
    }

    public static void setExtension(List<Doctor> extension) {
        Doctor.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return doctorId == doctor.doctorId && Objects.equals(nip, doctor.nip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doctorId, nip);
    }

}