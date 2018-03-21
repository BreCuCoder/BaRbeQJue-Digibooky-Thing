package com.barbeqjue.digibooky.domain.actor.moderator;

import javax.inject.Named;
import java.util.*;


@Named
public class ModeratorRepository {
    private Map<UUID, Moderator> moderators;
    private static int index;

    public ModeratorRepository(){
        moderators = new HashMap<>();
    }

    public Moderator storeModerator(Moderator moderator){
        moderator.setId(UUID.randomUUID());
        moderators.put(moderator.getId(), moderator);
        return moderator;
    }

    public List<Moderator> getModerators() {
        return Collections.unmodifiableList(new ArrayList<>(moderators.values()));
    }

    public Moderator getModerator(Integer id) {
        return moderators.get(id);
    }

    public Moderator updatedModerator(Moderator updatedModerator) {
        moderators.put(updatedModerator.getId(), updatedModerator);
        return updatedModerator;
    }

    public void deleteModerator(Integer idToRemove) {
        moderators.remove(idToRemove);
    }
}
