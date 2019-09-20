package br.edu.univas;

import java.util.List;

public class App {

	public static void main(String[] args) {
		FlightDAO flightDAO = new FlightDAO();
		List<Flight> flights = flightDAO.getAll();
		
		for (Flight flight : flights) {
			System.out.println(flight);
		}
		
		FlightAdapter adapter = new FlightAdapterImpl();
		List<Flight> adapters = adapter.getAll();
		
		for(Flight flight : adapters){
			System.out.println(flight);
		}
		
		
	}
}

