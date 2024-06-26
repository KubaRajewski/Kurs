package testy.test2.zadanie2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Patient extends Person {
    private static List<Patient> extension = new ArrayList<>();
    private int patientId;
    private List<Visit> visits = new ArrayList<>();

    public Patient(int patientId, String surname, String name, String pesel, Date dateOfBirth) {
        super(surname, name, pesel, dateOfBirth);
        for (Patient patient : extension) {
            if (patient.patientId == patientId) {
                throw new IllegalArgumentException("Patient with this patientID already exists");
            }
        }
        this.patientId = patientId;

        extension.add(this);
    }

    // Todo 0) zaimplementuj relacje oraz wczytaj pliki
    public static void readPatients(File patients) {
        try (BufferedReader reader = new BufferedReader(new FileReader(patients))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split("\t");

                if (parts.length == 5) {
                    int patientId = Integer.parseInt(parts[0]);
                    String surname = parts[1];
                    String name = parts[2];
                    String pesel = parts[3];
                    Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(parts[4]);

                    Patient patient = new Patient(patientId, surname, name, pesel, dateOfBirth);
                } else {
                    System.out.println("Skipping invalid data: " + line);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static Patient findPatientByID(int patientId) {
        for (Patient patient : extension) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        throw new IllegalArgumentException("Patient with this ID not found: " + patientId);
    }

    //TODO - znajdź pacjenta który miał najwięcej wizyt
    public static Patient busiestPatient() {
        if (extension.isEmpty()) {
            throw new IllegalArgumentException("List of patients is empty");
        }
        Patient busiestPatient = extension.get(0);

        for (Patient patient : extension) {
            if (patient.getVisits().size() > busiestPatient.getVisits().size()) {
                busiestPatient = patient;
            }
        }

        return busiestPatient;
    }

    public static List<Patient> patientsWithMinimumDoctors(int minDoctors) {
        Map<Patient, List<Doctor>> patientToDoctorsMap = new HashMap<>();
        List<Patient> resultPatients = new ArrayList<>();

        for (Visit visit : Visit.getExtension()) {
            Patient patient = visit.getPatient();
            Doctor doctor = visit.getDoctor();

            List<Doctor> doctorsList = patientToDoctorsMap.get(patient);
            if (doctorsList == null) {
                doctorsList = new ArrayList<>();
                patientToDoctorsMap.put(patient, doctorsList);
            }

            doctorsList.add(doctor);
        }

        for (Map.Entry<Patient, List<Doctor>> entry : patientToDoctorsMap.entrySet()) {
            List<Doctor> uniqueDoctors = entry.getValue();
            if (uniqueDoctors.size() >= minDoctors) {
                resultPatients.add(entry.getKey());
            }
        }

        return resultPatients;
    }

    public static List<Patient> getExtension() {
        return extension;
    }

    public static void setExtension(List<Patient> extension) {
        Patient.extension = extension;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return patientId == patient.patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), patientId);
    }
}
