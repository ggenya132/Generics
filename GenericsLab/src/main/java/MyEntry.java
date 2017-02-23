/**
 * Created by eugenevendensky on 2/23/17.
 */
public class MyEntry<K,V> {

        private final  K key;
        private  V  value;

        public MyEntry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public V getValue(){
            return this.value;
        }

    public K getKey() {
        return key;
    }
    public void setValue(V value){
            this.value = value;
    }
}
