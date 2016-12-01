package com.training.lab.action;

import com.training.lab.manager.ConfigurationManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandInit implements ICommandAction {
    private static final String PARAM_LOCALE = "locale";
    private static final String DEFAULT_LOCALE = "en_US";
    private static final String PARAM_LANGUAGE = "language";
    private static final String PATH_PAGE_UPLOAD_FILE = "path.page.uploadFile";

    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        if (session.getAttribute(PARAM_LANGUAGE) == null) {
            session.setAttribute(PARAM_LANGUAGE, DEFAULT_LOCALE);
        }

        String currLanguage = (String) session.getAttribute(PARAM_LANGUAGE);
        request.setAttribute(PARAM_LOCALE, currLanguage);
        ConfigurationManager config = new ConfigurationManager();
        return config.getProperty(PATH_PAGE_UPLOAD_FILE);
    }
}
