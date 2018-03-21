package com.barbeqjue.digibooky.domain.actor.person;

public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    private Person(){}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static class PersonBuilder{
        private Integer id;
        private String firstName;
        private String lastName;
        private String email;

        private PersonBuilder(){}

        public static PersonBuilder person(){
            return new PersonBuilder();
        }

        public Person build(){
            Person person = new Person();
            person.setId(id);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setEmail(email);
            return person;
        }

        public PersonBuilder withId(Integer id){
            this.id = id;
            return this;
        }

        public PersonBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder withEmail(String email){
            this.email = email;
            return this;
        }
    }
}
