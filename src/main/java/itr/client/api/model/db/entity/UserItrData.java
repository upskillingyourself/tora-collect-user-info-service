package itr.client.api.model.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_itr_data")
public class UserItrData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;


  @Column(name = "user_id")
  private int userId;

  private String aadharNo;
  private String  panNo;
  private String  passportNo;
  private String  voterId;
  private String  drivingLicense;
  private String  folderPath;
}
