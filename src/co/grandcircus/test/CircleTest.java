package co.grandcircus.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.grandcircus.Circle;

class CircleTest
{
   
   @Test
   void testGetArea() {
      // Failure cases...while these should never arise due to input validation, just in case...
      double radius = -1.0;
      Circle underTest = new Circle(radius);
      // For doubles, use the assertion form 'assertEquals(double left, double right, double delta, String failureMessage)'
      assertEquals(0, underTest.getArea(), 0.00001, "A malformed circle with radius -1 should have had area 0.");
      radius = 0.0;
      underTest = new Circle(radius);
      assertEquals(0, underTest.getArea(), 0.00001, "A malformed circle with radius 0 should have had area 0.");
      
      // Well-formed circles
      radius = 0.5;
      underTest = new Circle(radius);
      double expectedArea = 0.78539;
      assertEquals(expectedArea, 
            underTest.getArea(),
            0.00001,
            "A well-formed circle with radius " + radius + " should have had area " + expectedArea);
      radius = 1.0;
      underTest = new Circle(radius);
      double expectedArea = 3.14159;
      assertEquals(expectedArea, 
            underTest.getArea(),
            0.00001,
            "A well-formed circle with radius 1 should have had area " + expectedArea);
      radius = 2.0;
      underTest = new Circle(radius);
      double expectedArea = 12.56636;
      assertEquals(expectedArea, 
            underTest.getArea(),
            0.00001,
            "A well-formed circle with radius " + radius + " should have had area " + expectedArea);
   }

   @Test
   void testGetCircumference() {
      // Failure cases...while these should never arise due to input validation, just in case...
      double radius = -1.0;
      Circle underTest = new Circle(radius);
      
      assertEquals(0, underTest.getCircumference(), 0.00001, "A malformed circle with radius -1 should have had circumference 0.");
      radius = 0.0;
      underTest = new Circle(radius);
      assertEquals(0, underTest.getCircumference(), 0.00001, "A malformed circle with radius 0 should have had circumference 0.");
      
      // Well-formed circles
      radius = 0.5;
      underTest = new Circle(radius);
      double expectedCircumference = 3.14159;
      assertEquals(expectedCircumference, 
            underTest.getCircumference(),
            0.00001,
            "A well-formed circle with radius " + radius + " should have had circumference " + expectedCircumference);
      radius = 1.0;
      underTest = new Circle(radius);
      double expectedCircumference = 6.28318;
      assertEquals(expectedCircumference, 
            underTest.getCircumference(),
            0.00001,
            "A well-formed circle with radius 1 should have had circumference " + expectedCircumference);
      radius = 2.0;
      underTest = new Circle(radius);
      double expectedCircumference = 12.56636;
      assertEquals(expectedCircumference, 
            underTest.getCircumference(),
            0.00001,
            "A well-formed circle with radius " + radius + " should have had circumference " + expectedCircumference);

   }
   
   @Test
   //getFormattedCircumference()
   void testGetFormattedCircumference()
   {
      // Failure cases...while these should never arise due to input validation, just in case...
      double radius = -1.0;
      Circle underTest = new Circle(radius);
      
      assertEquals("Circumference: 0.00", 
            underTest.getFormattedCircumference(), 
            "A malformed circle with radius -1 should have formatted its circumference as 0.00.");
      radius = 0.0;
      underTest = new Circle(radius);
      assertEquals("Circumference: 0.00", 
            underTest.getFormattedCircumference(), 
            "A malformed circle with radius 0 should have formatted its circumference as 0.00.");
      
      // Well-formed circle
      radius = 1.0;
      underTest = new Circle(radius);
      assertEquals("Circumference: 6.28", 
            underTest.getFormattedCircumference(),
            "A well-formed circle with radius 1 should have had circumference 6.28.");
   }

   @Test
   //getFormattedCircumference()
   void testGetFormattedArea()
   {
      // Failure cases...while these should never arise due to input validation, just in case...
      double radius = -1.0;
      Circle underTest = new Circle(radius);
      
      assertEquals("Area: 0.00", 
            underTest.getFormattedArea(), 
            "A malformed circle with radius -1 should have formatted its area as 0.00.");
      radius = 0.0;
      underTest = new Circle(radius);
      assertEquals("Area: 0.00", 
            underTest.getFormattedArea(), 
            "A malformed circle with radius 0 should have formatted its area as 0.00.");
      
      // Well-formed circle
      radius = 1.0;
      underTest = new Circle(radius);
      assertEquals("Area: 3.14", 
            underTest.getFormattedArea(),
            "A well-formed circle with radius 1 should have had area 3.14.");
   }

}
