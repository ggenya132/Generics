import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugenevendensky on 2/22/17.
 */
public class MySetTest {

    MySet<String> mySet;

    @Before
    public void setUp(){

        mySet = new MySet<>(new String[]{"To", "be", "added"});
    }



    @Test
    public void getTest() {

       String actual = mySet.get(0);
        String expected = "To";
        assertEquals("I expect the method to return the elemet of the index requested", expected, actual);
    }

    @Test
    public void rejectionOfDuplicatesTest(){

        mySet.add("Duplicate");
        mySet.add("Not a dupliate");

        boolean actual = mySet.add("Duplicate");
        boolean expected = false;
        assertEquals("I expect the method to reject all duplicates by returning a false boolean", expected, actual);


    }
}
