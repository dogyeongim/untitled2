package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String foodId;
    private String address;
    private String options;
    private String status;

    public OrderCancled(Order aggregate) {
        super(aggregate);
    }

    public OrderCancled() {
        super();
    }
}
//>>> DDD / Domain Event
