public class ArabicToRome {
    private static String[] rnums = { "m", "cm", "d", "cd", "c", "xc", "l", "xl", "x", "Mx", "v", "Mv", "M", "CM",
            "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    private static int[] anums = { 1000000, 900000, 500000, 400000, 100000, 90000, 50000, 40000, 10000, 9000,
            5000, 4000, 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public static String change(String sc){
        if (isDigit(sc)) {
            int n = Integer.parseInt(sc);
            if (n > 0 && n < 4000000) {
                return toRnums(n);
            } else {
                return "Please input number around 1~3999999.";
            }
        }
        else{
            return "Please input integer.";
        }
    }
    public static boolean isDigit(String s){
        try {
            Integer.parseInt(s);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    public static String toRnums(int num){
        StringBuilder output = new StringBuilder();
        for(int i = 0;num > 0 && i < anums.length;i++)
        {
            while(num >= anums[i]){
                num -= anums[i];
                output.append(rnums[i]);
            }
        }
        return output.toString();
    }

}
