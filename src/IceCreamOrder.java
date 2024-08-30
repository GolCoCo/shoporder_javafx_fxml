public class IceCreamOrder extends Order {
    // private properties
    private String flavor;
    private double flavorPrice;
    private String topping;
    private double toppingPrice;

    // constructor
    public IceCreamOrder(String customerName, double taxRate, double discount, int quantity, String flavor, double flavorPrice, String topping, double toppingPrice) {
        // sending super constructor values
        super(customerName, taxRate, discount, quantity);

        // assigning current class values
        this.flavor = flavor;
        this.flavorPrice = flavorPrice;
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    // method to calculate the subtotal
    private double subTotal() {
        // subtotal will be flavor price + topping price
        return (flavorPrice + toppingPrice);
    }

    // method to calculate the tax
    private double tax() {
        return subTotal() * getTax();
    }

    // method to calculate the discount
    private double discount() {
        return subTotal() * getDiscount() / 100;
    }

    // method to calculate the total
    public double total() {
        return (subTotal() + tax() - discount()) * getQuantity();
    }
}