package org.matsim.networkReader;

import org.matsim.run.NetworkCleaner;

public class CleanNetwork {
    public static void main (String[] args){

        NetworkCleaner cleaner = new NetworkCleaner();

        cleaner.run("/Users/adfil/Desktop/network_ush.xml",
                "/Users/adfil/Desktop/network_ush_clean.xml");

    }


}
