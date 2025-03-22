public class Generator {
    /*
    !@# 33 - 47 ; 58 - 64 ; 91 - 96 ; 123 - 126
    123 48 - 57
    ABC 65 - 90
    abc 97 - 122
    */
    public static String GeneratePassword(int length, boolean lower, boolean upper, boolean nums, boolean symbols) {
        StringBuilder password = new StringBuilder();

        if (!lower && !upper && !nums && !symbols) {
            return "";
        }

        while (password.length() < length) {
            int x = randomNumber();

            if ((x >= 97 && x <= 122) && lower) {
                password.append((char) x);
            } else if ((x >= 65 && x <= 90) && upper) {
                password.append((char) x);
            } else if ((x >= 48 && x <= 57) && nums) {
                password.append((char) x);
            } else if (((x >= 33 && x <= 47) || (x >= 58 && x <= 64) || (x >= 91 && x <= 96) || (x >= 123 && x <= 126)) && symbols){
                password.append((char) x);
            }
        }


        return password.toString();
    }

    public static int randomNumber() {
        return 33 + (int) (Math.random() * 94);
    }


}
