# Shapes! _The Lab_

You've probably used calculators like Desmos or Geogebra in math class--or perhaps even more complex tools for 3D
modeling, like TinkerCAD or Fusion360 (or something else). All of these programs rely heavily on object-oriented
design patterns. In this lab you will demonstrate your understanding of these same OOP principles to build the
"brains" of a simple geometry calculator.

## Structure

This project has two main parts--the main geometry classes and the underlying vector class. These work together
to perform the necessary calculations.

### Vector Class

The `PlaneVector` class contains several functions for operating on 2D vectors. Hopefully you'll remember these from math class.
In case you don't, here is a simple definition:

> [!NOTE]
> A **vector** is a mathematical object with both _magnitude_ and _direction_.

Although, in practice, we often use vector to mean any ordered tuple. Since we're in 2D for this project, we will be working with 2D vectors represented as ordered pairs. For example, the vector in the image below represents the vector $\textbf{u} = <3, 4>$

<p align="center">
    <img src = "img/vector1.png" width = 300>
</p>

We call the elements of this pair the x- and y- _components_

In the `PlaneVector` class, the components are represented by an _immutable_ `Pair<Double, Double>`

#### Functions

The `PlaneVector` class contains the following functions which you should implement:

Assume vectors $\textbf{u} = <u_x, u_y>$ and $\textbf{v} = <v_x, v_y>$:

| Function | Meaning | Computation |
| --- | --- | --- |
| `u.x()` | x-component of $\textbf{u}$ | $u_x$ |
| `u.y()` | y-component of $\textbf{u}$ | $u_y$ |
| `u.r()` | magnitude of $\textbf{u}$ | $\sqrt{u_x^2 + u_y^2}$ |
| `u.theta()` | angle of $\textbf{u}$ from the positive x-axis | $atan2(u_y,\ u_x)$ |
| `u.plus(v)` | $\textbf{u} + \textbf{v}$ | $\left<u_x + v_x,\ u_y + v_y\right>$ |
| `u.minus(v)` | $\textbf{u} - \textbf{v}$ | $\left<u_x - v_x,\ u_y - v_y\right>$ |
| `u.dot(v)` | $\textbf{u} \cdot \textbf{v}$ | $u_x v_x + u_y v_y$ |
| `u.scl(scl)` | $scl \cdot \textbf{u}$ | $\left<scl \cdot u_x,\ scl \cdot u_y\right>$ |
| `u.normSquared()` | $\lVert \textbf{u} \rVert ^2$ | $u_x^2 + u_y^2$ |
| `u.norm()` | $\lVert \textbf{u} \rVert$ | $\sqrt{u_x^2 + u_y^2}$ |
| `u.unitVector()` | $\hat{\textbf{u}}$, a vector in the direction of $\textbf u$ with a magnitude of 1 | $\left<\dfrac{u_x}{\lVert \textbf{u} \rVert},\ \dfrac{u_y}{\lVert \textbf{u} \rVert}\right>$ |
| `u.xComponentVector()` | x-component of $\textbf{u}$ | $\left<u_x,\ 0\right>$ |
| `u.yComponentVector()` | y-component of $\textbf{u}$ | $\left<0,\ u_y\right>$ |
| `u.cross(v)` | $ \textbf{u} \times \textbf{v} $ | $ u_x v_y - u_y v_x $ |
| `u.rotate(alpha)` | $\textbf{u}$ rotated counter-clockwise by $\alpha$ | $(u.r(),\ u.theta() + \alpha)$ |

Note that the `PlaneVector` class is also immutable, so each of these will return a _new_ vector--they do not modify the existing vector.

### Shape Classes

This project contains the following skeleton classes which you must fully implement: `Polygon.java`, `Circle.java`, `Triangle.java`, `Rectangle.java`, and `Square.java`.

For each of those classes, you have been provided with _some_ starter code, including blank functions which must also be fully implemented. For example, here is the stub from `Rectangle.java`:

```java
public class Rectangle extends SimplePolygon {

    public Rectangle(double x, double y, double width, double height) {

    }

    public static Rectangle fromCenter(double cx, double cy, double width, double height) {

    }

    @Override
    public double area() {

    }

    @Override
    public double perimeter() {

    }

}
```

In this class, you should implement the constructor and static factory method. Additionally, you should override the area and perimeter calculations to be a little more direct than the polygon version (i.e. how can you use what you know about a rectangle to make this easier to calculate?).

### Some Helpful Hints

#### Area Computation

The area calculation for any polygon given its vertices is surpisingly easy:

$$A = \frac{1}{2}\sum_{i=0}^{n-1} v_i \times v_{i+1} $$

Where $v_n = v_0$ and "$\times$" is the 2D cross-product operator (from the `PlaneVector` class). In other words, you are crossing each vertex with the next vertex until you get back to the beginning, when you finally cross the last vertex with the first one.

#### PlaneVector Construction

In the `PlaneVector` class, it's a good idea to "eat your own dogfood." You'll notice that the class constructor is _private_. So, from outside the class, they have to be constructed with factory methods specifying $x$ and $y$ _or_ $r$ and $\theta$. It's actually quite helpful to use the factory functions _inside_ the class as well.

If you do this, you can enforce the property that if `u` and `v` are both the vector $\left<0, 0\right>$, then `u.equals(v)` will be `true` _and_ `u == v` will also always be `true`, which is a nice feature.

#### PlaneVector Comparison

You will need to override the `equals(Object o)` function, inherited by `PlaneVector` from the `Object` class. Two vectors are equal if they have the same components (that's not so terrible).

But, if the second vector is `null`, it will be quite hard to check its components (you will get a `NullPointerException` if you try to do something like `o.components` when `o` is `null`). You can fix this by testing `o == null`.

Additionally, when we override an inherited method, its method signature must mach _exactly_. So, we must accept _any_ object as an argument, not just `PlaneVectors`. If we try to access `o.components`, say, we'll get a compiler error since `o` doesn't necessarily have a field called `components`.

You can test if an object is an instance of a class by doing something like `if (o instance of PlaneVector)`. If it's not a `PlaneVector`, obviously it is not equal to `this` one. Once you are sure you're dealing with an instance of a `PlaneVector` you can do a type cast:

```java
PlaneVector pv = (PlaneVector) o;
```

This is guaranteed to succeed as long as you test that `o` is a `PlaneVector` first; othwerise, the _compiler_ will complain at you. Technically, this is just a compmiler _warning_, but we should take these seriously: usually it means you've written some code that isn't quite right!
