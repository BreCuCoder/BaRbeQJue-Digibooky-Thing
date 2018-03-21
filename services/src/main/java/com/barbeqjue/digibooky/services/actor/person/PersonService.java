package com.barbeqjue.digibooky.services.actor.person;

import com.barbeqjue.digibooky.domain.actor.person.Person;
import com.barbeqjue.digibooky.domain.actor.person.PersonRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PersonService {

    private final PersonRepository personRepository;

    @Inject
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson (Person providedPerson){
        assertEmailIsValid(providedPerson);
        assertLastNameisValid(providedPerson);
        return personRepository.storePerson(providedPerson);

    }

    private void assertEmailIsValid(Person providedPerson){
        if (providedPerson.getEmail() == null || providedPerson.getEmail().length() == 0){
            throw new IllegalArgumentException("You have to provide an Email");
        }
        if (!providedPerson.getEmail().matches("[\\w]{1,}@[\\w]{1,}\\.[\\w]{1,}")){
            throw new IllegalArgumentException("Your email format is not recognized");
        }
    }

    private void assertLastNameisValid (Person providedPerson){
        if (providedPerson.getLastName() == null || providedPerson.getLastName().length() == 0){
            throw new IllegalArgumentException( "You have to provide a last name");
        }
    }
}
