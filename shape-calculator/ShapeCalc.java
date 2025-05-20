/* 
* Program to calculate area of a rectangle and volumes of shapes
* It uses classes and methods to organize the calculations
* It also handles user input and displays results
*/

import java.util.Scanner;

public class ShapeCalc {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean keepRunning = true;
        
        // welcome message
        System.out.println("Shape Calculator Program");
        
        // main program loop
        while (keepRunning) {
            showMenu();
            
            // get user selection
            int choice = 0;
            try {
                choice = in.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number!");
                in.nextLine(); // clear bad input
                continue;
            }
            
            // handle user choice
            switch (choice) {
                case 1:
                    doRectangle(in);
                    break;
                case 2:
                    doSphere(in);
                    break;  
                case 3:
                    doCylinder(in);
                    break;
                case 4:
                    doCube(in);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        
        in.close();
    }
    
    // displays the menu options
    static void showMenu() {
        System.out.println("\nWhat would you like to calculate?");
        System.out.println("1. Rectangle Area");
        System.out.println("2. Sphere Volume");
        System.out.println("3. Cylinder Volume");  
        System.out.println("4. Cube Volume");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }
    
    // handles rectangle area calculation
    static void doRectangle(Scanner in) {
        try {
            System.out.print("Enter length: ");
            double l = in.nextDouble();
            
            System.out.print("Enter width: ");
            double w = in.nextDouble();
            
            // check for positive values
            if (l <= 0 || w <= 0) {
                System.out.println("Measurements must be positive!");
                return;
            }
            
            // create rectangle and get area
            Rectangle r = new Rectangle(l, w);
            double area = r.getArea();
            
            System.out.println("The rectangle area is: " + area);
            
        } catch (Exception e) {
            System.out.println("Input error! Try again.");
            in.nextLine(); // clear bad input
        }
    }
    
    // handles sphere volume calculation
    static void doSphere(Scanner in) {
        try {
            System.out.print("Enter radius: ");
            double r = in.nextDouble();
            
            // check for positive radius
            if (r <= 0) {
                System.out.println("Radius must be positive!");
                return;
            }
            
            // create sphere and get volume
            Sphere s = new Sphere(r);
            double vol = s.getVolume();
            
            System.out.println("The sphere volume is: " + vol);
            
        } catch (Exception e) {
            System.out.println("Input error! Try again.");
            in.nextLine(); // clear bad input
        }
    }
    
    // handles cylinder volume calculation
    static void doCylinder(Scanner in) {
        try {
            System.out.print("Enter radius: ");
            double r = in.nextDouble();
            
            System.out.print("Enter height: ");
            double h = in.nextDouble();
            
            // check for positive values
            if (r <= 0 || h <= 0) {
                System.out.println("Measurements must be positive!");
                return;
            }
            
            // create cylinder and get volume
            Cylinder c = new Cylinder(r, h);
            double vol = c.getVolume();
            
            System.out.println("The cylinder volume is: " + vol);
            
        } catch (Exception e) {
            System.out.println("Input error! Try again.");
            in.nextLine(); // clear bad input
        }
    }
    
    // handles cube volume calculation
    static void doCube(Scanner in) {
        try {
            System.out.print("Enter side length: ");
            double s = in.nextDouble();
            
            // check for positive side
            if (s <= 0) {
                System.out.println("Side length must be positive!");
                return;
            }
            
            // create cube and get volume
            Cube c = new Cube(s);
            double vol = c.getVolume();
            
            System.out.println("The cube volume is: " + vol);
            
        } catch (Exception e) {
            System.out.println("Input error! Try again.");
            in.nextLine(); // clear bad input
        }
    }
}

// Rectangle class - calculates area
class Rectangle {
    // fields for dimensions
    double length;
    double width;
    
    // constructor
    Rectangle(double l, double w) {
        length = l;
        width = w;
    }
    
    // calculate area
    double getArea() {
        return length * width;
    }
}

// Sphere class - calculates volume
class Sphere {
    // field for dimension
    double radius;
    
    // constructor
    Sphere(double r) {
        radius = r;
    }
    
    // calculate volume
    double getVolume() {
        // formula: (4/3) * pi * r^3
        return (4.0/3.0) * 3.14159 * radius * radius * radius;
    }
}

// Cylinder class - calculates volume
class Cylinder {
    // fields for dimensions
    double radius;
    double height;
    
    // constructor
    Cylinder(double r, double h) {
        radius = r;
        height = h;
    }
    
    // calculate volume
    double getVolume() {
        // formula: pi * r^2 * h
        return 3.14159 * radius * radius * height;
    }
}

// Cube class - calculates volume
class Cube {
    // field for dimension
    double side;
    
    // constructor
    Cube(double s) {
        side = s;
    }
    
    // calculate volume
    double getVolume() {
        // formula: side^3
        return side * side * side;
    }
}