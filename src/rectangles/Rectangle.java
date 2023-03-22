package rectangles;

import java.util.Objects;

public class Rectangle implements Comparable<Rectangle> {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Math.min(width, height) == Math.min(rectangle.width, rectangle.height)
            && Math.max(width, height) == Math.max(rectangle.width, rectangle.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.min(width, height), Math.max(width, height));
    }

    @Override
    public String toString() {
        return "Rectangle: " + width + ", " + height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Rectangle o) {
        int lowerValComparison = Integer.compare(Math.min(width, height), Math.min(o.width, o.height));
        if(lowerValComparison == 0)
            return Integer.compare(Math.max(width, height), Math.max(o.width, o.height));
        return lowerValComparison;
    }
}
