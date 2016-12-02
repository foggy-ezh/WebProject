package com.training.lab.action;

import com.training.lab.manager.ConfigurationManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class CommandUpload implements ICommandAction{
    private static final String SAVE_DIR = "uploadFiles";
    private static final String FILE = "file";
    private static final String FILE_NAME = "filename";
    private static final String CONTENT_DISPOSITION = "content-disposition";
    private static final String PATH_PAGE_MAIN = "path.page.main";
    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        Part part = request.getPart(FILE);
        String fileName = extractFileName(part);
        fileName = new File(fileName).getName();
        String fullName = savePath + File.separator + fileName;
        System.out.println(savePath + File.separator + fileName);
        part.write(fullName);
        request.getSession().setAttribute(FILE, fullName);
        System.out.println(request.getSession().getAttribute("locale"));
        System.out.println(request.getSession().getAttribute("language"));
        ConfigurationManager config = new ConfigurationManager();
        return config.getProperty(PATH_PAGE_MAIN);
    }
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader(CONTENT_DISPOSITION);
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith(FILE_NAME)) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
