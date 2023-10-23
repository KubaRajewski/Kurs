package dalsze.podstawy.daty.lekarze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Visit {
    public static List<Visit> extension = new ArrayList<>();
    private final Doctor doctor;
    private final Patient patient;
    private final LocalDate date;

    public Visit(Doctor doctor, Patient patient, LocalDate date) {
        if (doctor == null || patient == null) {
            throw new IllegalArgumentException("Doctor and patient needed");
        }

        this.doctor = doctor;
        this.patient = patient;
        this.date = date;

        extension.add(this);
        doctor.getVisits().add(this);
        patient.getVisits().add(this);
    }

    public static void readVisits(File visits) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d"); // Ustalamy format daty
        try (BufferedReader reader = new BufferedReader(new FileReader(visits))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split("\t");

                if (parts.length == 3) {
                    int doctorId = Integer.parseInt(parts[0]);
                    int patientId = Integer.parseInt(parts[1]);
                    LocalDate date = LocalDate.parse(parts[2], formatter); // Używamy określonego wcześniej formatu
                    Doctor doctor = Doctor.findDoctorByID(doctorId);
                    Patient patient = Patient.findPatientByID(patientId);

                    Visit visit = new Visit(doctor, patient, date);
                } else {
                    System.out.println("Skipping invalid data: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Visit> getExtension() {
        return extension;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getDate() {
        return date;
    }

    private String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Override
    public String toString() {
        return "Doctor: " + doctor.getName() + " " + doctor.getSurname() + ", Patient: "
                + patient.getName() + " " + patient.getSurname() + ", Date: " + getFormattedDate() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visit visit)) return false;
        return Objects.equals(doctor, visit.doctor) && Objects.equals(patient, visit.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, patient, date);
    }
}


