
import java.util.Scanner;

class Calculator {

    public double add(double a, double b) {
        double sum;
        sum = a + b;
        return sum;
    }

    public double add(int arr[]) {
        double sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            sum += arr[i];
        }
        return sum;
    }

    public double subtract(double a, double b) {
        double sub;
        sub = a - b;
        return sub;
    }

    public double multiply(double a, double b) {
        double mul;
        mul = a * b;
        return mul;
    }

    public double divide(double a, double b) {
        double div;
        div = a / b;
        return div;
    }

    public double modulo(double a, double b) {
        double mod;
        mod = a % b;
        return mod;
    }

    public double square(double a) {
        double sq;
        sq = a * a;
        return sq;
    }

    public double squareRoot(double a) {
        double sqrt;
        sqrt = Math.sqrt(a);
        return sqrt;
    }

    public double multiInverse(double a) {
        double inv;
        inv = 1 / a;
        return inv;
    }

    public long fact(int num) {
        long sum = 1;
        for(int i=2; i<=num; i++) {
            sum = sum * i;
        }
        return sum;
    }

    public double naturalLog(double a) {
        double nLog;
        nLog = Math.log(a);
        return nLog;
    }

    public double log(double a, int b) {
        double log;
        log = Math.log10(a)/Math.log10(b);
        return log;
    }

    public double nPr(int n, int r) {
        double num = (double)fact(n);
        double den = (double)fact(n-r);
        return num / den;
    }

    public double nCr(int n,int r) {
        double num = (double)fact(n);
        double den = (double)fact(n-r) * (double)fact(r);

        return num / den;
    }

    public double power(double x, int y) {
        double ans = 1;
        long absN = Math.abs((long)y);
        while(absN > 0) {
            if((absN&1)==1)
            {
                ans *= x;
            }
            absN >>= 1;
            x *= x;
        }
        if(y < 0)
        {
            return 1/ans;
        }
        else
        {
            return ans;
        }
    }

    public int romanToInt(String s) {
        int n=0,prev=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='I')
            {
                n=n+1;
                prev=1;
            }
            else if(s.charAt(i)=='V')
            {
                if(prev<5)
                {
                    n=n-2*(prev);
                }
                n+=5;
                prev=5;
            }
            else if(s.charAt(i)=='X')
            {
                if(prev<10)
                {
                    n=n-2*(prev);
                }
                n+=10;
                prev=10;
            }
            else if(s.charAt(i)=='L')
            {
                if(prev<50)
                {
                    n=n-2*(prev);
                }
                n+=50;
                prev=50;
            }
            else if(s.charAt(i)=='C')
            {
                if(prev<100)
                {
                    n=n-2*(prev);
                }
                prev=100;
                n+=100;
            }
            else if(s.charAt(i)=='D')
            {
                if(prev<500)
                {
                    n=n-2*(prev);
                }
                prev=500;
                n+=500;
            }
            else if(s.charAt(i)=='M')
            {
                if(prev<1000)
                {
                    n=n-2*(prev);
                }
                prev=1000;
                n+=1000;
            }
        }
        return n;
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while(num>=2)
        {
            int reminder = num%2;
            sb.append(Integer.toString(reminder));
            num=num/2;
        }
        sb.append(Integer.toString(num));
        sb.reverse();
        return sb.toString();
    }

    public int binaryToDecimal(String binary) {
        StringBuilder sb = new StringBuilder(binary);
        sb.reverse();
        int num = 0;
        for(int i=0;i<sb.length();i++)
        {
            if(sb.charAt(i)=='1')
            {
                num+=power(2,i);
            }
        }
        return num;
    }

    public String hexaToBinary(String hexa) {
        String temp = "0123456789ABCDEF";
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<hexa.length();i++)
        {
            int index = temp.indexOf(hexa.charAt(i));
            String bin = decimalToBinary(index);
            StringBuilder sb = new StringBuilder(bin);
            sb.reverse();
            while(sb.length()!=4)
            {
                sb.append("0");
            }
            sb.reverse();
            ans.append(sb);
        }
        return ans.toString();
    }

    public String binaryToHexa(String binary) {
        String str = "0123456789ABCDEF";
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder(binary);
        sb.reverse();
        int i=0;
        while(i<sb.length())
        {
            int c=0;
            StringBuilder temp = new StringBuilder();
            while(i<sb.length() && c<4)
            {
                temp.append(sb.charAt(i));
                i++;
                c++;
            }
            temp.reverse();
            int n = binaryToDecimal(temp.toString());
            ans.append(str.charAt(n));
        }
        ans.reverse();
        return ans.toString();
    }

    public String decimalToHexa(int num) {
        String str = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        while(num >= 16)
        {
            int reminder = num%16;
            sb.append(str.charAt(reminder));
            num = num / 16;
        }
        sb.append(str.charAt(num));
        sb.reverse();

        return sb.toString();
    }

    public int hexaToDecimal(String hexa) {
        String str = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder(hexa);
        sb.reverse();
        int num = 0;
        for(int i=0;i<sb.length();i++)
        {
            num+=power(16,i)*str.indexOf(sb.charAt(i));
        }
        return num;
    }

    public String octalToBinary(String octal) {
        String temp = "01234567";
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<octal.length();i++)
        {
            int index = temp.indexOf(octal.charAt(i));
            String bin = decimalToBinary(index);
            StringBuilder sb = new StringBuilder(bin);
            sb.reverse();
            while(sb.length()!=3)
            {
                sb.append("0");
            }
            sb.reverse();
            ans.append(sb);
        }
        return ans.toString();
    }

    public String binaryToOctal(String binary) {
        String str = "01234567";
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder(binary);
        sb.reverse();
        int i=0;
        while(i<sb.length())
        {
            int c=0;
            StringBuilder temp = new StringBuilder();
            while(i<sb.length() && c<3)
            {
                temp.append(sb.charAt(i));
                i++;
                c++;
            }
            temp.reverse();
            int n = binaryToDecimal(temp.toString());
            ans.append(str.charAt(n));
        }
        ans.reverse();
        return ans.toString();
    }

    public int octalToDecimal(String octal) {
        String str = "01234567";
        StringBuilder sb = new StringBuilder(octal);
        sb.reverse();
        int num = 0;
        for(int i=0;i<sb.length();i++)
        {
            num+=power(8,i)*str.indexOf(sb.charAt(i));
        }
        return num;
    }

    public String decimalToOctal(int num) {
        String str = "01234567";
        StringBuilder sb = new StringBuilder();
        while(num>=8)
        {
            int reminder = num%8;
            sb.append(str.charAt(reminder));
            num=num/8;
        }
        sb.append(str.charAt(num));
        sb.reverse();
        return sb.toString();
    }

    public String octalToHexa(String octal) {
        String binary = octalToBinary(octal);
        return binaryToHexa(binary);
    }

    public String hexaToOctal(String hexa) {
        String binary = hexaToBinary(hexa);
        return binaryToOctal(binary);
    }

    public double areaOfSquare(double l) {
        double area = l*l;
        return area;
    }

    public double areaOfRactangle(double l, double b) {
        double area = l*b;
        return area;
    }

    public double areaOfCircle(double r) {
        double pi = 3.14;
        double area = pi*r*r;
        return area;
    }

    public double areaOfTriangle(double b,double h) {
        double area = 0.5*b*h;
        return area;
    }

    public double surfaceAreaOfCube(double l) {
        double area = 6*l*l;
        return area;
    }

    public double surfaceAreaOfCylinder(double r,double h) {
        double pi = 3.14;
        double area = 2*pi*r*(r+h);
        return area;
    }

    public double surfaceAreaOfCone(double r,double l) {
        double pi = 3.14;
        double area = pi*r*(r+l);
        return area;
    }

    public double surfaceAreaOfSphere(double r) {
        double pi = 3.14;
        double area = 4*pi*r*r;
        return area;
    }

    public double volumeOfCube(double l) {
        double volume = l*l*l;
        return volume;
    }

    public double volumeOfCylinder(double r,double h) {
        double pi = 3.14;
        double volume = pi*r*r*h;
        return volume;
    }

    public double volumeOfCone(double r, double h) {
        double pi = 3.14;
        double volume = 1/3*pi*r*r*h;
        return volume;
    }

    public double volumeOfSphere(double r) {
        double pi = 3.14;
        double volume = 4/3*pi*r*r*r;
        return volume;
    }
}

