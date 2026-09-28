package com.studentmanagament.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.studentmanagament.model.Marks;
import com.studentmanagament.model.Student;

public class StudentServiceImpl implements StudentService {

	
	private final List<Student> list = new ArrayList<Student>();
	private final Scanner sc;

	public StudentServiceImpl(Scanner sc) {
		this.sc = sc;
	}

// CASE 1 - ADD STUDENT
	@Override
	public void addStudent(Student student) {

		System.out.println("How many Student you need to store");
		int num = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < num; i++) {

			Student newStudent = new Student();
			Marks marks = new Marks();

			System.out.println("Student " + (i + 1));

			System.out.print("Enter Student Name :- ");
			newStudent.setName(sc.nextLine());

			System.out.print("Enter Student Address :- ");
			newStudent.setAddress(sc.nextLine());

			System.out.print("Enter Roll Number :- ");
			int rollNo = sc.nextInt();

			// Check duplicate roll number before taking marks
			if (findStudentById(rollNo) != null) {
				System.out.println("Roll number already exists. Student not added.");
				i--;
				sc.nextLine();
				continue;
			}

			newStudent.setRollno(rollNo);

			System.out.println("Now Enter Marks");

			// Java Mark
			boolean java = true;

			do {
				System.out.print("Enter Java Mark :- ");
				float javaMark = sc.nextFloat();

				if (javaMark >= 0 && javaMark <= 100) {
					marks.setJavaMarks(javaMark);
					java = false;
				} else {
					System.out.println("Invalid mark");
				}

			} while (java);

			// SQL Mark
			boolean sql = true;

			do {
				System.out.print("Enter Sql Mark :- ");
				float sqlMark = sc.nextFloat();

				if (sqlMark >= 0 && sqlMark <= 100) {
					marks.setSqlMarks(sqlMark);
					sql = false;
				} else {
					System.out.println("Invalid mark");
				}

			} while (sql);

			// Spring Mark
			boolean spring = true;

			do {
				System.out.print("Enter Spring Mark :- ");
				float springMark = sc.nextFloat();

				if (springMark >= 0 && springMark <= 100) {
					marks.setSpringMarks(springMark);
					spring = false;
				} else {
					System.out.println("Invalid mark");
				}

			} while (spring);

			// HTML Mark
			boolean html = true;

			do {
				System.out.print("Enter Html Mark :- ");
				float htmlMark = sc.nextFloat();

				if (htmlMark >= 0 && htmlMark <= 100) {
					marks.setHtmlMarks(htmlMark);
					html = false;
				} else {
					System.out.println("Invalid mark");
				}

			} while (html);

			// React Mark
			boolean react = true;

			do {
				System.out.print("Enter React Mark :- ");
				float reactMark = sc.nextFloat();

				if (reactMark >= 0 && reactMark <= 100) {
					marks.setReactMarks(reactMark);
					react = false;
				} else {
					System.out.println("Invalid mark");
				}

			} while (react);

			sc.nextLine();

			newStudent.setMark(marks);
			list.add(newStudent);

			System.out.println("Student added successfully.");
		}
	}

// CASE 2 - VIEW ALL STUDENTS
	@Override
	public List<Student> getAllStudents() {

		System.out.println("====== All Students Data ======");

		if (list.isEmpty()) {
			System.out.println("No Student Available");
		} else {
			list.forEach(System.out::println);
		}

		return list;
	}

// CASE 3 - SEARCH STUDENT
	@Override
	public Student findStudentById(int studentId) {

		for (Student student : list) {

			if (student.getRollno() == studentId) {
				return student;
			}
		}

		return null;
	}

