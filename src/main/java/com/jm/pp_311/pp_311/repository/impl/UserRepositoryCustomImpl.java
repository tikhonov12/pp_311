package com.jm.pp_311.pp_311.repository.impl;

import com.jm.pp_311.pp_311.model.User;
import org.springframework.stereotype.Repository;
import com.jm.pp_311.pp_311.repository.UserRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void detachUser(User u) {
        entityManager.detach(u);
    }
}
