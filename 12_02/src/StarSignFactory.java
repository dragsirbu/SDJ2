import java.util.HashMap;

public class StarSignFactory {
    private static HashMap signs = new HashMap(13);

    public static AbstractStarSign getStarSign(String name) {
        StarSign sign = (StarSign)signs.get(name);

        if (sign == null) {
            sign = new StarSign(name);
            signs.put(name,sign);
        }
        return sign;
    }
}
