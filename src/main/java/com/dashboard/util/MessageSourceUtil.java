package com.dashboard.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceUtil {

	@Autowired
    private MessageSource messageSource;
    
	@Autowired
    private MessageSource notificationMessageSource;
   
    
//    public MessageSourceUtil(MessageSource messageSource) {
//    	this.messageSource = messageSource;
//    }
    public String getMessage(String code) {
        return getMessage(code, null);
    }

    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, "");
    }

    public String getMessage(String code, Object[] args, String defaultMsg) {
        //This is a convenient way to use and does not rely on request
        Locale locale = LocaleContextHolder.getLocale();
//        System.out.println("messageSource - "  + messageSource);
        return messageSource.getMessage(code, args, defaultMsg, locale);
    }
    
    public String getNotificationMessage(String code) {
        return getMessage(code, null);
    }

    public String getNotificationMessage(String code, Object[] args) {
        return getMessage(code, args, "");
    }
    
    public String getNotificationMessage(String code, Object[] args, String defaultMsg) {
        //This is a convenient way to use and does not rely on request
        Locale locale = LocaleContextHolder.getLocale();
//        System.out.println("notificationMessageSource - "  + notificationMessageSource);
        return notificationMessageSource.getMessage(code, args, defaultMsg, locale);
    }
}
