package com.example

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/persons")
class PersonsResource {

    //TODO: add remaining rest methods

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun getPersons(): List<Person> {
        return listOf()
    }
}