package com.barbeqjue.digibooky.domain.actor.member;

import com.barbeqjue.digibooky.domain.actor.HumanInfo;

import java.util.UUID;


public class Member {
    private UUID id;
    private HumanInfo humanInfo;
    private String inss;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;

    private Member(){}

    public void setId(UUID id) {
        this.id = id;
    }

    public void setHumanInfo(HumanInfo humanInfo) {
        this.humanInfo = humanInfo;
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

    public UUID getId() {
        return id;
    }

    public HumanInfo getHumanInfo() {
        return humanInfo;
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
        private UUID id;
        private HumanInfo humanInfo;
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
            member.setId(id);
            member.setHumanInfo(humanInfo);
            member.setInss(inss);
            member.setStreetName(streetName);
            member.setStreetNumber(streetNumber);
            member.setPostalCode(postalCode);
            member.setCity(city);
            return member;
        }

        public MemberBuilder withId (UUID id){
            this.id = id;
            return this;
        }

        public MemberBuilder withHumanInfo (HumanInfo humanInfo){
            this.humanInfo = humanInfo;
            return this;
        }

        public MemberBuilder withInss(String inss){
            this.inss = inss;
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
