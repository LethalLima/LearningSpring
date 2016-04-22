package com.caveofprogramming.spring.test;

/*
 * Dummy implementation of logger.
 */

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

public class Logger {

	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

//    @Resource
    @Inject
    @Named(value = "consoleWriter")
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

//    @Resource(name = "squirrel")
    @Inject
    @Named(value = "squirrel")
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

    @PostConstruct
    public void init(){
        System.out.println("Initializing...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying...");
    }
}
