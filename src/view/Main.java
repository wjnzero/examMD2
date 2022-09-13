package view;

import controller.Admin;
import model.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Product> productList = Admin.productList;
    static Admin admin = new Admin();
    public static void main(String[] args) {
        menuOfProduct();
    }
    public static void menuOfProduct() {
        try {
            do {
                Menu();
                Scanner scanner = new Scanner(System.in);
                Scanner scanner1 = new Scanner(System.in);
                int num = scanner1.nextInt();
                switch (num) {
                    case 1:
                        admin.displayProduct();
                        break;
                    case 2:
                        addProduct(scanner, scanner1);
                        break;
                    case 3:
                        editProduct(scanner, scanner1);
                        break;
                    case 4:
                        removeProduct(scanner);
                        break;
                    case 5:
                        softProduct(scanner);
                        break;
                    case 6:
                        admin.displayMaxPriceProduct();
                        break;
                    case 7:
                        admin.writeProduct(productList);
                        break;
                    case 8:
                        admin.readProduct();
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Bạn nhập sai dữ liệu");
            System.out.println("------------------------------");
            menuOfProduct();
        }
    }

    private static void softProduct(Scanner scanner) {
        try {
            System.out.println("1. Sắp xếp");
            System.out.println("3. Trở về menu chính");
            int case5 = scanner.nextInt();
            switch (case5){
                case 1:
                    admin.sortByPriceLowToHeight();
                    System.out.println("xong, ve menu de xem");
                    break;
                case 3:
                    menuOfProduct();
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("Bạn đã nhập sai dữ liệu");
            System.out.println("------------------------------");
        }
    }

    private static void removeProduct(Scanner scanner) {
        try {
            System.out.print("Mời bạn nhập ID: ");
            String id = scanner.nextLine();
            int check = admin.checkID(id);
            if (check == -1) {
                System.out.println("Không có sản phẩm theo ID");
                System.out.println("----------------------------------");
            } else {
                admin.deleteProduct(check);
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu");
            System.out.println("------------------------------");
        }
    }

    private static void editProduct(Scanner scanner, Scanner scanner1) {
        try {
            System.out.println("Mời bạn nhập ID");
            String id = scanner.nextLine();
            int check = admin.checkID(id);
            if (check == -1) {
                System.out.println("Không có sản phẩm theo ID");
            } else {
                addProduct(scanner, scanner1);
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu");
            System.out.println("------------------------------");
        }
    }

    private static void addProduct(Scanner scanner, Scanner scanner1) {
        try {
            System.out.print("Mời bạn nhập ID: ");
            String ID = scanner.nextLine();
            System.out.print("Mời bạn nhập tên: ");
            String name = scanner.nextLine();
            System.out.print("Mời bạn nhập giá: ");
            double price = scanner1.nextDouble();
            System.out.print("Mời bạn nhập số lượng: ");
            int amount = scanner1.nextInt();
            System.out.print("Mời bạn nhập mô tả: ");
            String description = scanner.nextLine();
            Product product = new Product(ID, name, price, amount, description);
            admin.addProduct(product);
        } catch (InputMismatchException e) {
            System.out.println("Sai kiểu dữ liệu");
            System.out.println("-------------------------------");
        }
    }

    private static void Menu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Ghi file");
        System.out.println("8. Đọc file");
        System.out.println("9. Thoát");
        System.out.println("-----------------------------------------------");
        System.out.println("Mời bạn nhập lựa chọn: ");
    }
}