package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Refuse extends AbstractEvent {

    private Long id;
    private Long orderId;

    public Refuse(Cook aggregate) {
        super(aggregate);
    }

    public Refuse() {
        super();
    }
}
//>>> DDD / Domain Event
