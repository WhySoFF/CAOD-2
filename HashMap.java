public class HashMap {

    List[] arrayLists;

    HashMap(int size) {
        arrayLists = new List[(size % 20)+1];
        for(int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new List();
        }
    }

    int hashFunction(int key) {
        return key % arrayLists.length;
    }

    void push(int key, String data) {
        arrayLists[hashFunction(key)].addNode(key, data);
    }

    void delete(int key) {
        arrayLists[hashFunction(key)].delete(key);
    }

    String show(int key) {
        return arrayLists[hashFunction(key)].showNode(key);
    }
}