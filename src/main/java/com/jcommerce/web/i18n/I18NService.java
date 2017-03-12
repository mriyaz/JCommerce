package com.jcommerce.web.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by Riyazuddin M on 3/12/2017.
 */
@Service
public class I18NService {
    /*The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(I18NService.class);
    
    @Autowired
    private MessageSource messageSource;

    /**
     * Returns a message for the given message id and the default locale in the session context
     *
     * @param messageId The key to the messages resource file
     **/
    public String getMessage(String messageId) {
        LOG.info("Returning i18n text for messageId {}",messageId);
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(messageId, locale);
    }

    /**
     * Returns a messsage for the given message id and locale
     *
     * @param messageId The key to the messages resource file
     * @param locale    The Locale
     **/
    public String getMessage(String messageId, Locale locale) {
        return messageSource.getMessage(messageId,null,locale);
    }

}
