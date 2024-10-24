//Sahej Chawla
//CS2210A

import java.util.LinkedList;

public class HashDictionary implements DictionaryADT {
    private LinkedList<Data>[] hashTable;
    private int tableSize;
    private int numRecords;

    @SuppressWarnings("unchecked")
    public HashDictionary(int size) {
        tableSize = size * 5; // Significantly increase the table size
        hashTable = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new LinkedList<Data>();
        }
        numRecords = 0;
    }

    private int hashFunction(String key) {
        long hash = 0xcbf29ce484222325L;
        long fnvPrime = 0x100000001b3L;

        for (int i = 0; i < key.length(); i++) {
            hash ^= key.charAt(i);
            hash *= fnvPrime;
        }

        return (int) (Math.abs(hash) % tableSize);
    }

    @Override
    public int put(Data record) throws DictionaryException {
        int hashKey = hashFunction(record.getConfiguration());
        LinkedList<Data> bucket = hashTable[hashKey];

        for (Data data : bucket) {
            if (data.getConfiguration().equals(record.getConfiguration())) {
                throw new DictionaryException();
            }
        }

        boolean isCollision = !bucket.isEmpty();
        bucket.add(record);
        numRecords++;

        return isCollision ? 1 : 0;
    }

    @Override
    public void remove(String config) throws DictionaryException {
        int hashKey = hashFunction(config);
        LinkedList<Data> bucket = hashTable[hashKey];

        for (Data data : bucket) {
            if (data.getConfiguration().equals(config)) {
                bucket.remove(data);
                numRecords--;
                return;
            }
        }
        throw new DictionaryException();
    }

    @Override
    public int get(String config) {
        int hashKey = hashFunction(config);
        LinkedList<Data> bucket = hashTable[hashKey];

        for (Data data : bucket) {
            if (data.getConfiguration().equals(config)) {
                return data.getScore();
            }
        }
        return -1;
    }

    @Override
    public int numRecords() {
        return numRecords;
    }
}