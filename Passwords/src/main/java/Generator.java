public class Generator {
    public static String GeneratePassword(int length){
        StringBuilder password= new StringBuilder();
        for (int i = 0; i < length; i++) {
            int j = 33 + (int)(Math.random()*94);
            char c = (char)j;
            password.append(c);
        }
        return password.toString();
    }
}
