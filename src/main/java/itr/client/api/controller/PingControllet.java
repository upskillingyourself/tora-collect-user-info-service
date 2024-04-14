package itr.client.api.controller;

import itr.client.api.model.request.ItrFileRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class PingControllet {

    @GetMapping("/data")
    public String uploadFiles() {
        return   "working fine";


    }

}
