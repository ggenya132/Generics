import java.util.Arrays;
import java.util.Objects;

/**
 * Created by eugenevendensky on 2/22/17.
 */
public class MySet<T> {

    private T[] mySet;

    public MySet(T[] t) {

        mySet = t;
    }

    public MySet(){

        mySet = (T[]) new Objects[10];
    }


    public void resize(){
        for(int i = mySet.length -1; i >= 0; i--){
            if(mySet[i]==null){

                remove(i);
            }
        }
    }

    public void remove(int elementToBeRemoved){

        T[] left = Arrays.copyOfRange(mySet,0, elementToBeRemoved );
//        for(T t : left){
//
//            System.out.println(t);  //bad debugging
//        }
        T[] right = Arrays.copyOfRange(mySet,elementToBeRemoved+1, mySet.length);
//        for(T z : right){
//
//            System.out.println(z);  //bad debugging
//        }
        int length = left.length + right.length;
        T[] newArray = Arrays.copyOf(left, length);
        System.arraycopy(right, 0, newArray, left.length, right.length );
//        for(T x: newArray){
//
//            System.out.println(x);  //this debugging was performed to understanad the behavior of copyOf.
//        }
        mySet = newArray;
    } //I know this method is very hacky.

    public T set(int indexToReplaced, T elementToBeSet){
        if(indexToReplaced>mySet.length -1){
            this.add(elementToBeSet);
            return mySet[mySet.length-1];
        }

        mySet[indexToReplaced] = elementToBeSet;

        return mySet[indexToReplaced];
    }


    public boolean add(T elementToBeAdded) {

        if(contain(elementToBeAdded)){

            return false;
        }





        if(this.contain(null)) {
            for (int i = 0; i < mySet.length; i++) {
                if (mySet[i] == null) {
                    mySet[i] = elementToBeAdded;
                    resize();
                    return mySet[i] == elementToBeAdded;
                }
            }
        }

        int length = mySet.length;
        mySet = Arrays.copyOf(mySet, length + 1);
        mySet[this.size() - 1] = elementToBeAdded;
        resize();
        return elementToBeAdded == mySet[this.size()-1];
    }


    public boolean contain(T elementToBeCheckFor) {
        boolean contains = false;
        for (T elementBeingChecked : mySet) {
            if (elementBeingChecked == elementToBeCheckFor) {
                return true;
            }
        }
        return contains;   //probably a better way to optimize this.
    }


    public int size(){

        return mySet.length;
    }


    public T get(int index) {
        return mySet[index];
    }

}
