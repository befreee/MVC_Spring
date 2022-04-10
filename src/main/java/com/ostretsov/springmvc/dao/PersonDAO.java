package com.ostretsov.springmvc.dao;

import com.ostretsov.springmvc.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT = 1;

    {
        people = new ArrayList<>();

        people.add(new Person(PEOPLE_COUNT++, "Tom",30,"tom@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Valera",54,"valera@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Katy", 28,"ekaterina@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Alexey",27,"lexa@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "John",40,"johncarter@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(PEOPLE_COUNT++);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person updatedPerson = show(id);
        updatedPerson.setName(person.getName());
        updatedPerson.setAge(person.getAge());
        updatedPerson.setEmail(person.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId()==id);
    }
}
