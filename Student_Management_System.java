import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
   

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
       
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }
   

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
	public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class Student_Management_System {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			StudentManagementSystem system = new StudentManagementSystem();

			while (true) {
			    System.out.println("1. Add Student\n2. Remove Student\n3. Search Student\n4. Display All Students\n5. Save to File\n6. Load from File\n7. Exit");
			    System.out.print("Enter your choice: ");
			    int choice = scanner.nextInt();

			    switch (choice) {
			        case 1:
			            // Add Student
			            System.out.print("Enter name: ");
			            String name = scanner.next();
			            System.out.print("Enter roll number: ");
			            int rollNumber = scanner.nextInt();
			            System.out.print("Enter grade: ");
			            String grade = scanner.next();
			            

			            Student newStudent = new Student(name, rollNumber, grade);
			            system.addStudent(newStudent);
			            break;

			        case 2:
			            // Remove Student
			            System.out.print("Enter roll number to remove: ");
			            int removeRollNumber = scanner.nextInt();
			            system.removeStudent(removeRollNumber);
			            break;

			        case 3:
			            // Search Student
			            System.out.print("Enter roll number to search: ");
			            int searchRollNumber = scanner.nextInt();
			            Student foundStudent = system.searchStudent(searchRollNumber);
			            if (foundStudent != null) {
			                System.out.println("Student found: " + foundStudent);
			            } else {
			                System.out.println("Student not found.");
			            }
			            break;

			        case 4:
			            // Display All Students
			            system.displayAllStudents();
			            break;

			        case 5:
			            // Save to File
			            System.out.print("Enter filename to save: ");
			            String saveFileName = scanner.next();
			            system.saveToFile(saveFileName);
			            break;

			        case 6:
			            // Load from File
			            System.out.print("Enter filename to load: ");
			            String loadFileName = scanner.next();
			            system.loadFromFile(loadFileName);
			            break;

			        case 7:
			            // Exit
			            System.exit(0);

			        default:
			            System.out.println("Invalid choice. Please try again.");
			    }
			}
		}
    }
}
