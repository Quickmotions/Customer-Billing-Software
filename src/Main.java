public class Main {
    public static void main(String[] args) {
        DatabaseInteraction DataManager = new DatabaseInteraction();
        Customer[] customers;
        customers = DataManager.ReadDataFromFile();
        System.out.println(customers[0].name);

    }
}
