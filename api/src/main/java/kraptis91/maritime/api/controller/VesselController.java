package kraptis91.maritime.api.controller;

import io.javalin.http.Handler;
import kraptis91.maritime.api.service.ServiceFactory;
import org.eclipse.jetty.http.HttpStatus;

/**
 * @author Konstantinos Raptis [kraptis at unipi.gr] on 7/12/2020.
 */
public class VesselController {

    public static Handler getVesselsByShipType =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getVesselsByShipType(
                        ctx.pathParam("type"),
                        ctx.header("skip", Integer.class).get(),
                        ctx.header("limit", Integer.class).get()));

    public static Handler getVesselByMMSI =
        ctx ->
            ServiceFactory.createVesselService()
                .getVesselByMMSI(ctx.pathParam("mmsi", Integer.class).get())
                .ifPresentOrElse(ctx::json, () -> ctx.status(HttpStatus.NOT_FOUND_404));

    public static Handler getVesselByName =
        ctx ->
            ServiceFactory.createVesselService()
                .getVesselByName(ctx.pathParam("name"))
                .ifPresentOrElse(ctx::json, () -> ctx.status(HttpStatus.NOT_FOUND_404));

    public static Handler getVessels =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getVessels(
                        ctx.header("skip", Integer.class).get(),
                        ctx.header("limit", Integer.class).get()));

    public static Handler getShipTypes =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getShipTypes());

    public static Handler getVesselTrajectoryByName =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getVesselTrajectory(
                        ctx.pathParam("name")));

    public static Handler getVesselTrajectoryByMMSI =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getVesselTrajectory(
                        ctx.pathParam("mmsi", Integer.class).get()));

    public static Handler getNearVessels =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getNearVessels(
                        ctx.pathParam("lon", Double.class).get(),
                        ctx.pathParam("lat", Double.class).get(),
                        ctx.pathParam("dist", Double.class).get(),
                        ctx.header("skip", Integer.class).get(),
                        ctx.header("limit", Integer.class).get()));

    public static Handler getKeplerGlVesselTrajectoryByMMSI =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getKeplerGlVesselTrajectory(
                        ctx.pathParam("mmsi", Integer.class).get()));

    public static Handler getPlainVesselsByShipType =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getPlainVesselsByType(
                        ctx.pathParam("type"),
                        ctx.header("skip", Integer.class).get(),
                        ctx.header("limit", Integer.class).get()));

    public static Handler getPlainVesselsByCountryCode =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getPlainVesselByCountryCode(
                        ctx.pathParam("code"),
                        ctx.header("skip", Integer.class).get(),
                        ctx.header("limit", Integer.class).get()));

    public static Handler getPlainVessels =
        ctx ->
            ctx.json(
                ServiceFactory.createVesselService()
                    .getPlainVessels(
                        ctx.pathParam("type"),
                        ctx.pathParam("code"),
                        ctx.header("skip", Integer.class).get(),
                        ctx.header("limit", Integer.class).get()));
}
