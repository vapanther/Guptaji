/*package com.tvu.Metadata_BE.websocket;
import java.lang.reflect.Field;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.messaging.simp.stomp.DefaultStompSession;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.messaging.tcp.TcpConnection;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.sockjs.client.WebSocketClientSockJsSession;
public class Handler extends StompSessionHandlerAdapter {
	//private Logger logger = LoggerFactory.getLogger(MyStompSessionHandler.class);
	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
		// we need another sessionId!
		System.out.println("New session established : " + session.getSessionId());
		DefaultStompSession defaultStompSession =
				(DefaultStompSession) session;
		Field fieldConnection = ReflectionUtils.findField(DefaultStompSession.class, "connection");
		fieldConnection.setAccessible(true);
		String sockjsSessionId = "";
		try {
			TcpConnection<byte[]>; connection = (TcpConnection<byte[]>;) fieldConnection.get(defaultStompSession);
			try {
				Class adapter = Class.forName("org.springframework.web.socket.messaging.WebSocketStompClient$WebSocketTcpConnectionHandlerAdapter");
				Field fieldSession = ReflectionUtils.findField(adapter, "session");
				fieldSession.setAccessible(true);
				WebSocketClientSockJsSession sockjsSession = (WebSocketClientSockJsSession) fieldSession.get(connection);
				sockjsSessionId = sockjsSession.getId();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if (StringUtils.isBlank(sockjsSessionId)) {
			throw new IllegalStateException("couldn't extract sock.js session id");
		}
		String subscribeLink = "/topic/auth-user" + sockjsSessionId;
		session.subscribe(subscribeLink, this);
		System.out.println("Subscribed to " + subscribeLink);
		String sendLink = "/app/user";
		session.send(sendLink, getSampleMessage());
		System.out.println("Message sent to websocket server");

	} //... other overriden methods aren't so interesting 
}*/