package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.OrderRejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FoodCooking_table")
@Data
public class FoodCooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private String foodId;

    private Long orderId;

    private String options;

    private String storeId;

    @PostPersist
    public void onPostPersist() {
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    public static FoodCookingRepository repository() {
        FoodCookingRepository foodCookingRepository = StoreApplication.applicationContext.getBean(
            FoodCookingRepository.class
        );
        return foodCookingRepository;
    }

    public void accept(AcceptCommand acceptCommand) {
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
    }

    public void start() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    public void finish() {
        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    public static void updateStatus(Paid paid) {
        /** Example 1:  new item 
        FoodCooking foodCooking = new FoodCooking();
        repository().save(foodCooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(foodCooking->{
            
            foodCooking // do something
            repository().save(foodCooking);


         });
        */

    }

    public static void copyOrderInfo(OrderPlaced orderPlaced) {
        /** Example 1:  new item  */
        FoodCooking foodCooking = new FoodCooking();
        foodCooking.setFoodId(orderPlaced.getFoodId());
        foodCooking.setOrderId(orderPlaced.getId());
        foodCooking.setOptions(orderPlaced.getOptions());
        foodCooking.setStatus("주문됨");
        foodCooking.setStoreId(orderPlaced.getStoreId());
        repository().save(foodCooking);

        

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(foodCooking->{
            
            foodCooking // do something
            repository().save(foodCooking);


         });
        */

    }
}
