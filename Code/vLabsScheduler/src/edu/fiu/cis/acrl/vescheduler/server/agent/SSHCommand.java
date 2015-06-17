package edu.fiu.cis.acrl.vescheduler.server.agent;

import com.jcraft.jsch.*;

import edu.fiu.cis.acrl.vescheduler.server.tools.debug.DebugTools;

import java.io.*;


/**
 * Establishes an ssh connection and executes a command
 */
public class SSHCommand { // implements Runnable {

	// Debug level for this class
	private static int DEBUG_LEVEL = 5;
	
	//    private static final String USER = "portal";
	//    private static final String PASSWORD = "k4se*prt4l";
	//    private static final String HOST = "dolphin.cis.fiu.edu";
	//    private static final int PORT = 22;

	private String command; 
	private String host; 
	private int port;
	private String user;
	private String password;
	private int wait;

	public SSHCommand(
			String command, 
			String host, 
			int port, 
			String user, 
			String password,
			int wait) {

		this.command = command;
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.wait = wait;
	}

	// @   Override
	// public void run() {
	public int run() {
		
		try { if (wait > 0) Thread.sleep(wait*1000); } catch(Exception e) {}

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

				try { Thread.sleep(100); } catch(Exception e) {}
		
			}
			
			exitCode = channel.getExitStatus();

			channel.disconnect();
			session.disconnect();

			DebugTools.println(DEBUG_LEVEL, "[SSHCommand - run] " +
					"Command " + command + "\n\t exitCode: " + exitCode);
			if (exitCode < 0) {
				Exception e =
					new Exception(
					"Command " + command + " failed. Status: " + exitCode);
				e.printStackTrace();
			}
		} catch (Exception e) {
			DebugTools.println(-1, "[SSHCommand - run] " +
						"This command could not be executed: " + command);
			DebugTools.println(-1, "[SSHCommand - run] " +
					"The exception message is: " + e.getLocalizedMessage());
			if (e.getMessage().contains("No route to host")) {
				exitCode = -101;
			}
			DebugTools.println(-1, "[SSHCommand - run] " +
					"The user is " + user + ", host is " + host + 
					", the port is " + port + ", and the exitCode is " + exitCode);
			DebugTools.println(-1, "[SSHCommand - run] " +
					"See the exception below for more information");
			e.printStackTrace();
		}
		return exitCode;
	}
}
