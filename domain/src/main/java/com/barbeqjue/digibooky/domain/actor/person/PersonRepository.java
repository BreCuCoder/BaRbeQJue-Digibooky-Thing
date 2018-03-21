package com.barbeqjue.digibooky.domain.actor.person;

import javax.inject.Named;
import java.util.*;


@Named
public class PersonRepository {
    private Map<Integer, Person> persons;
    private static int index;

    public PersonRepository(){
        persons = new HashMap<>();
    }

    public Person storePerson(Person person){
        person.setId(index++);
        persons.put(person.getId(), person);
        return person;
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(new ArrayList<>(persons.values()));
    }

    public Person getPerson(Integer id) {
        return persons.get(id);
    }

    public Person updatedPerson(Person updatedPerson) {
        persons.put(updatedPerson.getId(), updatedPerson);
        return updatedPerson;
    }

    public void deletePerson(Integer idToRemove) {
        persons.remove(idToRemove);
    }
}
