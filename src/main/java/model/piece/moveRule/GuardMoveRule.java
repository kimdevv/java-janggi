package model.piece.moveRule;

import model.piece.position.Position;

public class GuardMoveRule extends OnlyInPalaceMoveRule {

    public GuardMoveRule(final Position position) {
        super(position);
    }

}
