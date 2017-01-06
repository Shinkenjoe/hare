package ch06;

/*3. Implement a class Table<K, V> that manages an array list of
  Entry<K, V> elements. Supply methods to get the value associated
  with a key, to put a value for a key, and to remove a key.*/

public class Entry<K, V>{
    private K key;
    private V value;

    public Entry(K key, V value){
	this.key = key;
	this.value = value;
    }

    public V getValue(){	return this.value;    }

    public K getKey(){	return this.key;    }

    public void set(V value){this.value = value;}
}
