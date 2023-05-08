package user_management

import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonRepository : PanacheRepository<Person> {

    fun findByRegistration(registration: String) = Person("registration = '$registration'")

}