// Program 3: Person class with a copy constructor
import java.util.Scanner;

class Person {
    // Attributes
    private String name;
    private int age;
    private String email;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "unknown@example.com";
    }

    // Parameterized constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Copy constructor — clones another Person object
    public Person(Person other) {
        this.name  = other.name;
        this.age   = other.age;
        this.email = other.email;
    }

    // Getters
    public String getName()  { return name; }
    public int getAge()      { return age; }
    public String getEmail() { return email; }

    // Setters
    public void setName(String name)   { this.name = name; }
    public void setAge(int age)        { this.age = age; }
    public void setEmail(String email) { this.email = email; }

    // Display method
    public void displayPersonDetails() {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Email : " + email);
    }
}

class PersonDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create original person using parameterized constructor
        System.out.println("Enter details for original person:");
        System.out.print("Name  : ");
        String name = sc.nextLine();
        System.out.print("Age   : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Email : ");
        String email = sc.nextLine();

        Person originalPerson = new Person(name, age, email);

        // Create a clone using copy constructor
        Person clonedPerson = new Person(originalPerson);

        // Modify a field in original to prove clone is independent
        originalPerson.setEmail("modified@example.com");

        System.out.println("\n--- Original Person (after email update) ---");
        originalPerson.displayPersonDetails();

        System.out.println("\n--- Cloned Person (copy constructor - unaffected) ---");
        clonedPerson.displayPersonDetails();

        sc.close();
    }
}
