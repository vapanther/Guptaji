package com.tvu.Metadata_BE.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tvu.Metadata_BE.Constants;
import com.tvu.Metadata_BE.Model.Records;
import com.tvu.Metadata_BE.Model.Session;
import com.tvu.Metadata_BE.dto.DownloadFileRequestDTO;
import com.tvu.Metadata_BE.dto.DownloadFileResponseDTO;
import com.tvu.Metadata_BE.dto.ResponseSessionInfo;
import com.tvu.Metadata_BE.dto.SessionDTO;
import com.tvu.Metadata_BE.repository.RecordRepository;
import com.tvu.Metadata_BE.repository.SessionRepository;


@Service("SessionStub")
public class SessionStub {

	@Autowired
	private RecordRepository recordrepo;
	@Autowired
	private RecordRepository recordInfo;
	@Autowired
	private SessionRepository sessionrepo;
	
	@Value("${user.path}")
	private String userPath;
	
	public ResponseSessionInfo getSessionInfo(String userid,int offset,int limit)
	{
		ResponseSessionInfo sessioninfo=new ResponseSessionInfo();
		Pageable pageable = PageRequest.of(offset, limit);
		List<Session> sessions=sessionrepo.findByProducedBy(userid,pageable);
		List<SessionDTO> listSession=new ArrayList<SessionDTO>(); 
		for(Session s:sessions)
		{
			SessionDTO session=new SessionDTO();
			session.setId(s.getId());
			session.setPlaceRootPath(s.getPlaceRootPath());
			session.setProducedBy(s.getProducedBy());
			session.setDescription(s.getDescription());
			session.setStatus(s.getStatus());
			session.setStartTime(s.getStartTime());
			session.setEndTime(s.getEndTime());
			listSession.add(session);
		}
		sessioninfo.setErrorCode(Constants.API.SUCCESS_CODE);	
		sessioninfo.setErrorMessage(Constants.API.SUCCESS_MESSAGE_GET);	
		sessioninfo.setUserid(userid);
		sessioninfo.setSessionInfo(listSession);
		return sessioninfo;

	}
	
	public DownloadFileResponseDTO getInfo(DownloadFileRequestDTO req)
	{
		String sessionid=req.getSessionid();
		String recordid=req.getRecordid();
		Session session=sessionrepo.getOne(sessionid);
		Records record=recordrepo.getOne(recordid);
		String param1=session.getPlaceRootPath().split("/")[0];
		String param2=userPath;
		String param3="tvuclip://"+session.getPlaceRootPath().split("/")[1]+"/"+session.getProducedBy()+"/"+session.getId()+"/"+record.getSourceId();
		String param4=Long.toString(record.getStartTimeStamp());
		String param5=Long.toString(record.getStartTimeStamp());
		String param6=userPath+"/"+session.getProducedBy()+"_"+record.getId()+".ts";
		DownloadFileResponseDTO abc=new DownloadFileResponseDTO();
		abc.setParam1(param1);
		abc.setParam2(param2);
		abc.setParam3(param3);
		abc.setParam4(param4);
		abc.setParam5(param5);
		abc.setParam6(param6);
		return abc;
	}
}
