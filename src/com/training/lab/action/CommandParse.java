package com.training.lab.action;

import com.training.lab.builder.AbstractFlowersParser;
import com.training.lab.builder.FlowersParserFactory;
import com.training.lab.entity.Flower;
import com.training.lab.entity.IndoorFlower;
import com.training.lab.entity.OutdoorFlower;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CommandParse implements ICommandAction {
    private final String PARAM_PARSER_TYPE = "parserType";
    private final String PARAM_INDOOR_FLOWERS = "indoorFlowers";
    private final String PARAM_OUTDOOR_FLOWERS = "outdoorFlowers";
    private final String FILE_NAME = "/home/artem/IdeaProjects/WebProject/data/flowers.xml";

    @Override
    public String execute(HttpServletRequest request) {
        String type = request.getParameter(PARAM_PARSER_TYPE);
        AbstractFlowersParser parser = FlowersParserFactory.valueOf(type.toUpperCase()).getParser();
        parser.buildListFlowers(FILE_NAME);
        List<Flower> flowers = parser.getFlowers();
        List<IndoorFlower> indoorFlowers = new ArrayList<>();
        List<OutdoorFlower> outdoorFlowers = new ArrayList<>();

        for(Flower current : flowers){
            if(current instanceof IndoorFlower){
                indoorFlowers.add((IndoorFlower) current);
            }
            else if (current instanceof OutdoorFlower){
                outdoorFlowers.add((OutdoorFlower) current);
            }
        }

        request.setAttribute(PARAM_INDOOR_FLOWERS, indoorFlowers);
        request.setAttribute(PARAM_OUTDOOR_FLOWERS, outdoorFlowers);
        request.setAttribute(PARAM_PARSER_TYPE, type);

        return "/jsp/result.jsp";
    }
}
