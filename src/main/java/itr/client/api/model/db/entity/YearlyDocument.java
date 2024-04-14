package itr.client.api.model.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class YearlyDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String  yearlyInformationId;
    private String  documentName;
    private String  documentPath;
    private String  uploadedDate;
    private String  uploadedStatus;
}
