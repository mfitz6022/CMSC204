package com.example;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TownGraphManager implements TownGraphManagerInterface {
    private Graph townGraph;

    public TownGraphManager() {
        townGraph = new Graph();
    }

    @Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town start = new Town(town1), end = new Town(town2);
		try {
			if(townGraph.addEdge(start, end, weight, roadName) != null)
				return true;

			else
				return false;

		} catch(Exception e) {
			return false;
		}
	}

    @Override
	public String getRoad(String town1, String town2) {
		Town start = new Town(town1), end = new Town(town2);
		Road road = townGraph.getEdge(start, end);

		if(road != null)
			return road.getName();

		else
			return null;
    }

    @Override
    public boolean addTown(String v) {
		Town newTown = new Town(v);
		return townGraph.addVertex(newTown);
	}

    @Override
	public Town getTown(String name) {
		Town newTown = new Town(name);
		return townGraph.getVertex(newTown);
	}

    @Override
	public boolean containsTown(String v) {
		Town newTown = new Town(v);
		return townGraph.containsVertex(newTown);
	}

    @Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town start = new Town(town1), end = new Town(town2);
		return townGraph.containsEdge(start, end);
	}

    @Override
	public ArrayList<String> allRoads() {
		Set<Road> roadSet = townGraph.edgeSet();
		TreeSet<String> sortedNames = new TreeSet<String>();
		Iterator<Road> roadIterator = roadSet.iterator();

		while(roadIterator.hasNext()) 
			sortedNames.add(roadIterator.next().getName());
		
		Iterator<String> sortedRoadIterator = sortedNames.iterator();
		ArrayList<String> roadList = new ArrayList<String>();

		while(sortedRoadIterator.hasNext()) 
			roadList.add(sortedRoadIterator.next());
		
		return roadList;
	}

    @Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town start = new Town(town1), end = new Town(town2);
		Road targetRoad = townGraph.getEdge(start, end);

		if(targetRoad != null) {
			if(townGraph.removeEdge(start, end, targetRoad.getDistance(), road) != null)
				return true;

			else
				return false;
		} else
			return false;
	}

    @Override
	public boolean deleteTown(String v) {
		Town newTown = new Town(v);
		return townGraph.removeVertex(newTown);
	}

    @Override
	public ArrayList<String> allTowns() {
		Set<Town> townSet = townGraph.vertexSet();
		TreeSet<String> sortedNames = new TreeSet<String>();
		Iterator<Town> townIterator = townSet.iterator();

		while(townIterator.hasNext())
			sortedNames.add(townIterator.next().getName());

		Iterator<String >sortedTownIterator = sortedNames.iterator();
		ArrayList<String> townList = new ArrayList<String>();

		while(sortedTownIterator.hasNext())
			townList.add(sortedTownIterator.next());

		return townList;
	}

    @Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town start = new Town(town1), end = new Town(town2);
		return townGraph.shortestPath(start, end);
	}

    public void populateTownGraph(File dataFile) throws FileNotFoundException{
        try {
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
				String[] roadParts = parts[0].split(",");

                if (parts.length == 3) {
                    String roadName = roadParts[0];
                    int distance = Integer.parseInt(roadParts[1]);
                    String town1 = parts[1];
                    String town2 = parts[2];
                    addRoad(town1, town2, distance, roadName);
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }

			reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 

    }
}
