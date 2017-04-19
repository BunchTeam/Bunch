/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZimnY
 */
@Stateless
public class CzatgrupowyFacade extends AbstractFacade<Czatgrupowy> {

    @PersistenceContext(unitName = "BunchPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CzatgrupowyFacade() {
        super(Czatgrupowy.class);
    }
    
}
