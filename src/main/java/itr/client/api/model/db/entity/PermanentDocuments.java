package itr.client.api.model.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "parmanent_documents")
public class PermanentDocuments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_itr_data_id")
    private int userItrId;

    private String  documentName;
    private String documentPath;
    private String  uploadedDate;
    private String  uploadedStatus;
}
