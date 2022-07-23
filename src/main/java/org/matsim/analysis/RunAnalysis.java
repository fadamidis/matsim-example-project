package org.matsim.analysis;

import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.events.EventsUtils;

public class RunAnalysis {
    public static void main (String[] args){

        // Read scenario
        EventsManager eventsManager = EventsUtils.createEventsManager();
        SimpleEventsHandler handler = new SimpleEventsHandler();
        eventsManager.addHandler(handler);

        EventsUtils.readEvents(eventsManager, "/Users/adfil/Documents/MATSim/matsim-example-project/output/basic/output_events.xml.gz");





    }
}
