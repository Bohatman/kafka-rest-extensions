package io.confluent.kafkarest.response;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import io.confluent.kafkarest.entities.v3.ProduceResponse;
@Provider
public class TestMessageBody implements MessageBodyWriter<AutoValue_StreamingResponse_ResultHolder>{
    Logger logger = LoggerFactory.getLogger(TestMessageBody.class);
    @Context
    private UriInfo uriInfo;
    @Context
    private ResourceInfo resourceInfo;
    private ObjectMapper getJsonMapper(){
        return new ObjectMapper()
                        .registerModule(new GuavaModule())
                        .registerModule(new Jdk8Module())
                        .registerModule(new JavaTimeModule())
                        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                        .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"))
                        .setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        String path = uriInfo.getPath();
        return path.startsWith("v3") && path.endsWith("records") && type == AutoValue_StreamingResponse_ResultHolder.class;
    }

    @Override
    public void writeTo(AutoValue_StreamingResponse_ResultHolder o
            , Class<?> type
            , Type genericType
            , Annotation[] annotations
            , MediaType mediaType
            , MultivaluedMap<String, Object> httpHeaders
            , OutputStream entityStream) throws IOException, WebApplicationException {
        String path = uriInfo.getPath();
        if(!(path.startsWith("v3") && path.endsWith("records"))){
            entityStream.write(getJsonMapper().writeValueAsBytes(o));
        }else{
            ProduceResponse response = (ProduceResponse) o.getResult();
            if(response.getErrorCode() == 200){
                ProduceResponseWithOutErrorCode responseWithOutErrorCode = ProduceResponseWithOutErrorCode.builder()
                        .setMessage(response.getMessage())
                        .setClusterId(response.getClusterId())
                        .setTopicName(response.getTopicName())
                        .setPartitionId(response.getPartitionId())
                        .setOffset(response.getOffset())
                        .setTimestamp(response.getTimestamp())
                        .setKey(response.getKey())
                        .setValue(response.getValue())
                        .build();
                entityStream.write(getJsonMapper().writeValueAsBytes(responseWithOutErrorCode));
            }else{
                entityStream.write(getJsonMapper().writeValueAsBytes(o));
            }
        }
        entityStream.flush();
        entityStream.close();
    }
}
