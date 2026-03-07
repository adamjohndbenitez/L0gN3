package nubank.cosmo.solid.lsp.follows.rectanglesquareproblem;

import nubank.cosmo.solid.lsp.violates.rectanglesquareproblem.Rectangle;

public class Square implements Shape {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    // this method cannot be access because of reference type Shape is only contracted to getArea() method
    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}
