/*
Pseudo-code:
HashTable():
  create an array A of size n
  for each key-value pair (k, v):
    i = hash(k)
    A[i] = v

Insert(k, v):
  i = hash(k)
  A[i] = v

Search(k):
  i = hash(k)
  return A[i]

*/

//Code:
package Hash_Table;

import java.util.*;

class HashTable {
    private int SIZE = 20;
    private LinkedList[] table;

    HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++)
            table[i] = new LinkedList();
    }

    public void put(Object key, Object value) {
        int hashCode = key.hashCode() % SIZE;
        LinkedList list = table[hashCode];
        list.add(new Entry(key, value));
    }

    public Object get(Object key) {
        int hashCode = key.hashCode() % SIZE;
        LinkedList list = table[hashCode];
        for (Object obj : list) {
            Entry entry = (Entry) obj;
            if (entry.key.equals(key))
                return entry.value;
        }
        return null;
    }

    class Entry {
        Object key, value;

        Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class Hashtable1 {
    public static void main(String[] args) {
        // input
        HashTable ht = new HashTable();
        ht.put("key1", "value1");
        ht.put("key2", "value2");
        ht.put("key3", "value3");

        // output
        System.out.println(ht.get("key1"));
        System.out.println(ht.get("key2"));
        System.out.println(ht.get("key3"));

    }
}
