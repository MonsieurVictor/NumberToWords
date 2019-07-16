package main.java;

public class NumberToWordsConverter implements INumberToWords {

    StringBuilder[] digits = new StringBuilder[]{
            new StringBuilder("один"),
            new StringBuilder("два"),
            new StringBuilder("три"),
            new StringBuilder("четыре"),
            new StringBuilder("пять"),
            new StringBuilder("шесть"),
            new StringBuilder("семь"),
            new StringBuilder("восемь"),
            new StringBuilder("девять")
    };

    StringBuilder[] teenth = new StringBuilder[]{
            new StringBuilder("десять"),
            new StringBuilder("одиннадцать"),
            new StringBuilder("двенадцать"),
            new StringBuilder("тринадцать"),
            new StringBuilder("четырнадцать"),
            new StringBuilder("пятнадцать"),
            new StringBuilder("шестнадцать"),
            new StringBuilder("семнадцать"),
            new StringBuilder("восемнадцать"),
            new StringBuilder("девятнадцать")
    };

    StringBuilder[] twoDigits = new StringBuilder[]{
            new StringBuilder("двадцать"),
            new StringBuilder("тридцать"),
            new StringBuilder("сорок"),
            new StringBuilder("пятьдесят"),
            new StringBuilder("шестьдесят"),
            new StringBuilder("семьдесят"),
            new StringBuilder("восемьдесят"),
            new StringBuilder("девяносто")
    };

    StringBuilder[] hundreds = new StringBuilder[]{
            new StringBuilder("сто"),
            new StringBuilder("двести"),
            new StringBuilder("триста"),
            new StringBuilder("четыреса"),
            new StringBuilder("пятьсот"),
            new StringBuilder("шестьсот"),
            new StringBuilder("семьсот"),
            new StringBuilder("восемьсот"),
            new StringBuilder("девятьсот")
    };

    public String toWords() {
        return null;
    }

    public String toWords(int n) {
        StringBuilder s = new StringBuilder();
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

    private StringBuilder convert1To9(int n) {


        StringBuilder str = new StringBuilder();
        str.de
        str = digits[n - 1];
        return str;
    }

    private StringBuilder convert10To99(int n) {
        StringBuilder str = new StringBuilder();

        if (n <= 19) {
            str = teenth[n % 10];
            return str;
        } else {
            str = twoDigits[n / 10 - 2];
            if ((n % 10) > 0) {
                str.append(" ");
                str.append(convert1To9(n % 10));
            }
            return str;
        }
    }

    private StringBuilder convert100To999(int n) {
        StringBuilder str = new StringBuilder();
        str = hundreds[n / 100 - 1];
        if (n/100 > 0) {
            str.append(" ");
            str.append(convert10To99(n % 100));
        }
        return str;
    }
}
