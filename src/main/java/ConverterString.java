package main.java;

public class ConverterString implements IConverter {
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
        String superStr = new String();
        for (int i = 1; i <= 2147483647; i++) {
            superStr += toWords(i) + ", \n ";
        }
        return superStr;
    }

    public String toWords(int n) {
        String s = new String();
        if (n < 1) {
            System.out.println("Illegal number!");
        } else if (n >= 1 && n <= 9) {
            s = convert1To9(n);
        } else if (n >= 10 && n <= 99) {
            s = convert10To99(n);
        } else if (n >= 100 && n <= 999) {
            s = convert100To999(n);
        } else System.out.println("Illegal number!");
        return s;
    }

    private String convert1To9(int n) {
        String str = new String();
        str +=(digits[n - 1]);
        return str;
    }

    private String convert10To99(int n) {
        String str = new String();
        if (n<=9){
            str +=(digits[n-1]);
            return str;
        } else if (n <= 19) {
            str +=(teenth[n % 10]);
            return str;
        } else {
            str +=(twoDigits[n / 10 - 2]);
            if ((n % 10) > 0) {
                str +=(" ");
                str +=(convert1To9(n % 10));
            }
            return str;
        }
    }

    private String convert100To999(int n) {
        String str = new String();
        str +=(hundreds[n / 100 - 1]);
        if (n%100 > 0) {
            str +=(" ");
            str +=(convert10To99(n % 100));
        }
        return str;
    }
}