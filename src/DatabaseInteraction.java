import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DatabaseInteraction {

    public void WriteDataToFile(Customer[] customers){
        File user_data = new File("UserData.txt");
        if (!user_data.exists()) {
            CreateFile();
        }
        try {
            FileWriter myWriter = new FileWriter("UserData.txt");
            String data = "";
            for (int i=0; i==customers.length-1; i++){
                Customer currentCustomer = customers[i];
                data += currentCustomer.name + "\t" +
                        currentCustomer.email + "\t" +
                        currentCustomer.age + "\t" +
                        currentCustomer.data_used + "\t" +
                        currentCustomer.data_plan + "\n";
            }
            myWriter.write(data);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("failed to write");
            throw new RuntimeException(e);
        }

    }

    public void CreateFile(){
        try {
            File user_data = new File("UserData.txt");
            if (user_data.createNewFile()) {
                System.out.println("File created: " + user_data.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("failed to create new file");
            throw new RuntimeException(e);
        }
    }
    public Customer[] ReadDataFromFile(){

        try {
            File user_data  = new File("UserData.txt");
            Scanner myReader = new Scanner(user_data);

            // Get Length of customers in UserData and create a array with such length
            int count = 0;
            while (myReader.hasNextLine()) {
                count++;
                myReader.nextLine();
            }
            Customer[] customers = new Customer[count];
            count = 0;

            // reset position of reader
            myReader = new Scanner(user_data);

            // Add data from file to each item in customer array
            while (myReader.hasNextLine()){
                // split user data into an array of data and remove newline char
                String data = myReader.nextLine();
                String[] data_items = data.replaceAll("\n", "").split("\t");
                // assign the users data
                customers[count] = new Customer();
                customers[count].setName(data_items[0]);
                customers[count].setEmail(data_items[1]);
                customers[count].setAge(Integer.parseInt(data_items[2]));
                customers[count].setData_used(Float.parseFloat(data_items[3]));
                customers[count].setData_plan(Integer.parseInt(data_items[4]));
                count++;
            }
            myReader.close();
            return customers;

        } catch (FileNotFoundException e) {
            System.out.println("failed to read");
            throw new RuntimeException(e);
        }

    }
}
