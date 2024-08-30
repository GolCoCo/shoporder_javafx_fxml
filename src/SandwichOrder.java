public class SandwichOrder extends Order {
    // private properties
    private String breadType;
    private double breadTypePrice;
    private String type;
    private double typePrice;

    // constructor
    public SandwichOrder(String customerName, double taxRate, double discount, int quantity, String breadType, double breadTypePrice, String type, double typePrice) {
        // sending values to the super constructor
        super(customerName, taxRate, discount, quantity);

        // assigning values to this class
        this.breadType = breadType;
        this.breadTypePrice = breadTypePrice;
        this.type = type;
        this.typePrice = typePrice;
    }

    // method to calculate sub-total
    private double subTotal() {
        return breadTypePrice + typePrice;
    }

    // method to calculate tax
    private double tax() {
        return subTotal() * getTax();
    }

    // method to calculate discount
    private double discount() {
        return subTotal() * getDiscount() / 100;
    }

    // method to calculate total
    public double total() {
        return (subTotal() + tax() - discount()) * getQuantity();
    }
}
