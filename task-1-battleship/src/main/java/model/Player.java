package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@EqualsAndHashCode
public class Player {
    String name;

    @Override
    public String toString() {
        return name + " ";
    }

}
