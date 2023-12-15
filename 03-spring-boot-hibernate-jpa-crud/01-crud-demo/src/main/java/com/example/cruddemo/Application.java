package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            readAllStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students...");
        int num = studentDAO.deleteAll();
        System.out.println("Deleted " + num + " students");

        System.out.println("Reading all students...");
        studentDAO.findAll().forEach(System.out::println);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        System.out.println("Deleting student...");
        studentDAO.delete(3);
        System.out.println("Deleted student with id: 3");

        System.out.println("Reading all students...");
        studentDAO.findAll().forEach(System.out::println);
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("Updating student...");
        Student student = studentDAO.findById(3);

        student.setFirstName("Piotr");
        student.setEmail("piotrkowalski@gmail.com");

        studentDAO.update(student);

        System.out.println("Updated student: " + student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        System.out.println("Querying for students by last name...");

        studentDAO.findByLastName("Kowalski").forEach(System.out::println);
    }

    private void readAllStudents(StudentDAO studentDAO) {
        System.out.println("Reading all students...");

        studentDAO.findAll().forEach(System.out::println);
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(4);

        System.out.println(student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating new student objects...");
        Student newStudent1 = new Student("Jan", "Kowalski", "jankowalski@gmail.com");
        Student newStudent2 = new Student("Anna", "Nowak", "annanowak@gmail.com");
        Student newStudent3 = new Student("Piotr", "Kowalczyk", "piotrkowalczyk@gmail.com");

        System.out.println("Saving students...");
        studentDAO.save(newStudent1);
        studentDAO.save(newStudent2);
        studentDAO.save(newStudent3);

        System.out.println("Saved students. Generated ids: " + newStudent1.getId() + ", " + newStudent2.getId() + ", " + newStudent3.getId());
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object...");
        Student newStudent = new Student("Jan", "Kowalski", "jankowalski@gmail.com");

        System.out.println("Saving student...");
        studentDAO.save(newStudent);

        System.out.println("Saved student. Generated id: " + newStudent.getId());
    }
}
