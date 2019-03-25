package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.Course;
import main.java.CourseGrades1;
import main.java.CourseGrades2;
import main.java.CourseGrades5;
import main.java.CourseGrades4;
import main.java.CourseGrades0;
import main.java.CourseGrades3;

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
               // {CourseGrades0.class},
               // {CourseGrades1.class},
               // {CourseGrades2.class},
                //{CourseGrades3.class},
                {CourseGrades4.class}//,
                //{CourseGrades5.class}
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
    
    Course a_Student;
    HashMap<String, Integer> a_StudentExpected = new HashMap<String, Integer>();
    
    Course b_Student;
    HashMap<String, Integer> b_StudentExpected = new HashMap<String, Integer>();
    
    Course c_Student;
    HashMap<String, Integer> c_StudentExpected = new HashMap<String, Integer>();
    
    Course d_Student;
    HashMap<String, Integer> d_StudentExpected = new HashMap<String, Integer>();
    
    Course f_Student;
    HashMap<String, Integer> f_StudentExpected = new HashMap<String, Integer>();
    
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
       a_Student = createCourse("SER100");
       a_Student.set_points("Alice",100);
       //expected output
       a_StudentExpected.put("A", 1);
       a_StudentExpected.put("B", 0);
       a_StudentExpected.put("C", 0);
       a_StudentExpected.put("D", 0);
       a_StudentExpected.put("F", 0);
       
       //course with only B's
       b_Student = createCourse("SER165");
       b_Student.set_points("Alice",100);//to set max points
       b_Student.set_points("Barry",66);
       //expected output
       b_StudentExpected.put("A", 1);
       b_StudentExpected.put("B", 1);
       b_StudentExpected.put("C", 0);
       b_StudentExpected.put("D", 0);
       b_StudentExpected.put("F", 0);
      
       //course with only C's
       c_Student = createCourse("SER150");
       c_Student.set_points("Alice",100);//to set max points
       c_Student.set_points("Charlie",51);
       //expected output
       c_StudentExpected.put("A", 1);
       c_StudentExpected.put("B", 0);
       c_StudentExpected.put("C", 1);
       c_StudentExpected.put("D", 0);
       c_StudentExpected.put("F", 0);
      
       //course with only D's
       d_Student = createCourse("SER135");
       d_Student.set_points("Alice",100);//to set max points
       d_Student.set_points("Denise",36);
       //expected output
       d_StudentExpected.put("A", 1);
       d_StudentExpected.put("B", 0);
       d_StudentExpected.put("C", 0);
       d_StudentExpected.put("D", 1);
       d_StudentExpected.put("F", 0);
    
       //course with only F's
       f_Student = createCourse("SER115");
       f_Student.set_points("Alice",100);//to set max points
       f_Student.set_points("Frank",15);
       //expected output
       f_StudentExpected.put("A", 1);
       f_StudentExpected.put("B", 0);
       f_StudentExpected.put("C", 0);
       f_StudentExpected.put("D", 0);
       f_StudentExpected.put("F", 1);
   
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
    public void manyStudent(){
    	System.out.println("Many Student Test");
        HashMap<String, Integer> ans = manyStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(manyStudentExpected));
    }

    
    @Test 
    public void a_Student(){
    	System.out.println("A Student Test");
        HashMap<String, Integer> ans = a_Student.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(a_StudentExpected));
    }

    
    @Test 
    public void b_Student(){
    	System.out.println("B Student Test");
        HashMap<String, Integer> ans = b_Student.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(b_StudentExpected));
    }

    
    @Test 
    public void c_Student(){
    	System.out.println("C Student Test");
        HashMap<String, Integer> ans = c_Student.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(c_StudentExpected));
    }

    
    @Test 
    public void d_Student(){
    	System.out.println("D Student Test");
        HashMap<String, Integer> ans = d_Student.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(d_StudentExpected));
    }

    
    @Test 
    public void f_Student(){
    	System.out.println("F Student Test");
        HashMap<String, Integer> ans = f_Student.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(f_StudentExpected));
    }

    
    @Test 
    public void oneOfEachStudent(){
    	System.out.println("One Of Each Student Test");
        HashMap<String, Integer> ans = oneOfEachStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(oneOfEachStudentExpected));
    }

    
    @Test 
    public void highValues(){
    	System.out.println("High Value Test");
        HashMap<String, Integer> ans = highValues.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(highValuesExpected));
    }

    
    @Test 
    public void zeroValues(){
    	System.out.println("Zero Value Test");
        HashMap<String, Integer> ans = zeroValues.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(zeroValuesExpected));
    }
    
    @Test 
    public void negativeValues(){
    	System.out.println("Negative Value Test");
        HashMap<String, Integer> ans = negativeValues.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(negativeValuesExpected));
    }


}
