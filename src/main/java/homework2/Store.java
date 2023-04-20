package homework2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Store {
    public Store() {
    }

    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList();
        laptops.add(new MSI());
        laptops.add(new Ilbrus());
        laptops.add(new AppleMacBookPro());
        laptops.add(new MSITitan());
        Map<String, String> allSorted = Data.choice();
        System.out.println("Сортировка по:");
        Iterator var3 = allSorted.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)var3.next();
            PrintStream var10000 = System.out;
            String var10001 = (String)entry.getKey();
            var10000.println(var10001 + ": " + (String)entry.getValue());
        }

        List<Laptop> sortList = Data.suitableOptions(laptops, allSorted);
        if (sortList.size() == 0) {
            System.out.println("Не подходящих вариантов");
        }

        Iterator var7 = sortList.iterator();

        while(var7.hasNext()) {
            Laptop laptop = (Laptop)var7.next();
            System.out.println("Подходящие варианты: " + laptop.getClass().getSimpleName());
        }

    }
}
