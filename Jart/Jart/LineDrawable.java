// Line.java
public class Line implements Drawable {
    private final Point a;
    private final Point b;
    private final Color color;

    public Line(Point a, Point b) {
        this(a, b, Color.BLUE);
    }

    public Line(Point a, Point b, Color color) {
        if (a == null || b == null) throw new IllegalArgumentException("Points must not be null");
        if (a.getX() == b.getX() && a.getY() == b.getY()) {
            throw new IllegalArgumentException("Line endpoints must be different");
        }
        this.a = a;
        this.b = b;
        this.color = color == null ? Color.BLUE : color;
    }

    public static Line random(int maxWidth, int maxHeight) {
        Point p1 = Point.random(maxWidth, maxHeight);
        Point p2;
        do {
            p2 = Point.random(maxWidth, maxHeight);
        } while (p1.getX() == p2.getX() && p1.getY() == p2.getY());
        return new Line(p1, p2);
    }

    @Override
    public void draw(Displayable displayable) {
        int x0 = a.getX();
        int y0 = a.getY();
        int x1 = b.getX();
        int y1 = b.getY();

        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            displayable.display(x0, y0, getColor());
            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
