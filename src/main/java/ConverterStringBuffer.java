package main.java;

public class ConverterStringBuffer implements IConverter {

    int first;
    int last;

    public ConverterStringBuffer(int first, int last){
        this.first = first;
        this.last = last;
    }

    private String[] digits = new String[]{
            "один","два","три","четыре","пять","шесть","семь","восемь","девять"
    };

    private String[] teens = new String []{
            "десять","одиннадцать","двенадцать","тринадцать","четырнадцать",
            "пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать"
    };

    private String[] twoDigits = new String []{
            "двадцать","тридцать","сорок","пятьдесят","шестьдесят",
            "семьдесят","восемьдесят","девяносто"
    };

    private String[] hundreds = new String []{
            "сто","двести","триста","четыреста","пятьсот",
            "шестьсот","семьсот","восемьсот","девятьсот"
    };

    private String[] thousands = new String[]{
            "одна тысяча","две тысячи","три тысячи","четыре тысячи","пять тысяч",
            "шесть тысяч","семь тысяч","восемь тысяч","девять тысяч"};

    private String[] millions = new String[]{
            "один миллион", "два миллиона", "три миллиона", "четыре миллиона", "пять миллионов", "шесть миллионов", "семь миллионов", "восемь миллионов", "девять миилионов"
    };

    private String[] billions = new String[]{
            "один миллиард", "два миллиарда", "три миллиарда", "четыре миллиарда", "пять миллиардов", "шесть миллиардов", "семь миллиардов", "восемь миллиардов", "девять миилиардов"
    };

    public String toWords(){
        StringBuffer superStr = new StringBuffer();
        for (int i = first; i <= last; i++) {
            superStr.append("\nStringBuffer: " + i + ": " + beginConverting(i)+ ";");
        }
        return superStr.toString();
    }

    public String toWords(int n) {
        StringBuffer str = new StringBuffer();
        return str.append("StringBuffer: " + n + ": " + beginConverting(n)+ ";").toString();
    }

    public StringBuffer beginConverting(int n){
        StringBuffer str = new StringBuffer();
        if (n < 1) {
            System.out.println("Illegal number below zero!");
        } else if (n >= 1 && n <= 9) {
            str.append(convert1To9(n));
        } else if (n >= 10 && n <= 99) {
            str.append(convert10To99(n));
        } else if (n >= 100 && n <= 999) {
            str.append(convert100To999(n));
        } else if (n >= 1_000 && n <= 9_999) {
            str.append(convert1to9Thousands(n));
        } else if (n >= 10_000 && n <= 19_999) {
            str.append(convert10to19Thousands(n));
        } else if (n >= 20_000 && n <= 99_999) {
            str.append(convert20to99Thousands(n));
        } else if (n >= 100_000 && n <= 999_999) {
            str.append(convert100to999Thousands(n));
        } else if (n >= 1_000_000 && n <= 9_999_999) {
            str.append(convert1to9Millions(n));
        } else if (n >= 10_000_000 && n <= 19_999_999) {
            str.append(convert10to19Millions(n));
        } else if (n >= 20_000_000 && n <= 99_999_999) {
            str.append(convert20to99Millions(n));
        } else if (n >= 100_000_000 && n <= 999_999_999) {
            str.append(convert100to999Millions(n));
        } else if (n >= 1_000_000_000 && n <= Integer.MAX_VALUE) {
            str.append(convert1to2Billions(n));
        } else
            System.out.println("Illegal number!");
        return str;
    }

    private StringBuffer convert1To9(int n) {
        StringBuffer str = new StringBuffer();
        str.append(digits[n - 1]);
        return str;
    }

    private StringBuffer convert10To99(int n) {
        StringBuffer str = new StringBuffer();
        if (n <= 9){
            str.append(digits[n - 1]);
            return str;
        } else if (n <= 19) {
            str.append(teens[n % 10]);
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
        if (n % 100 > 0) {
            str.append(" ");
            str.append(convert10To99(n % 100));
        }
        return str;
    }

    private StringBuffer convert1to9Thousands(int n) {
        StringBuffer str = new StringBuffer();
        str.append(thousands[n / 1_000 - 1]);
        if (n % 1_000 > 0) {
            str.append(" ");
            str.append(beginConverting(n % 1_000));
        }
        return str;
    }

    private StringBuffer convert10to19Thousands(int n) {
        StringBuffer str = new StringBuffer();
        str.append(convert10To99(n / 1_000 ));
        str.append(" тысяч");
        if (n % 1_000 > 0) {
            str.append(" ");
            str.append(beginConverting(n % 1_000));
        }
        return str;
    }

    private StringBuffer convert20to99Thousands(int n) {
        StringBuffer str = new StringBuffer();
        str.append(twoDigits[n / 1_0_000 - 2]);
        if ((n % 1_0_000 / 1_000) > 0) {
            str.append(" ");
            str.append(convert1to9Thousands(n % 1_0_000));
        } else {
            str.append(" тысяч");
            if (n % 1_000 > 0) {
                str.append(" ");
                str.append(beginConverting(n % 1_000));
            }
        }
        return str;
    }

    private StringBuffer convert100to999Thousands(int n) {
        StringBuffer str = new StringBuffer();
        str.append(hundreds[n / 100_000 - 1]);
        if (n % 100_000 > 0) {
            str.append(" ");
            str.append(beginConverting(n % 100_000));
        } else {
            str.append(" тысяч");
        }
        return str;
    }

    private StringBuffer convert1to9Millions(int n) {
        StringBuffer str = new StringBuffer();
        str.append(millions[n / 1_000_000 - 1]);
        if (n % 1_000_000 > 0) {
            str.append(" ");
            str.append(beginConverting(n % 1_000_000));
        }
        return str;
    }

    private StringBuffer convert10to19Millions(int n) {
        StringBuffer str = new StringBuffer();
        str.append(convert10To99(n / 1_000_000 ));
        str.append(" миллионов");
        if (n % 1_000_000 > 0) {
            str.append(" ");
            str.append(beginConverting(n % 1_000_000));
        }
        return str;
    }

    private StringBuffer convert20to99Millions(int n) {
        StringBuffer str = new StringBuffer();
        str.append(twoDigits[n / 1_0_000_000 - 2]);
        if ((n % 1_0_000_000 / 1_000_000) > 0) {
            str.append(" ");
            str.append(convert1to9Millions(n % 1_0_000_000));
        } else {
            str.append(" миллионов");
            if (n % 1_000_000 > 0) {
                str.append(" ");
                str.append(beginConverting(n % 1_000_000));
            }
        }
        return str;
    }

    private StringBuffer convert100to999Millions(int n) {
        StringBuffer str = new StringBuffer();
        str.append(hundreds[n / 100_000_000 - 1]);
        if (n % 100_000_000 > 0) {
            str.append(" ");
            str.append(beginConverting(n % 100_000_000));
        } else {
            str.append(" миллионов");
        }
        return str;
    }

    private StringBuffer convert1to2Billions(int n) {
        StringBuffer str = new StringBuffer();
        str.append(billions[n / 1_000_000_000 - 1]);
        if (n % 1_000_000_000 > 0) {
            str.append(" ");
            str.append(beginConverting(n % 1_000_000_000));
        }
        return str;
    }
}