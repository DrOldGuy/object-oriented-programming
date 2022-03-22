# Object-Oriented Programming
This project contains commented classes that demonstrate the principles of object-oriented programming. Start with the PowerPoint presentation in the project root: "The Shape of OOP.pptx". This will orient you to the project. 

You can also take a look at StackHeapDemo.drawio. (You will need Draw.io to view this file.) This file shows the relationship between the stack and the heaps, and how Java objects are stored in memory.

# Object-Oriented Principles
This project demonstrates the four principles of Object-Oriented Programming: abstraction, encapsulation, inheritance and polymorphism.

## Abstraction
Each concrete class (a class that can create objects with the new operator) represents a shape: a triangle, a rectangle and a square. Each concrete class is an abstraction of the associated shape. For example, the Triangle class does not contain all the attributes of a triangle; only the lengths of the sides. Other attributes that  _could_  be modeled include angles of the sides, line color, fill color, etc. So, the Triangle class is  _not_  a triangle; it is an abstraction of a triangle. It contains only the attributes we are interested in for this project, namely, the lengths of the sides.

## Encapsulation
Encapsulation is data hiding, or as I like to say, "hiding the dirty laundry." An example is the SideInfo class. It has private instance variables with public getters. Since the instance variables are not exposed, the SideInfo class is free to store them or manipulate them in any way it wants. This is encapsulation.

## Inheritance
The inheritance chain of the classes in this project is: Shape <-- BaseShape <-- Rectangle <-- Square. Inheritance allows a child class to utilize a method (or variable) defined in a parent class without redefining it in the child class.

How does this work? A Square object is created with the new operator and assigned to a variable of type Shape. The JVM knows that all abstract methods have been satisfied (i.e., implemented with a method body) because an object has been created. (It is not possible to create an object unless all abstract methods have method bodies.) Let's say that the area() method is called on a Square object. The JVM starts at the Square class to see if there is an area method. There is not so it moves up the inheritance chain to see if an area() method is present on the superclass, the Rectangle. It finds an area method so it calls that one.

## Polymorphism
Polymorphism is the ability of a child class to  _modify_  a method defined in the parent class. So, Inheritance  _utilizes_  a method in the parent class whereas Polymorphism  _modifies_  a method defined in the parent class. This is done by redeclaring a method with the exact same method signature in the child class.

Let's see an example. An object of type Square is assigned to a variable of type BaseShape. The shapeInfo method is called on the variable. (Note: since shapeInfo has protected access, it cannot be called by an outside class. It is called by the describe method in BaseShape, which has public access.) Similar to inheritance, the JVM starts at the farthest point in the inheritance chain (the Square) and checks to see if there is a shapeInfo method defined. There is so the JVM does not check the parent class (Rectangle) to see if there is also a shapeInfo method defined (there is). The shapeInfo method in Square overrides the shapeInfo method in Rectangle. This allows the Square to modify the behavior of Rectangle. This is Polymorphism.

# Using this project
This is an Eclipse project and it contains the .classpath and .project files used by Eclipse. If you use IntelliJ IDEA or another IDE you will need to create the project files applicable to that IDE.

Start with the ShapeDemo class in the shape package. This contains the main method, which creates the various shapes. Use the debugger to step through the describe method. Observe the following:

* The describe method is defined in the BaseShape abstract class. This class also declares the shapeInfo method. When shapeInfo is called on a Square object, the debugger jumps into the shapeInfo method in the Square class. When shapeInfo is called on a Rectangle object, the debugger jumps into the shapeInfo method in the Rectangle class. The Square class uses Polymorphism to redefine the shapeInfo method in its parent class.

* The area method is defined in the Shape interface. When area is called on a Square object, the debugger jumps into the area method in the Rectangle class. This is because the Square uses Inheritance to utilize the area method in its parent class.

That's it! Inheritance is using parent class methods. Polymorphism is modifying parent class methods. Even though the objects are assigned to a Shape variable, the JVM always starts at the end of the inheritance chain to see if a method is present on the class. If it can't find one it moves up the inheritance chain class by class until it finds the method. It  stops at the first one it finds.

# Inheritance and Polymorphism in variables
It makes sense to talk about Inheritance in variables. This is how the Square class can reference width in the shapeInfo method without storing the value. The variable width is in the parent Rectangle class.

Polymorphism  _can_  apply to variables but it is confusing and should not be used in my opinion. Polymorphism with variables means that a variable can have different values depending on the context. This is really confusing and is best avoided.