package com.dextra.webapp.rest;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dextra.webapp.entity.Usuario;

@Path("")
public class Hello {
	
	private static AtomicInteger count = new AtomicInteger(1);
	
	@PersistenceContext 
	private EntityManager em;
	
	@GET
    @Produces(MediaType.TEXT_HTML)
	@Path("hello")
	public String hello() {
		
		EntityTransaction transaction = this.em.getTransaction();
		transaction.begin();
		
		int value = count.getAndAdd(1);
		Usuario user = new Usuario();
		user.setNome("blablabla-" + value);
		this.em.persist(user);
		
		transaction.commit();
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<head>");
		builder.append("\t<title>Ola</title>");
		builder.append("\t<link href=\"/style/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
		builder.append("</head>");
		builder.append("<body>");
		builder.append("\t<h1>Ola Mundo???</h1>");
		builder.append("</body>");
		builder.append("</html>");
		
		return builder.toString();
	}

}
