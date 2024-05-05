import java.util.*;

/*Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.*/

public class telephonenote {

    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<>();

        //тестовые контакты
        map.put("имя1", "45678987");
        map.put("имя2", "98736254, 5625266, 5642572");
        map.put("имя3", "63773773, 4567878");
        map.put("имя4", "87655535");

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Укажете действие (1-добавление, 2-вывод всех контактов)");
            String action = scanner.next();

            if (action.equals("1")){
                System.out.println("Укажете имя контакта");
                String contName = scanner.next();
                System.out.println("Укажете номер телефона");
                String numPhone = "";
                if(map.getOrDefault(contName, "Нет контакта") != "Нет контакта"){
                    numPhone = numPhone + map.get(contName) + ", ";
                }
                numPhone = numPhone + scanner.next();
                map.put(contName, numPhone);

            }else if(action.equals("2")){   
                HashMap<String, String> mapOutput = new HashMap<String,String>(map);
                System.out.println();
                while (mapOutput.size()>0) {
                    int max = 0;
                    String maxKey = "";
                    for (String key : mapOutput.keySet()) {
                        String[] count = mapOutput.get(key).split(", ");
                        if(count.length > max){
                            max = count.length;
                            maxKey = key;
                        }
                    }
                    System.out.println(maxKey);
                    System.out.println(mapOutput.get(maxKey));
                    mapOutput.remove(maxKey);
                    System.out.println();
                }
                
            }else{
                System.exit(0);
            }

        }
    
    }
}