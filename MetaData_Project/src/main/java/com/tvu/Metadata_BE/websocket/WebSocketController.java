/*package com.tvu.Metadata_BE.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.tvu.Metadata_BE.dto.DownloadFileRequestDTO;
import com.tvu.Metadata_BE.dto.DownloadFileResponseDTO;
import com.tvu.Metadata_BE.dto.Greeting;
import com.tvu.Metadata_BE.dto.HelloMessage;
import com.tvu.Metadata_BE.stub.SessionStub;
import com.tvu.Metadata_BE.stub.SocketService;

@Controller
public class WebSocketController {

	@Autowired
	SocketService socketService;
	@Autowired
	SessionStub sessionStub;

	@MessageMapping("/hello")
	@SendToUser("/topic/test/greetings")
	public Greeting greeting(@Header("simpSessionId") String sessionId,HelloMessage message,Principal principal) throws Exception {
		Thread.sleep(1000); // simulated delay
		String response=socketService.mergeChunks("a","a","a","a","a","a","a");
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) +"SessionId:-" + sessionId+"!"+"Response "+response);		
	}

	@MessageMapping("/download-files")
	@SendTo("/tvu/download/status")
	public String getStatus(DownloadFileRequestDTO req) throws Exception {
		DownloadFileResponseDTO downloadFileResponseDTO=sessionStub.getParamsInfo(req);
		String response=socketService.mergeChunks(downloadFileResponseDTO.getCmdPath(), downloadFileResponseDTO.getBucketName(), downloadFileResponseDTO.getLocalSytemPath(), downloadFileResponseDTO.getPath(), downloadFileResponseDTO.getStarttimestamp(), downloadFileResponseDTO.getEndtimestamp(), downloadFileResponseDTO.getFilename());
		return response;

	}
	@MessageExceptionHandler
	@SendTo("/queue/errors")
	public String handleException(Throwable exception) {
		return exception.getMessage();
	}

}
*/