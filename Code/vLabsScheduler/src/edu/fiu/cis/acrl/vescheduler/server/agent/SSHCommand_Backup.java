package edu.fiu.cis.acrl.vescheduler.server.agent;

import com.jcraft.jsch.*;
import java.io.*;


/**
 * Establishes an ssh connection and executes a command
 */
public class SSHCommand_Backup {

	//    private static final String USER = "portal";
	//    private static final String PASSWORD = "k4se*prt4l";
	//    private static final String HOST = "dolphin.cis.fiu.edu";
	//    private static final int PORT = 22;

	public static int execute(
			String command, 
			String host, 
			int port, 
			String user, 
			String password) {

		int exitCode = -1;

		try {

			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);

			java.util.Properties config = new java.util.Properties(); 
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setPassword(password);
			session.connect();

			Channel channel = session.openChannel("exec");
			((ChannelExec)channel).setCommand(command);

			InputStream in = channel.getInputStream();

			channel.connect();

			while(!channel.isClosed()) {

				try { 
		
					Thread.sleep(100);
		
				}
				catch(Exception e) {}
		
			}

			exitCode = channel.getExitStatus();

			channel.disconnect();
			session.disconnect();

		}
		catch (Exception e) {

			e.printStackTrace();
		
		}

		return exitCode;


	}


	public static void main(String [] args) {

		System.out.println("About to execute a command");
		//	System.out.println("Result is: " + SSHCommand.execute("touch /tmp/testssh"));
	}

}
