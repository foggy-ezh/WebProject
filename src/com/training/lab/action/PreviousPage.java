package com.training.lab.action;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayDeque;

public class PreviousPage {
    private  static final String JSP_PATH = "jspPath";
    private  static boolean init;

    public static void setPreviousPage(HttpServletRequest request){
        String previousPage = request.getParameter(JSP_PATH);
        if(!previousPage.isEmpty()){
            if (!init){
                ArrayDeque<String> pagesHistory = new ArrayDeque<>();
                pagesHistory.add(previousPage);
                request.getSession(true).setAttribute(JSP_PATH, pagesHistory);
                init=true;
            } else {
                ArrayDeque<String> pagesHistory;
                pagesHistory = (ArrayDeque<String>) request.getSession().getAttribute(JSP_PATH);
                pagesHistory.addLast(previousPage);
                System.out.println(pagesHistory.toString());
                request.getSession(true).setAttribute(JSP_PATH, pagesHistory);
            }
        }
    }

    public static String getPreviousPage(HttpServletRequest request){
        ArrayDeque<String> pagesHistory = (ArrayDeque<String>) request.getSession().getAttribute(JSP_PATH);
        return pagesHistory.removeLast();
    }
}
