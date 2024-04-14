package itr.client.api.model.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class UserItrData {
  @Id
  @GeneratedValue
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
