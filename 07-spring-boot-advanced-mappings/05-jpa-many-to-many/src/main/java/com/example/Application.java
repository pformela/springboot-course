package com.example;

import com.example.dao.AppDAO;
import com.example.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createCourseAndStudents(appDAO);
//            findCourseAndStudents(appDAO);
//            findStudentAndCourses(appDAO);
//            updateStudent(appDAO);
//            deleteCourseById(appDAO);
            deleteStudent(appDAO);
        };
    }

    private void deleteStudent(AppDAO appDAO) {
        Student student = appDAO.findStudentAndCoursesByStudentId(3);

        System.out.println("Found student: " + student);
        System.out.println("Found courses: " + student.getCourses());

        appDAO.deleteStudentById(3);
        System.out.println("Deleted student");
    }

    private void updateStudent(AppDAO appDAO) {
        Student student = appDAO.findStudentAndCoursesByStudentId(3);

        Course newCourse = new Course("Flutter for beginners");

        student.addCourse(newCourse);

        appDAO.update(student);
        System.out.println("Updated student: " + student);
        System.out.println("Updated courses: " + student.getCourses());
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        Student student = appDAO.findStudentAndCoursesByStudentId(3);

        System.out.println("Found student: " + student);
        System.out.println("Found courses: " + student.getCourses());
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        Course course = appDAO.findCourseAndStudentsByCourseId(10);

        System.out.println("Found course: " + course);
        System.out.println("Found students: " + course.getStudents());
    }

    private void createCourseAndStudents(AppDAO appDAO) {
        Course course = new Course("Spring Boot 6 + Hibernate");


        Student student1 = new Student("John", "Doe", "johndoe@gmail.com");
        Student student2 = new Student("Jan", "Kowalski", "jankowalski@gmail.com");
        Student student3 = new Student("Zbigniew", "Nowak", "zbigniewnowak@gmail.com");

        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);

        appDAO.save(course);
        System.out.println("Saved course: " + course);
        System.out.println("Course students: " + course.getStudents());
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        System.out.println("deleting course with id 10");
        appDAO.deleteCourseById(10);

        System.out.println("Done");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        Course course = appDAO.findCourseAndReviewsByCourseId(10);

        System.out.println("Found course: " + course);
        System.out.println("Found reviews: " + course.getReviews());
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course course = new Course("Java");

        course.addReview(new Review("Great course!"));
        course.addReview(new Review("loved it"));
        course.addReview(new Review("tragic course"));

        appDAO.save(course);

        System.out.println("Saved course: " + course);
        System.out.println("Saved reviews: " + course.getReviews());
    }

    private void deleteCourseById(AppDAO appDAO) {
        System.out.println("Deleting course with id 10");
        appDAO.deleteCourseById(10);
        System.out.println("Done");
    }

    private void updateCourse(AppDAO appDAO) {
        Course course = appDAO.findCourseById(11);

        System.out.println("Found course: " + course);

        course.setTitle("Spring Boot version 6 + Hibernate");

        System.out.println("Updating course: " + course);
        appDAO.updateCourse(course);

        System.out.println("Updated course: " + course);
    }

    private void updateInstructor(AppDAO appDAO) {
        Instructor instructor = appDAO.findInstructorById(1);
        System.out.println("Found instructor: " + instructor);

        instructor.setFirstName("Robert");
        instructor.setEmail("robertsmith@gmail.com");

        System.out.println("Updating instructor: " + instructor);

        appDAO.updateInstructor(instructor);

        System.out.println("Updated instructor: " + instructor);
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(1);

        System.out.println("Found instructor: " + instructor);
        System.out.println("Found instructor detail: " + instructor.getInstructorDetail());
        System.out.println("Found courses: " + instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        Instructor instructor = appDAO.findInstructorById(1);

        System.out.println("Found instructor: " + instructor);

        List<Course> courses = appDAO.findCoursesByInstructorId(1);
        instructor.setCourses(courses);
        System.out.println("Found courses: " + instructor.getCourses());

        System.out.println("Done");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = appDAO.findInstructorById(1);

        System.out.println("Found instructor: " + instructor);

        System.out.println("Done");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("Bob", "Smith", "bobsmith@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("youtube.com/bobob", "Coding");

        instructor.setInstructorDetail(instructorDetail);

        instructor.add(new Course("Java"));
        instructor.add(new Course("Spring Boot"));
        instructor.add(new Course("Flutter"));

        System.out.println("Saving instructor: " + instructor);
        System.out.println("Saving courses: " + instructor.getCourses());

        // this will also save courses because of CascadeType.PERIST
        appDAO.save(instructor);
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        appDAO.deleteInstructorDetailById(3);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(1);
        System.out.println("Found instructor detail: " + instructorDetail);
    }

    private void deleteInstructor(AppDAO appDAO) {

        appDAO.deleteInstructorById(1);
    }

    private void findInstructor(AppDAO appDAO) {
        Instructor instructor = appDAO.findInstructorById(2);
        System.out.println("Found instructor: " + instructor);
        System.out.println("Found instructor detail: " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor();
        instructor.setFirstName("Bob");
        instructor.setLastName("Smith");
        instructor.setEmail("smithbob@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setYoutubeChannel("youtube.com/bobob");
        instructorDetail.setHobby("Coding");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving instructor: " + instructor);
        appDAO.save(instructor);
    }
}
