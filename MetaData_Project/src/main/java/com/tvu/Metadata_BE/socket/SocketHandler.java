package com.tvu.Metadata_BE.socket;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.tvu.Metadata_BE.dto.DownloadFileResponseDTO;
import com.tvu.Metadata_BE.stub.SessionStub;
import com.tvu.Metadata_BE.stub.SocketService;

@Service
public class SocketHandler extends TextWebSocketHandler {

	@Autowired
	SocketService socketService;
	@Autowired
	SessionStub sessionStub;

	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

	@SuppressWarnings("unchecked")
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		Map<String, String> value = new Gson().fromJson(message.getPayload(), Map.class);
		/*for(WebSocketSession webSocketSession : sessions) {
			webSocketSession.sendMessage(new TextMessage("Hello " + value.get("name") + " !"));
		}*/

		try {
			JSONObject jsonObject = new JSONObject(value.get("name"));
			String recordid=(String)jsonObject.get("recordid");
			String sessionid=(String)jsonObject.get("sessionid");
		
		
		System.out.println("recordid"+recordid);
		System.out.println("sessionid"+sessionid);
		

		DownloadFileResponseDTO downloadFileResponseDTO=sessionStub.getParamsInfo(recordid,sessionid);
		String response=socketService.mergeChunks(downloadFileResponseDTO.getCmdPath(), downloadFileResponseDTO.getBucketName(), downloadFileResponseDTO.getLocalSytemPath(), downloadFileResponseDTO.getPath(), downloadFileResponseDTO.getStarttimestamp(), downloadFileResponseDTO.getEndtimestamp(), downloadFileResponseDTO.getFilename());
		session.sendMessage(new TextMessage("Hello " + value.get("name") +" "+"Your file download Started...... "+"\n"+response+" !"));
		//session.sendMessage(new TextMessage("Hello " + value.get("name")));
		}catch (JSONException err){
			err.printStackTrace(); ;
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//the messages will be broadcasted to all users.
		sessions.add(session);
	}

}