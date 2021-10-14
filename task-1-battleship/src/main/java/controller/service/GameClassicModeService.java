package controller.service;


import controller.PlayerData;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import model.*;
import model.units.Unit;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GameClassicModeService {
    Game game;

    PlayerData p1Data;
    PlayerData p2Data;

    public GameClassicModeService(Player p1, Set<Unit> p1Units, Player p2, Set<Unit> p2Units, Board board) {
        p1Data = new PlayerData(p1, p1Units, board);
        p2Data = new PlayerData(p2, p2Units, board);

        p1Data.setOpponentData(p2Data);
        p2Data.setOpponentData(p1Data);

        game = new Game(p1, p2, board);
    }

    public void startGame() {
        System.out.println("Game is started...");
        game.setCurrentMovePlayer(ThreadLocalRandom.current().nextInt(0, 2) == 0 ? game.getP1() : game.getP2());

        PlayerService playerService = new PlayerService();

        game.setGameStatus(GameStatus.InProgress);
        while (game.getWinner() == null) {

            PlayerData currentMovePlayerData = getCurrentMovePlayerData();
            System.out.println("Player " + game.getCurrentMovePlayer() + "making move...");
            System.out.println(playerService.makeMove(currentMovePlayerData));

            if (playerService.isShouldSwitchMovePlayer()) {
                switchCurrentMovePlayer();
                currentMovePlayerData = getCurrentMovePlayerData();
            }

            if (currentMovePlayerData.getOpponentData().getUsedShipCoordinates().isEmpty()) {
                game.setWinner(game.getCurrentMovePlayer());
                System.out.println(game.getWinner() + " wins");
                game.setGameStatus(GameStatus.Ended);
            }

        }
    }
    private void switchCurrentMovePlayer() {
        game.setCurrentMovePlayer(game.getCurrentMovePlayer() == p1Data.getPlayer() ? p2Data.getPlayer() : p1Data.getPlayer());
    }
    private PlayerData getCurrentMovePlayerData() {
        return game.getCurrentMovePlayer() == p1Data.getPlayer() ? p1Data : p2Data;
    }

}
