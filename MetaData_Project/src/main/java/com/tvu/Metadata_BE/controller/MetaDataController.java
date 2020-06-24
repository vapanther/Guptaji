package com.tvu.Metadata_BE.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tvu.Metadata_BE.Constants;
import com.tvu.Metadata_BE.dto.DownloadFileRequestDTO;
import com.tvu.Metadata_BE.dto.DownloadFileResponseDTO;
import com.tvu.Metadata_BE.dto.MetaDataResponse;
import com.tvu.Metadata_BE.dto.MetaRequestsDTO;
import com.tvu.Metadata_BE.dto.ResponseRecordInfo;
import com.tvu.Metadata_BE.dto.ResponseSessionInfo;
import com.tvu.Metadata_BE.stub.MetadataStub;
import com.tvu.Metadata_BE.stub.RecordStub;
import com.tvu.Metadata_BE.stub.SessionStub;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "TVU Api for storing and retriving the MetaData Information..")
public class MetaDataController {
	@Autowired
	private MetadataStub savemetadata;
	@Autowired
	private RecordStub recordStub;
	@Autowired
	private SessionStub sessionStub;

	@ApiOperation(value = "To set the info of Meta Data ")
	@PostMapping(value = "/tvu/MeatadataService/setMetaData")
	public MetaDataResponse setMetaData(@RequestBody MetaRequestsDTO context)
			throws IOException {
		MetaDataResponse response=null;
		//System.out.println(context.toString());
		response=savemetadata.saveData(context);
		response.setErrorCode(Constants.API.SUCCESS_CODE);
		response.setErrorMessage(Constants.API.SUCCESS_MESSAGE);
		return response;
	}

	@ApiOperation(value = "To Get SessionInfo")
	//@PostMapping(value = "/tvu/MeatadataService/GetSessionInfo",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/tvu/MeatadataService/GetSessionInfo")
	public ResponseSessionInfo getPart(@RequestParam(value = "userid") String userid,@RequestParam(value = "offset") int offset,@RequestParam(value = "limit") int limit) {
		ResponseSessionInfo response=sessionStub.getSessionInfo(userid,offset,limit);
		return response;
	}

	@ApiOperation(value = "To Get RecordInfo")
	//@PostMapping(value = "/tvu/MeatadataService/GetRecordInfo",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/tvu/MeatadataService/GetRecordInfo")
	public ResponseRecordInfo getRecords(@RequestParam(value = "sessionid") String sessionid) {
		ResponseRecordInfo recordinfo=recordStub.getRecordInfo(sessionid);
		return recordinfo;
	}

	/*@GetMapping("/download/{fileName}") 
	public ResponseEntity downloadFileFromLocal(@PathVariable String fileName)
	{
		Path path = Paths.get(fileBasePath + fileName); 
		Resource resource = null; 	
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace(); 	
		} 
		return ResponseEntity.ok().
				contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}*/

	@ApiOperation(value = "To Info")
	@GetMapping("/tvu/MeatadataService/GetInfo")
	public DownloadFileResponseDTO getStatus(@RequestParam(value = "recordid") String recordid,@RequestParam(value = "sessionid") String sessionid) 
	{
		DownloadFileResponseDTO response=sessionStub.getParamsInfo(recordid,sessionid);
		return response;
	}
}
