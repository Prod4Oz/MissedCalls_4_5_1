import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"); // новая фишка для форматирования читабельного вида вывода времени из LocalDateTime
    Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissedCalls(String phone) {
        missedCalls.put(LocalDateTime.now(), phone);   // добавляем тел. в пропущенные

    }


    public String toString(ContactsAll contactsAll) {
        StringBuffer strBuffer = new StringBuffer("Список пропушенных вызовов >>> "); //конструктор строки
        for (Map.Entry<LocalDateTime, String> missedCall : missedCalls.entrySet()) { // перебор мапы по ключ-значениям
            final Contact contact = contactsAll.searchByPhone(missedCall.getValue()); // добавили контакт по поиску ключу, поиск сделали по значениям
            strBuffer
                    .append(DATE_TIME_FORMATTER.format(   // новая фишка для форматирования читабельного вида вывода времени из LocalDateTime, т.к ключ у нас это время
                        missedCall.getKey())) // добавили в нашу строку ключ
                    .append("\t")
                    .append(
                            contact != null ? contact.getName() : missedCall.getValue()) // тернарка, если контакт есть в записной книжке то получили все данные о нем, если нет получили его имя
                    .append("\n");

        }
        return strBuffer.toString();  // Возвращение списка пропущенных вызовов.
    }

    public void cleanMissedCalls() {
        missedCalls.clear(); // чистим все от пропушенных
    }


}
