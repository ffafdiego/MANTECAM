/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import Entities.Revision;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Pablitolog
 */
@Stateless
public class RevisionFacade extends AbstractFacade<Revision> implements RevisionFacadeLocal {
    @PersistenceContext(unitName = "EnterpriseAppMantecam-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RevisionFacade() {
        super(Revision.class);
    }
    
     @Override
     public List<Revision> findByEstadoRevision(String estadoRevision) {

        Query query;

        query = em.createNamedQuery("Revision.findByEstadoRevision")
                .setParameter("estadoRevision", estadoRevision);
        return query.getResultList();
    }
     
    @Override
    public List<Revision> findByTecnico(Integer id) {
        Query query;
        query = em.createNamedQuery("Revision.findByTecnico")
                .setParameter("id", id);
        return query.getResultList();
    }
}
