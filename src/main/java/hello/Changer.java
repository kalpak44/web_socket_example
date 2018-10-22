package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

@Service
public class Changer {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedRate = 1000)
    public void changeMe(){
        this.template.convertAndSend("/topic/greetings", new Greeting("Hello, " +  HtmlUtils.htmlEscape("Date: " + new Date()) +"!"));
    }
}
