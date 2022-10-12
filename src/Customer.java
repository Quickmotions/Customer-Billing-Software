public class Customer {
    public String name;
    public String email;
    public int age;
    public float data_used; // in bytes
    public int data_plan;

    public void setAge(int age) {
        this.age = age;
    }
    public void setData_plan(int data_plan) {
        this.data_plan = data_plan;
    }
    public void setData_used(float data_used) {
        this.data_used = data_used;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float CalculateBill(){
        float data_in_GB = data_used / 1024f / 1024f / 1024f;
        int data_in_GB_rounded  = (int) Math.ceil(data_in_GB);
        float price = 0f;
        switch (data_plan){
            case 0:
                price = 2.50f * data_in_GB_rounded;
            case 1:
                price = 4.50f;
                if (data_in_GB_rounded > 2) price += (data_in_GB_rounded - 2) * 2.99f;
            case 2:
                price = 15.00f;
                if (data_in_GB_rounded > 10) price += (data_in_GB_rounded - 10) * 1.99f;
            case 3:
                price = 22.00f;
                if (data_in_GB_rounded > 20) price += (data_in_GB_rounded - 20) * 1.29f;
            case 4:
                price = 35.00f;
                if (data_in_GB_rounded > 50) price += (data_in_GB_rounded - 50) * 0.89f;
            case 5:
                price = 46.00f;
        }
        return price;
    }
}
