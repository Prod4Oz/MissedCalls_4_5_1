import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactsAll contactsAll = new ContactsAll();// создаем объеты контактов
        MissedCalls missedCalls = new MissedCalls();// создаем объеты пропущенных

        printInfo();


        while (true) {

            Scanner scanner = new Scanner(System.in);
            menu();
            String input = scanner.nextLine();
            if ("end".equals(input) || "5".equals(input)) {
                System.out.println("Выход из программы завершен");
                break;
            }
            int operation = Integer.parseInt(input);



            inputOperations(operation,contactsAll, missedCalls);

        }

//        addContactsAll(contactsAll);// добавляем контакты
//        addMissedCalls(missedCalls);// добавляем пропущенный вызов
//        System.out.println(missedCalls.toString(contactsAll)); // выводим список пропущенных вызовов
//        missedCalls.cleanMissedCalls();// чистим пропущенные вызовы


    }


    private static String scanner () {
        Scanner scanner = new Scanner(System.in);
        String userInput;
            System.out.println("Введите номер пропушенного");
            userInput = scanner.nextLine();
        return userInput;
    }

    public static void addContactsAll (ContactsAll contactsAll){
        contactsAll.addContact(new Contact("QQQ","AAA","111", Group.WORK.FAMILY));
        contactsAll.addContact(new Contact("WWW","SSS","222", Group.FRIENDS));
        contactsAll.addContact(new Contact("EEE","DDD","333", Group.WORK));
        contactsAll.addContact(new Contact("RRR","FFF","444", Group.FAMILY));
        contactsAll.addContact(new Contact("TTT","GGG","555", Group.WORK));
    }
    public static void addMissedCalls (MissedCalls missedCalls){
        missedCalls.addMissedCalls(scanner());
    }

    public static void printInfo (){
        System.out.println("Программа: пропущенные вызовы");
        System.out.println();
        System.out.println("Меню:\n" +
                "1. Добавить контакт\n" +
                "2. Добавить пропущенный вызов\n" +
                "3. Вывести все пропущенные вызовы\n" +
                "4. Очистить пропущенные вызовы\n" +
                "5 ||end. Выход\n" );


    }
    public static void inputOperations (int operation, ContactsAll contactsAll, MissedCalls missedCalls) {
        switch (operation) {
            case 1:
                addContactsAll(contactsAll);// добавляем контакты
                System.out.println("Контакты добавлены в телефонную книгу по шаблону");
                break;
            case 2:
                addMissedCalls(missedCalls);// добавляем пропущенный вызов
                System.out.println("Добавлен пропущенный вызов");
                break;
            case 3:
                System.out.println(missedCalls.toString(contactsAll)); // выводим список пропущенных вызовов
                break;
            case 4:
                missedCalls.cleanMissedCalls();
                System.out.println("Список <<Пропушенные вызовы>> очищен");
                break;

            default:
                System.out.println("Такой операции нет");
                break;
        }


    }
    public static void menu (){
        System.out.println(
                "Выберите пункт из меню (1-4):");
    }
}


