import model.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    // Hash Tables is an abstract data type. It's good for retrieval O(1).
    // It's Key-Value data type (similar to Dictionaries, Map, etc.) -- Provide access to value using keys
    // Key can be any data type because it'll be hashed to integer before store.
    // Key (Any) -> Hashing -> HashedKey (Integer) -> Access

    // Load Factor tells how full a hash table is (i.e. 0.5 is half).
    // Load Factor uses to decide when to resize the array (if backing with array)
    // If using crappy hash function or load factor is high, when adding it'll make a lots of collision and obviously time complexity of retrieval might not achieve constant time.

    public static void main(String[] args) {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee marySmith = new Employee("Mary", "Smith", 2);
        Employee georgeBrown = new Employee("George", "Brown", 3);
        Employee nathanWilliams = new Employee("Nathan", "Williams", 4);

        // Hash tables backing by array
        SimpleHashTable simpleHashTable = new SimpleHashTable();
        System.out.println("Put 3 employees");
        simpleHashTable.put("Doe", johnDoe);
        simpleHashTable.put("Smith", marySmith);
        simpleHashTable.put("Brown", georgeBrown); // This one can't add to hashTable because our homemade hashFunction (key have same length)
        simpleHashTable.printHashTable();
        System.out.println("Retrieve key \"Smith\": " + simpleHashTable.get("Smith"));
        System.out.println("Retrieve key \"Brown\": " + simpleHashTable.get("Brown") + " (collision)");

        // SimpleHashTable with Linear Probing
        LinearProbingHashTable linearProbingHashTable = new LinearProbingHashTable();
        System.out.println("\nPut 3 employees");
        linearProbingHashTable.put("Doe", johnDoe);
        linearProbingHashTable.put("Smith", marySmith);
        linearProbingHashTable.put("Brown", georgeBrown);
        linearProbingHashTable.put("Wills", nathanWilliams);
        linearProbingHashTable.printHashTable();
        System.out.println("Retrieve key \"Brown\": " + linearProbingHashTable.get("Brown"));
        System.out.println("Retrieve key \"Wills\": " + linearProbingHashTable.get("Wills"));
        System.out.println("Remove employee (key=\"Brown\"): " + linearProbingHashTable.remove("Brown")); // Check remove method for a bug
        System.out.println("Retrieve key \"Brown\": " + linearProbingHashTable.get("Brown"));
        System.out.println("Retrieve key \"Wills\": " + linearProbingHashTable.get("Wills"));

        // Hash tables implements chaining (Array of linkedList)
        ChainedHashTable chainedHashTable = new ChainedHashTable();
        System.out.println("\nPut 3 employees");
        chainedHashTable.put("Doe", johnDoe);
        chainedHashTable.put("Smith", marySmith);
        chainedHashTable.put("Brown", georgeBrown);
        chainedHashTable.printHashTable();
        System.out.println("Retrieve key \"Smith\": " + chainedHashTable.get("Smith"));
        System.out.println("Removed employee: " + chainedHashTable.remove("Doe"));
        System.out.println("Removed employee: " + chainedHashTable.remove("Smith"));
        chainedHashTable.printHashTable();

        // JDK's hashMap (backing by array)
        // In JDK, hashMap != hashtable (hashtable contains no null)
        Map<String, Employee> jdkHashTable = new HashMap<>();
        System.out.println("\nPut 3 employees");
        jdkHashTable.put("Doe", johnDoe);
        jdkHashTable.put("Smith", marySmith);
        jdkHashTable.put("Brown", georgeBrown);
//        Iterator<Employee> iterator = jdkHashTable.values().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        jdkHashTable.forEach((k,v) -> System.out.println("Key = " + k + ", Employee = " + v));
        System.out.println("Is Doe(key) in the hashMap: " + jdkHashTable.containsKey("Doe"));
        System.out.println("Is John Doe(value) in the hashMap: " + jdkHashTable.containsValue(johnDoe));
        System.out.println("\nPut 1 employees (replace)");
        jdkHashTable.put("Doe", nathanWilliams); // replace
        jdkHashTable.forEach((k,v) -> System.out.println("Key = " + k + ", Employee = " + v));
        System.out.println("Is Doe(key) in the hashMap: " + jdkHashTable.containsKey("Doe"));
        System.out.println("Is John Doe(value) in the hashMap: " + jdkHashTable.containsValue(johnDoe));
        System.out.println("\nPut 1 employees (put if the key is absent)");
        jdkHashTable.putIfAbsent("Doe", johnDoe); // not replace
        jdkHashTable.forEach((k,v) -> System.out.println("Key = " + k + ", Employee = " + v));
        System.out.println("Is Doe(key) in the hashMap: " + jdkHashTable.containsKey("Doe"));
        System.out.println("Is Nathan Williams(value) in the hashMap: " + jdkHashTable.containsValue(nathanWilliams));
        System.out.println("Retrieve key \"Someone\": " + jdkHashTable.get("Someone"));
        System.out.println("Retrieve key \"Someone\" and default is George Brown : " + jdkHashTable.getOrDefault("Someone", georgeBrown));
        System.out.println("Removed employee: " + jdkHashTable.remove("Doe"));
    }
}
