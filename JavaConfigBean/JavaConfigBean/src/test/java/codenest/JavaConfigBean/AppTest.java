package codenest.JavaConfigBean;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import codenest.JavaConfigBean.config.JavaConfig;
import codenest.JavaConfigBean.domain.Printer;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Printer printer = context.getBean(Printer.class);
		printer.print();
		context.close();
	}
}
