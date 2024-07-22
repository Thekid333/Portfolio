import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private ArrayList<List<String>> table;
    private int numBuckets;
    private int numElements;
    private String hashFunction;

    public HashTable(int numBuckets, String hashFunction){
        this.numElements = 0;
        this.numBuckets = numBuckets;
        table = new ArrayList<List<String>>();
        for(int i = 0; i < numBuckets; i++){
            table.add(new ArrayList<String>());
        }
        this.hashFunction = hashFunction;
    }
    public boolean insert(String key){
        int hash;
        switch(hashFunction){
            case "ASCII":
                hash = asciiHash(key);
                break;
            case "PRIME":
                hash = primeHash(key);
                break;
            case "MYHASH":
                hash = myHash(key);
                break;
            default:
                hash = key.hashCode();
        }
        int i = hash % numBuckets;
        if(table.get(i).contains(key)){
            return false;
        }
        
        table.get(i).add(key);
        return true;
    }

    public int asciiHash(String key){
        int hash = 0;
        for(int i = 0; i < key.length(); i++){
           hash += (int)key.charAt(i);
        }
        return Math.abs(hash);
    }
    public int primeHash(String key){
        int hash = 9;
        for(int i = 0; i < key.length(); i++){
            hash += (int)key.charAt(i) * 17;
         }
        return Math.abs(hash);
    }
    public int myHash(String key){
        int hash  = key.charAt(0) * 18;
        return hash;
    }


    public String toString(){
        StringBuilder ret = new StringBuilder("");
        for(int i = 0; i < table.size(); i++){
            List<String> bucket = table.get(i);
            ret.append(String.format("bucket %d: %s\n", i, bucket.toString()));
        }
        return ret.toString();
    }
    public static void main(String[] args){
        HashTable test = new HashTable(7, "ASCII");
        /* Hash Tests */
        System.out.println("Testing asciiHash...");
        int ans = 387;
        int hash1 = test.asciiHash("Liam");
        System.out.printf("Expected: %d, Actual: %d\n", ans, hash1);
        if(ans != hash1){
            System.out.println("FAILURE -> Something is wrong with your asciiHash!");
        }
        System.out.println("");
        HashTable test2 = new HashTable(7, "PRIME");

        int ans2 = 15887;
        int hash2 = test2.primeHash("Charlotte");
        System.out.println("Testing primeHash...");
        System.out.printf("Expected: %d, Actual: %d\n", ans2, hash2);
        if(ans2 != hash2){
            System.out.println("FAILURE -> Something is wrong with your primeHash!");
        }
        System.out.println("");
        HashTable test3 = new HashTable(7, "MYHASH");
        int ans3 = 1296;
        int hash3 = test3.myHash("Harper");
        System.out.println("Testing myHash...");
        System.out.printf("Expected: %d, Actual: %d\n", 1296, test.myHash("Harper"));
        if(ans3 != hash3){
            System.out.println("FAILURE -> Something is wrong with your myHash!");
        }
        System.out.println("");

        /* Table tests */
        String[] names = {"Liam", "Noah", "William", "James","Oliver",
                "Benjamin", "Charlotte", "Mia", "Evelyn", "Harper",
                "Lucas", "Mason", "Lucas"};
        HashTable[] tables = new HashTable[3];
        tables[0] = new HashTable(5, "ASCII");
        tables[1] = new HashTable(5, "PRIME");
        tables[2] = new HashTable(5, "MYHASH");
        for(HashTable table: tables){
            for(String name : names){
                table.insert(name);
            }
        }
        int i = 0;
        for(HashTable table: tables){
            System.out.println("TABLE " + i);
            System.out.println(table);
            i++;
        }
    }
}