class Menus {
    Scanner input = new Scanner(System.in);
    Calculator cal = new Calculator();

    public void performBAriOps() {
        int choice;
        double a, b;

        while(true) {
            System.out.println("\n1. Addition.");
            System.out.println("2. Subtraction.");
            System.out.println("3. Multiplication.");
            System.out.println("4. Division.");
            System.out.println("5. Modulo.");
            System.out.println("6. Square.");
            System.out.println("7. Square root.");
            System.out.println("8. Multiplicative Inverse.");
            System.out.println("0. Exit.");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();

            switch(choice) {
                // Exit
                case 0:
                    return;
                // Addition
                case 1:
                    System.out.print("\nEnter a number : ");
                    a = input.nextDouble();
                    System.out.print("Enter another number : ");
                    b = input.nextDouble();
                    System.out.println("Output (a + b) : " + cal.add(a, b));
                    break;
                // Subtraction
                case 2:
                    System.out.print("\nEnter a number : ");
                    a = input.nextDouble();
                    System.out.println("Enter another number : ");
                    b = input.nextDouble();
                    System.out.println("Output (a - b) : " + cal.subtract(a, b));
                    break;
                // Multiplication
                case 3:
                    System.out.print("\nEnter a number : ");
                    a = input.nextDouble();
                    System.out.print("Enter another number : ");
                    b = input.nextDouble();
                    System.out.println("Output (a * b) : " + cal.multiply(a, b));
                    break;
                // Division
                case 4:
                    System.out.print("\nEnter a number : ");
                    a = input.nextDouble();
                    System.out.print("Enter another number : ");
                    b = input.nextDouble();
                    System.out.println("Output (a / b) : " + cal.divide(a, b));
                    break;
                // Modulo
                case 5:
                    System.out.print("\nEnter a number : ");
                    a = input.nextDouble();
                    System.out.print("Enter another number : ");
                    b = input.nextDouble();
                    System.out.println("Output (a % b) : " + cal.modulo(a, b));
                    break;
                // Square
                case 6:
                    System.out.print("\nEnter a number : ");
                    a = input.nextDouble();
                    System.out.println("Output (a ^ 2) : " + cal.square(a));
                    break;
                // SquareRoot
                case 7:
                    System.out.print("\nEnter a number : ");
                    a = input.nextDouble();
                    System.out.println("Output (sqrt(a)) : " + cal.squareRoot(a));
                    break;
                // Multiplicative Inverse
                case 8:
                    System.out.print("\nEnter a number : ");
                    a = input.nextDouble();
                    System.out.println("Output (1 / a) : " + cal.multiInverse(a));
                    break;
            }
        }
    }

