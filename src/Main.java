public class Main {
    static String output= " Проверка работы репозитория";
    static int result;
    public static String calc(String input){
        String exception = "throws Exception"; // выдача исключения.
        Main action = new Main();
        String[] arihtExpr = input.split(" "); // разложили операцию по составляющим
        int a;
        int b;
        if (arihtExpr.length != 3){
            return exception+ " // т.к. формат математической операции не удовлетворяет заданию - две переменные и один оператор (+, -, /, *)";
        }  // проверка на количество переменных
        boolean rimskie = false;
        boolean rimskie1 ;
        boolean rimskie2 ;
        rimskie1 = action.rimPro(arihtExpr[0]);
        rimskie2 = action.rimPro(arihtExpr[2]);
        // Проверяем какие переменные арабские или римские.
        if ((rimskie1 && rimskie2 == false) || (rimskie1 == false && rimskie2 == true)){
            return exception+ " //т.к. используются одновременно разные системы счисления";
        }
        // Если переменные римские, то для проведения оперции приводим их в арабские и в вид целочисленных
        if(rimskie1 == true && rimskie2 == true) {
            rimskie = true;
            arihtExpr[0] =Integer.toString(action.convRimInArab(arihtExpr[0]));
            arihtExpr[2] = Integer.toString(action.convRimInArab(arihtExpr[2]));
        }
        // приводим числа в целочисленные значения
        try {
        a = Integer.parseInt(arihtExpr[0]);
        } catch (NumberFormatException e) {
        return exception+"//т.к. введены не целочисленные значения";
        }
        try {
        b = Integer.parseInt(arihtExpr[2]);
        } catch (NumberFormatException e) {
        return exception + "//т.к. введены не целочисленные значения";
        }
        // проверяем переменные на диапазон значений
        if ( a<1 || a>10 || b<1 || b>10 ) {
            return exception+ "//т.к. операторы не подходят по условия от 1 до 10";
            }
        // проверяем оператор и производим вычисление.
        switch(arihtExpr[1]) {
            case "+" :
                result= a+b;
            break;
            case "-" :
                result= a-b;
            break;
            case "/":
                result= a/b;
            break;
            case "*":
                result= a*b;
                break;
            default:
                    {return exception + " //т.к. формат математической операции не удовлетворяет заданию - дву переменные и один оператор (+, -, /, *)";
                    }
                  }
              // Если числа были римские, то ответ переводим в римский вид
        if (rimskie) {
              if(result < 0){ output = exception + "// т.к. в римской системе нет отрицательных чисел";}
              else {
            output = action.convRimVArab(result);}
        } else
            {output=Integer.toString(result);}
        return output;
    }
// распознаём, являются ли переменная римской
    Boolean rimPro(String b){
    String[] rimAlf = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    for (String string:rimAlf){
         if (b.equals(string)){
             return true;
         }
    }
    return false;
    }
     // Конвертация из арабских букв в римские для ввода от 1 до 10
    int convRimInArab(String arab){
        String[] rimAlf = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int z = 0;
        for (int i=0; i<rimAlf.length; i++){
            if (arab.equals(rimAlf[i])){
             z = i+1;
             break;
            }
        }
        return z;
    }
    // Конвертация из латинских букв в арабские от 0 до 100;
    String convRimVArab(int rim){
        String[] rimAlf100 = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return rimAlf100[rim];
    }
}

