package operations;

public class Validations {

    public static boolean isEmpty(String value) {
        if (value != null) {
            return value.trim().isEmpty();
        }
        return false;
    }

    public static boolean isNumber(String value) {
        try {
            if (value != null) {
                Integer.parseInt(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {
        }
        return false;
    }
    public static boolean isFloat(String value) {
        try {
            if (value != null) {
                Float.parseFloat(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {
        }
        return false;
    }
    public static boolean isValidImage(String path){
        String[] extensions = {"jpg","jpeg","png","gif"};
        path = path.toLowerCase();
        for(String extension : extensions){
            if( path.endsWith(extension)){
                return true;
            }
        }
        return false;
    }
    public static boolean isValidContactNo(String str){
        if(str.length()==10){
            for(int i = 0; i < str.length();i++){
                if(!Character.isDigit(str.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
