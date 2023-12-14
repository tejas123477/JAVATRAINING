

    abstract class Shape {
        public abstract double getArea();
        public abstract String getName();
    }

    // Circle.java
    class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public String getName() {
            return "Circle";
        }
    }

    // Rectangle.java
    class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public String getName() {
            return "Rectangle";
        }
    }

    // Square.java
    class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return side * side;
        }

        @Override
        public String getName() {
            return "Square";
        }
    }

    // App.java
    public class App {
        public static void main(String[] args) {
            Circle circle = new Circle(5);
            System.out.println("Circle - Area: " + circle.getArea() + ", Name: " + circle.getName());

            Rectangle rectangle = new Rectangle(4, 6);
            System.out.println("Rectangle - Area: " + rectangle.getArea() + ", Name: " + rectangle.getName());

            Square square = new Square(3);
            System.out.println("Square - Area: " + square.getArea() + ", Name: " + square.getName());
        }
    }

