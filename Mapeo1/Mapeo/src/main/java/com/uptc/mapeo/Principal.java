package com.uptc.mapeo;

import com.uptc.mapeo.persistence.PersistenceUtil;
import jakarta.persistence.EntityManager;


public class Principal {
    public static void main(String[] args) {

        EntityManager em = PersistenceUtil.getEntityManager();
    }
}
