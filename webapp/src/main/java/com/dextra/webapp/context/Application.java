package com.dextra.webapp.context;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.dextra.webapp.rest.MainServlet;

@ApplicationPath("api")
public class Application extends javax.ws.rs.core.Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		
		classes.add(MainServlet.class);
		
		return classes;
	}

}
