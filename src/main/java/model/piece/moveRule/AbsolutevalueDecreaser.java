package model.piece.moveRule;

public class AbsolutevalueDecreaser {

    public static int decreaseOne(final int number) {
        if (number < 0) {
            return number + 1;
        }
        if (number > 0) {
            return number - 1;
        }
        return number;
    }

}
