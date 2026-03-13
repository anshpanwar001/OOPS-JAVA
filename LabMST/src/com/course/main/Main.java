package com.course.main;

import com.course.model.Course;
import com.course.model.Student;
import com.course.services.CourseService;
import com.course.exception.CourseFullException;
import com.course.exception.CourseNotFoundException;

public class Main {

    public static void main(String[] args) {

        CourseService service = new CourseService();

        Course c1 = new Course(101, "Java Programming", 2);
        Course c2 = new Course(102, "Data Structures", 3);

        service.addCourse(c1);
        service.addCourse(c2);

        Student s1 = new Student(1, "Ansh");
        Student s2 = new Student(2, "Rahul");
        Student s3 = new Student(3, "Aman");

        try {

            service.enrollStudent(101, s1);
            service.enrollStudent(101, s2);
            service.enrollStudent(101, s3); // should throw exception

        } catch (CourseFullException e) {
            System.out.println(e.getMessage());
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAvailable Courses:");
        service.viewCourses();
    }
}