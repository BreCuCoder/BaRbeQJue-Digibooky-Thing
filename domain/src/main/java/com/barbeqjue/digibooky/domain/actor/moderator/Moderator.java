package com.barbeqjue.digibooky.domain.actor.moderator;

import com.barbeqjue.digibooky.domain.actor.HumanInfo;

import java.util.UUID;

public class Moderator {
    private UUID id;
    private HumanInfo humanInfo;
    private Status status;

    private Moderator(){}

    public void setId(UUID id) {
        this.id = id;
    }

    public void setHumanInfo(HumanInfo humanInfo) {
        this.humanInfo = humanInfo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public HumanInfo getHumanInfo() {
        return humanInfo;
    }

    public Status getStatus() {
        return status;
    }

    public static class ModeratorBuilder {
        private UUID id;
        private HumanInfo humanInfo;
        private Status status;


        private ModeratorBuilder(){}

        public static ModeratorBuilder moderator(){
            return new ModeratorBuilder();
        }

        public Moderator build(){
            Moderator moderator = new Moderator();
            moderator.setId(id);
            moderator.setHumanInfo(humanInfo);
            moderator.setStatus(status);
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

        public ModeratorBuilder withStatus (Status status) {
            this.status = status;
            return this;
        }

    }
}
