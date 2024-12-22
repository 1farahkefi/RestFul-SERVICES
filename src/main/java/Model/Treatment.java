/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author farah
 */
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Treatment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Treatment {
    private int id;
    private String medication;
    private String testResults;

    public Treatment() {}

    public Treatment(int id, String medication, String testResults) {
        this.id = id;
        this.medication = medication;
        this.testResults = testResults;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMedication() { return medication; }
    public void setMedication(String medication) { this.medication = medication; }

    public String getTestResults() { return testResults; }
    public void setTestResults(String testResults) { this.testResults = testResults; }
}