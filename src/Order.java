public class Order {
    // private properties
    private String customerName;
    private double taxRate;
    private double discount;
    private int quantity;

    // constructor
    public Order(String customerName, double taxRate, double discount, int quantity) {
        this.customerName = customerName;
        this.taxRate = taxRate;
        this.discount = discount;
        this.quantity = quantity;
    }

    // method to get discount
    public double getDiscount() {
        return discount;
    }

    // method to get tax
    public double getTax() {
        return taxRate;
    }

    // method to get customer name
    public String getCustomerName() {
        return customerName;
    }

    // method to get quantity
    public int getQuantity() {
        return quantity;
    }
}
