/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.RestService;

/**
 *
 * @author farah
 */

import Model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient/{name}/{roomNumber}")
    public Patient getPatientInfo(@PathVariable String name, @PathVariable int roomNumber) {
        return patientService.getPatientByNameAndRoomNumber(name, roomNumber);
    }
}