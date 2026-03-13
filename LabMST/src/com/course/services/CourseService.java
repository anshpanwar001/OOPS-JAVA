package com.course.services;

import com.course.model.Course;
import com.course.model.Student;
import com.course.exception.CourseFullException;
import com.course.exception.CourseNotFoundException;

import java.io.*;
import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();
    private final String FILE_NAME = "courses.txt";

    public void addCourse(Course c) {
        courses.add(c);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(c.getCourseId() + "," + c.getCourseName() + "," + c.getMaxSeats() + "," + c.getEnrolledStudents());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public void enrollStudent(int courseId, Student s)
            throws CourseFullException, CourseNotFoundException {

        Course foundCourse = null;

        for (Course c : courses) {
            if (c.getCourseId() == courseId) {
                foundCourse = c;
                break;
            }
        }

        if (foundCourse == null) {
            throw new CourseNotFoundException("Course ID not found");
        }

        if (foundCourse.getEnrolledStudents() >= foundCourse.getMaxSeats()) {
            throw new CourseFullException("Course is full");
        }

        foundCourse.setEnrolledStudents(foundCourse.getEnrolledStudents() + 1);

        System.out.println("Student enrolled successfully: " + s.getStudentName());
    }

    public void viewCourses() {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("Course ID: " + data[0]);
                System.out.println("Course Name: " + data[1]);
                System.out.println("Max Seats: " + data[2]);
                System.out.println("Enrolled Students: " + data[3]);
                System.out.println("--------------------------");
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}