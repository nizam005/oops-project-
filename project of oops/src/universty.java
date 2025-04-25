import java.util.*;


class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}


class Student extends Person {
    private String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
    }
}

class Professor extends Person {
    private String subject;

    public Professor(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Teaches: " + subject);
    }
}


class Department {
    private String deptName;
    private List<Professor> professors;

    public Department(String deptName, List<Professor> professors) {
        this.deptName = deptName;
        this.professors = professors;
    }

    public void displayProfessors() {
        System.out.println("Department: " + deptName);
        for (Professor prof : professors) {
            prof.displayInfo();
        }
    }
}


class University {
    private String uniName;
    private List<Department> departments;

    public University(String uniName, List<Department> departments) {
        this.uniName = uniName;
        this.departments = departments;
    }

    public void displayUniversity() {
        System.out.println("University: " + uniName);
        for (Department dept : departments) {
            dept.displayProfessors();
        }
    }
}


 class UniversityManagementSystem {
    public static void main(String[] args) {

        Professor p1 = new Professor("Dr. Haris", 45, "Mathematics");
        Professor p2 = new Professor("Dr. Ali", 54, "Physics");
        List<Professor> scienceProfessors = Arrays.asList(p1, p2);


        Department scienceDept = new Department("BSRS", scienceProfessors);

        University uni = new University(" Mehran University", Arrays.asList(scienceDept));

        uni.displayUniversity();

        Student s1 = new Student("zaid", 20, "S11");


        Thread studentThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("\n--- Student Info (from a separate thread) ---");
                s1.displayInfo();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });

        studentThread.start();

        System.out.println("\nMain thread is continuing...");
    }
}

