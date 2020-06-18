package com.tvu.Metadata_BE.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tvu.Metadata_BE.Constants;
import com.tvu.Metadata_BE.dto.DownloadFileRequestDTO;
import com.tvu.Metadata_BE.dto.DownloadFileResponseDTO;
import com.tvu.Metadata_BE.dto.MetaDataResponse;
import com.tvu.Metadata_BE.dto.MetaRequestsDTO;
import com.tvu.Metadata_BE.dto.RequestRecordInfo;
import com.tvu.Metadata_BE.dto.RequestSessionInfo;
import com.tvu.Metadata_BE.dto.ResponseRecordInfo;
import com.tvu.Metadata_BE.dto.ResponseSessionInfo;
import com.tvu.Metadata_BE.stub.RecordStub;
import com.tvu.Metadata_BE.stub.SaveMetaData;
import com.tvu.Metadata_BE.stub.SessionStub;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "TVU Api for storing and retriving the MetaData Information..")
public class Controller {
	@Autowired
	private SaveMetaData savemetadata;
	@Autowired
	private RecordStub recordStub;
	@Autowired
	private SessionStub sessionStub;

	@ApiOperation(value = "To set the info of Meta Data ")
	@PostMapping(value = "/tvu/MeatadataService/setMetaData")
	public MetaDataResponse setMetaData(@RequestBody MetaRequestsDTO context)
			throws IOException {
		MetaDataResponse response=null;
		System.out.println(context.toString());
		response=savemetadata.saveData(context);
		response.setErrorCode(Constants.API.SUCCESS_CODE);
		response.setErrorMessage(Constants.API.SUCCESS_MESSAGE);
		return response;
	}

	@ApiOperation(value = "To Get SessionInfo")
	@PostMapping(value = "/tvu/MeatadataService/GetSessionInfo",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseSessionInfo getPart(@RequestBody RequestSessionInfo req) {
		ResponseSessionInfo response=sessionStub.getSessionInfo(req.getUserid(), req.getOffset(), req.getLimit());
		return response;
	}

	@ApiOperation(value = "To Get RecordInfo")
	@PostMapping(value = "/tvu/MeatadataService/GetRecordInfo",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseRecordInfo getRecords(@RequestBody RequestRecordInfo req) {
		ResponseRecordInfo recordinfo=recordStub.getRecordInfo(req.getUserid(), req.getSessionid());
		return recordinfo;
	}

	@ApiOperation(value = "To Info")
	@PostMapping(value = "/tvu/MeatadataService/GetInfo",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public DownloadFileResponseDTO getStatus(@RequestBody DownloadFileRequestDTO req) throws Exception {
		DownloadFileResponseDTO response=sessionStub.getInfo(req);
		return response;
	}
}
