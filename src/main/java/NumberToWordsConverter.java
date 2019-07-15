package main.java;

public class NumberToWordsConverter implements INumberToWords  {

    public String toWords(){
        return null;
    }

    public String toWords(int n){
        String s = new String();
        if (n < 1) {
            System.out.println("Illegal number!");
        } else if (n >= 1 && n <= 9) {
            s = convertFrom1To9(n);
        } else if (n >= 10 && n <= 19) {
            s = convertFrom10To19(n);
        } else if (n >= 20 && n <=99 ){
            s = convert
        }
        return s;
    }

    private String convertFrom1To9(int n) {
        switch (n) {
            case 1:
                return "один";
            case 2:
                return "два";
            case 3:
                return "три";
            case 4:
                return "четыре";
            case 5:
                return "пять";
            case 6:
                return "шесть";
            case 7:
                return "семь";
            case 8:
                return "восемь";
            case 9:
                return "девять";
            default:
                return "error";
        }
    }

    private String convertFrom10To19(int n) {
        switch (n) {
            case 10:
                return "десять";
            case 11:
                return "одиннадцать";
            case 2:
                return "двенадцать";
            case 3:
                return "тринадцать";
            case 4:
                return "четырнадцать";
            case 5:
                return "пятнадцать";
            case 6:
                return "шестнадцать";
            case 7:
                return "семнадцать";
            case 8:
                return "восемнадцать";
            case 9:
                return "девятнадцать";
            default:
                return "error";
        }
    }


}
