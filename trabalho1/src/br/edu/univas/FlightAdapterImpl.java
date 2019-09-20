package br.edu.univas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightAdapterImpl implements FlightAdapter {

	@Override
	public List<Flight> getAll() {
		List<Flight> flights = new ArrayList<>();
		readFlightInformation(flights);
		return flights;
	}

	@Override
	public void readFlightInformation(List<Flight> flights) {
		try {
			InputStream inputStream = FlightDAO.class.getResourceAsStream("/flights");
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String line = null;
			String from = null;
			String to = null;

			do {

				if (line != null) {
					if (from == null && to == null) {
						String[] route = line.split("-");
						from = route[0];
						to = route[1];
					} else {
						Flight flight = new Flight();
						flight.setFrom(from);
						flight.setTo(to);

						String[] flightInformation = line.split("\t");
						flight.setCompany(flightInformation[0]);
						flight.setDeparture(stringToZonedDateTime(flightInformation[1]));
						flight.setArrival(stringToZonedDateTime(flightInformation[2]));
						flights.add(flight);
					}
				}

				line = bufferedReader.readLine();

			} while (line != null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ZonedDateTime stringToZonedDateTime(String date) {
		return convertZonedDataTime(ZonedDateTime.parse(date));
	}
	
	private ZonedDateTime convertZonedDataTime(ZonedDateTime old){
		return old.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
	}

}
