package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.StoreApplication;
import untitled.domain.Refuse;

@Entity
@Table(name = "Cook_table")
@Data
//<<< DDD / Aggregate Root
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String foodId;

    private String options;

    @PostPersist
    public void onPostPersist() {
        Refuse refuse = new Refuse(this);
        refuse.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    //<<< Clean Arch / Port Method
    public void isAccept(IsAcceptCommand isAcceptCommand) {
        //implement business logic here:

        Accept accept = new Accept(this);
        accept.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void startCook() {
        //implement business logic here:

        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void completeCook() {
        //implement business logic here:

        CookCompleted cookCompleted = new CookCompleted(this);
        cookCompleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void createCookInfo(Ordered ordered) {
        //implement business logic here:

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
