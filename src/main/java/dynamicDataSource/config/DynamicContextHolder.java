package dynamicDataSource.config;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Dynamic datasource context
 */
public final class DynamicContextHolder {
    @SuppressWarnings("unchecked")
    private static final ThreadLocal<Deque<String>> CONTEXT_HOLDER = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new ArrayDeque<>();
        }
    };

    /**
     * get datasource of currency thread
     */
    public static String peek(){
        return CONTEXT_HOLDER.get().peek();
    }

    /**
     * set datasource for currency thread
     */
    public static void push(String dataSource){
        CONTEXT_HOLDER.get().push(dataSource);
    }

    /**
     * clean datasource of currency thread
     */
    public static void poll(){
        Deque<String> deque = CONTEXT_HOLDER.get();
        deque.poll();
        if (deque.isEmpty()){
            CONTEXT_HOLDER.remove();
        }
    }

}
