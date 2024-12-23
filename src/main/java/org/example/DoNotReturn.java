package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Provider
public class DoNotReturn implements WriterInterceptor {
    Logger logger = LoggerFactory.getLogger(DoNotReturn.class);
    @Context
    private UriInfo uriInfo;
    @Context
    private ResourceInfo resourceInfo;
    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        String path = uriInfo.getPath();
        if(path.startsWith("v3") && path.endsWith("records")){
            Object entity = context.getEntity();
            logger.info("Entity type:" + entity.getClass());
        }
        context.proceed();
    }
}
