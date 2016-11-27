package com.training.lab.action;

import javax.servlet.http.HttpServletRequest;

public class ClientCommand {

    private final String PARAM_COMMAND = "command";
    private final String PARSE = "parse";
    private final String CHANGE_LANGUAGE = "change_language";

    public ICommandAction getCurrentCommand(HttpServletRequest request){
        String action = request.getParameter(PARAM_COMMAND);
        switch (action){
            case PARSE:
                return new CommandParse();
            case CHANGE_LANGUAGE:
//                return new CommandChangeLanguage();
            default:
                  return  null;
        }
    }

}
