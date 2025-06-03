package com.cibertec.JpaProject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cibertec.entity.Actor;
import com.cibertec.util.JPAUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	EntityManager cm = JPAUtil.getEntityManager();
    	try {
    		
	    	cm.getTransaction().begin();;
	    	
	    	//Actor actors = new Actor();
	    	Actor actors = cm.find(Actor.class, 5);
	    	
	    	cm.remove(actors);
	    	
    	} catch(Exception e) {
    		
    		cm.getTransaction().rollback();
    		
    		e.printStackTrace();
    	}
    		
    	cm.getTransaction().commit();
    	
    	TypedQuery<Actor> query = cm.createQuery("SELECT a from Actor a", Actor.class);
    	
    	List<Actor> actorList = query.getResultList();
    	
    	for(Actor a : actorList) {
    		
    		System.out.println(a.getActorId() + " -> " + a.getFirstName());
    	}
    }
}
