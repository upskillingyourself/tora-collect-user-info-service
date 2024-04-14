package itr.client.api.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
public class FileUploadRequest {

    private String use_id;
    private String fileName;
    private String panCard;
    private MultipartFile file;
}
