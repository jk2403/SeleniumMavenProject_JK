package demo;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Log4jDemo {

	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("\n Hello World \n");
logger.info("This is information message");
logger.error("This is error message");
logger.fatal("This is fatal message");
logger.warn("This is warning message");
logger.debug("This is debug message");
logger.trace("This is Trace message");

System.out.println("\n Completed \n");
	}

}
