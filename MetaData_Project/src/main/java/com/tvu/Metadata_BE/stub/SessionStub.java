package com.tvu.Metadata_BE.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tvu.Metadata_BE.Constants;
import com.tvu.Metadata_BE.Model.Records;
import com.tvu.Metadata_BE.Model.Session;
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
	@Value("${user.cmdpath}")
	private String commandPath;

	public ResponseSessionInfo getSessionInfo(String userid,int offset,int limit)
	{
		ResponseSessionInfo sessioninfo=new ResponseSessionInfo();
		//Pageable pageable = PageRequest.of(offset, limit,Sort());
		//Pageable pageable = PageRequest.of(offset, limit, Sort.by(Sort.Direction.DESC, "StartTime"));
		List<Session> count=sessionrepo.findByProducedBy(userid);
		List<Session> sessions=sessionrepo.getSessionByProducedBy(offset,limit);
		List<SessionDTO> listSession=new ArrayList<SessionDTO>(); 
		for(Session s:sessions)
		{
			SessionDTO session=new SessionDTO();
			session.setId(s.getId());
			session.setPlaceRootPath(s.getPlaceRootPath());
			session.setProducedBy(s.getProducedBy());
			session.setTitle(s.getTitle());
			session.setDescription(s.getDescription());
			session.setStatus(s.getStatus());
			session.setStartTime(s.getStartTime());
			session.setEndTime(s.getEndTime());
			listSession.add(session);
		}
		sessioninfo.setCount(count.size());
		sessioninfo.setErrorCode(Constants.API.SUCCESS_CODE);	
		sessioninfo.setErrorMessage(Constants.API.SUCCESS_MESSAGE_GET);	
		sessioninfo.setUserid(userid);
		sessioninfo.setSessionInfo(listSession);
		return sessioninfo;

	}

	public DownloadFileResponseDTO getParamsInfo(String recordid,String sessionid)
	{
	
		Session session=sessionrepo.getOne(sessionid);
		Records record=recordrepo.getOne(recordid);
		String cmdPath=commandPath;
		String bucketName=session.getPlaceRootPath().split("/")[0];
		String localSytemPath=userPath;
		String path="tvuclip://"+session.getPlaceRootPath().split("/")[1]+"/"+session.getProducedBy()+"/"+session.getId()+"/"+record.getSourceId();
		String starttimestamp=Long.toString(record.getStartTimeStamp());
		String endtimestamp=Long.toString(record.getStartTimeStamp());
		String filename=userPath+"/"+session.getProducedBy()+"_"+record.getId()+".ts";
		DownloadFileResponseDTO downloadFileResponseDTO=new DownloadFileResponseDTO();
		downloadFileResponseDTO.setCmdPath(cmdPath);
		downloadFileResponseDTO.setBucketName(bucketName);
		downloadFileResponseDTO.setLocalSytemPath(localSytemPath);
		downloadFileResponseDTO.setPath(path);
		downloadFileResponseDTO.setStarttimestamp(starttimestamp);
		downloadFileResponseDTO.setEndtimestamp(endtimestamp);
		downloadFileResponseDTO.setFilename(filename);
		return downloadFileResponseDTO;
	}
}
