package com.training.lab.action;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ClientCommand {
    private final Logger LOGGER = LogManager.getLogger();
    private final String PARAM_COMMAND = "command";
    private final String PARSE = "parse";
    private final String UPLOAD = "upload";
    private final String CHANGE_LANGUAGE = "change_language";
    private final String BACK = "back";

    public ICommandAction getCurrentCommand(HttpServletRequest request){
        String action = request.getParameter(PARAM_COMMAND);
        LOGGER.log(Level.INFO, "Action command =" + action);
        switch (action){
            case UPLOAD:
                return new CommandUpload();
            case PARSE:
                return new CommandParse();
            case BACK:
                return new CommandBack();
            case CHANGE_LANGUAGE:
//                return new CommandChangeLanguage();
            default:
                  return  null;
        }
    }

}
