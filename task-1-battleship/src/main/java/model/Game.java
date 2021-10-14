package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@RequiredArgsConstructor
public class Game {
    @NonNull
    Player p1;
    @NonNull
    Player p2;
    @NonNull
    Board board;

    @Setter
    Player currentMovePlayer;
    @Setter
    Player winner;
    @Setter
    GameStatus gameStatus;

}
