package com.tvu.Metadata_BE.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvu.Metadata_BE.Model.Records;
import com.tvu.Metadata_BE.dto.RecordsDTO;
import com.tvu.Metadata_BE.dto.ResponseRecordInfo;
import com.tvu.Metadata_BE.repository.RecordRepository;
import com.tvu.Metadata_BE.repository.SessionRepository;


@Service("recordStub")
public class RecordStub {

	@Autowired
	private RecordRepository recordrepo;
	@Autowired
	private RecordRepository recordInfo;
	@Autowired
	private SessionRepository sessionrepo;

	public ResponseRecordInfo getRecordInfo(String Userid,String sessionid)
	{
		ResponseRecordInfo recordinfo=new ResponseRecordInfo();
		recordinfo.setUserid(Userid);
		List<Records> recordList=recordInfo.findAllBySession(sessionrepo.findById(sessionid));
		List<RecordsDTO> recordDTOList=new ArrayList<RecordsDTO>();
		for(Records record:recordList)
		{
			RecordsDTO recordDTO=new RecordsDTO();
			recordDTO.setID(record.getId());
			recordDTO.setTitle(record.getTitle());
			recordDTO.setTags(record.getTags());
			recordDTO.setStartTimeStamp(record.getStartTimeStamp());
			recordDTO.setEndTimeStamp(record.getEndTimeStamp());
			recordDTOList.add(recordDTO);
		}
		recordinfo.setRecords(recordDTOList);

		return recordinfo;
	}

}
