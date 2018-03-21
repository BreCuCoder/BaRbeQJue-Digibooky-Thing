package com.barbeqjue.digibooky.services.actor.person;

import com.barbeqjue.digibooky.domain.actor.person.Person;
import com.barbeqjue.digibooky.domain.actor.person.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    public void createPerson_HappyPath() {
        Person providedPerson = Person.PersonBuilder.person()
                .withLastName("Rens")
                .withEmail("quentinrens@hotmail.com")
                .build();

        Person expectedPerson = Person.PersonBuilder.person()
                .withId(1)
                .withLastName(providedPerson.getLastName())
                .withEmail(providedPerson.getEmail())
                .build();

        Mockito.when(personRepository.storePerson(providedPerson)).thenReturn(expectedPerson);

        Person actualPerson = personService.createPerson(providedPerson);

        Assertions.assertThat(actualPerson).isEqualToComparingFieldByField(expectedPerson);
    }
}
