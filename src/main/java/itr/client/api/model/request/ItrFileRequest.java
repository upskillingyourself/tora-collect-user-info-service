package itr.client.api.model.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Getter
@Setter
public class ItrFileRequest {

    private String panNo;
    private String aadharNo;
    private String itrYear;
    private String phoneNo;
    private String emailId;
   // private List<MultipartFile> files;
    private String passportNo;
    private String voterId;
    private String dlNo;
    private String folderPath;
}
