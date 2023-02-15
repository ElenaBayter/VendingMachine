import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static String changeLanguage() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String language = "";
        int index = 0;
        do {
            if (index == 1 || index == 2) {
                break;
            }
            System.out.println("Please choose language: \n 1. English \n2. Spanish");
            index = Integer.parseInt(reader.readLine());
            if (index == 1) {
                language = "English";
            } else if (index == 2) {
                language = "Spanish";
            } else {
                System.out.println("False number");
            }

        } while (true);
        return language;
    }

    public static void main(String[] args) throws Exception {
        VendingMachine vendy = new VendingMachine(10);
        String language = changeLanguage();

        vendy.add(new Product(language.equals("English") ? "apple" : "manzana", 12), language);
        vendy.add(new Product(language.equals("English") ? "carrot" : "zanahoria", 8), language);
        vendy.add(new Product(language.equals("English") ? "banano" : "platano", 34), language);
        vendy.add(new Product(language.equals("English") ? "peach" : "durazno", 6), language);
        vendy.add(new Product(language.equals("English") ? "pear" : "pera", 12), language);
        vendy.add(new Product(language.equals("English") ? "apple" : "manzana", 12), language);
        vendy.add(new Product(language.equals("English") ? "carrot" : "zanahoria", 8), language);
        vendy.add(new Product(language.equals("English") ? "banano" : "platano", 34), language);
        vendy.add(new Product(language.equals("English") ? "peach" : "durazno", 6), language);
        vendy.add(new Product(language.equals("English") ? "pear" : "pera", 12), language);
        while (true) {
            if (language.equals("English")){
                System.out.println("Menu: ");
                System.out.println("1. Change language:");
                System.out.println("2. Search by price");
                System.out.println("3. Search by name");
                System.out.println("0. Exit");
            } else {
                System.out.println("Menu: ");
                System.out.println("1. Cambiar idioma:");
                System.out.println("2. Buscar de precio: ");
                System.out.println("3. Buscar de nombre");
                System.out.println("0. Salida");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int action = Integer.parseInt(reader.readLine());
            if (action == 0) {
                break;
            }
            if (action == 1) {
                language = changeLanguage();
            }
            if (action == 2) {
                if (language.equals("English")){System.out.println("Please input prise for search: ");}
                else {System.out.println("Por favor escriba precio para buscar: ");}
                int price = Integer.parseInt(reader.readLine());
                List<Product> products = vendy.getProductByCost(price);
                for (Product product : products) {
                    System.out.println(product.getName() + " " + product.getPrice() + "$");
                }
            }
            if (action == 3) {
                if (language.equals("English")){
                System.out.println("Please input name to search: ");}
                else {
                    System.out.println("Por favor escriba nombre para buscar:");}
                String name = reader.readLine();
                List<Product> products = vendy.getProductByName(name);
                for (Product product : products) {
                    System.out.println(product.getName() + " " + product.getPrice() + "$");
                }
            }
        }




    }

}