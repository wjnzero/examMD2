package storage.product;
import model.Product;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadWriteProduct implements IReadWriteProduct {
    private ReadWriteProduct() {
    }
    private static ReadWriteProduct readWriteProduct;

    public static ReadWriteProduct getInstance(){
        if (readWriteProduct == null)
            readWriteProduct = new ReadWriteProduct();
        return readWriteProduct;
    }
    @Override
    public List<Product> readData() {
        List<Product> productList = new LinkedList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        Object obj = null;
        try {
            fis = new FileInputStream("src/data/products.csv");
            ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        }
        catch (FileNotFoundException e){
            System.out.println("null");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        productList = (List<Product>) obj;
        return productList;
    }
    @Override
    public void writeData(List<Product> list) {
        try {
            FileOutputStream fos = new FileOutputStream("src/data/products.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
