package com.marketplaces.www.enums;

public class QueueNames {

    private static final String transactionalQueue = "transactional";
    private static final String promotionalHighQueue = "promotionalHigh";
    private static final String promotionalMedQueue = "promotionalMed";
    private static final String promotionalLowQueue = "promotionalLow";

    public enum Queues {
        transactionalQueue,
        promotionalHighQueue,
        promotionalMedQueue,
        promotionalLowQueue;
    }
}



