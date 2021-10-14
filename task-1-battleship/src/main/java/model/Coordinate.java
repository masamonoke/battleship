package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Coordinate {
    int x;
    int y;

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
