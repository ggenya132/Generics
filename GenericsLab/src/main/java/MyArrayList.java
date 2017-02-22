import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by eugenevendensky on 2/22/17.
 */
public class MyArrayList<T>  {



    private T[] myArrayList;


    public  MyArrayList(int t){

        myArrayList = (T[]) new Object[t];
    }

    public  MyArrayList(){

        myArrayList =  (T[]) new Object[10];
    }


    public MyArrayList(T[] t) {

        myArrayList = t;
    }

  //  public T next(){} -- I might implement iterable;


    public boolean add(T elementToBeAdded) {

        if(this.contain(null)) {
            for (int i = 0; i < myArrayList.length; i++) {
                if (myArrayList[i] == null) {
                    myArrayList[i] = elementToBeAdded;
                    resize();
                    return myArrayList[i] == elementToBeAdded;
                }
            }
        }

        int length = myArrayList.length;
        myArrayList = Arrays.copyOf(myArrayList, length + 1);
        myArrayList[this.size() - 1] = elementToBeAdded;
        resize();
        return elementToBeAdded == myArrayList[this.size()-1];
    }
    public boolean add(T elementToBeAdded, int indexToPutElementInto){
        T[] left = Arrays.copyOfRange(myArrayList,0, indexToPutElementInto );

        T[] right = Arrays.copyOfRange(myArrayList,indexToPutElementInto, myArrayList.length);

        int length = left.length + right.length;

        T[] newArray = Arrays.copyOf(left, length+1);


        System.arraycopy(right, 0, newArray, left.length, right.length );



        newArray[indexToPutElementInto] = elementToBeAdded;

        for(int i = 0; i < indexToPutElementInto; i++){

            newArray[i] = left[i];
        }

        for (int z = indexToPutElementInto+1, x = 0; z < newArray.length; z++, x++ ){

            newArray[z] = right[x];
        }

        for (T t : newArray){

            System.out.println(t);
        }



        myArrayList = newArray;
        return  myArrayList[indexToPutElementInto] == elementToBeAdded;
    } //Wow, such refactor needed.
    public void add(T[] arrayToBeAdded){

        for(T t: arrayToBeAdded){
            add(t);
        }
    }

    public void resize(){
        for(int i = myArrayList.length -1; i >= 0; i--){
            if(myArrayList[i]==null){

                remove(i);
            }
        }
        }

    public T get(int index) {
        return myArrayList[index];
    }
    public T[]getMyArrayList(){
        return myArrayList;
    }

    public boolean isEmpty() {
        return this.myArrayList.length == 0;
    }

    public boolean contain(T elementToBeCheckFor) {
        boolean contains = false;
        for (T elementBeingChecked : myArrayList) {
            if (elementBeingChecked == elementToBeCheckFor) {
                return true;
            }
        }
        return contains;   //probably a better way to optimize this.
    }

    public void remove(int elementToBeRemoved){

        T[] left = Arrays.copyOfRange(myArrayList,0, elementToBeRemoved );
//        for(T t : left){
//
//            System.out.println(t);  //bad debugging
//        }
        T[] right = Arrays.copyOfRange(myArrayList,elementToBeRemoved+1, myArrayList.length);
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
        myArrayList = newArray;
    } //I know this method is very hacky.

    public T set(int indexToReplaced, T elementToBeSet){
        if(indexToReplaced>myArrayList.length -1){
            this.add(elementToBeSet);
            return myArrayList[myArrayList.length-1];
        }

        myArrayList[indexToReplaced] = elementToBeSet;

        return myArrayList[indexToReplaced];
    }

    public  void clear(){
        int i = 0;
        for(T t: myArrayList){
            this.set(i, null);
            i++;
        }
    }

    public int size(){

        return myArrayList.length;
    }

}
