import java.io.*;

class Customer implements Serializable {
    private static final long serialVersionUID = 1L; // Ensure compatibility for future changes
    private int id;
    private String name;
    private String contactNo;
    private String address;

    // Constructor, getters, and setters (omitted for brevity)
}

public class SerializationDemo {
    public static void main(String[] args) {
        Customer customer = new Customer(101, "John Doe", "123-456-7890", "123 Main St");

        try {
            FileOutputStream fileOut = new FileOutputStream("JavaObject.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customer);
            out.close();
            fileOut.close();
            System.out.println("Customer object serialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}