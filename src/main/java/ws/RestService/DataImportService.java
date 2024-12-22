package ws.RestService;

import Model.Patient;
import Model.Admission;
import com.opencsv.CSVReader;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataImportService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AdmissionRepository admissionRepository;

    @PostConstruct
    public void init() {
        try {
            importPatientData();
            System.out.println("Importation des données terminée avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'importation : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour importer les données des patients et admissions depuis un fichier CSV
     */
    @Transactional
    public void importPatientData() {
        List<Patient> patients = new ArrayList<>();
        List<Admission> admissions = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (CSVReader reader = new CSVReader(new InputStreamReader(
                new ClassPathResource("healthcare_dataset.csv").getInputStream()))) {

            String[] values;
            reader.readNext(); // Ignorer la ligne d'entête (header)

            while ((values = reader.readNext()) != null) {
                try {
                    // Validation et création du patient
                    Patient patient = createPatient(values);
                    patient = patientRepository.save(patient); // Sauvegarder le patient
                    patients.add(patient);

                    System.out.println("Patient inséré avec succès : " + patient.getName());

                    // Validation et création de l'admission
                    Admission admission = createAdmission(values, patient, dateFormat);
                    admissions.add(admission);

                } catch (Exception e) {
                    System.err.println("Erreur lors du traitement de la ligne : " + String.join(",", values));
                    e.printStackTrace();
                }
            }

            // Sauvegarder toutes les admissions en une seule fois
            admissionRepository.saveAll(admissions);
            System.out.println("Importation des admissions terminée avec succès !");

        } catch (Exception e) {
            System.err.println("Erreur lors de l'importation des données : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour créer un patient à partir des données CSV
     */
    private Patient createPatient(String[] values) {
        Patient patient = new Patient();
        patient.setName(values[0].trim()); // Name
        patient.setAge(parseInt(values[1], "Age"));
        patient.setGender(values[2].trim()); // Gender
        patient.setBloodType(values[3].trim()); // Blood Type
        patient.setMedicalCondition(values[4].trim()); // Medical Condition
        return patient;
    }

    /**
     * Méthode pour créer une admission à partir des données CSV
     */
    private Admission createAdmission(String[] values, Patient patient, SimpleDateFormat dateFormat) throws ParseException {
        Admission admission = new Admission();
        admission.setPatient(patient);
        admission.setDateOfAdmission(parseDate(values[5], dateFormat, "Date of Admission")); // Date of Admission
        admission.setDoctor(values[6].trim()); // Doctor
        admission.setHospital(values[7].trim()); // Hospital
        admission.setInsuranceProvider(values[8].trim()); // Insurance Provider
        admission.setBillingAmount(parseDouble(values[9], "Billing Amount")); // Billing Amount
        admission.setRoomNumber(parseInt(values[10], "Room Number")); // Room Number
        admission.setAdmissionType(values[11].trim()); // Admission Type
        admission.setDischargeDate(parseDate(values[12], dateFormat, "Discharge Date")); // Discharge Date
        admission.setMedication(values[13].trim()); // Medication
        admission.setTestResults(values[14].trim()); // Test Results
        return admission;
    }

    /**
     * Méthode utilitaire pour parser un entier avec gestion des erreurs
     */
    private int parseInt(String value, String fieldName) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            System.err.println("Erreur de conversion pour le champ '" + fieldName + "': " + value);
            return 0; // Retourne une valeur par défaut en cas d'erreur
        }
    }

    /**
     * Méthode utilitaire pour parser un double avec gestion des erreurs
     */
    private double parseDouble(String value, String fieldName) {
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            System.err.println("Erreur de conversion pour le champ '" + fieldName + "': " + value);
            return 0.0; // Retourne une valeur par défaut en cas d'erreur
        }
    }

    /**
     * Méthode utilitaire pour parser une date avec gestion des erreurs
     */
    private java.util.Date parseDate(String value, SimpleDateFormat dateFormat, String fieldName) {
        try {
            return dateFormat.parse(value.trim());
        } catch (ParseException e) {
            System.err.println("Erreur de conversion pour le champ '" + fieldName + "': " + value);
            return null; // Retourne null en cas d'erreur
        }
    }
}