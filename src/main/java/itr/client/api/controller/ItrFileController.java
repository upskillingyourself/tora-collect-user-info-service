package itr.client.api.controller;

import itr.client.api.model.request.ItrFileRequest;
import itr.client.api.service.impl.IrtFillingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/upload-user-details")
public class ItrFileController {

    @Autowired
    private IrtFillingServiceImpl irtFillingService;


    @PostMapping("/upload")
    public String uploadFiles( @RequestBody ItrFileRequest request) {
       return   irtFillingService.getItrUserData(request);


    }




}
