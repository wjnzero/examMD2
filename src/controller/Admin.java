package controller;

import model.Product;
import storage.product.IReadWriteProduct;
import storage.product.ReadWriteProduct;
import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Admin implements Serializable {
    public static IReadWriteProduct readWriteProduct = ReadWriteProduct.getInstance();
    public static List<Product> productList = new LinkedList<>();
//    static {
//            productList = readWriteProduct.readData();
//            if (productList ==null)
//                productList =new LinkedList<>();
//    }
    public void readProduct(){
        productList = readWriteProduct.readData();

    }
    public void writeProduct(List<Product> list){
        readWriteProduct.writeData(list);
    }
    public void displayProduct(){
        for (Product x : productList
        ) {
            System.out.println(x.toString());
        }
    }
    public void displayMaxPriceProduct(){
        double max = productList.get(0).getPrice();
        Product a = null;
        for (Product product : productList) {
            if (max < product.getPrice()) {
                max = product.getPrice();
                a = product;
            }
        }
        System.out.println(a);
    }
    public void addProduct(Product product) {
        productList.add(product);
    }

//    public void editProduct(int id, Product product) {
//        productList.set(id,product);
//    }

    public void deleteProduct(int id_product) {
        productList.remove(id_product);
    }

    public int checkID(String id){
        int check = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getID())){
                check = i;
            }
        }
        return check;
    }

    public void sortByPriceLowToHeight(){
        productList.sort(Comparator.comparingDouble(Product::getPrice));
    }


}
