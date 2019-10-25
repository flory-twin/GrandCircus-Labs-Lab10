package co.grandcircus;

public class Circle
{
   private double radius;
   
   private static String formatNumber(double x) {
      return String.format("%.2f", x);
   }
   
   public Circle() {
      radius = 0.0;
   }
   
   public Circle(double radius) {
      if (radius >= 0.0) {
         this.radius = radius; 
      } else {
         this.radius = 0.0;
      }
   }
   
   public double getCircumference() {
      return 2 * Math.PI * radius;
   }
   
   public double getArea() {
      return Math.PI * Math.pow(radius, 2.0);
   }
   
   public String getFormattedCircumference() {
      return "Circumference: " + formatNumber(getCircumference());
   }
   
   public String getFormattedArea() {
      return "Area: " + formatNumber(getArea());
   }
   
   public String toString() {
      return getFormattedCircumference() + "\n" + 
             getFormattedArea() + "\n";
   }
}
