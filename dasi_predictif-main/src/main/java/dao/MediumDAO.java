/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import metier.modele.Medium;

/**
 *
 * @author yguerin
 */
public class MediumDAO {
    static public void create(Medium medium){
        JpaUtil.obtenirContextePersistance().persist(medium);
    }
    static public Medium getMediumById(Integer id){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(Medium.class, id);
    }
    static public Medium getMediumByName(String denomination){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        String jpql = "select e from Medium e where e.denomination = :denomination";
        TypedQuery query = em.createQuery(jpql, Medium.class);
        query.setParameter("denomination", denomination);
        return (Medium)query.getSingleResult();

    }
    
    static public List<Medium> getMediumList (){
        EntityManager em = JpaUtil.obtenirContextePersistance();
        String jpql = "select e from Medium e";
        TypedQuery query = em.createQuery(jpql, Medium.class);
        return query.getResultList();
    }
    
    static public Medium merge(Medium medium) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.merge(medium);
        return medium;
    }
    
    static public List<Medium> getTop5Mediums (){
        EntityManager em = JpaUtil.obtenirContextePersistance();
//        String jpql = "select e from Medium e ORDER BY e.nbConsultations DESC";
//        TypedQuery<Medium> query = em.createQuery(jpql, Medium.class);
//        query.setMaxResults(5);
//        return query.getResultList();
        List<Medium> list = em.createQuery("select m from Medium m",Medium.class).getResultList();
        list.sort((a, b) ->Integer.compare(b.getNbConsultations(),a.getNbConsultations()));
        return list.stream().limit(5).toList();
    }
}
