
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class Student extends Person {
    protected final String studentId;
    protected double gpa;

    public Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String toString() {
        return super.toString() + ", Student{studentId='" + studentId + "', gpa=" + gpa + "}";
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, int age, String studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    public String toString() {
        return super.toString() + ", GradStudent{thesis='" + thesis + "'}";
    }

    public static void main(String[] args) {
        GradStudent gs = new GradStudent("Bittu", 22, "GS101", 8.9, "AI Research");
        System.out.println(gs);
        System.out.println("GradStudent IS-A Student: " + (gs instanceof Student));
        System.out.println("Student IS-A Person: " + (gs instanceof Person));
    }
}
