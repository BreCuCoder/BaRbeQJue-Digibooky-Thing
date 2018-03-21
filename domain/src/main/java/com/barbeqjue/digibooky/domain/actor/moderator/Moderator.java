package com.barbeqjue.digibooky.domain.actor.moderator;

import com.barbeqjue.digibooky.domain.actor.HumanInfo;

import java.util.UUID;

public class Moderator {
    private UUID id;
    private HumanInfo humanInfo;


    private String firstName;
    private String lastName;
    private String email;

    private Moderator(){}

    public void setId(UUID id) {
        this.id = id;
    }

    public void setHumanInfo(HumanInfo humanInfo) {
        this.humanInfo = humanInfo;
    }

    public UUID getId() {
        return id;
    }

    public HumanInfo getHumanInfo() {
        return humanInfo;
    }

    public static class ModeratorBuilder {
        private UUID id;
        private HumanInfo humanInfo;


        private ModeratorBuilder(){}

        public static ModeratorBuilder person(){
            return new ModeratorBuilder();
        }

        public Moderator build(){
            Moderator moderator = new Moderator();
            moderator.setId(id);
            moderator.setHumanInfo(humanInfo);
            return moderator;
        }

        public ModeratorBuilder withId(UUID id){
            this.id = id;
            return this;
        }

        public ModeratorBuilder withHumanInfo (HumanInfo humanInfo){
            this.humanInfo = humanInfo;
            return this;
        }

    }
}
