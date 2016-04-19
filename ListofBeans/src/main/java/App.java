import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by jeffrey.lima on 4/18/2016.
 */
public class App {
    public static void main(String[] args){
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/beans/beans.xml");

        Jungle jungle = (Jungle)context.getBean("jungle");

        System.out.println(jungle);

        ((FileSystemXmlApplicationContext)context).close();
    }
}
