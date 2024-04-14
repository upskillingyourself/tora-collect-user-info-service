package itr.client.api.model.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class PermanentDocuments implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_itr_data_id")
    private int userItrId;

    private String  documentName;
    private String documentPath;
    private String  uploadedDate;
    private String  uploadedStatus;
}
