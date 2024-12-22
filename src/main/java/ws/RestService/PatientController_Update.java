/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.RestService;

import Model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patients")
public class PatientController_Update {

    @Autowired
    private PatientService_Update patientServiceUpdate;

    // Endpoint pour mettre à jour les informations du patient par son nom
    @PutMapping("/{name}")
    public Patient updatePatientInformation(
        @PathVariable String name,        // Paramètre : nom du patient
        @RequestParam int age,           // Paramètre : âge à mettre à jour
        @RequestParam int roomNumber     // Paramètre : numéro de chambre à mettre à jour
    ) {
        return patientServiceUpdate.updatePatientInformation(name, age, roomNumber);
    }
}


