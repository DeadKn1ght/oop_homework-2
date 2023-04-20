package homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Data {
    public Data() {
    }

    public static Map<String, String> choice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количесвто критерия для соритровки:\n1. Производитель\n2. Цвет\n3. Оперативная память\n4. Объем жесткого диска\n5. Наличие операционной системы\n6. Цена\n");
        int countChoice = scanner.nextInt();
        Map<String, String> allSorted = new HashMap();

        for(int i = 0; i < countChoice; ++i) {
            System.out.print("\u001b[H\u001b[2J");
            System.out.println("Введите номер критерия для сортировки:\n1. Производитель\n2. Цвет\n3. Оперативная память\n4. Объем жесткого диска\n5. Наличие операционной системы\n6. Цена\n");
            int choice = scanner.nextInt();
            int flag;
            if (choice == 1) {
                System.out.println("Введите номер производителя :\n1.MSI\n2.Ilbrus\n3.Apple");
                flag = scanner.nextInt();
                if (flag == 1) {
                    allSorted.put("name", "MSI");
                } else if (flag == 2) {
                    allSorted.put("name", "Ilbrus");
                } else if (flag == 3) {
                    allSorted.put("name", "Apple");
                }
            } else if (choice == 2) {
                System.out.println("Введите номер цвета :\n1.white\n2.black");
                flag = scanner.nextInt();
                if (flag == 1) {
                    allSorted.put("color", "white");
                } else if (flag == 2) {
                    allSorted.put("color", "black");
                }
            } else if (choice == 3) {
                System.out.println("Введите минимальное значение оперативной памяти: ");
                flag = scanner.nextInt();
                allSorted.put("ram", String.valueOf(flag));
            } else if (choice == 4) {
                System.out.println("Введите минимальное значение объема жесткого диска:");
                flag = scanner.nextInt();
                allSorted.put("storage", String.valueOf(flag));
            } else if (choice == 5) {
                System.out.println("Наличие операционной системы:\n1.Да\n2.Нет");
                flag = scanner.nextInt();
                if (flag == 1) {
                    allSorted.put("os", "true");
                } else if (flag == 2) {
                    allSorted.put("os", "false");
                }
            } else if (choice == 6) {
                System.out.println("Введите максимальную цену: ");
                flag = scanner.nextInt();
                allSorted.put("price", String.valueOf(flag));
            }
        }

        return allSorted;
    }

    public static List<Laptop> suitableOptions(List<Laptop> laptops, Map<String, String> choice) {
        List<Laptop> sortedList = new ArrayList(laptops);
        Iterator var3 = laptops.iterator();

        while(var3.hasNext()) {
            Laptop laptop = (Laptop)var3.next();

            for(int j = 0; j < sortedList.size(); ++j) {
                if (laptop == sortedList.get(j)) {
                    if (choice.containsKey("name") && !laptop.producer().equals(choice.get("name"))) {
                        sortedList.remove(j);
                    } else if (choice.containsKey("color") && !laptop.color().equals(choice.get("color"))) {
                        sortedList.remove(j);
                    } else if (choice.containsKey("ram") && laptop.ram() <= Integer.parseInt((String)choice.get("ram"))) {
                        sortedList.remove(j);
                    } else if (choice.containsKey("storage") && laptop.storage() <= Integer.parseInt((String)choice.get("storage"))) {
                        sortedList.remove(j);
                    } else if (choice.containsKey("os") && !laptop.os() == Boolean.getBoolean((String)choice.get("os"))) {
                        sortedList.remove(j);
                    } else if (choice.containsKey("price") && laptop.price() >= Double.parseDouble((String)choice.get("price"))) {
                        sortedList.remove(j);
                    }
                }
            }
        }

        return sortedList;
    }
}
