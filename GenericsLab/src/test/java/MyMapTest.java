import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugenevendensky on 2/22/17.
 */
public class MyMapTest {


    MyMap<String, Integer> myMap;
    @Before
    public void setUp(){ myMap = new MyMap<>();}

    @Test
    public void putTest(){

        myMap.put("Key", 1);
        Integer actual = myMap.get("Key");
        Integer expected = 1;
        assertEquals("I expect the integer to return the value of new MyEntry object I inserted with put", expected, actual);

    }
    @Test
    public void putTestWithKeyAlreadyCreated(){

        myMap.put("Key", 1);
        myMap.put("Key", 2);

        Integer expected = 2;
        Integer actual = myMap.get("Key");
        assertEquals("I expect the method to detect the key already exists and call the set method instead of creating a new MyEntry object", expected, actual);


    }

    @Test
    public void ensureCapacityTest(){
        myMap.put("Key", 1);
        myMap.put("Key2", 2);
        myMap.put("Key 3", 3);

        Integer actual = myMap.size();
        Integer expected = 4;
        assertEquals("I expect ensureCapacity() to double the size of values when it reaches capacity", expected, actual);
    }


}
