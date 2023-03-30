package user_management

import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/persons")
class PersonsResource(val personRepository: PersonRepository){

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    fun addPerson(person: Person): Response {
        personRepository.persist(person)
        return Response.ok(person).status(201).build()
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    fun deletePerson(@PathParam("id") id: Long): Response {
        personRepository.deleteById(id)
        return Response.ok("Person with id $id is deleted").build()
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun update(person: Person, @PathParam("id") id: Long): Response {
        personRepository.update("" +
                "firstName = ${person.firstName}, " +
                "lastName = '${person.lastName}', " +
                "registration = ${person.registration}, " +
                "where id = $id")
        return Response.ok(personRepository.findById(id)).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllPersons(): Response = Response.ok(personRepository.listAll()).build()

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPerson(@PathParam("id") id:Long): Response = Response.ok(personRepository.findById(id)).build()

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    fun findByRegistrationPlate(
        @QueryParam(value = "registration") registration: String
    ): Response = Response.ok(personRepository.findByRegistration(registration)).build()

}