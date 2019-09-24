package br.edu.univas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public interface FlightAdapter {
	
	public List<Flight> getAll();

	void readFlightInformation(List<Flight> flights);

	ZonedDateTime stringToZonedDateTime(String date);


}
