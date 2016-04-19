package lethallima;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/lethallima/beans/beans.xml");
//        Person person = (Person) context.getBean("person");
//        Person person2 = (Person) context.getBean("person");

//        person.setTaxId(666);

        // setting scope to prototype in beans.xml instead of blank or typing in singleton creates a new bean.
//        System.out.println(person);
//        System.out.println(person2);

//        Address address2 = (Address)context.getBean("address2");
//        System.out.println(address2);

        FruitBasket basket = (FruitBasket)context.getBean("basket");
        System.out.println(basket);

        ((FileSystemXmlApplicationContext)context).close();
    }
}
