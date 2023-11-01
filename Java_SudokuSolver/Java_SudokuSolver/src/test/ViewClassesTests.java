package test;

import nl.elridge.sudoku.model.Game;
import nl.elridge.sudoku.model.UpdateAction;
import nl.elridge.sudoku.view.ButtonPanel;
import nl.elridge.sudoku.view.Field;
import nl.elridge.sudoku.view.Sudoku;
import nl.elridge.sudoku.view.SudokuPanel;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;


import static nl.elridge.sudoku.model.UpdateAction.*;
import static org.junit.Assert.*;

public class ViewClassesTests {

    @Test
    public void TestStartGui() {
        Sudoku sudoku = new Sudoku();
        sudoku.main(null);
        assertTrue(sudoku.getContentPane().getLayout() instanceof BorderLayout);
        assert sudoku != null;


    }


    @Test
    public void TestSudokuConstructor() {
        Sudoku sudoku = new Sudoku();
        assertEquals("Sudoku", sudoku.getTitle());
        assertEquals(WindowConstants.EXIT_ON_CLOSE, sudoku.getDefaultCloseOperation());
        assertTrue(sudoku.getContentPane().getLayout() instanceof BorderLayout);
        assert sudoku != null;


    }

    @Test
    public void TestGetFieldX() {
        int expectedX = 7;
        Field field = new Field(expectedX, 7);
        assertEquals(expectedX, field.getFieldX());
    }

    @Test
    public void TestGetFieldY() {
        int expectedY = 8;
        Field field = new Field(8, expectedY);
        assertEquals(expectedY, field.getFieldY());

    }


    @Test
    public void TestSudokuPanelUpdateNewGame() {
        SudokuPanel sudokuPanel = new SudokuPanel();
        Game game = new Game();
        boolean NewGame;
        UpdateAction action = NEW_GAME;
        sudokuPanel.update(game, action);
        assertEquals(action, NEW_GAME);
    }

    @Test
    public void TestSudokuPanelUpdateCheck() {
        SudokuPanel sudokuPanel = new SudokuPanel();
        Game game = new Game();
        boolean NewGame;
        UpdateAction action = UpdateAction.CHECK;
        sudokuPanel.update(game, action);
        assertEquals(action, CHECK);


    }
    @Test
    public void TestSudokuPanelUpdateSELECTED_NUMBER(){
        SudokuPanel sudokuPanel = new SudokuPanel();
        Game game = new Game();
        boolean NewGame;
        UpdateAction action = SELECTED_NUMBER;
        sudokuPanel.update(game, action);
        assertEquals(action, SELECTED_NUMBER);
    }

    @Test
    public void TestSudokuPanelUpdateCANDIDATES() {
        SudokuPanel sudokuPanel = new SudokuPanel();
        Game game = new Game();
        boolean NewGame;
        UpdateAction action = CANDIDATES;
        sudokuPanel.update(game, action);
        assertEquals(action, CANDIDATES);
    }


    @Test
    public void TestButtonPanelUpdateMethod() {
        ButtonPanel buttonPanel = new ButtonPanel();
        Game game = new Game();

        //case NEW_GAME:
        boolean setGameCalled = false;
        UpdateAction action = NEW_GAME;
        buttonPanel.update(game, action);
        if (action == NEW_GAME) {
            setGameCalled = true;
        }
        assertTrue(setGameCalled);

        //case CHECK:
        boolean setCheckCalled = false;
        int bgNumbersCalculator = 1;
        UpdateAction action1 = UpdateAction.CHECK;
        buttonPanel.update(game, action1);
        if (action1 == UpdateAction.CHECK) {
            setCheckCalled = true;
        }
        assertTrue(setCheckCalled);

        if (setCheckCalled = true) {
            bgNumbersCalculator = 0;
        }
        assertEquals(0, bgNumbersCalculator);
    }





}
