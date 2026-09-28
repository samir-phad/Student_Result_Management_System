package com.studentmanagament.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.studentmanagament.model.Student;
import com.studentmanagament.service.StudentService;
import com.studentmanagament.service.StudentServiceImpl;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		StudentService service = new StudentServiceImpl(sc);

		System.out.println("========================================");
		System.out.println("STUDENT RESULT MANAGEMENT SYSTEM");
		System.out.println("========================================");

		boolean run = true;

		while (run) {

			System.out.println("\n1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Add/Update Marks");
			System.out.println("7. Student Result");
			System.out.println("8. Find Topper");
			System.out.println("9. Sort Students");
			System.out.println("10. Exit");

			System.out.println("Enter Number to Perform Specific Task :- ");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				service.addStudent(new Student());

				break;

			case 2:

				service.getAllStudents();

				break;

			case 3:

				System.out.println("Enter Student Roll No for Search :- ");

				int searchId = sc.nextInt();

				Student searchedStudent = service.findStudentById(searchId);

				if (searchedStudent != null) {

					System.out.println(searchedStudent);

				} else {

					System.out.println("Student not found.");
				}

				break;

			case 4:

				service.updateStudent(new Student());

				break;

			case 5:

				service.deleteStudent(0);

				break;

			case 6:
				// Existing updateStudent() method is used

				service.updateStudent(new Student());

				break;

			case 7:

				System.out.println("Enter Student Roll Number:");

				int resultId = sc.nextInt();

				System.out.println(service.getStudentResult(resultId));

				break;

			case 8:

				service.findTopper();

				break;

			case 9:

				System.out.println("\nEnter how you want to sort the data:");

				System.out.println("1. Sort by Roll Number");
				System.out.println("2. Sort by Name");
				System.out.println("3. Sort by Total Marks");
				System.out.println("4. Sort by Percentage");
				System.out.println("5. Sort by Grade");
				System.out.println("6. Sort by Pass/Fail");

				int a = sc.nextInt();

				// Create a copy so sorting does not permanently change
				// the original list inside StudentServiceImpl
				List<Student> students = new ArrayList<>(service.getAllStudents());

				switch (a) {

				case 1:

					// Sort by Roll Number

					students.sort(Comparator.comparingInt(Student::getRollno));

					students.forEach(x -> System.out.println(
							"Student Roll No :- " + x.getRollno() + "\nStudent Name :- " + x.getName() + "\n"));

					break;

				case 2:

					// Sort by Name

					students.sort(Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER));

					students.forEach(x -> System.out.println("Student Name :- " + x.getName() + "\n"));

					break;

				case 3:

					// Sort by Total Marks

					students.removeIf(student -> student.getMark() == null);

					students.sort(Comparator.comparingDouble(student -> ((Student) student).getMark().calculateTotal())
							.reversed());

					students.forEach(x -> System.out.println("Student Name :- " + x.getName() + "\nStudent Roll no :- "
							+ x.getRollno() + "\nStudent Mark is :- " + x.getMark().calculateTotal() + "\n"));

					break;

				case 4:

					// Sort by Percentage

					students.removeIf(student -> student.getMark() == null);

					students.sort(
							Comparator.comparingDouble(student -> ((Student) student).getMark().calculatePercentage())
									.reversed());

					students.forEach(x -> System.out
							.println("Student Name :- " + x.getName() + "\nStudent Roll no :- " + x.getRollno()
									+ "\nStudent Percentage is :- " + x.getMark().calculatePercentage() + "\n"));

					break;

				case 5:

					// Sort by Grade

					students.removeIf(student -> student.getMark() == null);

					students.sort(
							Comparator.comparingDouble(student -> ((Student) student).getMark().calculatePercentage())
									.reversed());

					students.forEach(x -> System.out.println("Student Name :- " + x.getName() + "\nStudent Roll no :- "
							+ x.getRollno() + "\nGrade is :- " + x.getMark().calculateGrade() + "\n"));

					break;

				case 6:

					// Sort / Filter by PASS/FAIL

					System.out.println("1. Show Passed Students");
					System.out.println("2. Show Failed Students");
					System.out.println("Enter your choice:");

					int passFailChoice = sc.nextInt();

					switch (passFailChoice) {

					case 1:

						System.out.println("\n===== PASSED STUDENTS =====");

						boolean passFound = false;

						for (Student student : students) {

							if (student.getMark() != null && student.getMark().isPassed()) {

								System.out.println(student);

								passFound = true;
							}
						}

						if (!passFound) {
							System.out.println("No passed students found.");
						}

						break;

					case 2:

						System.out.println("\n===== FAILED STUDENTS =====");

						boolean failFound = false;

						for (Student student : students) {

							if (student.getMark() != null && !student.getMark().isPassed()) {

								System.out.println(student);

								failFound = true;
							}
						}

						if (!failFound) {
							System.out.println("No failed students found.");
						}

						break;

					default:

						System.out.println("Invalid choice.");

						break;
					}

					break;

				default:

					System.out.println("Invalid sort choice.");

					break;
				}

				break;

			case 10:

				run = false;

				System.out.println("Thank you!");

				break;

			default:

				System.out.println("Invalid Input");

				break;
			}
		}

		sc.close();
	}

}
