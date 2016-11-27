package com.training.lab.builder;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class FlowersSAXBuilder extends AbstractFlowersParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private FlowersHandler flowerHandler;
    private XMLReader reader;

    public FlowersSAXBuilder(){
        flowerHandler = new FlowersHandler();
        try{
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(flowerHandler);
        } catch (SAXException e){
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        }
    }

    public void buildListFlowers(String fileName){
        try{
            reader.parse(fileName);
        } catch (SAXException | IOException e){
            LOGGER.log(Level.FATAL, e);
        }
        setFlowers(flowerHandler.getFlowers());
    }
}
