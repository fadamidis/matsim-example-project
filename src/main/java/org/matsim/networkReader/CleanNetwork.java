package org.matsim.networkReader;

import org.matsim.run.NetworkCleaner;

public class CleanNetwork {
    public static void main (String[] args){

        NetworkCleaner cleaner = new NetworkCleaner();

        cleaner.run("/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/network_unterschleissheim.xml",
                "/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/network_unterschleissheim_clean.xml");

    }


}
