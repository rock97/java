package rock.tx;

public class TxTest {

    public static void main(String[] args) {
        Tx tx = new Tx();
        Listener sourceA = new ListenerA();
        Listener sourceB = new ListenerB();
        tx.register("1",sourceA);
        tx.register("1",sourceB);

        tx.isCommit("1",false,sourceA);
        tx.isCommit("1",true,sourceB);
    }

}
