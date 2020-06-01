package ru.job4j.chess.firuges.black;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;


public class BishopBlackTest {

    @Test
    public void checkPosition() {
        Cell e2 = Cell.E2;
        BishopBlack bishopBlack = new BishopBlack(e2);
        assertThat(bishopBlack.position(), is(e2));
    }

    @Test
    public void checkCopy() {
        Cell e4 = Cell.E4;
        Figure bishopBlack = new BishopBlack(Cell.E2).copy(e4);
        assertThat(bishopBlack.position(), is(e4));
    }

    @Test
    public void checkWayC1G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] wayCells = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expectedCells = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(wayCells, is(expectedCells));
    }

    @Test
    public void checkWayG5C1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Cell[] wayCells = bishopBlack.way(Cell.G5, Cell.C1);
        Cell[] expectedCells = {Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(wayCells, is(expectedCells));
    }

    @Test
    public void checkWayB8E5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B8);
        Cell[] wayCells = bishopBlack.way(Cell.B8, Cell.E5);
        Cell[] expectedCells = {Cell.C7, Cell.D6, Cell.E5};
        assertThat(wayCells, is(expectedCells));
    }

    @Test
    public void checkWayE5B8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E5);
        Cell[] wayCells = bishopBlack.way(Cell.E5, Cell.B8);
        Cell[] expectedCells = {Cell.D6, Cell.C7, Cell.B8};
        assertThat(wayCells, is(expectedCells));
    }

    @Test
    public void whenIsDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E5);
        boolean diagonal = bishopBlack.isDiagonal(Cell.E5, Cell.B8);
        assertThat(diagonal, is(true));
    }

    @Test
    public void whenIsNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E5);
        boolean diagonal = bishopBlack.isDiagonal(Cell.E5, Cell.B7);
        assertThat(diagonal, is(false));
    }

    @Test(expected = IllegalStateException.class)
    public void checkIllegalStateExceptionE2E4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E2);
        Cell[] wayCells = bishopBlack.way(Cell.E2, Cell.E4);
        Cell[] expectedCells = {Cell.E3, Cell.E4};
    }

    @Test(expected = IllegalStateException.class)
    public void whenIllegalStateExceptionC1G6() {
        Cell source = Cell.C1;
        Cell dest = Cell.G6;
        BishopBlack bishopBlack = new BishopBlack(source);
        bishopBlack.way(source,dest);
    }

}
