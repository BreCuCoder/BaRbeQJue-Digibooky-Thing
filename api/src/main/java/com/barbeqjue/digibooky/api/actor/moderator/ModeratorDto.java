package com.barbeqjue.digibooky.api.actor.moderator;

import com.barbeqjue.digibooky.domain.actor.HumanInfo;
import com.barbeqjue.digibooky.domain.actor.moderator.Status;

import java.util.UUID;

public class ModeratorDto {
    private UUID id;
    private HumanInfo humanInfo;
    private Status status;

    private ModeratorDto(){}

    public static ModeratorDto moderatorDto(){
        return new ModeratorDto();
    }

    public ModeratorDto withId(UUID id){
        this.id = id;
        return this;
    }

    public ModeratorDto withHumanInfo (HumanInfo humanInfo){
        this.humanInfo = humanInfo;
        return this;
    }

    public ModeratorDto withStatus (Status status){
        this.status = status;
        return this;
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
}
