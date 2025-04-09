/*

Factory is a design pattern in common usage. Implement a ShapeFactory that can generate correct shape.
You can assume that we have only tree different shapes: Triangle, Square and Rectangle.

Example
    ShapeFactory sf = new ShapeFactory();
    Shape shape = sf.getShape("Square");
    shape.draw();
    >>  ----
    >> |    |
    >> |    |
    >>  ----

    shape = sf.getShape("Triangle");
    shape.draw();
    >>   /\
    >>  /  \
    >> /____\

    shape = sf.getShape("Rectangle");
    shape.draw();
    >>  ----
    >> |    |
    >>  ----

*/


    interface Shape {
        void draw();
    }

    class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println(" ---- ");
            System.out.println("|    |");
            System.out.println(" ---- ");
       }
    }

    class Square implements Shape {
       @Override
       public void draw() {
            System.out.println(" ---- ");
            System.out.println("|    |");
            System.out.println("|    |");
            System.out.println(" ---- ");
       }
    }

    class Triangle implements Shape {
       @Override
       public void draw() {
            System.out.println("  /\\");
            System.out.println(" /  \\");
            System.out.println("/____\\");
       }
    }

    public class ShapeFactory {

        public Shape getShape(String shapeType) {
            if (shapeType == null) {
                return null;
            }       
            if (shapeType.equalsIgnoreCase("Triangle")) {
                return new Triangle();
            } else if(shapeType.equalsIgnoreCase("Rectangle")) {
                return new Rectangle();         
            } else if(shapeType.equalsIgnoreCase("Square")) {
                return new Square();
            } else return null;
        }
    }
