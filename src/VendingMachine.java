import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private int maxCapasity;

    private List<Product> list = new ArrayList<>();

    public VendingMachine(int maxCapasity, List<Product> list) {
        this.maxCapasity = maxCapasity;
        this.list = list;
    }
    public VendingMachine(int maxCapasity) {
        this.maxCapasity = maxCapasity;
    }

    public void add(Product product, String language){
        if (list.size() < maxCapasity){
            list.add(product);
        }
        else{
            if (language.equals("English")){
                System.out.println("The vending machine is full, you cannot add products");
            }
            else {
                System.out.println("La macina esta llena");
            }
        }
    }

    public List<Product> getProductByName(String name) throws Exception {
        List<Product> products = new ArrayList<>();
        for (Product product: list){
            if (product.getName().equals(name)){
                products.add(product);
            }
        }
        return products;
    }
    public List<Product> getProductByCost(double price) throws Exception {
        List<Product> products = new ArrayList<>();
        for (Product product: list){
            if (product.getPrice() == price){
                products.add(product);
            }
        }
        //throw new Exception("I didn't find anything");
        return products;
    }

}

