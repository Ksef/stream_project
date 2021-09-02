package cw02_09;

import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "qwer", "book",150.0));
        products.add(new Product(2, "reqw", "book",99.0));
        products.add(new Product(3, "wqer", "book",101.0));
        products.add(new Product(4, "ewqr", "book",200.0));
        products.add(new Product(5, "kukla", "toy",150.0));
        products.add(new Product(6, "ball", "toy",144.0));
        products.add(new Product(7, "sword", "toy",120.0));
        products.add(new Product(8, "cubik", "toy",250.0));

//        1. Obtain a list of products belongs to category “Books” with price > 100
        Predicate<Product> more100 = product -> product.getPrice() >= 100;
        products.stream().filter(more100).forEach(product -> System.out.println(product));

        System.out.println("=================");

//        2. Obtain a list of product with category = “Toys” and then apply 10% discount
        products.stream().map(product -> {
            if (product.getCategory().startsWith("toy")){
                product.setPrice(product.getPrice()- product.getPrice()*0.1);
            }
            return product;
        }).forEach(System.out::println);
        System.out.println("=================");

//        3. Get the cheapest products of “Books” category
        Product product = products.stream()
                .min((o1, o2) -> (int) (o1.getPrice() - o2.getPrice())).get();
        System.out.println(product);


    }
}
