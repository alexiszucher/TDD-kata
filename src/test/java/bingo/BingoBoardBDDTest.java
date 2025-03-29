package bingo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BingoBoardBDDTest {
    BingoBoard board;

    @Test
    void aNewlyCreatedBoardIsNotInitialized() {
        givenBingoBoardOfSize(1, 1);
        thenBoardIsNotInitialized();
    }

    @Test
    void whenAllFieldsAreSetTheBoardIsInitialized() {
        String anyValue = "42";
        givenBingoBoardOfSize(1, 1);
        whenCellIsDefined(0, 0, anyValue);
        thenBoardIsInitialized();
    }

    @Test
    void whenAllFieldsOnRectangularBoardAreSetItIsInitialized() {
        String one = "one, two, three";
        String two = "Bingo cells can contain any text";
        givenBingoBoardOfSize(1, 2);
        whenCellIsDefined(0, 0, one);
        whenCellIsDefined(0, 1, two);
        thenBoardIsInitialized();
    }

    @Test
    void aDefinedCellCantBeRedefinedEvenIfItsTheSameValue() {
        String anyValue = "42";
        givenBingoBoardOfSize(1, 1);
        whenCellIsDefined(0, 0, anyValue);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> whenCellIsDefined(0, 0, anyValue));
        Assertions.assertEquals(exception.getMessage(), "cell already defined");
    }

    @Test
    void duplicateCellsAreNotAllowed() {
        String anyValue = "42";
        givenBingoBoardOfSize(2, 2);
        whenCellIsDefined(0, 1, anyValue);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> whenCellIsDefined(1, 0, anyValue));
        Assertions.assertEquals(exception.getMessage(), anyValue + " already present at 0,1");
    }

    @Test
    void aNonInitializedBoardCannotBeMarked() {
        givenBingoBoardOfSize(1, 1);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> whenCellIsMarked(0, 0));
        Assertions.assertEquals(exception.getMessage(), "board not initialized");
    }

    @Test
    void whenAllCellGetsMarkedItIsMarked() {
        String anyValue = "42";
        givenBingoBoardOfSize(1, 1);
        whenCellIsDefined(0, 0, anyValue);
        whenCellIsMarked(0, 0);
        thenCellIsMarked(0, 0);
    }

    void givenBingoBoardOfSize(int width, int height) {
        board = new BingoBoard(width, height);
    }

    void whenCellIsDefined(int x, int y, String value) {
        board.defineCell(x, y, value);
    }

    void whenCellIsMarked(int x, int y) {
        board.markCell(x, y);
    }

    void thenBoardIsNotInitialized() {
        assertFalse(boardInitializeState());
    }

    void thenBoardIsInitialized() {
        assertTrue(boardInitializeState());
    }

    boolean boardInitializeState() {
        return board.isInitialized();
    }

    void thenCellIsMarked(int x, int y) {
        assertTrue(board.isMarked(x, y));
    }

}
