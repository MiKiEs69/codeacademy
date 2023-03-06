package Uzduotis1;

public class Skaiciuotuvas<N extends Number>{

    public double sudeti(N a, N b) {
        return a.doubleValue() + b.doubleValue();
    }

    public int atimti(int a, int b) {
        return 0;
    }

    public long dauginti(int a, int b) {
        return 0;
    }

    public double dalinti(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Dalyba iš nulio!");
        } else {
            return a / b;
        }
    }

    public double istrauktiSkaiciausSakni(int a) {
        if (a < 0) {
            throw new ArithmeticException("Illegal square root from negative numbers");
        }
        return Math.sqrt(a);
    }

    public double skaiciausProcentineIsraiska (int a) {
        return 0;
    }



}
