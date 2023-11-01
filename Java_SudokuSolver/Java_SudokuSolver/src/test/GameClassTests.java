package test;

import nl.elridge.sudoku.controller.ButtonController;
import nl.elridge.sudoku.model.Game;
import org.junit.Test;
import org.testng.Assert;


import java.awt.event.ActionEvent;
import java.util.Random;

import static java.awt.event.ActionEvent.ACTION_PERFORMED;
import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class GameClassTests {

    @Test
    public void TestNewGame() {
        Game game = new Game();
        ButtonController controller = new ButtonController(game);
        ActionEvent event = new ActionEvent(game, ACTION_PERFORMED, "Exit");
        game.newGame();
        game.checkGame();
        game.setSelectedNumber(2);
        game.getSelectedNumber();
        game.setNumber( 2, 2, 2 );
        Assert.assertEquals( 2, game.getNumber(2,2));



    }




    @Test
    public void TestCheckGame() {
        int[][] game = new int[9][9];
        int[][] solution = new int[9][9];
        boolean[][] check = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                game[i][j] = 0 * 9 + j * 1;
                solution[i][j] = 0 * 9 + j * 1;

            }
        }
        Game g = new Game();
        g.checkGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                check[i][j] = game[i][j] == solution[i][j];
                assertEquals(check[i][j], true);
            }
        }

    }


    @Test
    public void TestIsCheckValid() {
        Game game = new Game();
        int x = 0;
        int y = 0;
        game.setNumber(x,y,2);
        assertFalse(game.isCheckValid(x ,y));

    }

    @Test
    public void SelectedNumberCandidate(){
        Game game = new Game();
        Random random = new Random();
        int x = random.nextInt(9)+0;
        int y = random.nextInt(9)+0;
        int Random = random.nextInt(9)+0;
        //   boolean SelectedNumberIsCandidate;
        game.setNumber(x,y, Random);
        //   SelectedNumberIsCandidate = game.isSelectedNumberCandidate(x,y);
        if (game.isSelectedNumberCandidate(x, y) && game.isCheckValid(x, y)) {
            game.setNumber(x, y, game.getSelectedNumber());
            assertTrue(game.isCheckValid(x, y));
        }else {
            assertFalse(game.isCheckValid(x, y));
        }

        /*
           Parametrizovani test koji ste mi rekli da dodam na konsultacijama

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9 })
        public void isSelectedNumberCandidateValidTrue(int n) {

        game.checkGame();
        game.setSelectedNumber(n);
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (game.isSelectedNumberCandidate(x, y) && game.isCheckValid(x, y)) {
                    game.setNumber(x, y, game.getSelectedNumber());
                    Assertions.assertTrue(game.isCheckValid(x, y));
                }
            }
        }
    }




         */







    }


}
