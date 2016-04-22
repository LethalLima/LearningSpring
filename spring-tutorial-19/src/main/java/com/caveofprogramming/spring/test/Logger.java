package com.caveofprogramming.spring.test;

/*
 * Dummy implementation of logger.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger {
    // Autowiring the fields does not require setters.
//    @Autowired
	private ConsoleWriter consoleWriter;
//    @Autowired
	private LogWriter fileWriter;

    /*
    // Autowiring the constructor
    @Autowired
	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter){
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}
    */
    
	// Autowiring the setters
	@Autowired()
    @Qualifier("toconsole")
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

	@Autowired
    @Qualifier("fileWriter")
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
        if(consoleWriter != null)
    		consoleWriter.write(text);
	}

}
