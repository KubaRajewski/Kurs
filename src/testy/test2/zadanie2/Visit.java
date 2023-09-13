package testy.test2.zadanie2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Visit {
    private final Doctor doctor;
    private final Patient patient;
    private final Date date;

    public static List<Visit> extension = new ArrayList<>();

    public Visit(Doctor doctor, Patient patient, Date date) {
        if (doctor == null || patient == null){
            throw new IllegalArgumentException("Doctor and patient needed");
        }

        this.doctor = doctor;
        this.patient = patient;
        this.date = date;

        extension.add(this);
        doctor.getVisits().add(this);
        patient.getVisits().add(this);
    }

    // Todo 0) zaimplementuj relacje oraz wczytaj pliki
    public static void readVisits(File visits) {
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
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(parts[2]);
                    Doctor doctor = Doctor.findDoctorByID(doctorId);
                    Patient patient = Patient.findPatientByID(patientId);

                    Visit visit = new Visit(doctor, patient, date);
                } else {
                    System.out.println("Skipping invalid data: " + line);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    //TODO - którego roku było najwięcej wizyt?
    public static int busiestYear() {
        Map<Integer, Integer> yearCounts = new HashMap<>();

        for (Visit visit : extension) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(visit.getDate());
            int year = calendar.get(Calendar.YEAR);
            yearCounts.put(year, yearCounts.getOrDefault(year, 0) + 1);
        }

        int maxCount = 0;
        int busiestYear = 0;

        for (Map.Entry<Integer, Integer> entry : yearCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                busiestYear = entry.getKey();
            }
        }

        return busiestYear;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getDate() {
        return date;
    }

    private String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static List<Visit> getExtension() {
        return extension;
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
