package com.barbeqjue.digibooky.domain.lending;

import javax.inject.Named;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Named
public class LendingRepository {
    private static int databaseIndex = 0;
    private Map<Integer, Lending> lendings;

    public LendingRepository() {
        this.lendings = new HashMap<>();
    }

    public Map<Integer, Lending> getLendings() {
        return Collections.unmodifiableMap(lendings);
    }

    public Lending getLending (Integer uuid){
        return lendings.get(uuid);
    }

    public Lending storeLending(Lending lending) {
        lending.setUuid(databaseIndex++);
        lendings.put(lending.getuuid(), lending);
        return lending;
    }

    public void deleteLending(Integer uuid) {
        lendings.remove(uuid);
    }

//        public List<Lending> getLendings() {
//            return Collections.unmodifiableList(new ArrayList<>(lendings.values()));
//        }

//        public Lending getLending(Integer id) {
//            return lendings.get(id);
//        }

//        public Lending updateLending(Lending updatedLending) {
//            lendings.put(updatedLending.getUUID(), updatedLending);
//            return updatedLending;
//        }

//        public void deleteLending(Integer idToRemove) {
//            lendings.remove(idToRemove);
//        }
}

