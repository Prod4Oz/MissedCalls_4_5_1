public class Contact {
    private String name, surname, phone;
    Group group;

    public Contact(String name, String surname, String phone, Group group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.group = group;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  String.format("Name : %s %s , Phone - %s , Group >>> %s", name,surname,phone,group);
    }
}
