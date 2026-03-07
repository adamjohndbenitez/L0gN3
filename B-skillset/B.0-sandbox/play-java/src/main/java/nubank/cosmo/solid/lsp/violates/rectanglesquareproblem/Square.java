package nubank.cosmo.solid.lsp.violates.rectanglesquareproblem;

public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = this.height = width; // In Java, the expression width = height = w; is valid. Here's how it Works: Assignment in Java is right-to-left. So height = assigns the value of w to height , and then width = (height = w) assigns the result (which is w) to Width as well. So both width and height end up with the value ofw. It's a shorthand way to set both variables to the same value in one line.
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }
}
