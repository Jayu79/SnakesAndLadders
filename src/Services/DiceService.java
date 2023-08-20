package Services;
import java.util.*;

//This Dice Service can be used as 3rd party api using an adapter
public class DiceService {

    public static int roll(int n){
        int min = 1;
        int max = n*6;
        Random random = new Random();
        return random.nextInt(max)+min;
    }

}
