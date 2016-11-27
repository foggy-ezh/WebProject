package com.training.lab.action;

import javax.servlet.http.HttpServletRequest;

public interface ICommandAction {
    String execute(HttpServletRequest request);
}
