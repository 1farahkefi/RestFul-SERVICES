package Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String gender;
    private String bloodType;
    private String medicalCondition;
     @OneToOne(mappedBy = "patient")
     @JsonManagedReference
     private Admission admission;

    // Getters et setters
    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    @OneToMany(mappedBy = "patient")
    private List<Admission> admissions;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public List<Admission> getAdmissions() {
        return admissions;
    }

   
}
