package user_management

class PersonMapperImpl : PersonMapper {

    override fun toPersonDto(person: Person): PersonDto {
        var personDto = PersonDto()
        personDto.id = person.id
        personDto.firstName = person.firstName
        personDto.lastName = person.lastName
        personDto.registration = person.registration
        return personDto
    }

    override fun toPerson(personDto: PersonDto): Person {
        var person = Person()
        person.firstName = personDto.firstName
        person.lastName = personDto.lastName
        person.registration = personDto.registration
        return person
    }
}