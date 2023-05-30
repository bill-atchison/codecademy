namespace ArchitectArithmetic
{
    internal class Program
    {
        static void Main(string[] args)
        {
            const double flooringCost = 180;

            double rectArea = RectangleArea(2500, 1500);
            double circleArea = CircleArea(375);
            double triangleArea = TriangleArea(750, 500);
            double totalArea = rectArea + circleArea + triangleArea;    
            double totalCost = totalArea * flooringCost;

            Console.WriteLine($"Rectangle Area: {rectArea}");
            Console.WriteLine($"Circle Area: {circleArea}");
            Console.WriteLine($"Triangle Area: {triangleArea}");
            Console.WriteLine($"Total Area: {totalArea}");
            Console.WriteLine($"Total Cost: {Math.Round(totalCost,2)} pesos");
        }

        static double RectangleArea(double length, double width)
        {
            return length * width;
        }

        static double CircleArea(double radius)
        {
            return Math.PI * Math.Pow(radius, 2);   
        }

        static double TriangleArea(double bottom, double height)
        {
            return 0.5 * bottom * height;
        }


    }
}