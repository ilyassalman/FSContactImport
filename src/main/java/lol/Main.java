package lol;

import logic.FileParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@Component
public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
        FileParser parser = (FileParser)applicationContext.getBean("fileParser");
        try {
            try {
                parser.run();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
