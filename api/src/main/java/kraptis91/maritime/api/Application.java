package kraptis91.maritime.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import io.javalin.plugin.json.JavalinJackson;
import kraptis91.maritime.api.controller.CountryController;
import kraptis91.maritime.api.controller.PortController;
import kraptis91.maritime.api.controller.VesselController;
import kraptis91.maritime.api.enums.ServerConfig;

/**
 * @author Konstantinos Raptis [kraptis at unipi.gr] on 7/12/2020.
 */
public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins)
            .start(ServerConfig.INSTANCE.getPort());

        app.get("/", ctx -> ctx.result("Server Is Up and Running..."));
        app.get("/vessels", VesselController.getVessels);
        app.get("/vessels/types", VesselController.getShipTypes);
        app.get("/vessels/type/:type", VesselController.getPlainVesselsByShipType);
        app.get("/vessels/country/:code", VesselController.getPlainVesselsByCountryCode);
        app.get("/vessels/type/:type/country/:code", VesselController.getPlainVessels);
        app.get("/vessels/mmsi/:mmsi", VesselController.getVesselByMMSI);
        app.get("/vessels/name/:name", VesselController.getVesselByName);
        app.get("/vessels/trajectory/name/:name", VesselController.getVesselTrajectoryByName);
        app.get("/vessels/trajectory/mmsi/:mmsi", VesselController.getVesselTrajectoryByMMSI);
        app.get("/vessels/trajectory/keplergl/mmsi/:mmsi", VesselController.getKeplerGlVesselTrajectoryByMMSI);
        app.get("/vessels/near/lon/:lon/lat/:lat/dist/:dist", VesselController.getNearVessels);

        app.get("/ports", PortController.getPorts);
        app.get("/ports/country/:code", PortController.getPortsByCountryCode);
        app.get("/ports/near/lon/:lon/lat/:lat/dist/:dist", PortController.getNearPortsByReferencePoint);
        app.get("/ports/near/vessel/mmsi/:mmsi/dist/:dist", PortController.getNearPortsByMMSI);

        app.get("/countries", CountryController.getCountriesWith2ACodes);

        JavalinJackson.configure(
            new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL));
    }
}
