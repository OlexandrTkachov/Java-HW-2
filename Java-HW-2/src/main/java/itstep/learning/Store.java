package itstep.learning;

import java.util.*;

public class Store {
    List<Product> products = new ArrayList<>();
    Map<String, String> categories = new LinkedHashMap<>();

    public void printAll() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void run() {
        System.out.println("Вітаємо в магазині");
        Scanner scanner = new Scanner(System.in);

        String choice;
        while (true) {
            System.out.println();
            System.out.println("Якщо бажаєте переглянути товари - введіть \"1\";");
            System.out.println("Якщо бажаєте щось додати до магазину - введіть \"2\";");
            System.out.print("Якщо бажаєте вийти з магазину - введіть \"3\": ");
            choice = scanner.nextLine();
            if (choice.equals("1")) {
                String printingChoice;
                while (true) {
                    System.out.print("Якщо бажаєте переглянути усі товари - введіть \"1\", якщо за категоріями - \"2\": ");
                    printingChoice = scanner.nextLine();
                    if (printingChoice.equals("1")) {
                        this.printAll();
                        break;
                    }
                    else if (printingChoice.equals("2")) {
                        System.out.println("Усі категорії:");
                        for (String c : categories.keySet()) {
                            System.out.println(c);
                        }
                        System.out.print("Введіть потрібну категорію: ");
                        String category = scanner.nextLine();
                        for (Product product : products) {
                            if (product.fields.containsKey(categories.get(category))) {
                                System.out.println(product);
                            }
                        }
                        break;
                    }
                    else System.out.println("Ви ввели неправильний знак. Спробуйте ще раз.");
                }
            }
            else if (choice.equals("2"))
            {
                String addingChoice;
                while (true) {
                    System.out.print("Якщо бажаєте додати товар - введіть \"1\", якщо категорію - \"2\": ");
                    addingChoice = scanner.nextLine();
                    if (addingChoice.equals("1")) {
                        System.out.print("\nВведіть назву товару: ");
                        Product p = new Product(scanner.nextLine());
                        String continuingChoice;
                        while (true) {
                            System.out.print("Якщо бажаєте ще додати поля товару - введіть \"+\", якщо ні - \"-\": ");
                            continuingChoice = scanner.nextLine();
                            if (continuingChoice.equals("+")) {
                                System.out.print("Введіть назву поля: ");
                                String fieldName = scanner.nextLine();
                                System.out.print("Введіть значення поля: ");
                                p.fields.put(fieldName, scanner.nextLine());
                            }
                            else if (continuingChoice.equals("-")) break;
                            else System.out.println("Ви ввели неправильний знак. Спробуйте ще раз.");
                        }
                        products.add(p);
                        break;
                    }
                    else if (addingChoice.equals("2")) {
                        System.out.print("Введіть назву категорії: ");
                        String categoryName = scanner.nextLine();
                        System.out.print("Введіть визначальне поле: ");
                        categories.put(categoryName, scanner.nextLine());
                        break;
                    }
                    else System.out.println("Ви ввели неправильний знак. Спробуйте ще раз.");
                }
            }
            else if (choice.equals("3"))
            {
                System.out.println("Бувайте!");
                return;
            }
            else System.out.println("Ви ввели неправильний знак. Спробуйте ще раз.");
        }
    }
}
