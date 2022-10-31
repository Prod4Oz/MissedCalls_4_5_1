import java.util.HashMap;
import java.util.Map;

public class ContactsAll {
    Map<String, Contact> contactsAll = new HashMap<>();

    public void addContact(Contact contact) {
        contactsAll.put(contact.getPhone(), contact);  // добавляем по ключу(номер)
    }

    public void delContact(Contact contact) {
        while (contactsAll.values().remove(contact)) ; // чистим по значению
    }

    public Contact searchByPhone(String phone) {
        return contactsAll.get(phone); //  ищем по ключу(номеру)
    }


}
