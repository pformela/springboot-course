package com.example;

import com.example.dao.AppDAO;
import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);
//            findInstructorDetail(appDAO);
            deleteInstructorDetail(appDAO);
        };
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        appDAO.deleteInstructorDetailById(3);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(1);
        System.out.println("Found instructor detail: " + instructorDetail);
    }

    private void deleteInstructor(AppDAO appDAO) {
        appDAO.deleteInstructorById(2);
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
