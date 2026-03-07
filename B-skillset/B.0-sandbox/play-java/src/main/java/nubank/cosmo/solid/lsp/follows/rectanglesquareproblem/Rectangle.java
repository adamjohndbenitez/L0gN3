package nubank.cosmo.solid.lsp.follows.rectanglesquareproblem;

public class Rectangle implements Shape {

    protected int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // ? cannot access these setters ? when i implement Shape interface.
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}
