package rock.tx;

public class ListenerB implements Listener {

    @Override
    public void commit() {
        System.out.println("ListenerB commit");
    }

    @Override
    public void rollback() {
        System.out.println("ListenerB rollback");
    }
}
