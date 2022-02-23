package ru.tokarev.springmvcapp.dao;

import org.springframework.stereotype.Component;
import ru.tokarev.springmvcapp.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 12, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 32, "bob@inbox.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 51, "mike@qwe.ru"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        for(Person person: people)
            if(person.getId() == id)
                return person;

        return null;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person currentPerson = show(id);
        currentPerson.setName(updatedPerson.getName());
        currentPerson.setAge(updatedPerson.getAge());
        currentPerson.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
