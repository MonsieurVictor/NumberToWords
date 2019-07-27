package main.java;

public class ConverterStringBuffer implements IConverter {

    private String[] digits = new String[]{
            "один","два","три","четыре","пять","шесть","семь","восемь","девять"
    };

    private String[] teenth = new String []{
            "десять","одиннадцать","двенадцать","тринадцать","четырнадцать",
            "пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать"
    };

    private String[] twoDigits = new String []{
            "двадцать","тридцать","сорок","пятьдесят","шестьдесят","семьдесят","восемьдесят","девяносто"
    };

    private String[] hundreds = new String []{
            "сто","двести","триста","четыреста","пятьсот","шестьсот","семьсот","восемьсот","девятьсот"
    };

    public String toWords(){
        StringBuffer superStr = new StringBuffer();
        for (int i = 1; i<=2147483647; i++) {

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
        str.append(hundreds[n / 100 - 1]);
        if (n%100 > 0) {
            str.append(" ");
            str.append(convert10To99(n % 100));
        }
        return str;
    }
}