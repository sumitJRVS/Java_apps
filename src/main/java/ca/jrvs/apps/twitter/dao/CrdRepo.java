package ca.jrvs.apps.twitter.dao;

public interface CrdRepo <T, ID> {
// here "ID" is generic listed as T and thats why
        T create(T twtEntity);
        T findById(ID id);
        T deleteById(ID id);
}

