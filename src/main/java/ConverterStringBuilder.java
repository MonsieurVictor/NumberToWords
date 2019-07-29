package main.java;

public class ConverterStringBuilder implements IConverter {

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
        StringBuilder superStr = new StringBuilder();
        for (int i = 1; i <= 999999999; i++) {
                superStr.append(toWords(i));
                superStr.append("\n");
            }
    return superStr.toString();
    }

    public String toWords(int n) {
        StringBuilder str = new StringBuilder();
        if (n < 1) {
            System.out.println("Illegal number!");
        } else if (n >= 1 && n <= 9) {
            str = convert1To9(n);
        } else if (n >= 10 && n <= 99) {
            str = convert10To99(n);
        } else if (n >= 100 && n <= 999) {
            str = convert100To999(n);
        } else if (n >= 1000 && n <= 9999) {
            str  = convert1to9Thousands(n);
        } else if (n >= 10000 && n <= 19999) {
            str = convert10to19Thousands(n);
        } else if (n >= 20000 && n <= 99999) {
            str = convert20to99Thousands(n);
        } else if (n >= 100000 && n <= 999999) {
            str = convert100to999Thousands(n);
        } else if (n >= 1000000 && n <= 9999999) {
            str  = convert1to9Millions(n);
        } else if (n >= 10000000 && n <= 19999999) {
            str = convert10to19Millions(n);
        } else if (n >= 20000000 && n <= 99999999) {
            str = convert20to99Millions(n);
        } else if (n >= 100000000 && n <= 999999999) {
            str = convert100to999Millions(n);
        } else if (n >= 1000000000 && n <= 2147483647) {
            str  = convert1to2Billions(n);
        } else
            System.out.println("Illegal number!");
        return str.toString();
    }

    private StringBuilder convert1To9(int n) {
        StringBuilder str = new StringBuilder();
        str.append(digits[n - 1]);
        return str;
    }

    private StringBuilder convert10To99(int n) {
        StringBuilder str = new StringBuilder();
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

    private StringBuilder convert100To999(int n) {
        StringBuilder str = new StringBuilder();
        str.append(hundreds[n / 100 - 1]);
        if (n % 100 > 0) {
            str.append(" ");
            str.append(convert10To99(n % 100));
        }
        return str;
    }

    private StringBuilder convert1to9Thousands(int n) {
        StringBuilder str = new StringBuilder();
        str.append(thousands[n / 1000 - 1]);
        if (n % 1000 > 0) {
            str.append(" ");
            str.append(toWords(n % 1000));
        }
        return str;
    }

    private StringBuilder convert10to19Thousands(int n) {
        StringBuilder str = new StringBuilder();
        str.append(convert10To99(n / 1000 ));
        str.append(" тысяч");
        if (n % 1000 > 0) {
            str.append(" ");
            str.append(toWords(n % 1000));
        }
        return str;
    }

      private StringBuilder convert20to99Thousands(int n) {
        StringBuilder str = new StringBuilder();
        str.append(twoDigits[n / 10000 - 2]);
        if ((n % 10000 / 1000) > 0) {
            str.append(" ");
            str.append(convert1to9Thousands(n % 10000));
        } else {
            str.append(" тысяч");
            if (n % 1000 > 0) {
                str.append(" ");
                str.append(toWords(n % 1000));
            }
        }
        return str;
    }

    private StringBuilder convert100to999Thousands(int n) {
        StringBuilder str = new StringBuilder();
        str.append(hundreds[n / 100000 - 1]);
        if (n % 100000 > 0) {
            str.append(" ");
            str.append(toWords(n % 100000));
        } else {
            str.append(" тысяч");
        }
        return str;
    }

    private StringBuilder convert1to9Millions(int n) {
        StringBuilder str = new StringBuilder();
        str.append(millions[n / 1000000 - 1]);
        if (n % 1000000 > 0) {
            str.append(" ");
            str.append(toWords(n % 1000000));
        }
        return str;
    }

    private StringBuilder convert10to19Millions(int n) {
        StringBuilder str = new StringBuilder();
        str.append(convert10To99(n / 1000000 ));
        str.append(" миллионов");
        if (n % 1000000 > 0) {
            str.append(" ");
            str.append(toWords(n % 1000000));
        }
        return str;
    }

    private StringBuilder convert20to99Millions(int n) {
        StringBuilder str = new StringBuilder();
        str.append(twoDigits[n / 10000000 - 2]);
        if ((n % 10000000 / 1000000) > 0) {
            str.append(" ");
            str.append(convert1to9Millions(n % 10000000));
        } else {
            str.append(" тысяч");
            if (n % 1000000 > 0) {
                str.append(" ");
                str.append(toWords(n % 1000000));
            }
        }
        return str;
    }

    private StringBuilder convert100to999Millions(int n) {
        StringBuilder str = new StringBuilder();
        str.append(hundreds[n / 100000000 - 1]);
        if (n % 100000000 > 0) {
            str.append(" ");
            str.append(toWords(n % 100000000));
        } else {
            str.append(" миллионов");
        }
        return str;
    }

    private StringBuilder convert1to2Billions(int n) {
        StringBuilder str = new StringBuilder();
        str.append(billions[n / 1000000000 - 1]);
        if (n % 1000000000 > 0) {
            str.append(" ");
            str.append(toWords(n % 1000000000));
        }
        return str;
    }
}