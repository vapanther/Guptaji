package com.tvu.Metadata_BE.websocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.tvu.Metadata_BE.Model.Records;
import com.tvu.Metadata_BE.Model.Session;
import com.tvu.Metadata_BE.dto.DownloadFileRequestDTO;
import com.tvu.Metadata_BE.dto.DownloadFileResponseDTO;
import com.tvu.Metadata_BE.dto.Greeting;
import com.tvu.Metadata_BE.dto.HelloMessage;
import com.tvu.Metadata_BE.repository.RecordRepository;
import com.tvu.Metadata_BE.repository.SessionRepository;

@Controller
public class WebSocketController {
	
	@Autowired
	SessionRepository sessionRepo;
	@Autowired
	RecordRepository recordRepo;
	
	@Value("${path}")
	private String localpath;
	
	@MessageMapping("/hello")
	@SendTo("/topic/ankit/greetings")
	public Greeting greeting(@Header("simpSessionId") String sessionId,HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) +"SessionId:-" + sessionId+"!");		
	}
	
	@MessageMapping("/download-files")
	@SendTo("/topic/ankit/greetings1")
	public DownloadFileResponseDTO getStatus(DownloadFileRequestDTO req) throws Exception {
		Thread.sleep(1000); // simulated delay
		String sessionid=req.getSessionid();
		String recordid=req.getRecordid();
		Session session=sessionRepo.getOne(sessionid);
		Records record=recordRepo.getOne(recordid);
		String param1=session.getPlaceRootPath().split("/")[0];
		String param2=localpath;
		String param3="tvuclip://"+session.getPlaceRootPath().split("/")[1]+"/"+session.getProducedBy()+"/"+session.getId()+"/"+record.getSourceId();
		String param4=Long.toString(record.getStartTimeStamp());
		String param5=Long.toString(record.getStartTimeStamp());
		String param6=localpath+"/"+session.getProducedBy()+"_"+record.getId();
		try {  
			String line;  
			//Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tree.com /A");
			Process p = new ProcessBuilder("C:\\PathToExe\\MyExe.exe","param1","param2").start();
			BufferedReader input =  
					new BufferedReader  
					(new InputStreamReader(p.getInputStream()));  
			while ((line = input.readLine()) != null) {  
				System.out.println(line);  
			}  
			input.close();  
		}  
		catch (Exception err) {  
			err.printStackTrace();  
		}  
		return new DownloadFileResponseDTO();
		//return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
	@MessageExceptionHandler
    @SendTo("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }

}
