package com.training.lab.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CommandBack implements ICommandAction {
    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        return PreviousPage.getPreviousPage(request);
    }
}
