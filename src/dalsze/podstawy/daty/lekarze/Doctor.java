package dalsze.podstawy.daty.lekarze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;

public class Doctor extends Person {
    private static List<Doctor> extension = new ArrayList<>();
    private final int doctorId;
    private final String nip;
    private String specialization;
    private List<Visit> visits = new ArrayList<>();

    public Doctor(String surname, String name, String pesel, Date dateOfBirth, int doctorId, String specialization, String nip) {
        super(surname, name, pesel, dateOfBirth);
        for (Doctor doctor : extension) {
            if (doctor.doctorId == doctorId) {
                throw new IllegalArgumentException("Doctor with this Id already exists");
            } else if (doctor.nip.equals(nip)) {
                throw new IllegalArgumentException("Doctor with this NIP already exists");
            }
        }

        this.doctorId = doctorId;
        this.specialization = specialization;
        this.nip = nip;

        extension.add(this);
    }

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
            if (doctor.getDoctorId() == doctorId) {
                return doctor;
            }
        }
        throw new IllegalArgumentException("Doctor with this ID not found: " + doctorId);
    }

    // TODO Wypisz wszystkich lekarzy którzy mieli wizyty w marcu, czerwcu i grudniu 2007
    public static Set<Doctor> doctorsWithVisitsInMonthAndYear(Month month, Year year) {
        Set<Doctor> doctorsInMonth = new HashSet<>();

        for (Visit visit : Visit.getExtension()) {
            if (visit.getDate().getYear() == year.getValue() && visit.getDate().getMonth() == month) {
                doctorsInMonth.add(visit.getDoctor());
            }
        }

        return doctorsInMonth;
    }

    public static List<Doctor> doctorsWithVisitsInGivenMonths(Year year, List<Month> months) {
        Map<Doctor, Integer> doctorMonthCount = new HashMap<>();

        for (Month month : months) {
            Set<Doctor> doctorsInGivenMonth = doctorsWithVisitsInMonthAndYear(month, year);
            for (Doctor doctor : doctorsInGivenMonth) {
                doctorMonthCount.put(doctor, doctorMonthCount.getOrDefault(doctor, 0) + 1);
            }
        }

        List<Doctor> resultDoctors = new ArrayList<>();
        for (Map.Entry<Doctor, Integer> entry : doctorMonthCount.entrySet()) {
            if (entry.getValue() == months.size()) {
                resultDoctors.add(entry.getKey());
            }
        }

        return resultDoctors;
    }

    // TODO Wypisz lekarza ktory miał najwiecej wizyt w okresie podanym jako parametr
    public static Doctor busiestDoctorInPeriod(LocalDate start, LocalDate end) {
        Map<Doctor, Integer> doctorVisitsCount = new HashMap<>();

        for (Visit visit : Visit.getExtension()) {
            if (visit.getDate().isAfter(start) && visit.getDate().isBefore(end)) {
                doctorVisitsCount.put(visit.getDoctor(), doctorVisitsCount.getOrDefault(visit.getDoctor(), 0) + 1);
            }
        }

        int maxVisits = 0;
        Doctor busiestDoctor = null;
        for (Map.Entry<Doctor, Integer> entry : doctorVisitsCount.entrySet()) {
            if (entry.getValue() > maxVisits) {
                maxVisits = entry.getValue();
                busiestDoctor = entry.getKey();
            }
        }

        return busiestDoctor;
    }

    public static List<Doctor> getExtension() {
        return extension;
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

