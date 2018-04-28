package practice2;

import java.util.List;

public class OrderItem {
    private Integer count;
    private long code;

    public OrderItem(long code, int count) {
        this.code = code;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public long getCode() {
        return code;
    }
}
