import model.Employee;
import model.StoredEmployee;

public class LinearProbingHashTable {

    // This class is SimpleHashTable class but add Linear Probing to handle collision when adding data to array
    // (i.e. adding Smith(length:5) then add Brown(length:5). If hashTable has the same length when adding these two, the hashedKey will be the same (collision)
    // Therefore, Probing is one of way to avoid collision of hash table.

    private StoredEmployee[] hashtable;

    public LinearProbingHashTable() {
        hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("Sorry, table is full");
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee removedEmployee = hashtable[hashedKey].getEmployee();
        hashtable[hashedKey] = null;

        // If we have no code down here, hash table will have a problem.
        // For example, we have key A,B,C at position 0-2 (equal length) because Linear probing we shift hashedKey with same length to next position.
        // But if we delete key B, then how we can access to key C. (A -> null -> C)
        // Therefore, we use rehashing for solve the problem.

        StoredEmployee[] oldHashTable = hashtable;
        hashtable = new StoredEmployee[oldHashTable.length];
        for (StoredEmployee storedEmployee : oldHashTable) {
            if (storedEmployee != null) {
                put(storedEmployee.getKey(), storedEmployee.getEmployee());
            }
        }
        return removedEmployee;
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].getEmployee();
    }

    public void printHashTable() {
        for (StoredEmployee storedEmployee : hashtable) {
            if (storedEmployee != null) {
                System.out.println(storedEmployee.getEmployee());
            } else {
                System.out.println("empty");
            }
        }
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length; // hash function (example)
    }

    private boolean occupied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        // In the second condition may be confused. It checks that hashedKey after shifting is not null.
        // If it's null, it means there's no key in the table because linear probing always shifts hashedKey to next available space.
        while (hashedKey != stopIndex && occupied(hashedKey) && !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (occupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }
        return -1;
    }
}
