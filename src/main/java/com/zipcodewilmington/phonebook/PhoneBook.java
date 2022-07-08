package com.zipcodewilmington.phonebook;

import java.util.*;
/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {
//    private String name;
//    private String phoneNumber;
//
    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        // LinkedHashMap preserves the insert so its better
        // than a HashMap in this case
        this.phonebook = new LinkedHashMap<>();
        phonebook.putAll(map);
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        addAll(name, phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return (phonebook.containsKey(name));
    }

    public Boolean hasEntry(String name, String phoneNum) {
        return (phonebook.containsKey(name) && reverseLookup(phoneNum).equals(name));
    }

    public List<String> lookup(String name) {
        return (phonebook.get(name));
    }

    public String reverseLookup(String phoneNumber) {
        for (String n : phonebook.keySet()) {
            if (phonebook.get(n).contains(phoneNumber)) {
                return n;
            }
        }
        return null;
    }


    public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>();
        names.addAll(phonebook.keySet());
//        Collections.sort(names);
        return names;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
