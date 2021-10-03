package testng.yaml.nested_models;

class Employee {
    public String name = null;
    public int no;
    private Address address;
    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getNo() {
        return no;
    }
}



