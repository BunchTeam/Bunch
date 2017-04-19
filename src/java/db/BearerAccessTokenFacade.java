/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.cxf.rs.security.oauth2.tokens.bearer.BearerAccessToken;

/**
 *
 * @author ZimnY
 */
@Stateless
public class BearerAccessTokenFacade extends AbstractFacade<BearerAccessToken> {

    @PersistenceContext(unitName = "BunchPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BearerAccessTokenFacade() {
        super(BearerAccessToken.class);
    }
    
}
