package com.dextra.webapp.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Iterator;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.dextra.webapp.context.ServerProperties;

@Path("")
public class Resources {

    private String basePath = ServerProperties.property("source.path");

    @GET
    @Path("{path:.*}")
    public Response doGet(@PathParam("path") String path) {
        File f = (path == null || path.isEmpty()) ? index() : new File(basePath + "/" + path);

        if (f == null || !f.exists() || !f.isFile()) {
            return this.send404();
        }

        String mime = this.getContentType(f);
        return Response.ok(f, mime).build();
    }

    /**
     * @return the first index file found on webapp root directory
     */
    private File index() {
        java.nio.file.Path dir = FileSystems.getDefault().getPath(this.basePath);
        try (DirectoryStream<java.nio.file.Path> stream = Files.newDirectoryStream(dir, "index.*")) {
            Iterator<java.nio.file.Path> iterator = stream.iterator();

            if (iterator.hasNext()) {
                java.nio.file.Path index = iterator.next();
                return index.toFile();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private Response send404() {
        File f = new File(basePath + "/404.html");
        ResponseBuilder response = Response.status(Response.Status.NOT_FOUND);
        return f.isFile() ? response.entity(f).build() : response.build();
    }

    private String getContentType(File f) {
        String contentType = null;
        try {
            contentType = Files.probeContentType(f.toPath());
        } catch (IOException e) {
            // do nothing
        }

        String mime = contentType == null ? (new MimetypesFileTypeMap()).getContentType(f) : contentType;
        return mime;
    }

}
