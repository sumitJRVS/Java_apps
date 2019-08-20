package ca.jrvs.apps.twitter.dao;

/**
 * Setup Interface and implements to TwitterRestDAO
 * here ID is generic which is ver important
 */

public interface CrdRepo<T, ID> {

    T create(T twtEntity);

    T findById(ID id);

    T deleteById(ID id);
}

