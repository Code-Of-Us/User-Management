package user_management

import lombok.*
import lombok.experimental.FieldDefaults

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class PersonDto(
    var id: Long? = null,
    var firstName: String = "",
    var lastName: String = "",
    var registration: String = ""
)