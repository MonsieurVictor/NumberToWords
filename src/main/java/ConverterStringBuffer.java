package main.java;

public class ConverterStringBuffer implements IConverter {

    private StringBuffer[] digits = new StringBuffer[]{
            new StringBuffer("один"),
            new StringBuffer("два"),
            new StringBuffer("три"),
            new StringBuffer("четыре"),
            new StringBuffer("пять"),
            new StringBuffer("шесть"),
            new StringBuffer("семь"),
            new StringBuffer("восемь"),
            new StringBuffer("девять")
    };

    private StringBuffer[] teenth = new StringBuffer[]{
            new StringBuffer("десять"),
            new StringBuffer("одиннадцать"),
            new StringBuffer("двенадцать"),
            new StringBuffer("тринадцать"),
            new StringBuffer("четырнадцать"),
            new StringBuffer("пятнадцать"),
            new StringBuffer("шестнадцать"),
            new StringBuffer("семнадцать"),
            new StringBuffer("восемнадцать"),
            new StringBuffer("девятнадцать")
    };

    private StringBuffer[] twoDigits = new StringBuffer[]{
            new StringBuffer("двадцать"),
            new StringBuffer("тридцать"),
            new StringBuffer("сорок"),
            new StringBuffer("пятьдесят"),
            new StringBuffer("шестьдесят"),
            new StringBuffer("семьдесят"),
            new StringBuffer("восемьдесят"),
            new StringBuffer("девяносто")
    };

    private StringBuffer[] hundreds = new StringBuffer[]{
            new StringBuffer("сто"),
            new StringBuffer("двести"),
            new StringBuffer("триста"),
            new StringBuffer("четыреста"),
            new StringBuffer("пятьсот"),
            new StringBuffer("шестьсот"),
            new StringBuffer("семьсот"),
            new StringBuffer("восемьсот"),
            new StringBuffer("девятьсот")
    };

    public String toWords(){
        StringBuffer superStr = new StringBuffer();
        for (int i = 1; i<=999; i++) {

            superStr.append(toWords(i));
            superStr.append(", \n ");
        }
        return superStr.toString();
    }

    public String toWords(int n) {
        StringBuffer s = new StringBuffer();
        if (n < 1) {
            System.out.println("Illegal number!");
        } else if (n >= 1 && n <= 9) {
            s = convert1To9(n);
        } else if (n >= 10 && n <= 99) {
            s = convert10To99(n);

        } else if (n >= 100 && n <= 999) {
            s = convert100To999(n);
        } else  System.out.println("Illegal number!");
        return s.toString();
    }

    private StringBuffer convert1To9(int n) {

        StringBuffer str = new StringBuffer();
        str.append(digits[n - 1]);
        return str;
    }

    private StringBuffer convert10To99(int n) {
        StringBuffer str = new StringBuffer();
        if (n<=9){
            str.append(digits[n-1]);
            return str;
        } else if (n <= 19) {
            str.append(teenth[n % 10]);
            return str;
        } else {
            str.append(twoDigits[n / 10 - 2]);
            if ((n % 10) > 0) {
                str.append(" ");
                str.append(convert1To9(n % 10));
            }
            return str;
        }
    }

    private StringBuffer convert100To999(int n) {
        StringBuffer str = new StringBuffer();
//        str = hundreds[n / 100 - 1]; вот где были ошибки
        str.append(hundreds[n / 100 - 1]);

        if (n%100 > 0) {
            str.append(" ");
            str.append(convert10To99(n % 100));
        }

        return str;

    }
}