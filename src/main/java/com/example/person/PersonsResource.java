package com.example.person;

import com.codahale.metrics.annotation.Timed;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonsResource {

    private final PersonService service;

    public PersonsResource(PersonService service) {
        this.service = service;
    }

    @GET
    @Timed
    public List<Person> getAll() {
        return service.getAll();
    }

    @GET
    @Path("{id}")
    public Person getOne(@PathParam("id") final int id) {
        return service.getOne(id);
    }

    @POST
    public void insert(Person person) {
        service.insertOne(person);
    }

    @DELETE
    @Path("{id}")
    public void deleteOne(@PathParam("id") final int id) {
        service.deleteOne(id);
    }

}
