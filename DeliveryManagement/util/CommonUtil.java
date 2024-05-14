package DeliveryManagement.util;

import java.util.List;

public  class CommonUtil {

    public static <T> boolean notNull(T obj) {
        return obj != null;
    }

    public static <T> boolean isNull(T obj) {
        return obj == null;
    }
    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.isEmpty();
    }
}
