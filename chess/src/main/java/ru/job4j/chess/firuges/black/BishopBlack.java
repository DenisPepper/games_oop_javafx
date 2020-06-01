package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int x = source.x;
        int deltaX = source.x < dest.x ? 1 : -1;
        int y = source.y;
        int deltaY = source.y < dest.y ? 1 : -1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x += deltaX, y += deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {

        int absX = Math.abs(dest.x - source.x);
        int absY = Math.abs(dest.y - source.y);
        return absX == absY && absX*absY != 0;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
