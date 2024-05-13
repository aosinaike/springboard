/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.services;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Abiodun-PC
 */

public class AssetAccountServices implements Serializable {

    private transient EntityManagerFactory emf = null;
    private transient EntityManager em = null;
    private static final long serialVersionUID = 2180L;

    public AssetAccountServices() {
        emf = PersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
}
