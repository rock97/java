package rock.tx;

public class ListenerA implements Listener {

    @Override
    public void commit() {
        System.out.println("ListenerA commit");
    }

    @Override
    public void rollback() {
        System.out.println("ListenerA rollback");
    }
}
