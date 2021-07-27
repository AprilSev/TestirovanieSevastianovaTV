package JCDZ4;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add (String surname, String phoneNumber) {
        ArrayList<String> phones = phoneBook.getOrDefault(surname, new ArrayList<>());
        phones.add(phoneNumber);
        phoneBook.put(surname, phones);
    }

    public ArrayList<String> get(String surname) {
        ArrayList<String> result = phoneBook.get(surname);
       if (result == null) {
           System.out.println("Абонент с такой фамилией не найден");
       }
        return result;
    }

    public static void main (String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Petrov", "999");
        phoneBook.add("Petrova", "998");
        phoneBook.add("Kozlov", "997");
        phoneBook.add("Kozlov", "996");

        System.out.println(phoneBook.get("Kozlova"));
    }
}
