package org.matsim.createNetwork;

import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.network.Network;
import org.matsim.contrib.accessibility.utils.MergeNetworks;
import org.matsim.core.api.internal.MatsimReader;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.network.algorithms.NetworkSimplifier;
import org.matsim.core.network.io.MatsimNetworkReader;
import org.matsim.core.router.util.PreProcessDijkstra;
import org.matsim.core.scenario.ScenarioUtils;

public class mergeNetwork {
    public static void main (String[] args) {

        Config config = ConfigUtils.createConfig();
        Scenario scenario = ScenarioUtils.createScenario(config);


        Network network_A = NetworkUtils.readNetwork("/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/network_car_wgs84_clean.xml");

        Network network_B = NetworkUtils.readNetwork("/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/network_pt_wgs84.xml");

        Network mergedNetwork = NetworkUtils.createNetwork();

        // Network simplifier start
        NetworkSimplifier netSimplifier = new NetworkSimplifier();
        netSimplifier.run(network_A);
        // Network simplifier end

        // Network preprocess Dijkstra start
        PreProcessDijkstra netDijkstra = new PreProcessDijkstra();
        netDijkstra.run(network_A);
        // Network preprocess Dijkstra end


        //new MatsimNetworkReader(scenario.getNetwork()).readFile("/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/network_unterschleissheim_clean.xml");

        MergeNetworks netMerger = new MergeNetworks();

        netMerger.merge(network_A, "CAR", network_B, "PT", mergedNetwork);

        NetworkUtils.writeNetwork(mergedNetwork, "/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/network_unterschleissheim_cleanWithPt.xml");


    }
}
