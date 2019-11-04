package rock.tx;


public interface Listener {
    void commit();
    void rollback();
}
