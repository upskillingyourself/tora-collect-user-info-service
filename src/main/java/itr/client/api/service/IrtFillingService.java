package itr.client.api.service;

import itr.client.api.model.request.FileUploadRequest;
import itr.client.api.model.request.ItrFileRequest;

public interface IrtFillingService {
    String getItrUserData(ItrFileRequest request) ;
    String uploadFile(FileUploadRequest fileUpoadRequest);
}
