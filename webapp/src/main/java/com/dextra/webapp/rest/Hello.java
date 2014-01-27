package com.dextra.webapp.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class Hello {
	
	@GET
    @Produces(MediaType.TEXT_HTML)
	@Path("hello")
	public String hello() {
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
