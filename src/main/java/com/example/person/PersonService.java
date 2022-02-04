package com.example.person;

import java.util.List;
import java.util.ArrayList;

class PersonService {

    public List<Person> persons;

    public PersonService() {
        persons = new ArrayList<Person>();
        persons.add(new Person(0, "Skip", "skip@example.com", "1414"));
        persons.add(new Person(1, "Brian", "brian@example.com", "2424"));
    }

    public List<Person> getAll() {
        return persons;
    }

    public Person getOne(int id) {
        return persons.get(id);
    }

    public void insertOne(Person person) {
        Person lastPerson = persons.get(persons.size() - 1);
        person.setId(lastPerson.id + 1);
        persons.add(person);
    }

    public void deleteOne(int id) {
        for(Person person: persons) {
            if(person.id == id) {
                persons.remove(person);
                break;
            }
        }
    }

}
