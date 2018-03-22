package com.barbeqjue.digibooky.domain.actor.member;

import com.barbeqjue.digibooky.domain.actor.person.Person;


public class Member {
    private Person person;
    private String inss;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;

    private Member(){}

    public void setPerson(Person person) {
        this.person = person;
    }


    public void setInss(String inss) {
        this.inss = inss;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public String getInss() {
        return inss;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class MemberBuilder{
        private Person person;
        private String inss;
        private String streetName;
        private String streetNumber;
        private String postalCode;
        private String city;

        private MemberBuilder(){}

        public static MemberBuilder member() {
            return new MemberBuilder();
        }

        public Member build(){
            Member member = new Member();
            member.setPerson(person);
            member.setInss(inss);
            member.setStreetName(streetName);
            member.setStreetNumber(streetNumber);
            member.setPostalCode(postalCode);
            member.setCity(city);
            return member;
        }

        public MemberBuilder withInss(String inss){
            this.inss = inss;
            return this;
        }

        public MemberBuilder withPerson (Person person) {
            this.person = person;
            return this;
        }

        public MemberBuilder withStreetName(String streetName){
            this.streetName = streetName;
            return this;
        }

        public MemberBuilder withStreetNumber(String streetNumber){
            this.streetNumber = streetNumber;
            return this;
        }

        public MemberBuilder withPostalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public MemberBuilder withCity(String city){
            this.city = city;
            return this;
        }



    }

}
