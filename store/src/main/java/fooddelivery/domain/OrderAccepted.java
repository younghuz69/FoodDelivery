package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private Long orderId;
    private String storeId;
    private String options;

    public OrderAccepted(FoodCooking aggregate) {
        super(aggregate);
    }

    public OrderAccepted() {
        super();
    }
}
