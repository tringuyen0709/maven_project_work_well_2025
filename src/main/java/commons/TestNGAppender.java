package commons;

import java.io.Serializable;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.testng.Reporter;

@Plugin(name = "TestNGAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE, printObject = true)
public class TestNGAppender extends AbstractAppender {

	protected TestNGAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
		super(name, filter, layout, true, Property.EMPTY_ARRAY);
	}

	public void info(String logMessage) {
		Reporter.log(logMessage + "<br>");
	}

	@Override
	public void append(LogEvent event) {
		Reporter.log(event.getMessage().getFormattedMessage());
	}

	@PluginFactory
	public static TestNGAppender createAppender(@PluginAttribute("name") String name, @PluginElement("Layout") Layout<? extends Serializable> layout, @PluginElement("Filter") final Filter filter,
			@PluginAttribute("otherAttribute") String otherAttribute) {
		if (name == null) {
			LOGGER.error("No name provided for TestAppender");
			return null;
		}
		if (layout == null) {
			layout = PatternLayout.createDefaultLayout();
		}
		return new TestNGAppender(name, filter, layout);
	}

}























//===============
//package commons;
//
//import org.apache.log4j.AppenderSkeleton;
//import org.apache.log4j.spi.LoggingEvent;
//import org.testng.Reporter;
//
///**
// * TestNG requires a call to Reporter.log to insert logging statements into the report
// */
//public class TestNGAppender extends AppenderSkeleton {
//
//	@Override
//	protected void append(LoggingEvent event) {
//		Reporter.log(getLayout().format(event) + "<br>");
//	}
//        
//	@Override
//	public void close() {
//		Reporter.log("Logging appender is closed");
//	}
//
//	@Override
//	public boolean requiresLayout() {
//		return true;
//	}
//
//	/**
//	 * Insert log message into ReportNG
//	 * @param logMessage
//	 */
//	public void info(String logMessage) {
//		Reporter.log(logMessage);
//	}
//
//}

















// File cu o duoi dong nay


//package commons;
//
//import org.apache.log4j.AppenderSkeleton;
//import org.slf4j.event.LoggingEvent;
//import org.testng.Reporter;
//
///**
// * TestNG requires a call to Reporter.log to insert logging statements into the report
// */
//public class TestNGAppender extends AppenderSkeleton {
//
//	@Override
//	protected void append(LoggingEvent event) {
//		Reporter.log(getLayout().format(event) + "<br>");
//	}
//        
//	@Override
//	public void close() {
//		Reporter.log("Logging appender is closed");
//	}
//
//	@Override
//	public boolean requiresLayout() {
//		return true;
//	}
//
//	/**
//	 * Insert log message into ReportNG
//	 * @param logMessage
//	 */
//	public void info(String logMessage) {
//		Reporter.log(logMessage);
//	}
//
//}