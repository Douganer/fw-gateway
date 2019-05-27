package cn.fw.gateway.filter;

import java.util.HashMap;
import java.util.Map;

/**
 * Log记录计数器
 *
 * @author 罗鑫
 * @since 2019-05-20
 */
public class LogCounter {
    /**
     * 线程容器
     */
    private static final ThreadLocal<Map<String, Object>> local = new ThreadLocal<Map<String, Object>>();

    /**
     * 开始
     */
    public static void start() {
        Map<String, Object> map = new HashMap<>();
        map.put("startTime", System.currentTimeMillis());
        local.set(map);
    }

    /**
     * 结束
     */
    public static long end() {
        long time = 0;
        Map<String, Object> map = local.get();
        if (map.get("startTime") != null) {
            time = System.currentTimeMillis() - Long.valueOf(map.get("startTime").toString());
        }
        local.remove();
        return time;
    }
}
