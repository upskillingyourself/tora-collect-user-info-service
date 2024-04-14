package itr.client.api.service.impl;

import itr.client.api.model.db.entity.PermanentDocuments;
import itr.client.api.model.db.entity.UserItrData;
import itr.client.api.model.db.entity.YearlyDocument;

import itr.client.api.model.db.entity.YearlyInformation;
import itr.client.api.model.request.ItrFileRequest;
import itr.client.api.repository.PermanentDocumentsRepository;
import itr.client.api.repository.UserItrDataRepository;
import itr.client.api.repository.YearlyDocumentsRepository;
import itr.client.api.repository.YearlyInformationRepository;
import itr.client.api.service.IrtFillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Service
public class IrtFillingServiceImpl implements IrtFillingService {


    private static final String AADHAR = "Adhar Card";
    @Autowired
    private PermanentDocumentsRepository permanentDocumentsRepository;

    @Autowired
     UserItrDataRepository userItrDataRepository;

    @Autowired
     YearlyDocumentsRepository yearlyDocumentsRepository;

    @Autowired
     YearlyInformationRepository yearlyInformationRepository;


    //@Value("folder.path")
    private String folderPath="/Users/sudhanshugupta/Desktop/itr-file-test-folder";

    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());


    public String getItrUserData(ItrFileRequest request) {
        // Create the folder if it doesn't exist
        String folderName= "pan_"+request.getPanNo();
        File folder = new File(folderPath + File.separator + folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
/*

        StringBuilder response = new StringBuilder();
        for (MultipartFile file : request.getFiles()) {
            String fileName = file.getOriginalFilename();
            if (fileName != null) {
                File destFile = new File(folder.getAbsolutePath() + File.separator + fileName);
                try {
                    file.transferTo(destFile);
                    response.append("File ").append(fileName).append(" uploaded successfully.\n");
                } catch (IOException e) {
                    response.append("Failed to upload ").append(fileName).append(": ").append(e.getMessage()).append("\n");
                }
            }
        }

*/
        savePermanentDocuments(request);
        saveUserItrData(request);
        saveYearlyDocuments(request);
        saveYearlyInformation(request);

        return "OK";
    }

    private void saveYearlyInformation(ItrFileRequest request) {
        YearlyInformation yInfo= new YearlyInformation();
        yInfo.setItrYear(request.getItrYear());

        yearlyInformationRepository.save(yInfo);
    }

    private void saveYearlyDocuments(ItrFileRequest request) {
        YearlyDocument ydoc =new YearlyDocument();
        ydoc.setDocumentName(request.getPanNo());
        yearlyDocumentsRepository.save(ydoc);
    }

    private void saveUserItrData(ItrFileRequest request) {
        UserItrData userdata= new UserItrData();
        userdata.setAadharNo(request.getAadharNo());
        userdata.setPanNo(request.getPanNo());
        userdata.setDrivingLicense(request.getDlNo());
        userdata.setPassportNo(request.getPassportNo());
        userdata.setVoterId(request.getVoterId());

        userItrDataRepository.save(userdata);
    }

    private void savePermanentDocuments(ItrFileRequest request) {

        PermanentDocuments aAdhardoc= new PermanentDocuments();
        aAdhardoc.setDocumentName(AADHAR);
        aAdhardoc.setUploadedDate(timeStamp);
        aAdhardoc.setDocumentPath("");
        aAdhardoc.setUploadedStatus("uploaded");
        permanentDocumentsRepository.save(aAdhardoc);


    }
}
