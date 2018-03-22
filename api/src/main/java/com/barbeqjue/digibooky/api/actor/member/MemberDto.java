package com.barbeqjue.digibooky.api.actor.member;

import com.barbeqjue.digibooky.domain.actor.HumanInfo;

import java.util.UUID;

public class MemberDto {
    private UUID id;
    private HumanInfo humanInfo;
    private String inss;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String city;

    private MemberDto(){}

    public static MemberDto memberDto (){
        return new MemberDto();
    }

    public MemberDto withId (UUID id){
        this.id = id;
        return this;
    }

    public MemberDto withHumanInfo (HumanInfo humanInfo){
        this.humanInfo = humanInfo;
        return this;
    }

    public MemberDto withInss(String inss){
        this.inss = inss;
        return this;
    }

    public MemberDto withoutInss(){
        this.inss = null;
        return this;
    }

    public MemberDto withStreetName(String streetName){
        this.streetName = streetName;
        return this;
    }

    public MemberDto withStreetNumber(String streetNumber){
        this.streetNumber = streetNumber;
        return this;
    }

    public MemberDto withPostalCode(String postalCode){
        this.postalCode = postalCode;
        return this;
    }

    public MemberDto withCity(String city){
        this.city = city;
        return this;
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


}
