public class Generator {
    public static String GeneratePassword(){
        String password= "";
        for (int i = 0; i < 20; i++) {
            int j = 33 + (int)(Math.random()*94);
            char c = (char)j;
            password+=c;
        }
        return password;
    }
}
