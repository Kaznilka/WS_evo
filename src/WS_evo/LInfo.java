package WS_evo;

/**
 * Created by berserk on 25.11.2017.
 */
public class LInfo {
    String password;
    int balance;

    public LInfo(String password, int balance) {
        this.password=password;
        this.balance=balance;
    }

    @Override
    public String toString() {
        String x = password + ":" + balance;

        return x;
    }
}