// CASE 4 - UPDATE STUDENT
	@Override
	public boolean updateStudent(Student student) {

		System.out.println("Enter Student Roll Number to Update:");
		int rollNo = sc.nextInt();

		Student existingStudent = findStudentById(rollNo);

		if (existingStudent == null) {
			System.out.println("Student not found.");
			return false;
		}

		System.out.println("What do you want to update?");
		System.out.println("1. Student Name / Address");
		System.out.println("2. Student Marks");

		int mainChoice = sc.nextInt();

		switch (mainChoice) {

		case 1:

			System.out.println("1. Name");
			System.out.println("2. Address");

			int updateChoice = sc.nextInt();
			sc.nextLine();

			switch (updateChoice) {

			case 1:

				System.out.println("Enter New Name:");
				String name = sc.nextLine();

				existingStudent.setName(name);

				break;

			case 2:

				System.out.println("Enter New Address:");
				String address = sc.nextLine();

				existingStudent.setAddress(address);

				break;

			default:

				System.out.println("Invalid choice");
				return false;
			}

			break;

		case 2:

			Marks newMarks = existingStudent.getMark();

			if (newMarks == null) {
				newMarks = new Marks();
				existingStudent.setMark(newMarks);
			}

			boolean loop = true;

			while (loop) {

				System.out.println("Which Subject Mark you need to Update :- ");
				System.out.println("1. Java Mark");
				System.out.println("2. Sql mark");
				System.out.println("3. Spring Mark");
				System.out.println("4. Html Mark");
				System.out.println("5. React Mark");
				System.out.println("6. Exit");
				System.out.println("Enter Subject Number :- ");

				int updateMark = sc.nextInt();

				switch (updateMark) {

				case 1:

					boolean java = true;

					do {

						System.out.println("Enter Java Marks:");
						float javaMark = sc.nextFloat();

						if (javaMark >= 0 && javaMark <= 100) {

							newMarks.setJavaMarks(javaMark);
							java = false;

						} else {

							System.out.println("Invalid mark");
						}

					} while (java);

					break;

				case 2:

					boolean sql = true;

					do {

						System.out.println("Enter SQL Marks:");
						float sqlMark = sc.nextFloat();

						if (sqlMark >= 0 && sqlMark <= 100) {

							newMarks.setSqlMarks(sqlMark);
							sql = false;

						} else {

							System.out.println("Invalid mark");
						}

					} while (sql);

					break;

				case 3:

					boolean spring = true;

					do {

						System.out.println("Enter Spring Marks:");
						float springMark = sc.nextFloat();

						if (springMark >= 0 && springMark <= 100) {

							newMarks.setSpringMarks(springMark);
							spring = false;

						} else {

							System.out.println("Invalid mark");
						}

					} while (spring);

					break;

				case 4:

					boolean html = true;

					do {

						System.out.println("Enter HTML Marks:");
						float htmlMark = sc.nextFloat();

						if (htmlMark >= 0 && htmlMark <= 100) {

							newMarks.setHtmlMarks(htmlMark);
							html = false;

						} else {

							System.out.println("Invalid mark");
						}

					} while (html);

					break;

				case 5:

					boolean react = true;

					do {

						System.out.println("Enter React Marks:");
						float reactMark = sc.nextFloat();

						if (reactMark >= 0 && reactMark <= 100) {

							newMarks.setReactMarks(reactMark);
							react = false;

						} else {

							System.out.println("Invalid mark");
						}

					} while (react);

					break;

				case 6:

					loop = false;

					break;

				default:

					System.out.println("Invalid choice");
					break;
				}
			}

			break;

		default:

			System.out.println("Invalid choice");
			return false;
		}

		System.out.println("Student updated successfully.");

		return true;
	}

// CASE 5 - DELETE STUDENT
	@Override
	public boolean deleteStudent(int studentId) {

		System.out.println("Enter Student Roll Number to Delete :");
		int roll = sc.nextInt();

		Student student = findStudentById(roll);

		if (student != null) {

			list.remove(student);

			System.out.println("Student deleted successfully.");

			return true;
		}

		System.out.println("Student not Found.");

		return false;
	}

// CASE 7 - STUDENT RESULT
	@Override
	public String getStudentResult(int studentId) {

		Student student = findStudentById(studentId);

		if (student == null) {
			return "Student not Found";
		}

		Marks marks = student.getMark();

		if (marks == null) {
			return "Marks not available for this student";
		}

		String pass;

		if (marks.isPassed()) {
			pass = "Pass";
		} else {
			pass = "Fail";
		}

		return "\nStudent Name :- " + student.getName() + "\nRoll Number  :- " + student.getRollno()
				+ "\nTotal Marks :- " + marks.calculateTotal() + "\nPercentage :- " + marks.calculatePercentage() + "%"
				+ "\nGrade  :- " + marks.calculateGrade() + "\nResult  :- " + pass;
	}

// CASE 8 - FIND TOPPER
	@Override
	public Student findTopper() {

		System.out.println("*** Our Class Topper ***");

		if (list.isEmpty()) {
			System.out.println("No Student Available");
			return null;
		}

		Student topper = list.stream().filter(student -> student.getMark() != null)
				.max(Comparator.comparingDouble(student -> student.getMark().calculatePercentage())).orElse(null);

		if (topper == null) {
			System.out.println("No Student Marks Available");
			return null;
		}

		System.out.println(topper);

		return topper;
	}

// FIND STUDENTS BY NAME
	@Override
	public List<Student> findStudentsByName(String name) {

		List<Student> studentByName = new ArrayList<>();

		for (Student student : list) {

			if (student.getName() != null && student.getName().equalsIgnoreCase(name)) {

				studentByName.add(student);
			}
		}

		return studentByName;
	}

// FIND STUDENTS ABOVE PERCENTAGE
@Override
public List<Student> findStudentsAbovePercentage(double percentage) {

    List<Student> abovePercentage = new ArrayList<>();

    for (Student student : list) {

        if (student.getMark() != null
                && student.getMark().calculatePercentage() > percentage) {

            abovePercentage.add(student);
        }
    }

    return abovePercentage;
}

}
