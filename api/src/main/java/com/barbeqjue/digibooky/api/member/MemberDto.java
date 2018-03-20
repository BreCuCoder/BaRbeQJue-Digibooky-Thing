package com.barbeqjue.digibooky.api.member;

public class MemberDto {
    private Integer id;
    private String inss;
    private String firstName;
    private String lastName;
    private String email;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;

    public static MemberDto memberDto (){
        return new MemberDto();
    }

    public MemberDto withId(Integer id) {
        this.id = id;
        return this;
    }

    public MemberDto withInss(String inss) {
        this.inss = inss;
        return this;
    }

    public MemberDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MemberDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MemberDto withEmail(String email) {
        this.email = email;
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

    public Integer getId() {
        return id;
    }

    public String getInss() {
        return inss;
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
