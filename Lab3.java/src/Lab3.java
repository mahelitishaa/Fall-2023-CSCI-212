public class Lab3 {
    public static void main(String[] args)  {
        float fahrenheit;
        float centigrade;
        fahrenheit = 98.6F; 
        centigrade = (float) 5/9 * (fahrenheit - 32);

        System.out.println("The degree in Fahrenheit is " + fahrenheit);
        System.out.println("The degree in Centigrade is " + centigrade);

        System.out.println("\nFahrenheit to Centigrade Conversion Table:");
        for (int f = 0; f <= 40; f += 5) {
            centigrade = (float) 5/9 * (f - 32);
            System.out.println(f + " Fahrenheit= " + centigrade + " Centigrade");
        }

        // Reset fahrenheit and use a while loop
        fahrenheit = 0;
        while (fahrenheit <= 40) {
            centigrade = (float) 5/9 * (fahrenheit - 32);
            System.out.println(fahrenheit + " Fahrenheit= " + centigrade + " Centigrade");
            fahrenheit += 5;
        }
    }
}

