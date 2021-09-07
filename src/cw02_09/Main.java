package cw02_09;

import jdk.jfr.Category;

import java.time.LocalDate;
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

        List<Customer> customers= new ArrayList<>();
        customers.add(new Customer(1,"qwer", 15));
        customers.add(new Customer(2,"reqw", 20));
        customers.add(new Customer(3,"wqer", 25));
        customers.add(new Customer(4,"ewqr", 30));

        List<Order> orders = new ArrayList<>();

        orders.add(new Order(1, "ok", LocalDate.of(2021,9,2), LocalDate.of(2021,9,5), products, customers.get(2)));
        orders.add(new Order(2, "ok", LocalDate.of(2021,9,2), LocalDate.of(2021,9,6), products, customers.get(3)));
        orders.add(new Order(3, "ok", LocalDate.of(2021,9,2), LocalDate.of(2021,9,7), products, customers.get(1)));
        orders.add(new Order(4, "ok", LocalDate.of(2021,9,2), LocalDate.of(2021,9,8), products, customers.get(4)));
        orders.add(new Order(5, "ok", LocalDate.of(2021,3,14), LocalDate.of(2021,3,16), (List<Product>) products.get(4), customers.get(4)));
        orders.add(new Order(6, "ok", LocalDate.of(2021,3,14), LocalDate.of(2021,3,18), (List<Product>) products.get(4), customers.get(4)));
        orders.add(new Order(7, "ok", LocalDate.of(2021,3,14), LocalDate.of(2021,3,17), (List<Product>) products.get(4), customers.get(4)));
        orders.add(new Order(8, "ok", LocalDate.of(2021,3,14), LocalDate.of(2021,3,19), (List<Product>) products.get(4), customers.get(4)));

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
//        .forEach (System.out::println);
        System.out.println(products);
        System.out.println("================");

//        4. Get the 3 most recent placed order

        List<Order> collect = orders.stream().sorted((o1, o2) -> o1.getOrderDate().compareTo(o2.getOrderDate())).limit(3).collect(Collectors.toList());
        System.out.println(collect);
//        System.out.println(order);
//        System.out.println(orders);
////        5. Calculate order average payment placed on 14-Mar-2021 (використайте в процесі mapToDouble)
//        Order order1 = orders.stream().filter(order -> order.getOrderDate().equals(LocalDate.of(2021,3, 14)))
//                .mapToDouble(value -> )
////        6. Get the most expensive product by category (використайте groupingBy)
////        Product product1 = products.stream();
////                .collect(products.groupingBy)

    }
}
