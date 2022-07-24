package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.ActivityEndEvent;
import org.matsim.api.core.v01.events.ActivityStartEvent;
import org.matsim.api.core.v01.events.handler.ActivityEndEventHandler;
import org.matsim.api.core.v01.events.handler.ActivityStartEventHandler;
import org.matsim.api.core.v01.population.Person;

import java.util.HashMap;
import java.util.Map;

public class SimpleEventsHandler implements ActivityStartEventHandler, ActivityEndEventHandler {

    private final Map<Id<Person>, Double> personToStartTime = new HashMap<>();

    @Override
    public void handleEvent(ActivityEndEvent activityEndEvent) {

        personToStartTime.put(activityEndEvent.getPersonId(), activityEndEvent.getTime());
        System.out.println("Person" + activityEndEvent.getPersonId().toString() + " finished activity " + activityEndEvent.getActType() +  " at " + activityEndEvent.getTime());
    }

    @Override
    public void handleEvent(ActivityStartEvent activityStartEvent) {
        System.out.println("Person" + activityStartEvent.getPersonId().toString() + " started activity at " + activityStartEvent.getTime());
        double startTime = personToStartTime.get(activityStartEvent.getPersonId());
        double travelTime = activityStartEvent.getTime() - startTime;
        System.out.println("Travel time was " + travelTime);
    }
}
