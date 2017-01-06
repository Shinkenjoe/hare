package ch06;

import java.util.ArrayList;

/*3. Implement a class Table<K, V> that manages an array list of
  Entry<K, V> elements. Supply methods to get the value associated
  with a key, to put a value for a key, and to remove a key.*/

public class Table<K, V>{
    private ArrayList<Entry<K, V>> daList;

    
    private static class Entry<K, V>{
	private K key;
	private V value;
	
	Entry(K key, V value){
	    this.key = key;
	    this.value = value;
	}
	
	public V getValue(){	return this.value;    }
	
	public K getKey(){	return this.key;    }
	
	public void set(V value){this.value = value;}
    }

    
    public Table(){
	this.daList = new ArrayList<Entry<K, V>>();
    }

    public  V get(K key){
	V result = null;
	for(Entry<K, V> e : this.daList){
	    if (e.getKey().equals(key))
		result = e.getValue();
	}
	return result;
    }

    public void set(K key, V value){
	boolean notThere = true;
	for(Entry<K, V> e : this.daList){
	    if (e.getKey().equals(key)){
		e.set(value);
		notThere = false;
	    }
	}
	if (notThere)
	    this.daList.add(new Entry<K, V>(key, value));
    }

    public void remove(K key){
	K toRemove = null;
	for(Entry<K, V> e : this.daList){
	    if (e.getKey().equals(key))
		toRemove = e.getKey();
	    this.daList.remove(toRemove);
	}
    }
}
    
