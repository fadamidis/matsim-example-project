package org.matsim.createPopulation;

import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.TransportMode;
import org.matsim.api.core.v01.population.*;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.gbl.MatsimRandom;
import org.matsim.core.population.PopulationUtils;
import org.matsim.core.scenario.ScenarioUtils;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import java.util.Random;

// Based on the coordinates from testfeldUnterschleissheim

public class randomDemand {

    private static final String NETWORK = "/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/network_car_wgs84_clean.xml";
    private static final String PLANS =  "/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/plans_10000.xml";

    private static double COORD_X_MIN = 11.5446156;
    private static double COORD_X_MAX = 11.6109164;

    private static double COORD_Y_MIN = 48.2661533;
    private static double COORD_Y_MAX = 48.3004814;


    public static void main (String[] args){


        Config config = ConfigUtils.createConfig();
        Scenario scenario = ScenarioUtils.createScenario(config);

        Population emptyPopulation = PopulationUtils.createPopulation(config);

        PopulationFactory factory = emptyPopulation.getFactory();

        for (int i=1; i <= 10000; i+=1 ){

            System.out.println("Creating person #" + i);
            Person person = factory.createPerson(Id.createPersonId(i));

            Plan plan1 = factory.createPlan();

            double x_home = returnRandom(COORD_X_MIN, COORD_X_MAX);
            double y_home = returnRandom(COORD_Y_MIN, COORD_Y_MAX);


            Activity home = factory.createActivityFromCoord("home", new Coord(x_home, y_home));
            home.setEndTime(returnRandom(7*60*60, 8*60*60));
            plan1.addActivity(home);

            Leg legToWork = factory.createLeg(TransportMode.car);
            plan1.addLeg(legToWork);

            Activity work = factory.createActivityFromCoord("work", new Coord(returnRandom(COORD_X_MIN, COORD_X_MAX), returnRandom(COORD_Y_MIN, COORD_Y_MAX)));
            work.setEndTime(returnRandom(16*60*60, 17*60*60));
            plan1.addActivity(work);

            Leg legToHome = factory.createLeg(TransportMode.car);
            plan1.addLeg(legToHome);

            Activity home2 = factory.createActivityFromCoord("home", new Coord(x_home, y_home));
            plan1.addActivity(home2);

            person.addPlan(plan1);

            emptyPopulation.addPerson(person);

        }


        PopulationWriter write = new PopulationWriter(emptyPopulation);

        write.write(PLANS);


    }

    public static double returnRandom(double min, double max){
        double random = new Random().nextDouble();
        return min + (random * (max - min));
    }

    public static double returnRandom(int min, int max){
        double random = new Random().nextDouble();
        return min + (random * (max - min));
    }


}
