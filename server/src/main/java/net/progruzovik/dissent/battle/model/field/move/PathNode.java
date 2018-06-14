package net.progruzovik.dissent.battle.model.field.move;

import net.progruzovik.dissent.battle.model.util.Cell;
import org.springframework.lang.NonNull;

public final class PathNode {

    private final int movementCost;
    private final @NonNull Cell cell;

    public PathNode(int movementCost, @NonNull Cell cell) {
        this.movementCost = movementCost;
        this.cell = cell;
    }

    public int getMovementCost() {
        return movementCost;
    }

    @NonNull
    public Cell getCell() {
        return cell;
    }
}