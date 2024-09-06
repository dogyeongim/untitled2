package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Accept extends AbstractEvent {

    private Long id;
    private Long orderId;

    public Accept(Cook aggregate) {
        super(aggregate);
    }

    public Accept() {
        super();
    }
}
//>>> DDD / Domain Event
