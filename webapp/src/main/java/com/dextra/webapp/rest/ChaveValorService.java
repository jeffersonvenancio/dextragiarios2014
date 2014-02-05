package com.dextra.webapp.rest;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.dextra.webapp.entity.ChaveValor;
import com.dextra.webapp.vo.ChaveValorVO;

@Path("chave-valor")
public class ChaveValorService {
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("vo")
    public ChaveValorVO page(@Context HttpServletRequest request) {
        
        Principal principal = request.getUserPrincipal();
        String name = principal.getName();
        List<ChaveValor> values = listar(name);
        
        return new ChaveValorVO(name, values);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public List<ChaveValor> listar(@Context HttpServletRequest request) {

    	Principal principal = request.getUserPrincipal();
        String name = principal.getName();
    	return listar(name);
    }
    
    private List<ChaveValor> listar(String usuario) {
    	String jpql = String.format("SELECT c"
                + " FROM %s c"
                + " WHERE c.usuario = :usuario", ChaveValor.class.getSimpleName());
       TypedQuery<ChaveValor> query = this.em.createQuery(jpql, ChaveValor.class);
       query.setParameter("usuario", usuario);
       return query.getResultList();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("") 
    public ChaveValor novo(
    		@FormParam("chave") String chave,
    		@FormParam("valor") String valor,
    		@Context HttpServletRequest request) {
    	
    	Principal principal = request.getUserPrincipal();
    	String usuario = principal.getName();
    	String data = DATE_FORMAT.format(Calendar.getInstance().getTime());
    	
    	ChaveValor chaveValor = new ChaveValor();
    	chaveValor.setChave(chave);
    	chaveValor.setDataHora(data);
    	chaveValor.setUsuario(usuario);
    	chaveValor.setValor(valor);
    	
    	this.em.persist(chaveValor);
    	
    	return chaveValor;
    }

}
