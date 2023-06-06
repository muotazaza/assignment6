package assigment;

import java.util.ArrayList;
import java.util.LinkedList;


public class HashMap<K,V> {
    private ArrayList<LinkedList<KeyValuePair< K ,V>>> container;
    private int limit;
    private int size;

    public int size(){
        return size;
    }
    public HashMap(int limit) {
        this.limit = limit;
        this.size=0;
        this.container=new ArrayList<>(limit);

        for (int i=0; i<limit;i++){
            container.add(new LinkedList<>());
        }
    }
    public int getIndex(K key  ){
       int hashcode=key.hashCode();
       return Math.abs(hashcode % limit);
    }
    public void put(K key ,V value){
        int index=getIndex(key);
        LinkedList<KeyValuePair<K ,V>> containers= container.get(index);
        for (KeyValuePair<K,V>pair :containers){
            if (pair.key.equals(key)){
                pair.value=value;
                return;
            }

        }
        containers.add(new KeyValuePair<>(key,value));
        size++;
    }

    public V get(K key){
       int index=getIndex(key);
       LinkedList<KeyValuePair<K,V>> containers =container.get(index);
       for (KeyValuePair<K,V> pair :containers){
           if (pair.getKey().equals(key)){
               return pair.getValue();
           }

       }


        return null;
    }
    public void remove(K key){
        int index=getIndex(key);
        LinkedList<KeyValuePair<K ,V>> containers =container.get(index);
        for (KeyValuePair<K,V> pair:containers){
            if (pair.getKey().equals(key)){
                containers.remove(pair);
                size--;
                return;
            }
        }
    }
    public class KeyValuePair<K,V>{

        private  K key ;
        private  V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}


