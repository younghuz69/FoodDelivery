package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Picked extends AbstractEvent {

    private Long id;
    private String status;
    private String address;
    private Long orderId;

    public Picked(Delivery aggregate) {
        super(aggregate);
    }

    public Picked() {
        super();
    }
}