    public void performAAriOps() {
        int choice, x, y, p, q, l, m, n;
        double a, b, c;

        while(true) {
            System.out.println("\n1. Log (Natural).");
            System.out.println("2. Log (base b).");
            System.out.println("3. Factorial.");
            System.out.println("4. Permutations (nPr).");
            System.out.println("5. Combinations (nCr).");
            System.out.println("6. Calculate y th Power of x (x ^ y).");
            System.out.println("0. Exit.");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();

            switch(choice) {
                // Exit
                case 0:
                    return;
                // Natural Log
                case 1:
                    System.out.print("\nEnter a number : ");
                    a = input.nextDouble();
                    System.out.println("Output (log(a)) : " + cal.naturalLog(a));
                    break;
                // Log (base b)
                case 2:
                    System.out.print("\nEnter a number : ");
                    b = input.nextDouble();
                    System.out.print("Enter the base : ");
                    y = input.nextInt();
                    System.out.println("Output (log(a, b)) : " + cal.log(b, y));
                    break;
                // Factorial
                case 3:
                    System.out.print("\nEnter a number : ");
                    x = input.nextInt();
                    System.out.println("Output (n!) : " + cal.fact(x));
                    break;
                // Permutations
                case 4:
                    System.out.print("\nEnter a number : ");
                    p = input.nextInt();
                    System.out.print("Enter another number : ");
                    q = input.nextInt();
                    System.out.println("Output (nPr) : " + cal.nPr(p, q));
                    break;
                // Combinations
                case 5:
                    System.out.print("\nEnter a number : ");
                    l = input.nextInt();
                    System.out.print("Enter another number : ");
                    m = input.nextInt();
                    System.out.println("Output (nCr) : " + cal.nCr(l, m));
                    break;
                // Power
                case 6:
                    System.out.print("\nEnter a number : ");
                    c = input.nextDouble();
                    System.out.print("Enter another number : ");
                    n = input.nextInt();
                    System.out.println("Output (nCr) : " + cal.power(c, n));
                    break;
                default:
                    System.out.println("Wrong input!!!");
                    break;
            }
        }
    }

