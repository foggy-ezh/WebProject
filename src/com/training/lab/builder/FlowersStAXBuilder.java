package com.training.lab.builder;

import com.training.lab.constant.FlowersStructure;
import com.training.lab.entity.*;
import com.training.lab.exception.FlowersException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FlowersStAXBuilder extends AbstractFlowersParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String DASH = "-";
    private static final String UNDERLINE = "_";


    private XMLInputFactory inputFactory;

    public FlowersStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public void buildListFlowers(String fileName) {

        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();

                if (XMLStreamConstants.START_ELEMENT == type) {
                    name = reader.getLocalName();

                    if (FlowersStructure.INDOOR_FLOWER.getValue().equals(name)) {
                        Flower flower = buildIndoorFlower(reader);
                        getFlowers().add(flower);
                    } else if (FlowersStructure.OUTDOOR_FLOWER.getValue().equals(name)) {
                        Flower flower = buildOutdoorFlower(reader);
                        getFlowers().add(flower);
                    }
                }
            }
        } catch (XMLStreamException | IOException | FlowersException e) {
            LOGGER.log(Level.FATAL, e);
            throw new RuntimeException();
        }
    }

    private IndoorFlower buildIndoorFlower(XMLStreamReader reader) throws XMLStreamException, FlowersException {
        IndoorFlower flower = new IndoorFlower();
        flower.setName(reader.getAttributeValue(null, FlowersStructure.NAME.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();

            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName().toUpperCase().replace(DASH, UNDERLINE);

                switch(FlowersStructure.valueOf(name)){
                    case ORIGIN:
                        flower.setOrigin(getXMLText(reader));
                        break;
                    case SOIL:
                        flower.setSoil(SoilType.valueOf(
                                getXMLText(reader).toUpperCase().replace(DASH, UNDERLINE)));
                        break;
                    case PARAMETERS:
                        flower.setParameters(buildParameters(reader));
                        break;
                    case MULTIPLYING:
                        flower.setMultiplying(MultiplyingType.valueOf(
                                getXMLText(reader).toUpperCase().replace(DASH, UNDERLINE)));
                        break;
                    case GROWING_TIPS:
                        flower.setGrowingTips(buildGrowingTips(reader));
                        break;
                    default:
                        throw new FlowersException("Wrong Enum present Flowers Structure:" + name);
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name  = reader.getLocalName();

                if (FlowersStructure.INDOOR_FLOWER.getValue().equals(name)) {
                    return flower;
                }
            }
        }
        throw new FlowersException("Unknown element in tag IndoorFlower");
    }

    private OutdoorFlower buildOutdoorFlower(XMLStreamReader reader) throws XMLStreamException, FlowersException {
        OutdoorFlower flower = new OutdoorFlower();
        flower.setName(reader.getAttributeValue(null, FlowersStructure.NAME.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName().toUpperCase().replace(DASH, UNDERLINE);
                switch(FlowersStructure.valueOf(name)){
                    case ORIGIN:
                        flower.setOrigin(getXMLText(reader));
                        break;
                    case SOIL:
                        flower.setSoil(SoilType.valueOf(
                                getXMLText(reader).toUpperCase().replace(DASH, UNDERLINE)));
                        break;
                    case PARAMETERS:
                        flower.setParameters(buildParameters(reader));
                        break;
                    case MULTIPLYING:
                        flower.setMultiplying(MultiplyingType.valueOf(
                                getXMLText(reader).toUpperCase().replace(DASH, UNDERLINE)));
                        break;
                    case BLOOMING_PERIOD:
                        flower.setBloomingPeriod(BloomingPeriodType.valueOf(
                                getXMLText(reader).toUpperCase().replace(DASH, UNDERLINE)));
                        break;
                    default:
                        throw new FlowersException("Wrong Enum present Flowers Structure:" + name);
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name  = reader.getLocalName();

                if (FlowersStructure.OUTDOOR_FLOWER.getValue().equals(name)) {
                    return flower;
                }
            }
        }
        throw new FlowersException("Unknown element in tag OutdoorFlower");
    }

    private Parameters buildParameters(XMLStreamReader reader) throws XMLStreamException, FlowersException {
        Parameters parameters = new Parameters();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName().toUpperCase().replace(DASH, UNDERLINE);
                switch(FlowersStructure.valueOf(name)){
                    case STEM_COLOR:
                        parameters.setStemColor(getXMLText(reader));
                        break;
                    case LEAF_COLOR:
                        parameters.setLeafColor(getXMLText(reader));
                        break;
                    case AVG_SIZE:
                        parameters.setAvgSize(Double.valueOf(getXMLText(reader)));
                        break;
                    default:
                        throw new FlowersException("StAX. Wrong Enum present Flowers Structure:" + name);
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name = reader.getLocalName();

                if (FlowersStructure.PARAMETERS.getValue().equals(name)) {
                    return parameters;
                }
            }
        }
        throw new FlowersException("Unknown element in tag Parameters");
    }

    private GrowingTips buildGrowingTips(XMLStreamReader reader) throws XMLStreamException, FlowersException {
        GrowingTips growingTips = new GrowingTips();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName().toUpperCase().replace(DASH, UNDERLINE);
                switch(FlowersStructure.valueOf(name)){
                    case TEMPERATURE:
                        growingTips.setTemperature(Double.valueOf(getXMLText(reader)));
                        break;
                    case REQUIRED_LIGHTING:
                        growingTips.setLightingType(LightingType.valueOf(
                                getXMLText(reader).toUpperCase().replace(DASH, UNDERLINE)));
                        break;
                    case WATER_NEED:
                        growingTips.setWaterNeed(Double.valueOf(getXMLText(reader)));
                        break;
                    default:
                        throw new FlowersException("Wrong Enum present Flowers Structure:" + name);
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name = reader.getLocalName();

                if (FlowersStructure.GROWING_TIPS.getValue().equals(name)) {
                    return growingTips;
                }
            }
        }
        throw new FlowersException("Unknown element in tag GrowingTips");
    }



    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}