import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugenevendensky on 2/22/17.
 */
public class MyArrayListTest


{


    MyArrayList<Integer> test;
    MyArrayList<String> test2;
    MyArrayList<Integer> test3;
    MyArrayList<String> test4;

    @Before
    public void setUp() {
        test2 = new MyArrayList<>(new String[]{"Test", "Contains"});
        test = new MyArrayList<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        test3 = new MyArrayList<>();
        test4 = new MyArrayList<>(new String[]{"To", "be", "added"});
    }

    @Test
    public void addTestWithSingleArguement() {
        boolean actual = test.add(6);
        boolean expected = true;
        assertEquals("I expect the method to return true that the element requested to be added is in fact the element that was added", actual, expected);

    }

    @Test
    public void getTest() {
        test.add(6);
        Integer actual = test.get(5);
        Integer expected = 6;
        assertEquals("I expect the method to return the elemet of the index requested", expected, actual);
    }


    @Test
    public void isEmptyTestWithElements() {
        boolean actual = test.isEmpty();
        boolean expected = false;
        assertEquals("I expect the boolean to return true if the list is empty and false if it is not", expected, actual);
    }

    @Test
    public void isEmptyTestWithoutElements() {

        MyArrayList<String> test2 = new MyArrayList<>(new String[]{}); //using strings for variety in test cases.
        boolean actual = test2.isEmpty();
        boolean expected = true;
        assertEquals("I expect the boolean to return true if the list is empty and false if it is not", expected, actual);
    }

    @Test
    public void containsTest() {

        boolean actual = test2.contain("Contains");
        boolean expected = true;
        assertEquals("I expect the test to return true if the element specified is a member element of the array", expected, actual);

    }

    @Test
    public void removeTest() {
        test.remove(3);
        int actual = test.get(3);
        int expected = 5;  //everything shifted to the left of the element removed.
        assertEquals("I expect the text to remove the appropriate element ", expected, actual);
    }

    @Test
    public void removeTestFirstElement() {
        test.remove(0);
        int actual = test.get(0);
        int expected = 2;  //Entire Array shifts left.
        assertEquals("I expect the text to remove the appropriate element ", expected, actual);
    }

    @Test
    public void removeTestLastElement() {
        test.remove(9);
        int actual = test.get(8);
        int expected = 9;  //Array stays the same except the very last element.
        assertEquals("I expect the text to remove the appropriate element ", expected, actual);
    }

    @Test
    public void setTest() {

        Integer actual = test.set(9, 11);
        Integer expected = test.get(9);
        assertEquals("I expect the test to properly set the given element in the requested index", expected, actual);
    }

    @Test
    public void setTestIfElementIsOutOfBounds() {
        Integer actual = test.set(10, 11);
        Integer expected = test.get(10);
        assertEquals("I expect the test to properly set the given element in the requested index", expected, actual);

    }

    @Test
    public void clearTest() {
        test.clear();
        Integer actual = test.get(0);
        Integer expected = null;
        assertEquals("I expect the method to set every element to null", expected, actual);

    }

    @Test
    public void addOverrideTest() {

        boolean actual = test.add(223, 0);
        boolean expected = true;
        assertEquals("I expect the boolean to show that the element to be added is in the position requested", expected, actual);
    }

    @Test
    public void addOverrideTestWithStrings() {

        boolean actual = test2.add("Another test", 0);
        boolean expected = true;
        assertEquals("I expect the boolean to show that the element to be added is in the position requested", expected, actual);
    }

    @Test
    public void defaultConstructorTest() {
        int actual = test3.size();
        int expected = 10;
        assertEquals("I expect the default constructor to build a generic Integer[] with ten space", expected, actual);
    }

    @Test
    public void resizeTest() {
        test3.add(1);
        test3.add(2);
        test3.add(3);
        test3.add(5);
        test3.resize();
        int actual = test3.size();
        int expected = 4;
        assertEquals("I expect myArrayList to resize dynamically, and leave just three elements because they are not null", expected, actual);
    }
    @Test
    public void addArrayToArrayTest(){
        test2.add(test4.getMyArrayList());
        boolean actual = test2.contain("added");
        boolean expected = true;
        assertEquals("I expect the boolean will return true showing the method sucesfully added the entire array", expected, actual);

    }

}
