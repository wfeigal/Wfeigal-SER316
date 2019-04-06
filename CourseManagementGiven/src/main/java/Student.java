package main.java;

import java.awt.List;
import java.util.ArrayList;

/**
 * This is student class encapsulating all the details for a student.
 */
public class Student {
    private String asurite;
    private Major major;
    private double overallGrade;
    private ArrayList<Course> courses = new ArrayList<Course>();
    //SER316 TASK 2 SPOTBUGS FIX - removed unused variable Courses2

    public Student(String asurite, Major major) {
        this.setAsurite(asurite);
        this.setMajor(major);
        setOverallGrade(0);

    }

    public String getAsurite() {
        return asurite;
    }

    public void setAsurite(String asurite) {
        this.asurite = asurite;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public double getOverall_grade() {
        return overallGrade;
    }

    public void setOverallGrade(double overallGrade) {
        this.overallGrade = overallGrade;
    }

    public boolean registerForCourse(Course course) {
        course.addStudent(this);
        return courses.add(course);
    }



}
