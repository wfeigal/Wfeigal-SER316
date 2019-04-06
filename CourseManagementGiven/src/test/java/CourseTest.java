/*
	File:CourseTest.Java
	Author:Bill Feigal
	Date:3/29/19
	Description:Tests for the calculateAverageWithoutMinWithoutMax() method
	within Course.Java
 */

package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.Course;
import main.java.Student;
import main.java.Major;

public class CourseTest {
    Course noStudent, singleStudent, twoStudent, threeStudent,
    negativeStudent, duplicateStudent, setPoint, addStudent, 
    singleNegStudent, twoStudentOneNeg, twoStudentOneNeg2,
    twoNegStudent, threeNegStudent;

    @Before
    public void setUp() throws Exception {
    }

    /**
	Method:NoStudent
	Description: This test checks that the proper exception is thrown with no students 
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    @Test
    public void NoStudent() {
        // No Students 
        noStudent = new Course("SER001");
        exception.expect(NullPointerException.class);
        double ans = noStudent.calculateAverageWithoutMinWithoutMax();
    }
    /**
	Method:SingleNegStudent
	Description: This test checks that the proper exception is thrown with a single negative value 
     */
    @Test
    public void SingleNegStudent() {
        // Single Negative Student 
        singleNegStudent = new Course("SER011");
        singleNegStudent.set_points("Jerry", -50);
        exception.expect(NullPointerException.class);
        double ans = singleNegStudent.calculateAverageWithoutMinWithoutMax();
    }

    /**
	Method:TwoNegStudent
	Description: This test checks that the proper exception is thrown with a two negative values 
     */
    @Test
    public void TwoNegStudent() {
        // Single Negative Student 
        twoNegStudent = new Course("SER111");
        twoNegStudent.set_points("Bunny", -50);
        twoNegStudent.set_points("Hunny", -80);
        exception.expect(NullPointerException.class);
        double ans = twoNegStudent.calculateAverageWithoutMinWithoutMax();
    }

    /**
	Method:ThreeNegStudent
	Description: This test checks that the proper exception is thrown with three negative values 
     */
    @Test
    public void ThreeNegStudent() {
        // Single Negative Student 
        threeNegStudent = new Course("SER011");
        threeNegStudent.set_points("Babs", -20);
        threeNegStudent.set_points("Tootsie", -30);
        threeNegStudent.set_points("Gloria", -40);
        exception.expect(NullPointerException.class);
        double ans = threeNegStudent.calculateAverageWithoutMinWithoutMax();
    }

    /**
	Method:TwoStudentOneNeg
	Description: This test checks that when two students are in a class and one score 
	is negative the appropriate action is taken
     */
    @Test
    public void TwoStudentOneNeg() {
        // Two Students
        twoStudentOneNeg = new Course("SER315");
        twoStudentOneNeg.set_points("Krystal", -60);
        twoStudentOneNeg.set_points("Jenny", 99);
        double ans = twoStudentOneNeg.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 99.0);
    }

    /**
	Method:TwoStudentOneNeg
	Description: This test checks that when two students are in a class and one score 
	is negative the appropriate action is taken - added to increase code coverage
     */
    @Test
    public void TwoStudentOneNeg2() {
        // Two Students
        twoStudentOneNeg2 = new Course("SER315");
        twoStudentOneNeg2.set_points("Kiki", 60);
        twoStudentOneNeg2.set_points("Jaklyn", -99);
        double ans = twoStudentOneNeg2.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 60.0);
    }

    /**
	Method:SingleStudent
	#######################
	Description: This test uses the test sequence #1 in my write up
	#######################
     */
    @Test
    public void SingleStudent() {
        // One Student
        singleStudent = new Course("SER316");
        singleStudent.set_points("Hanna", 50);
        double ans = singleStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 50.0);
    }

    /**
	Method:TwoStudent
	#######################
	Description: This test uses the test sequence #2 in my write up
	#######################
     */
    @Test
    public void TwoStudent() {
        // Two Students
        twoStudent = new Course("SER315");
        twoStudent.set_points("Kara", 20);
        twoStudent.set_points("Jenny", 30);
        double ans = twoStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 25.0);
    }

    /**
	Method:ThreeStudent
	#######################
	Description: This test uses the test sequence #3 in my write up
	#######################
     */
    @Test
    public void ThreeStudent() {
        // Three Students 
        threeStudent = new Course("SER334");
        threeStudent.set_points("Emerald", 10);
        threeStudent.set_points("Jade", 62);
        threeStudent.set_points("Cinnamon", 90);
        double ans = threeStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 62.0);
    }

    /**
	Method:NegativeStudent
	Description: This test checks that negative values are excluded from an otherwise
	valid calculation
     */
    @Test
    public void NegativeStudent() {
        // Three Students 
        negativeStudent = new Course("SER334");
        negativeStudent.set_points("Emerald", 10);
        negativeStudent.set_points("Jade", 75);
        negativeStudent.set_points("Cinnamon", 90);
        negativeStudent.set_points("Diamond", -10);
        double ans = negativeStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 75.0);
    }

    /**
	Method:duplicateStudent
	Description: This test checks that duplicate values are handled correctly
     */
    @Test
    public void DuplicateStudent() {
        // Three Students 
        duplicateStudent = new Course("SER422");
        duplicateStudent.set_points("Crystal", 20);
        duplicateStudent.set_points("Amber", 20);
        duplicateStudent.set_points("Tiffany", 90);
        duplicateStudent.set_points("Brandy", 65);
        double ans = duplicateStudent.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 42.5);
    }

    /**
	Method:SetPoint
	Description: This test checks the set_points method works appropriately 
     */
    @Test
    public void SetPoint() {
        // checks that student name and score is stored correctly
        HashMap<String, Integer> test = new HashMap<>();
        HashMap<String, Integer> control = new HashMap<>();
        control.put("Bambi", 20);
        setPoint = new Course("SER999");
        setPoint.set_points("Bambi", 20);
        setPoint.set_points("Bambi", 20);//Bambi should only be added once
        test = setPoint.GetPoints();
        System.out.println(test.toString());
        assertTrue(test.equals(control));
    }

    /**
	Method:AddStudent
	Description: This test checks the addStudent method works appropriately 
     */
    @Test
    public void AddStudent() {
        // checks that student object is stored correctly
        ArrayList<Student> test  = new ArrayList<Student>();
        Student s = new Student("Chloe", Major.CS);
        addStudent = new Course("SER215");
        addStudent.set_points("Chloe", 20);
        addStudent.set_points("Chloe", 50);
        test = addStudent.getStudents();
        assertTrue(test.get(0).getAsurite().contentEquals(s.getAsurite()));
    }
}