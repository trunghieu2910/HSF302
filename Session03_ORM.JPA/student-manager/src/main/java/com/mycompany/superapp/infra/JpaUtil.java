package com.mycompany.superapp.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("com.mycompany.supperapp-PU");
            // LOAD THÔNG TIN SERVER TUWF FILE PERSISTENCE.XML
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private JpaUtil() {
    }
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public static void shutdown() {
        if (emf != null) {
            emf.close();
        }
    }
}
