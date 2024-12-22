package ws.RestService;

import Model.Admission;
import Model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AdmissionRepository admissionRepository;

    // Recherche du patient par nom et numéro de chambre
    public Patient getPatientByNameAndRoomNumber(String name, int roomNumber) {
        // Chercher le patient par nom
        Patient patient = patientRepository.findByName(name);

        if (patient != null) {
            // Rechercher l'admission avec le numéro de chambre
            Admission admission = admissionRepository.findByPatientNameAndRoomNumber(name, roomNumber);
            if (admission != null) {
                // Assigner l'admission et son numéro de chambre
                patient.setAdmission(admission);  // Associe l'admission au patient
            }
        }
        return patient;
    }
}
