package ws.RestService;

import Model.Patient;
import Model.Admission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService_Update {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AdmissionRepository admissionRepository;

    public Patient updatePatientInformation(String name, int age, int roomNumber) {
        // Rechercher le patient par son nom
        Patient patient = patientRepository.findByName(name);

        if (patient != null) {
            // Mise à jour de l'âge du patient
            patient.setAge(age);

            // Rechercher l'admission du patient
            Admission admission = patient.getAdmission(); // Accède à l'admission du patient

            if (admission != null) {
                // Mise à jour du numéro de chambre dans l'admission
                admission.setRoomNumber(roomNumber);

                // Sauvegarder l'admission mise à jour
                admissionRepository.save(admission);
            } else {
                // Si l'admission n'existe pas, traiter l'absence d'admission ou créer une nouvelle admission
            }

            // Sauvegarder le patient mis à jour
            return patientRepository.save(patient);
        } else {
            // Si le patient n'existe pas, renvoyer une erreur ou null
            throw new RuntimeException("Patient not found with name: " + name);
        }
    }
}
