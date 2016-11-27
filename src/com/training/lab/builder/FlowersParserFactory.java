package com.training.lab.builder;


public enum FlowersParserFactory {
    DOM{
        @Override
        public AbstractFlowersParser getParser() {
            return new FlowersDOMBuilder();
        }
    },
    SAX{
        @Override
        public AbstractFlowersParser getParser() {
            return new FlowersSAXBuilder();
        }
    },
    STAX{
        @Override
        public AbstractFlowersParser getParser() {
            return new FlowersStAXBuilder();
        }
    };

    public abstract AbstractFlowersParser getParser();
}
