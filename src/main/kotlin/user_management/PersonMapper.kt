package user_management

import org.mapstruct.Mapper

@Mapper(componentModel = "cdi")
interface PersonMapper {

    fun toPersonDto(person: Person): PersonDto

    fun toPerson(personDto: PersonDto): Person

}