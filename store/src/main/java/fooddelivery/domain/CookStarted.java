package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String status;
    private String foodId;
    private String storeId;
    private String options;
    private Long orderId;

    public CookStarted(FoodCooking aggregate) {
        super(aggregate);
    }

    public CookStarted() {
        super();
    }
}
