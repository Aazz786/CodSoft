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
            students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void removeStudent(Student student) {
            students.remove(student);
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
    }

    public class StudentManagementSystemApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

            while (true) {
                System.out.println("Student Management System");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter roll number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();
                        Student newStudent = new Student(name, rollNumber, grade);
                        studentManagementSystem.addStudent(newStudent);
                        break;
                    case 2:
                        System.out.print("Enter roll number to remove: ");
                        int removeRollNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Student studentToRemove = studentManagementSystem.searchStudent(removeRollNumber);
                        if (studentToRemove != null) {
                            studentManagementSystem.removeStudent(studentToRemove);
                            System.out.println("Student removed successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter roll number to search: ");
                        int searchRollNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Student foundStudent = studentManagementSystem.searchStudent(searchRollNumber);
                        if (foundStudent != null) {
                            System.out.println("Student found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 4:
                        studentManagementSystem.displayAllStudents();
                        break;
                    case 5:
                        System.out.println("Exiting Student Management System.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }


