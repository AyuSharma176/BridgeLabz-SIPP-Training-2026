// Program 7: Hospital Management System
// Demonstrates: static, this, final, instanceof
import java.util.Scanner;

class Patient {

    // STATIC: hospital name and patient count shared across all Patient objects
    private static String hospitalName = "City Care Hospital";
    private static int totalPatients = 0;

    // FINAL: patientID uniquely identifies each patient and cannot change
    private final String patientID;

    // Instance variables
    private String name;
    private int age;
    private String ailment;
    private boolean isAdmitted;

    // Constructor - uses THIS to resolve ambiguity
    public Patient(String patientID, String name, int age, String ailment) {
        this.patientID  = patientID;   // 'this' resolves parameter vs attribute
        this.name       = name;
        this.age        = age;
        this.ailment    = ailment;
        this.isAdmitted = true;        // Patient is admitted upon creation
        totalPatients++;               // Increment shared counter
    }

    // Getters
    public String getPatientID()  { return patientID; }
    public String getName()       { return name; }
    public int getAge()           { return age; }
    public String getAilment()    { return ailment; }
    public boolean isAdmitted()   { return isAdmitted; }

    // Setters (patientID is final — no setter for it)
    public void setName(String name)       { this.name = name; }
    public void setAge(int age)            { this.age = age; }
    public void setAilment(String ailment) { this.ailment = ailment; }

    // Discharge the patient
    public void discharge() {
        if (isAdmitted) {
            isAdmitted = false;
            totalPatients--;
            System.out.println("Patient " + name + " (ID: " + patientID + ") has been discharged.");
        } else {
            System.out.println("Patient " + name + " is not currently admitted.");
        }
    }

    // STATIC methods: accessed on the class, not an object
    public static void getTotalPatients() {
        System.out.println("Hospital       : " + hospitalName);
        System.out.println("Total Patients : " + totalPatients);
    }

    public static void setHospitalName(String name) { hospitalName = name; }

    // Display patient details
    public void displayPatientDetails() {
        System.out.println("Hospital    : " + hospitalName);
        System.out.println("Patient ID  : " + patientID);   // final — cannot change
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Ailment     : " + ailment);
        System.out.println("Status      : " + (isAdmitted ? "Admitted" : "Discharged"));
    }
}

class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many patients to admit? ");
        int count = sc.nextInt();
        sc.nextLine();

        Patient[] patients = new Patient[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Patient " + (i + 1) + ":");
            System.out.print("Patient ID  : ");
            String pid = sc.nextLine();
            System.out.print("Name        : ");
            String name = sc.nextLine();
            System.out.print("Age         : ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Ailment     : ");
            String ailment = sc.nextLine();
            patients[i] = new Patient(pid, name, age, ailment);
        }

        // STATIC method call
        System.out.println("\n--- Hospital Summary (Static Method) ---");
        Patient.getTotalPatients();

        // INSTANCEOF check before displaying patient details
        System.out.println("\n--- Patient Details (instanceof check) ---");
        Object[] objects = patients;
        for (Object obj : objects) {
            if (obj instanceof Patient) {           // INSTANCEOF verification
                Patient p = (Patient) obj;
                p.displayPatientDetails();
                System.out.println();
            }
        }

        // Discharge first patient after instanceof check
        if (patients.length > 0) {
            Object first = patients[0];
            System.out.println("--- Discharging Patient 1 ---");
            if (first instanceof Patient) {         // INSTANCEOF before discharge
                ((Patient) first).discharge();
            }
            System.out.println("\n--- Updated Hospital Summary ---");
            Patient.getTotalPatients();
        }

        System.out.println("\nNote: 'patientID' is declared 'final' — it cannot be changed after creation.");

        sc.close();
    }
}
