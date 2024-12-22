package Model;

public class HealthData {

    private String name;
    private int age;
    private String gender;
    private String bloodType;
    private String medicalCondition;
    private String doctor;
    private String hospital;
    private String insuranceProvider;
    private double billingAmount;
    private int roomNumber;
    private String admissionType;
    private String dischargeDate;
    private String medication;
    private String testResults;

    // Constructeur avec tous les attributs
    public HealthData(String name, int age, String gender, String bloodType, String medicalCondition, String doctor, String hospital, String insuranceProvider, String admissionType, double billingAmount, int roomNumber, String dischargeDate, String medication, String testResults, String normal) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bloodType = bloodType;
        this.medicalCondition = medicalCondition;
        this.doctor = doctor;
        this.hospital = hospital;
        this.insuranceProvider = insuranceProvider;
        this.billingAmount = billingAmount;
        this.roomNumber = roomNumber;
        this.admissionType = admissionType;
        this.dischargeDate = dischargeDate;
        this.medication = medication;
        this.testResults = testResults;
    }

    // Getters et Setters pour chaque attribut
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

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public double getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(double billingAmount) {
        this.billingAmount = billingAmount;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getAdmissionType() {
        return admissionType;
    }

    public void setAdmissionType(String admissionType) {
        this.admissionType = admissionType;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }
}
