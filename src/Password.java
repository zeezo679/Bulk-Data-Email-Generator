import java.util.ArrayList;
import java.util.Random;
//1 - 30
//6
//20
//1
//6
//30
public class Password{
    private final char[] alphabet = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z','1','2','3','4','5',
            '6', '7', '8', '9', '!', '_', '#', '$', 'A', 'B',
            'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O'
    };
    protected String password;

    public void generatePass() {
        Random rn = new Random();
        String pass = "";
        for (int i = 0; i < 7; i++) {
            int idx = rn.nextInt((alphabet.length - 1) + 1) + 1;
            pass += alphabet[idx-1];
        }
        this.password = pass;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
