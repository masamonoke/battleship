import controller.service.GameClassicModeService;
import lombok.extern.slf4j.Slf4j;
import model.Board;
import model.Player;
import support.Generator;



@Slf4j
public class BattleshipApp {
    public static void main(String[] args)  {
        log.info("Game has started");

        Board board = new Board(10, 10);
        Player p1 = Generator.getInstance().generatePlayer(board);
        Player p2 = Generator.getInstance().generatePlayer(board);

        GameClassicModeService gameClassicModeService = new GameClassicModeService(p1, Generator.getInstance().genUnits(), p2, Generator.getInstance().genUnits(), board);
        gameClassicModeService.startGame();

        log.info("Game has ended");
    }
}
