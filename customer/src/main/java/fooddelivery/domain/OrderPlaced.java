package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String foodId;
    private String address;
    private String customerId;
    private String storeId;
    private String options;
}
