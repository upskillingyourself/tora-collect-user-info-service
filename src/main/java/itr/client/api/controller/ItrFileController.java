package itr.client.api.controller;

import itr.client.api.model.request.FileUploadRequest;
import itr.client.api.model.request.ItrFileRequest;
import itr.client.api.service.impl.IrtFillingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user-details")
public class ItrFileController {

    @Autowired
    private IrtFillingServiceImpl irtFillingService;


    @PostMapping("/form-data")
    public String uploadFiles( @ModelAttribute ItrFileRequest request) {
       return   irtFillingService.getItrUserData(request);


    }

    @PostMapping("/upload-files")
    public String uploadFile(@ModelAttribute FileUploadRequest fileUpoadRequest) {
        return   irtFillingService.uploadFile(fileUpoadRequest);

    }


}
