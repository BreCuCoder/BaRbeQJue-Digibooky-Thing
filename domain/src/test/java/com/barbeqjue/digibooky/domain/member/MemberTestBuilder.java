package com.barbeqjue.digibooky.domain.member;

public class MemberTestBuilder {
    private Integer id;
    private String inss;
    private String firstName;
    private String lastName;
    private String email;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;

    private MemberTestBuilder(){}

    public static MemberTestBuilder aMember() {
        return new MemberTestBuilder();
    }

    public Member build(){
     return Member.MemberBuilder.member()
             .withId(id)
             .withInss(inss)
             .withFirstName(firstName)
             .withLastName(lastName)
             .withEmail(email)
             .withStreetName(streetName)
             .withStreetNumber(streetNumber)
             .withPostalCode(postalCode)
             .withCity(city)
             .build();
    }

    public MemberTestBuilder withId(Integer id){
        this.id = id;
        return this;
    }

    public MemberTestBuilder withoutId (Integer id){
        this.id = null;
        return this;
    }

    public MemberTestBuilder withInss(String inss){
        this.inss = inss;
        return this;
    }

    public MemberTestBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public MemberTestBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public MemberTestBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public MemberTestBuilder withStreetName(String StreetName){
        this.streetName = streetName;
        return this;
    }

    public MemberTestBuilder withStreetNumber(String StreetNumber){
        this.streetNumber = streetNumber;
        return this;
    }

    public MemberTestBuilder withPostalCode(String PostalCode){
        this.postalCode = postalCode;
        return this;
    }

    public MemberTestBuilder withCity(String city){
        this.city = city;
        return this;
    }


}
