package com.speed.kinship.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

import com.speed.kinship.controller.MemoryHandler;
import com.speed.kinship.controller.StateHandler;
import com.speed.kinship.controller.ThingHandler;
import com.speed.kinship.controller.UserHandler;
import com.speed.kinship.controller.impl.MemoryHandlerImpl;
import com.speed.kinship.controller.impl.StateHandlerImpl;
import com.speed.kinship.controller.impl.ThingHandlerImpl;
import com.speed.kinship.controller.impl.UserHandlerImpl;
import com.speed.kinship.model.Identity;
import com.speed.kinship.model.User;
import com.speed.kinship.util.ObjectByteHelper;

public class ClientHandler implements Runnable {

	private Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			int comeInSize = dataInputStream.readInt();
			byte[] comeInBytes = new byte[comeInSize];
			int currentLength = 0;
			while(currentLength < comeInSize) {
				currentLength += dataInputStream.read(comeInBytes, currentLength, comeInSize-currentLength);
			}
			Object comeInObject = ObjectByteHelper.getInstance().bytesToObj(comeInBytes);
			MethodMessage methodMessage = (MethodMessage) comeInObject;
			Object resultObject = distributeMethod(methodMessage);
			
			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			byte[] resultObjectBytes = ObjectByteHelper.getInstance().objToBytes(resultObject);
			int writeSize = resultObjectBytes.length;
			dataOutputStream.writeInt(writeSize);
			dataOutputStream.write(resultObjectBytes);
			
			dataInputStream.close();
			inputStream.close();
			dataOutputStream.close();
			outputStream.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private Object distributeMethod(MethodMessage methodMessage) {
		String methodName = methodMessage.getName();
		if(methodName.equals(Constants.REGISTER)) {
			Arguments arguments = methodMessage.getArguments();
			String username = (String) arguments.getArgument("username");
			String password = (String) arguments.getArgument("password");
			Identity identity = (Identity) arguments.getArgument("identity");
			UserHandler userHandler = new UserHandlerImpl();
			return userHandler.register(username, password, identity);
		} else if(methodName.equals(Constants.LOGIN)) {
			Arguments arguments = methodMessage.getArguments();
			String username = (String) arguments.getArgument("username");
			String password = (String) arguments.getArgument("password");
			Identity identity = (Identity) arguments.getArgument("identity");
			UserHandler userHandler = new UserHandlerImpl();
			return userHandler.login(username, password, identity);
		}  else if(methodName.equals(Constants.GET_FIRST_N_STATES)) {
			Arguments arguments = methodMessage.getArguments();
			String username = (String) arguments.getArgument("username");
			int n = (int) arguments.getArgument("n");
			StateHandler stateHandler = new StateHandlerImpl();
			return stateHandler.getFirstNStates(username, n);
		} else if(methodName.equals(Constants.GET_NEXT_N_STATES)) {
			Arguments arguments = methodMessage.getArguments();
			String username = (String) arguments.getArgument("username");
			int startId = (int) arguments.getArgument("startId");
			int n = (int) arguments.getArgument("n");
			StateHandler stateHandler = new StateHandlerImpl();
			return stateHandler.getNextNStates(username, startId, n);
		} else if(methodName.equals(Constants.ADD_STATE)) {
			Arguments arguments = methodMessage.getArguments();
			User user = (User) arguments.getArgument("user");
			String content = (String) arguments.getArgument("content");
			byte[] pic = (byte[]) arguments.getArgument("pic");
			StateHandler stateHandler = new StateHandlerImpl();
			return stateHandler.addState(user, content, pic);
		} else if(methodName.equals(Constants.ADD_FEEDBACK)) {
			Arguments arguments = methodMessage.getArguments();
			int stateId = (int) arguments.getArgument("stateId");
			User feedbackCreator = (User) arguments.getArgument("feedbackCreator");
			String feedback = (String) arguments.getArgument("feedback");
			StateHandler stateHandler = new StateHandlerImpl();
			return stateHandler.addFeedback(stateId, feedbackCreator, feedback);
		} else if(methodName.equals(Constants.GET_FIRST_N_THINGS)) {
			Arguments arguments = methodMessage.getArguments();
			String username = (String) arguments.getArgument("username");
			int n = (int) arguments.getArgument("n");
			ThingHandler thingHandler = new ThingHandlerImpl();
			return thingHandler.getFirstNThings(username, n);
		} else if(methodName.equals(Constants.GET_NEXT_N_THINGS)) {
			Arguments arguments = methodMessage.getArguments();
			String username = (String) arguments.getArgument("username");
			Date startTime = (Date) arguments.getArgument("startTime");
			int n = (int) arguments.getArgument("n");
			ThingHandler thingHandler = new ThingHandlerImpl();
			return thingHandler.getNextNThings(username, startTime, n);
		} else if(methodName.equals(Constants.ADD_THING)) {
			Arguments arguments = methodMessage.getArguments();
			User user = (User) arguments.getArgument("user");
			String title = (String) arguments.getArgument("title");
			Date time = (Date) arguments.getArgument("time");
			String content = (String) arguments.getArgument("content");
			byte[] pic = (byte[]) arguments.getArgument("pic");
			ThingHandler thingHandler = new ThingHandlerImpl();
			return thingHandler.addThing(user, title, time, content, pic);
		} else if(methodName.equals(Constants.GET_ALL_MEMORIES)) {
			Arguments arguments = methodMessage.getArguments();
			String username = (String) arguments.getArgument("username");
			MemoryHandler memoryHandler = new MemoryHandlerImpl();
			return memoryHandler.getAllMemories(username);
		} else if(methodName.equals(Constants.ADD_MEMORY)) {
			Arguments arguments = methodMessage.getArguments();
			User user = (User) arguments.getArgument("user");
			Date time = (Date) arguments.getArgument("time");
			String content = (String) arguments.getArgument("content");
			MemoryHandler memoryHandler = new MemoryHandlerImpl();
			return memoryHandler.addMemory(user, time, content);
		}
		
		return null;
	}

}
