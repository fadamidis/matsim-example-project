/*
package org.matsim.networkReader;

import de.topobyte.osm4j.core.model.iface.OsmNode;
import org.matsim.api.core.v01.network.Network;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.utils.geometry.CoordinateTransformation;
import org.matsim.core.utils.geometry.transformations.TransformationFactory;
import org.matsim.core.utils.io.OsmNetworkReader;

@Deprecated
public class ReadNetworkDeprecated {

    private static final String inputFile = "/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/map_unterschleissheim.osm";
    private static final Path outputFile = "/Users/adfil/Documents/MATSim/matsim-example-project/unterschleissheim/network_unterschleissheim.xml";
    private static final String targetCoord = "EPSG:25832";

    public static void main (String[] args){

        Network network = NetworkUtils.createNetwork();

        // OSM uses WGS84
        // MATSim prefers

        CoordinateTransformation transformation = TransformationFactory.getCoordinateTransformation(TransformationFactory.WGS84, targetCoord);

        OsmNetworkReader reader = new OsmNetworkReader(network, transformation, true, true);
        reader.addOsmFilter(new NetworkFilter(filterSHape));

        OsmNetworkReader networkReader = new OsmNetworkReader(Network networkDeprecated, );






        networkReader.parse(inputFile);
        networkReader.
    }
}
*/
