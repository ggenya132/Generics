import java.util.Arrays;

/**
 * Created by eugenevendensky on 2/22/17.
 */
public class MyMap<K, V> {

    private int size;
    private int defaultCapacity = 16;
    //@SuppressWarnings("unchecked")
    private MyEntry<K, V>[] values = new MyEntry[defaultCapacity];  //what is an unchecked assignment?


    public void put(K key, V value){
        boolean insert = true;
        for(int i = 0; i < size; i++ ){
            if(values[i].getKey().equals(key)){
                values[i].setValue(value);
                insert = false;
            }


        }

        if(insert){
            ensureCapacity();
            values[size++] = new MyEntry<>(key, value);
        }

    }



    public V get(K key){
        for(int i = 0; i < size; i++){

            if(values[i]!=null){
                if (values[i].getKey().equals(key)){
                    return values[i].getValue();
                }
            }

        }
        return null;
    }
    public void ensureCapacity(){

        if(values.length==size){

            int newSize =  values.length * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    public int size(){
        return  values.length;
    }


    public void remove(K key){
        for(int i  = 0; i < size; i++){
            if(values[i].getKey().equals(key)){
                values[i] = null;
                size--;
                condenseArray(i); // helper method shifts everything left of space removed;
            }
        }

    }
    private void condenseArray(int start){

        for(int i = start; i < size; i++){
            values[i] = values[i+1];

        }
    }
}

  //  public MyMap(){
//
//        myEntry =  (MyEntry[]) new Object[10];
//    }
//
//    public V put(K k, V v){
//
//     MyEntry newMyEntry = new MyEntry(k, v);
//
//     if(myEntry[0]!=null){
//
//         myEntry[myEntry.length+1] = newMyEntry;
//     }
//
//     this.myEntry[0] = newMyEntry;
//     return myEntry[0].getV();
//    }
