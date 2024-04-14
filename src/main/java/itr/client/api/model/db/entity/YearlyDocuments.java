package itr.client.api.model.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "yearly_documents")
public class YearlyDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String  yearlyInformationId;
    private String  documentName;
    private String  documentPath;
    private String  uploadedDate;
    private String  uploadedStatus;
}
