package rock.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tx {
    static final Map<String,Integer> txMap = new ConcurrentHashMap<>();
    static final Map<String,List<Listener>> listenerMap = new ConcurrentHashMap<>();
    //注册
    public void register(String txId,Listener listener){
        if(listenerMap.get(txId) == null){
            List<Listener> list = new ArrayList();
            list.add(listener);
            listenerMap.put(txId,list);
        }else {
            List<Listener> listeners = listenerMap.get(txId);
            listeners.add(listener);
        }
        txMap.put(txId,0);
    }

    public void isCommit(String txId,boolean isCommit,Listener listener){
        List<Listener> listeners = listenerMap.get(txId);
        if(txMap.get(txId)==-1){
            listener.rollback();
            return;
        }

        if(!isCommit){
            for (Listener lis : listeners) {
                lis.rollback();
            }
            txMap.put(txId,-1);
            return;
        }

        txMap.put(txId,txMap.get(txId)+1);

        if(txMap.get(txId) == listeners.size()){
            for (Listener lis : listeners) {
                lis.commit();
            }
        }

    }

}

