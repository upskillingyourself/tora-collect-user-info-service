package itr.client.api.service.impl;

import itr.client.api.model.db.entity.PermanentDocuments;
import itr.client.api.model.db.entity.UserItrData;
import itr.client.api.model.db.entity.YearlyDocuments;
import itr.client.api.model.db.entity.YearlyInformation;
import itr.client.api.model.request.FileUploadRequest;
import itr.client.api.model.request.ItrFileRequest;
import itr.client.api.repository.PermanentDocumentsRepository;
import itr.client.api.repository.UserItrDataRepository;
import itr.client.api.repository.YearlyDocumentsRepository;
import itr.client.api.repository.YearlyInformationRepository;
import itr.client.api.service.IrtFillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Service
public class IrtFillingServiceImpl implements IrtFillingService {


    private static final String AADHAR = "Adhar Card";
    private static final String PANCARD = "Pan_Card";
    private static final String OTHER_DOCS = "Other_Documents";
    @Autowired
    private PermanentDocumentsRepository permanentDocumentsRepository;

    @Autowired
    UserItrDataRepository userItrDataRepository;

    @Autowired
    YearlyDocumentsRepository yearlyDocumentsRepository;

    @Autowired
    YearlyInformationRepository yearlyInformationRepository;


    //@Value("folder.path")
    private String folderPath = "/Users/sudhanshugupta/Desktop/itr-file-test-folder";

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());


    public String getItrUserData(ItrFileRequest request) {

        savePermanentDocuments(request);
        saveUserItrData(request);
        saveYearlyDocuments(request);
        saveYearlyInformation(request);
        return "Ok";
    }

    private void saveYearlyInformation(ItrFileRequest request) {
        YearlyInformation yInfo = new YearlyInformation();
        yInfo.setItrYear(request.getItrYear());
        yInfo.setSalaried("yes");
        yInfo.setTrnsactionId("transactionId");
        yInfo.setPaymentStatus("done");
        yInfo.setParmanentDataId("p1");
        yearlyInformationRepository.save(yInfo);
    }

    private void saveYearlyDocuments(ItrFileRequest request) {
            YearlyDocuments ydoc = new YearlyDocuments();
            ydoc.setDocumentName("ITR");
            ydoc.setDocumentPath("C://");
            ydoc.setUploadedStatus("uploaded");
            yearlyDocumentsRepository.save(ydoc);
    }

    private void saveUserItrData(ItrFileRequest request) {
        UserItrData userdata = new UserItrData();
        userdata.setAadharNo(request.getAadharNo());
        userdata.setPanNo(request.getPanNo());
        userdata.setDrivingLicense(request.getDlNo());
        userdata.setPassportNo(request.getPassportNo());
        userdata.setVoterId(request.getVoterId());

        userItrDataRepository.save(userdata);
    }

    private void savePermanentDocuments(ItrFileRequest request) {

            PermanentDocuments docName = new PermanentDocuments();

            docName.setDocumentName("documentName");
            docName.setUploadedDate(timeStamp);
            docName.setDocumentPath("PAN");
            docName.setUploadedStatus("uploaded");
            permanentDocumentsRepository.save(docName);


    }

    public String uploadFile(FileUploadRequest fileUploadRequest) {
        String folderName = fileUploadRequest.getPanCard();
        File folder = new File(folderPath + File.separator + folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        StringBuilder response = new StringBuilder();
        String fileName = fileUploadRequest.getFile().getOriginalFilename();
        if (fileName != null) {
            File destFile = new File(folder.getAbsolutePath() + File.separator + fileName);
            try {
                fileUploadRequest.getFile().transferTo(destFile);
                response.append("File ").append(fileName).append(" uploaded successfully.\n");
            } catch (IOException e) {
                response.append("Failed to upload ").append(fileName).append(": ").append(e.getMessage()).append("\n");
            }

        }
        return folderName;
    }

}
