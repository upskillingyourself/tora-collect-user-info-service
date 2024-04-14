package itr.client.api.model.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_itr_data")
public class YearlyInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String  itrYear;
    private String  trnsactionId;
    private String  paymentStatus;
    private String  salaried;
    private String  parmanentDataId;

}
