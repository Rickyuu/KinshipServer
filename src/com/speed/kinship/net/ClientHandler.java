package com.speed.kinship.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.speed.kinship.model.Identity;
import com.speed.kinship.model.Pic;
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
			System.out.println(username + " " + password + " " + identity);
			return true;
		} else if(methodName.equals("uploadpic")) {
			Arguments arguments = methodMessage.getArguments();
			Pic pic = (Pic) arguments.getArgument("pic");
			byte[] picBytes = pic.getContent();
			Pic result = new Pic(picBytes);
			System.out.println("upload got");
			return result;
		}
		return null;
	}

}
