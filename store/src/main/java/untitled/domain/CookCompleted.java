package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CookCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;

    public CookCompleted(Cook aggregate) {
        super(aggregate);
    }

    public CookCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
