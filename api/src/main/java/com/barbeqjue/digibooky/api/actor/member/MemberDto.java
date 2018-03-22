package com.barbeqjue.digibooky.api.actor.member;

import com.barbeqjue.digibooky.domain.actor.person.Person;

public class MemberDto {
    private Person person;
    private String inss;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;

    private MemberDto(){}

    public static MemberDto memberDto (){
        return new MemberDto();
    }

    public MemberDto withPerson (Person person){
        this.person = person;
        return this;
    }

    public MemberDto withInss(String inss) {
        this.inss = inss;
        return this;
    }

    public MemberDto withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public MemberDto withStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public MemberDto withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public MemberDto withCity(String city) {
        this.city = city;
        return this;
    }

    public Person getPerson() {return person;}

    public String getInss() {
        return inss;
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

    public String getCity() {
        return city;
    }


}