    public void performConversions() {
        int choice, a;
        String str;

        while(true) {
            System.out.println("\n1. Convert a Roman Number to an Integer.");
            System.out.println("2. Convert an Integer to a Roman Number.");
            System.out.println("3. Decimal to Binary.");
            System.out.println("4. Binary to Decimal.");
            System.out.println("5. HexaDecimal to Binary.");
            System.out.println("6. Binary to HexaDecimal.");
            System.out.println("7. Decimal to HexaDecimal.");
            System.out.println("8. HexaDecimal to Decimal.");
            System.out.println("9. Octal to Binary.");
            System.out.println("10. Binary to Octal.");
            System.out.println("11. Octal to Decimal.");
            System.out.println("12. Decimal to Octal.");
            System.out.println("13. Octal to HexaDecimal.");
            System.out.println("14. HexaDecimal to Octal.");
            System.out.println("0. Exit.");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();

            switch(choice) {
                // Exit
                case 0:
                    return;
                // Roman to Integer
                case 1:
                    System.out.print("\nEnter the Roman String : ");
                    str = input.next();
                    System.out.println("Output (Roman to Integer) : " + cal.romanToInt(str));
                    break;
                // Integer to Roman
                case 2:
                    System.out.print("\nEnter a number : ");
                    a = input.nextInt();
                    System.out.println("Output (Integer to Roman) : " + cal.intToRoman(a));
                    break;
                // Decimal to Binary
                case 3:
                    System.out.print("\nEnter a number : ");
                    a = input.nextInt();
                    System.out.println("Output (Decimal to Binary) : " + cal.decimalToBinary(a));
                    break;
                // Binary to Decimal
                case 4:
                    System.out.print("\nEnter a Binary number : ");
                    str = input.next();
                    System.out.println("Output (Binary to Decimal) : " + cal.binaryToDecimal(str));
                    break;
                // HexaDecimal to Binary
                case 5:
                    System.out.print("\nEnter a HexaDecimal number : ");
                    str = input.next();
                    System.out.println("Output (HexaDecimal to Binary) : " + cal.hexaToBinary(str));
                    break;
                // Binary to HexaDecimal
                case 6:
                    System.out.print("\nEnter a Binary number : ");
                    str = input.next();
                    System.out.println("Output (Binary to HexaDecimal) : " + cal.binaryToHexa(str));
                    break;
                // Decimal to HexaDecimal
                case 7:
                    System.out.print("\nEnter a number : ");
                    a = input.nextInt();
                    System.out.println("Output (Decimal to HexaDecimal) : " + cal.decimalToHexa(a));
                    break;
                // HexaDecimal to Decimal
                case 8:
                    System.out.print("\nEnter a HexaDecimal number : ");
                    str = input.next();
                    System.out.println("Output (Hexadecimal to Decimal) : " + cal.hexaToDecimal(str));
                    break;
                // Octal to Binary
                case 9:
                    System.out.print("\nEnter a Octal number : ");
                    str = input.next();
                    System.out.println("Output (Octal to Binary) : " + cal.octalToBinary(str));
                    break;
                // Binary to Octal
                case 10:
                    System.out.print("\nEnter a Binary number : ");
                    str = input.next();
                    System.out.println("Output (Binary to Octal) : " + cal.binaryToOctal(str));
                    break;
                // Octal to Decimal
                case 11:
                    System.out.print("\nEnter a Octal number : ");
                    str = input.next();
                    System.out.println("Output (Octal to Decimal) : " + cal.octalToDecimal(str));
                    break;
                // Decimal to Octal
                case 12:
                    System.out.print("\nEnter a number : ");
                    a = input.nextInt();
                    System.out.println("Output (Decimal to Octal) : " + cal.decimalToOctal(a));
                    break;
                // Octal to HexaDecimal
                case 13:
                    System.out.print("\nEnter a Octal number : ");
                    str = input.next();
                    System.out.println("Output (Octal to HexaDecimal) : " + cal.octalToHexa(str));
                    break;
                // HexaDecimal to Octal
                case 14:
                    System.out.print("\nEnter a Octal number : ");
                    str = input.next();
                    System.out.println("Output (HexaDecimal to Octal) : " + cal.hexaToOctal(str));
                    break;
                default:
                    System.out.println("Wrong input!!!");
                    break;
            }
        }
    }

