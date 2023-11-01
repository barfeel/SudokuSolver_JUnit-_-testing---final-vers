package test;


import nl.elridge.sudoku.controller.ButtonController;
import nl.elridge.sudoku.controller.SudokuController;
import nl.elridge.sudoku.model.Game;
import nl.elridge.sudoku.view.SudokuPanel;
import org.junit.Assert;
import org.junit.Test;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.awt.event.ActionEvent.ACTION_PERFORMED;
import static java.awt.event.MouseEvent.MOUSE_CLICKED;
import static org.junit.Assert.*;


public class ControllerClassesTests {

    @Test
    public void TestActionPerformed() {
        Game game = new Game();
        ButtonController buttonController = new ButtonController(game);
        // if Action Command = "New"
        ActionEvent event = new ActionEvent(this, ACTION_PERFORMED, "New");
        String CommandName = event.getActionCommand();
        buttonController.actionPerformed(event);
        assertEquals(CommandName, "New");

        // if Action command = "Check"
        ActionEvent event1 = new ActionEvent(this, ACTION_PERFORMED, "Check");
        String CommandName1 = event1.getActionCommand();
        buttonController.actionPerformed(event1);
        assertEquals(CommandName1, "Check");

    }

    @Test
    public void testActionPerformed() {

        Game game = new Game();
        ButtonController controller = new ButtonController(game);


        ActionEvent newEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "New");
        ActionEvent checkEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Check");
        JCheckBox helpCheckBox = new JCheckBox("Help on");
        ActionEvent helpEvent = new ActionEvent(helpCheckBox, ActionEvent.ACTION_PERFORMED, "Help on");
        ActionEvent numberEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "5");

        controller.actionPerformed(newEvent);
        String commandNew = newEvent.getActionCommand();
        assertEquals(commandNew , "New");

        controller.actionPerformed(checkEvent);
        String commandCheck = checkEvent.getActionCommand();
        assertEquals(commandCheck , "Check");


        controller.actionPerformed(helpEvent);
        String commandHelp = helpEvent.getActionCommand();
        assertEquals(commandHelp,"Help on");


        controller.actionPerformed(numberEvent);
        String number = numberEvent.getActionCommand();
        assertEquals(number,"5");
    }



    @Test
    public void TestHelpOnOff(){
        Game game = new Game();
        game.newGame();
        game.setHelp(true);
        Assert.assertTrue(game.isHelp());


     // Turn off test
        game.setHelp(false);
        assertFalse(game.isHelp());




    }





    @Test
    public void TestMouseClickedWithValidCoordinates() {
        Game game = new Game();
        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        MouseEvent event = new MouseEvent(sudokuPanel, MOUSE_CLICKED,
                System.currentTimeMillis(), 0,
                50, 50, 1, false);
        sudokuController.mouseClicked(event);
        assertNotNull(event);


    }

    @Test
    public void TestMouseClickedWithInvalidCoordinates() {
        Game game = new Game();
        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        MouseEvent event = new MouseEvent(sudokuPanel, MOUSE_CLICKED,
                System.currentTimeMillis(), 0,
                500, 500, 1, false);

        sudokuController.mouseClicked(event);
        assertNotNull(event.getClickCount());
    }

    @Test
    public void TestMouseEntered() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Game game = new Game();
        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        MouseEvent event = new MouseEvent(sudokuPanel, MouseEvent.MOUSE_ENTERED,
                System.currentTimeMillis(), 0,
                10, 10, 0, false);

        Method method = SudokuController.class.getDeclaredMethod("mouseEntered", MouseEvent.class);

        method.invoke(sudokuController, event);
        assertNotNull(event);

    }

    @Test
    public void TestMouseExited() {
        Game game = new Game();
        SudokuPanel sudokuPanel = new SudokuPanel();
        SudokuController sudokuController = new SudokuController(sudokuPanel, game);
        JPanel panel = new JPanel();
        MouseEvent event = new MouseEvent(sudokuPanel, MouseEvent.MOUSE_EXITED,
                System.currentTimeMillis(), 0,
                10, 10, 0, false);
        sudokuController.mouseExited(event);

    }


}
