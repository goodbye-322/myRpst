import java.util.Scanner;


public class Main {
    public static String calc(String input) {

        int result;
        String resultStr = "";
        String[] mathSymbol = {"+", "-", "/", "*"};
        String[] regexMathSymbol = {"\\+", "-", "/", "\\*"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expr = scanner.nextLine();
        expr = expr.replaceAll("\\s", "");
    
    
        int mathSymbolIndex=-1;
        for (int i = 0; i < mathSymbol.length; i++) {
            if(expr.contains(mathSymbol[i])){
                mathSymbolIndex = i;
                break;
            }
        }
       
        if(mathSymbolIndex==-1){
            return("Выражение не корректно!\nОтсутвуют математические знаки ");
        }

        char[] exprChars = expr.toCharArray();
        char[] mathSymbolChar = {'+', '-', '/', '*'};
        int manySymbol = 0;
        for (int i = 0; i < mathSymbolChar.length; i++) {
            for (int j = 0; j < exprChars.length; j++) {
                if (mathSymbolChar[i] == exprChars[j]) {
                manySymbol++;
                    if (manySymbol>=2) {
                        return("Выражение не корректно!\nМатематических знаков более одного ");
                    
                    }
                }
           
            }
        }
        
        
        String[] data = expr.split(regexMathSymbol[mathSymbolIndex]);
       
        int converter = 0;
        try {
            Integer.parseInt(data[0]);
            
          } catch(NumberFormatException e){
            converter++;
          }
          try {
            Integer.parseInt(data[1]);
            
          } catch(NumberFormatException e){
            converter++;
          }
        
          if (converter == 2) {
            int a = 0,b = 0;
            String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};
            
            for (int i = 0; i < romanArray.length; i++) {
                if (data[0].equals(romanArray[i])) {
                    a = i;
                    break;
                }
            }
            for (int i = 0; i < romanArray.length; i++) {
                if (data[1].equals(romanArray[i])) {
                    b = i;
                    break;
                }
            }
            if (a > 10 || b > 10) {
                return("Выражение не корректно!\nОдно или оба значений больше 10");
                
            }
            
            switch (mathSymbol[mathSymbolIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            resultStr = String.valueOf(result);
            for (int i = 0; i < romanArray.length; i++) {
                if (result==i ) {
                    if (result > 0) {
                        resultStr = (romanArray[i]);
                
                    } else {
                        return("Выражение не корректно!\nРимские числа не могут быть меньше нуля");
                    }
                }
            }
          }

        
        if(converter == 0){
            int a,b;

            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);

            if (a > 10 || b > 10) {
                return("Выражение не корректно!\nОдно или оба значений больше 10");
                
            }


            switch (mathSymbol[mathSymbolIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            resultStr = String.valueOf(result);
            

        }else if(converter == 1){
            return("Числа должны быть в одном формате");
        }
        return(resultStr);
    } 
}