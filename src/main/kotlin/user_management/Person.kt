package user_management

import io.quarkus.hibernate.orm.panache.PanacheEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "person")
class Person(
    @Column(name = "firstName")
    var firstName: String = "",
    @Column(name = "lastName")
    var lastName: String = "",
    @Column(name = "registration")
    var registration: String = ""
) : PanacheEntity()