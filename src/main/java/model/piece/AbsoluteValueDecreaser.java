package model.piece;

public final class AbsoluteValueDecreaser {

    public static int decreaseOne(final int number) {
        return decrease(number, 1);
    }

    public static int decrease(final int number, final int amount) {
        if (number < 0) {
            return number + amount;
        }
        return number - amount;
    }
}
