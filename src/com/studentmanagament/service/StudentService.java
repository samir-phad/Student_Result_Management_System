package com.studentmanagament.service;

import java.util.List;

import com.studentmanagament.model.Student;

public interface StudentService {

	public void addStudent(Student student);

	public List<Student> getAllStudents();

	public Student findStudentById(int studentId);

	public boolean updateStudent(Student student);

	public boolean deleteStudent(int studentId);

	public String getStudentResult(int studentId);

	public Student findTopper();

	public List<Student> findStudentsByName(String name);

	public List<Student> findStudentsAbovePercentage(double percentage);
}
