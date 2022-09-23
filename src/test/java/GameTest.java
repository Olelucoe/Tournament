import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

public class GameTest {
    @Test
    public void ifFirstPlayerIsStronger() {
        Player player1 = new Player(1, "Sub-Zero", 80);
        Player player2 = new Player(2, "Scorpion", 80);
        Player player3 = new Player(3, "Lu Kang", 85);
        Player player4 = new Player(4, "Reptile", 60);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 1;
        int actual = game.round(player1.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifSecondPlayerIsStronger() {
        Player player1 = new Player(1, "Sub-Zero", 80);
        Player player2 = new Player(2, "Scorpion", 80);
        Player player3 = new Player(3, "Lu Kang", 85);
        Player player4 = new Player(4, "Reptile", 60);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 2;
        int actual = game.round(player2.getName(), player3.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifPlayersEqualInStrength() {
        Player player1 = new Player(1, "Sub-Zero", 80);
        Player player2 = new Player(2, "Scorpion", 80);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round(player1.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenPlayerIsNotRegistered() {
        Player player1 = new Player(1, "Sub-Zero", 80);
        Player player2 = new Player(2, "Scorpion", 80);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () ->
        {
            game.round(player1.getName(), "Unregistered");
        });
    }

    @Test
    public void whenAllPlayersIsNotRegistered() {

        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () ->
        {
            game.round("Unregistered1", "Unregistered2");
        });
    }
}
