/**
 * Created by eugenevendensky on 2/22/17.
 */
public class Main {

    public static void main(String[] args){

        MyArrayList<String> myArrayList = new MyArrayList<>(3);

        myArrayList.add("derp");
        myArrayList.add("Herp");
        myArrayList.add("Whelp");
        myArrayList.add("Nope");
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(1));
        System.out.println(myArrayList.get(2));
        System.out.println(myArrayList.get(3));


    }
}
