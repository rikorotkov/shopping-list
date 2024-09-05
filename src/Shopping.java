import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        String[] shoppingList = new String[8];// Объявите массив shoppingList через длину
        int productCount = 0; // переменная для подсчёта добавленных товаров

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) {
                if (productCount < 8) {
                    System.out.println("Введите название товара для добавленяи в список:");
                    String product = scanner.next();//добавить товар

                    shoppingList[productCount] = product;
                    System.out.println("Товар " + product + " добавлен в список под номером " + (productCount + 1));
                    productCount++;
                } else {
                    System.out.println("Список товаров переполнен!");
                }

            } else if (actionNumber == 2) {
                if (productCount != 0) {
                    for (int i = 0; i < shoppingList.length; i++) {
                        if (shoppingList[i] == null) {
                            break;
                        } else {
                            System.out.println((i + 1) + ". " + shoppingList[i]);
                        }
                    }
                } else {
                    System.out.println("Список товаров пуст. Добавьте товары в список.");
                }
            } else if (actionNumber == 3) {
                for (int i = 0; i < shoppingList.length; i++) {
                    shoppingList[i] = null;
                }
                System.out.println("Список товаров очищен.");
            } else if (actionNumber == 4) {
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}