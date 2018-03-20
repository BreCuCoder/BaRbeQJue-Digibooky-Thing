package com.barbeqjue.digibooky.domain;

public class Member {
    private Integer id;
    private String inss;
    private String firstName;
    private String lastName;
    private String email;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;

    private Member(){}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInss(String inss) {
        this.inss = inss;
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

    public Integer getId() {
        return id;
    }

    public String getInss() {
        return inss;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getLastName() {
        return lastName;
    }

    public static class MemberBuilder{
        private Integer id;
        private String inss;
        private String firstName;
        private String lastName;
        private String email;
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
            member.setId(id);
            member.setInss(inss);
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setEmail(email);
            member.setStreetName(streetName);
            member.setStreetNumber(streetNumber);
            member.setPostalCode(postalCode);
            member.setCity(city);
            return member;
        }

        public MemberBuilder withId(Integer id){
            this.id = id;
            return this;
        }

        public MemberBuilder withInss(String inss){
            this.inss = inss;
            return this;
        }

        public MemberBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public MemberBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public MemberBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public MemberBuilder withStreetName(String StreetName){
            this.streetName = streetName;
            return this;
        }

        public MemberBuilder withStreetNumber(String StreetNumber){
            this.streetNumber = streetNumber;
            return this;
        }

        public MemberBuilder withPostalCode(String PostalCode){
            this.postalCode = postalCode;
            return this;
        }

        public MemberBuilder withCity(String city){
            this.city = city;
            return this;
        }



    }




}
