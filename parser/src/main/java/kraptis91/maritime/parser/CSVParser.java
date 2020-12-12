package kraptis91.maritime.parser;

import kraptis91.maritime.parser.dto.*;
import kraptis91.maritime.parser.exception.CSVParserException;
import kraptis91.maritime.parser.utils.CSVParserUtils;

import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

/** @author Konstantinos Raptis [kraptis at unipi.gr] on 9/12/2020. */
public class CSVParser {

  public static final Logger LOGGER = Logger.getLogger(CSVParser.class.getName());

  public SeaStateForecastDto extractSeaStateForecastDto(@NotNull String line)
      throws CSVParserException {
    // break the line at commas
    final String[] data = CSVParserUtils.splitLineAtCommas(line);
    // print data after split
    // LOGGER.info("Data extracted: " + Arrays.toString(data));
    // create the dto obj
    SeaStateForecastDto dto = new SeaStateForecastDto();
    // if a number format exception thrown, discard the line
    try {
      // loop through results
      for (int i = 0; i <= 7; i++) { // expecting 8 attributes

        switch (i) {
          case 0:
            dto.setLon(CSVParserUtils.parseDouble(data[i]));
            break;

          case 1:
            dto.setLat(CSVParserUtils.parseDouble(data[i]));
            break;

          case 2:
            dto.setDpt(CSVParserUtils.parseDoubleOrReturnDefault(data[i], -16384));
            break;

          case 3:
            dto.setWlv(CSVParserUtils.parseDoubleOrReturnDefault(data[i], -327.67));
            break;

          case 4:
            dto.setHs(CSVParserUtils.parseDoubleOrReturnDefault(data[i], -65.534));
            break;

          case 5:
            dto.setLm(CSVParserUtils.parseIntOrReturnDefault(data[i], -32767));
            break;

          case 7:
            dto.setTs(CSVParserUtils.parseLong(data[i]));
            break;
        }
      }
    } catch (CSVParserException | IllegalArgumentException e) {
      throw new CSVParserException(e);
    }

    return dto;
  }

  public NariStaticDto extractNariStaticDto(@NotNull String line) throws CSVParserException {

    // break the line at commas
    final String[] data = CSVParserUtils.splitLineAtCommas(line);
    // print data after split
    // LOGGER.info("Data extracted: " + Arrays.toString(data));
    // create the dto obj
    NariStaticDto dto = new NariStaticDto();
    // if a number format exception thrown, discard the line
    try {

      // loop through results
      for (int i = 0; i <= 13; i++) { // expecting 14 attributes

        switch (i) {
          case 0:
            dto.setMmsi(CSVParserUtils.parseInt(data[i]));
            break;

          case 1:
            dto.setImo(CSVParserUtils.parseInt(data[i]));
            break;

          case 2:
            dto.setCallSign(CSVParserUtils.parseTextOrReturnNull(data[i]));
            break;

          case 3:
            dto.setShipName(CSVParserUtils.parseTextOrReturnNull(data[i]));
            break;

          case 9:
            dto.setEta(CSVParserUtils.parseTextOrReturnNull(data[i]));
            break;

          case 10:
            dto.setDraught(CSVParserUtils.parseDouble(data[i]));
            break;

          case 11:
            dto.setDestination(CSVParserUtils.parseTextOrReturnNull(data[i]));
            break;
        }
      }
    } catch (CSVParserException | IllegalArgumentException e) {
      throw new CSVParserException(e);
    }

    return dto;
  }

  public MMSICountryCodesDto extractMmsiCountryCodesDto(@NotNull String line)
      throws CSVParserException {

    // break the line at commas
    final String[] data = CSVParserUtils.splitLineAtCommas(line);
    // print data after split
    // LOGGER.info("Data extracted: " + Arrays.toString(data));
    // create the dto obj
    MMSICountryCodesDto dto = new MMSICountryCodesDto();
    // if a number format exception thrown, discard the line
    try {

      // loop through results
      for (int i = 0; i <= 1; i++) { // expecting 2 attributes

        switch (i) {
          case 0:
            dto.setMmsiCountryCode(CSVParserUtils.parseInt(data[i]));
            break;

          case 1:
            dto.setCountry(CSVParserUtils.parseTextOrReturnNull(data[i]));
            break;
        }
      }
    } catch (CSVParserException | IllegalArgumentException e) {
      throw new CSVParserException(e);
    }

    return dto;
  }

  public ShipTypeListDto extractShipTypeListDto(@NotNull String line) throws CSVParserException {

    // break the line at commas
    final String[] data = CSVParserUtils.splitLineAtCommas(line);
    // print data after split
    // LOGGER.info("Data extracted: " + Arrays.toString(data));
    // create the dto obj
    ShipTypeListDto dto = new ShipTypeListDto();
    // if a number format exception thrown, discard the line
    try {

      // loop through results
      for (int i = 0; i <= 4; i++) { // expecting 5 attributes

        switch (i) {
          case 0:
            dto.setIdShipType(CSVParserUtils.parseInt(data[i]));
            break;

          case 3:
            dto.setTypeName(CSVParserUtils.parseTextOrReturnNull(data[i]));
            break;
        }
      }
    } catch (CSVParserException | IllegalArgumentException e) {
      throw new CSVParserException(e);
    }

    return dto;
  }

  public NariDynamicDto extractDynamicDto(@NotNull String line) throws CSVParserException {

    // break the line at commas
    final String[] data = CSVParserUtils.splitLineAtCommas(line);
    // print data after split
    // LOGGER.info("Data extracted: " + Arrays.toString(data));
    // create the dto obj
    NariDynamicDto dto = new NariDynamicDto();
    // if a number format exception thrown, discard the line
    try {

      // loop through results
      for (int i = 0; i <= 8; i++) { // expecting 9 attributes

        switch (i) {
          case 0:
            dto.setMmsi(CSVParserUtils.parseInt(data[i]));
            break;

          case 3:
            dto.setSpeed(CSVParserUtils.parseDouble(data[i]));
            break;

          case 6:
            dto.setLon(CSVParserUtils.parseDouble(data[i]));
            break;

          case 7:
            dto.setLat(CSVParserUtils.parseDouble(data[i]));
            break;

          case 8:
            dto.setT(CSVParserUtils.parseLong(data[i]));
            break;
        }
      }
    } catch (CSVParserException | IllegalArgumentException e) {
      throw new CSVParserException(e);
    }

    return dto;
  }

}
