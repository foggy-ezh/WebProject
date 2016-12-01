package com.training.lab.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandChangeLanguage implements ICommandAction {

    private static final String PARAM_LANGUAGE = "language";
    private static final String PARAM_LOCALE = "locale";
    private static final String DEFAULT_LOCALE_VALUE = "en_US";

    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        String language = request.getParameter(PARAM_LANGUAGE);
        HttpSession session = request.getSession(true);

        if(!language.isEmpty()) {
            session.setAttribute(PARAM_LANGUAGE, language);
            request.setAttribute(PARAM_LOCALE, language);
        } else {
            session.setAttribute(PARAM_LANGUAGE, DEFAULT_LOCALE_VALUE);
            request.setAttribute(PARAM_LOCALE, DEFAULT_LOCALE_VALUE);
        }

        return PreviousPage.getPreviousPage(request);
    }
}
