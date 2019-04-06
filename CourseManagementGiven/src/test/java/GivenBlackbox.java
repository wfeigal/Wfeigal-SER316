package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import main.java.Course;
import main.java.CourseGrades0;
import main.java.CourseGrades1;
import main.java.CourseGrades2;
import main.java.CourseGrades3;
import main.java.CourseGrades4;
import main.java.CourseGrades5;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



import java.lang.reflect.Constructor;

@RunWith(Parameterized.class)
public class GivenBlackbox {
    private Class<Course> classUnderTest;


    @SuppressWarnings("unchecked")
    public GivenBlackbox(Object classUnderTest) {
        this.classUnderTest = (Class<Course>) classUnderTest;
    }

    // Defining all the classes that need to be tested
    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = { 
                 {CourseGrades0.class},
                 {CourseGrades1.class},
                 {CourseGrades2.class},
                 {CourseGrades3.class},
                 {CourseGrades4.class},
                 {CourseGrades5.class}
        };
        return Arrays.asList(classes);
    }

    // method to call the correct constructor
    private Course createCourse(String name) throws Exception {
        Constructor<Course> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }


    // A sample course
    Course singleStudent;
    HashMap<String, Integer> singleStudentExpected = new HashMap<String, Integer>();

    Course twoStudent;
    HashMap<String, Integer> twoStudentExpected = new HashMap<String, Integer>(); 

    Course noStudent;

    Course manyStudent;
    HashMap<String, Integer> manyStudentExpected = new HashMap<String, Integer>();

    Course astudent;
    HashMap<String, Integer> astudentExpected = new HashMap<String, Integer>();

    Course bstudent;
    HashMap<String, Integer> bstudentExpected = new HashMap<String, Integer>();

    Course cstudent;
    HashMap<String, Integer> cstudentExpected = new HashMap<String, Integer>();

    Course dstudent;
    HashMap<String, Integer> dstudentExpected = new HashMap<String, Integer>();

    Course fstudent;
    HashMap<String, Integer> fstudentExpected = new HashMap<String, Integer>();

    Course oneOfEachStudent;
    HashMap<String, Integer> oneOfEachStudentExpected = new HashMap<String, Integer>();

    Course highValues;
    HashMap<String, Integer> highValuesExpected = new HashMap<String, Integer>();

    Course zeroValues;
    HashMap<String, Integer> zeroValuesExpected = new HashMap<String, Integer>();

    Course negativeValues;
    HashMap<String, Integer> negativeValuesExpected = new HashMap<String, Integer>();

    @Before
    public void setUp() throws Exception {

        // all courses should be created like this
        //Course NoStudents
        noStudent = createCourse("SER334");

        //course with a single student
        singleStudent = createCourse("SER800");
        singleStudent.set_points("Bob",50);
        //expected output
        singleStudentExpected.put("A", 1);
        singleStudentExpected.put("B", 0);
        singleStudentExpected.put("C", 0);
        singleStudentExpected.put("D", 0);
        singleStudentExpected.put("F", 0);

        // Course created with two Students having
        twoStudent = createCourse("SER315");
        twoStudent.set_points("Hanna",100);
        twoStudent.set_points("Karla",100);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        twoStudentExpected.put("A", 2);
        twoStudentExpected.put("B", 0);
        twoStudentExpected.put("C", 0);
        twoStudentExpected.put("D", 0);
        twoStudentExpected.put("F", 0);

        // Course created with many Students
        manyStudent = createCourse("SER316");
        manyStudent.set_points("Hanna",100);
        manyStudent.set_points("Karla",81);
        manyStudent.set_points("Hanna2",80);
        manyStudent.set_points("Karla2",66);
        manyStudent.set_points("Hanna3",65);
        manyStudent.set_points("Karla3",51);
        manyStudent.set_points("Hanna4",50);
        manyStudent.set_points("Karla4",36);
        manyStudent.set_points("Hanna5",35);
        manyStudent.set_points("Karla5",1);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        manyStudentExpected.put("A", 2);
        manyStudentExpected.put("B", 2);
        manyStudentExpected.put("C", 2);
        manyStudentExpected.put("D", 2);
        manyStudentExpected.put("F", 2);

        //course with only A's
        astudent = createCourse("SER100");
        astudent.set_points("Alice",100);
        //expected output
        astudentExpected.put("A", 1);
        astudentExpected.put("B", 0);
        astudentExpected.put("C", 0);
        astudentExpected.put("D", 0);
        astudentExpected.put("F", 0);

        //course with only B's
        bstudent = createCourse("SER165");
        bstudent.set_points("Alice",100);//to set max points
        bstudent.set_points("Barry",66);
        //expected output
        bstudentExpected.put("A", 1);
        bstudentExpected.put("B", 1);
        bstudentExpected.put("C", 0);
        bstudentExpected.put("D", 0);
        bstudentExpected.put("F", 0);

        //course with only C's
        cstudent = createCourse("SER150");
        cstudent.set_points("Alice",100);//to set max points
        cstudent.set_points("Charlie",51);
        //expected output
        cstudentExpected.put("A", 1);
        cstudentExpected.put("B", 0);
        cstudentExpected.put("C", 1);
        cstudentExpected.put("D", 0);
        cstudentExpected.put("F", 0);

        //course with only D's
        dstudent = createCourse("SER135");
        dstudent.set_points("Alice",100);//to set max points
        dstudent.set_points("Denise",36);
        //expected output
        dstudentExpected.put("A", 1);
        dstudentExpected.put("B", 0);
        dstudentExpected.put("C", 0);
        dstudentExpected.put("D", 1);
        dstudentExpected.put("F", 0);

        //course with only F's
        fstudent = createCourse("SER115");
        fstudent.set_points("Alice",100);//to set max points
        fstudent.set_points("Frank",15);
        //expected output
        fstudentExpected.put("A", 1);
        fstudentExpected.put("B", 0);
        fstudentExpected.put("C", 0);
        fstudentExpected.put("D", 0);
        fstudentExpected.put("F", 1);

        //course with all letter grades
        oneOfEachStudent = createCourse("SER222");
        oneOfEachStudent.set_points("Abby",100);
        oneOfEachStudent.set_points("Bob",66);
        oneOfEachStudent.set_points("Craig",51);
        oneOfEachStudent.set_points("Devon",36);
        oneOfEachStudent.set_points("Flagerty",34);
        //expected output
        oneOfEachStudentExpected.put("A", 1);
        oneOfEachStudentExpected.put("B", 1);
        oneOfEachStudentExpected.put("C", 1);
        oneOfEachStudentExpected.put("D", 1);
        oneOfEachStudentExpected.put("F", 1);

        //course with grade > 100
        highValues = createCourse("SER111");
        highValues.set_points("Hero",101);
        //expected output
        highValuesExpected.put("A", 1);
        highValuesExpected.put("B", 0);
        highValuesExpected.put("C", 0);
        highValuesExpected.put("D", 0);
        highValuesExpected.put("F", 0);

        //course with a zero grade value
        zeroValues = createCourse("SER001");
        zeroValues.set_points("Abby",100);
        zeroValues.set_points("Zed",0);
        //expected output
        zeroValuesExpected.put("A", 1);
        zeroValuesExpected.put("B", 0);
        zeroValuesExpected.put("C", 0);
        zeroValuesExpected.put("D", 0);
        zeroValuesExpected.put("F", 1);

        //course with a negative grade value
        negativeValues = createCourse("SER010");
        negativeValues.set_points("Abby",100);
        negativeValues.set_points("Zed",-10);
        //expected output
        negativeValuesExpected.put("A", 1);
        negativeValuesExpected.put("B", 0);
        negativeValuesExpected.put("C", 0);
        negativeValuesExpected.put("D", 0);
        negativeValuesExpected.put("F", 1);


    }
    @Rule
    public final ExpectedException exc = ExpectedException.none();

    @Test
    public void twoStudent() {
        System.out.println("Two Student Test");
        HashMap<String, Integer> ans = twoStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(twoStudentExpected));
    }

    @Test
    public void singleStudent() {
        System.out.println("single Student Test");
        HashMap<String, Integer> ans = singleStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(singleStudentExpected));
    }

    @Test
    public void noStudent() {
        System.out.println("No Student Test");
        exc.expect(NullPointerException.class);
        HashMap<String, Integer> ans = noStudent.countOccurencesLetterGrades();
        System.out.println(ans);
    }

    @Test 
    public void manyStudent() {
        System.out.println("Many Student Test");
        HashMap<String, Integer> ans = manyStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(manyStudentExpected));
    }


    @Test 
    public void astudent() {
        System.out.println("A Student Test");
        HashMap<String, Integer> ans = astudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(astudentExpected));
    }


    @Test 
    public void bstudent() {
        System.out.println("B Student Test");
        HashMap<String, Integer> ans = bstudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(bstudentExpected));
    }


    @Test 
    public void cstudent() {
        System.out.println("C Student Test");
        HashMap<String, Integer> ans = cstudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(cstudentExpected));
    }


    @Test 
    public void dstudent() {
        System.out.println("D Student Test");
        HashMap<String, Integer> ans = dstudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(dstudentExpected));
    }


    @Test 
    public void fstudent() {
        System.out.println("F Student Test");
        HashMap<String, Integer> ans = fstudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(fstudentExpected));
    }


    @Test 
    public void oneOfEachStudent() {
        System.out.println("One Of Each Student Test");
        HashMap<String, Integer> ans = oneOfEachStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(oneOfEachStudentExpected));
    }


    @Test 
    public void highValues() {
        System.out.println("High Value Test");
        HashMap<String, Integer> ans = highValues.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(highValuesExpected));
    }


    @Test 
    public void zeroValues() {
        System.out.println("Zero Value Test");
        HashMap<String, Integer> ans = zeroValues.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(zeroValuesExpected));
    }

    @Test 
    public void negativeValues() {
        System.out.println("Negative Value Test");
        HashMap<String, Integer> ans = negativeValues.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(negativeValuesExpected));
    }


}