    public void calculateAreas() {
        int choice;
        double a, b;

        while(true) {
            System.out.println("\n1. Calculate Area of Square.");
            System.out.println("2. Calculate Area of Rectangle.");
            System.out.println("3. Calculate Area of Circle.");
            System.out.println("4. Calculate Area of Triangle.");
            System.out.println("5. Calculate Total Surface Area of Cube.");
            System.out.println("6. Calculate Total Surface Area of Cylinder.");
            System.out.println("7. Calculate Total Surface Area of Cone.");
            System.out.println("8. Calculate Total Surface Area of Sphere.");
            System.out.println("9. Calculate Volume of Cube.");
            System.out.println("10. Calculate Volume of Cylinder.");
            System.out.println("11. Calculate Volume of Cone.");
            System.out.println("12. Calculate Volume of Sphere.");
            System.out.println("0. Exit.");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();

            switch(choice) {
                // Exit
                case 0:
                    return;
                // Area of Square
                case 1:
                    System.out.print("\nEnter length of the Square : ");
                    a = input.nextDouble();
                    System.out.println("Output (Area of Square) : " + cal.areaOfSquare(a));
                    break;
                // Area of Rectangle
                case 2:
                    System.out.print("\nEnter length of the Rectangle : ");
                    a = input.nextDouble();
                    System.out.print("Enter breadth of the Rectangle : ");
                    b = input.nextDouble();
                    System.out.println("Output (Area of Rectangle) : " + cal.areaOfRactangle(a, b));
                    break;
                // Area of Circle
                case 3:
                    System.out.print("\nEnter radius of the Circle : ");
                    a = input.nextDouble();
                    System.out.println("Output (Area of Circle) : " + cal.areaOfCircle(a));
                    break;
                // Area of Triangle
                case 4:
                    System.out.print("\nEnter height of the Circle : ");
                    a = input.nextDouble();
                    System.out.print("Enter base of the Circle : ");
                    b = input.nextDouble();
                    System.out.println("Output (Area of Triangle) : " + cal.areaOfTriangle(a, b));
                    break;
                // Surface Area of Cube
                case 5:
                    System.out.print("\nEnter radius of the Circle : ");
                    a = input.nextDouble();
                    System.out.println("Output (Area of Circle) : " + cal.surfaceAreaOfCube(a));
                    break;
                // Surface Area of Cylinder
                case 6:
                    System.out.print("\nEnter radius of the Cylinder : ");
                    a = input.nextDouble();
                    System.out.print("Enter height of the Cylinder : ");
                    b = input.nextDouble();
                    System.out.println("Output (Surface Area of Cylinder) : " + cal.surfaceAreaOfCylinder(a, b));
                    break;
                // Surface Area of Cone
                case 7:
                    System.out.print("\nEnter radius of the Cone : ");
                    a = input.nextDouble();
                    System.out.print("Enter length of the Cone : ");
                    b = input.nextDouble();
                    System.out.println("Output (Surface Area of Cone) : " + cal.surfaceAreaOfCone(a, b));
                    break;
                // Surface Area of Sphere
                case 8:
                    System.out.print("\nEnter radius of the Sphere : ");
                    a = input.nextDouble();
                    System.out.println("Output (Surface Area of Sphere) : " + cal.surfaceAreaOfSphere(a));
                    break;
                // Volume of Cube
                case 9:
                    System.out.print("\nEnter length of the Cube : ");
                    a = input.nextDouble();
                    System.out.println("Output (Volume of Cube) : " + cal.volumeOfCube(a));
                    break;
                // Volume of Cylinder
                case 10:
                    System.out.print("\nEnter radius of the Cylinder : ");
                    a = input.nextDouble();
                    System.out.print("Enter heigth of the Cylinder : ");
                    b = input.nextDouble();
                    System.out.println("Output (Volume of Cylinder) : " + cal.volumeOfCylinder(a, b));
                    break;
                // Volume of Cone
                case 11:
                    System.out.print("\nEnter radius of the Cone : ");
                    a = input.nextDouble();
                    System.out.print("Enter heigth of the Cone : ");
                    b = input.nextDouble();
                    System.out.println("Output (Volume of Cone) : " + cal.volumeOfCone(a, b));
                    break;
                // Volume of Sphere
                case 12:
                    System.out.print("\nEnter radius of the Sphere : ");
                    a = input.nextDouble();
                    System.out.println("Output (Volume of Sphere) : " + cal.volumeOfSphere(a));
                    break;
                default:
                    System.out.println("Wrong input!!!");
                    break;
            }
        }
    }
}

public class AllInOneCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menus men = new Menus();
        int choice;

        while(true) {
            System.out.println("\n1. Basic Arithemetic Operations.");
            System.out.println("2. Advanced Arithemetic Operations.");
            System.out.println("3. Conversion between Number Systems.");
            System.out.println("4. Calculate Area / Volume.");
            System.out.println("0. Exit.");
            System.out.print("Enter your choice : ");
            choice =
                    input.nextInt();

            switch(choice) {
                case 0:
                    return;
                case 1:
                    men.performBAriOps();
                    break;
                case 2:
                    men.performAAriOps();
                    break;
                case 3:
                    men.performConversions();
                    break;
                case 4:
                    men.calculateAreas();
                    break;
                default:
                    System.out.println("Wrong input!!!");
                    break;
            }
        }
    }
}
