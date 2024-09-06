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

            // Создание нового массива при переполнении
            if (productCount == shoppingList.length) {
                String[] oldShoppingList = new String[productCount];

                for (int i = 0; i < shoppingList.length; i++) {
                    oldShoppingList[i] = shoppingList[i];
                }

                shoppingList = new String[productCount + 1];

                for (int i = 0; i < oldShoppingList.length; i++) {
                    shoppingList[i] = oldShoppingList[i];
                }
            }

            // Добавление товара в список
            if (actionNumber == 1) {

                boolean isDuplicate = false;

                System.out.println("Введите название товара для добавленяи в список:");
                String product = scanner.next();

                // проверка на дубликаты
                for (int i = 0; i < shoppingList.length; i++) {
                    if (product.equals(shoppingList[i])) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    shoppingList[productCount] = product;
                    System.out.println("Товар " + product + " добавлен в список под номером " + (productCount + 1));
                    productCount++;
                } else {
                    System.out.println("Данный товар уже есть в списке покупок.");
                }

                // Показать список товаров
            } else if (actionNumber == 2) {
                System.out.println("Список товаров:");

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

                // Очистить список товаров
            } else if (actionNumber == 3) {
                for (int i = 0; i < shoppingList.length; i++) {
                    shoppingList[i] = null;
                }
                System.out.println("Список товаров очищен.");

                // Выход из приложения
            } else if (actionNumber == 4) {
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}