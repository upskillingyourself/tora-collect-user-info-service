package itr.client.api.model.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class YearlyInformation {

    @Id
    @GeneratedValue
    private int id;

    private String  itrYear;
    private String  trnsactionId;
    private String  paymentStatus;
    private String  salaried;
    private String  parmanentDataId;

}
