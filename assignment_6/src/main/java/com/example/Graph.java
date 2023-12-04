package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {
    private Set<Town> townSet;
	private ArrayList<Town> townList;
	private Set<Road> roadSet;
	private Road[][] adjMatrix;
	private int[] dijkstraParentArray;
	private int[] dijkstraDistanceArray;

    public Graph() {
		townSet = new HashSet<Town>();
		townList = new ArrayList<Town>();
		roadSet = new HashSet<Road>();
	}

    private void setAdjMatrixAdd() {
		Road[][] newMatrix = new Road[townSet.size() + 1][townSet.size() + 1];

		if(adjMatrix != null) {

			for(int i = 0; i < adjMatrix.length; i ++) {

				for(int j = 0; j < adjMatrix[i].length; j++)
					newMatrix[i][j] = adjMatrix[i][j];

			}
		}

		adjMatrix = newMatrix;
		return;
	}

    private void setAdjMatrixRemove(Town removedTown) {
		int townIndex = townList.indexOf(removedTown);
		int townNumber = townSet.size();

		while(townIndex < townNumber) {

			for (int i = 0; i < townNumber; ++i) 
                adjMatrix[i][townIndex] = adjMatrix[i][townIndex + 1];
            
            for (int i = 0; i < townNumber; ++i) 
            	adjMatrix[townIndex][i] = adjMatrix[townIndex + 1][i];
            
            townIndex++;
		}

		return;
	}

    @Override
	public Road getEdge(Town town1, Town town2) {
		if(townSet.contains(town1) && townSet.contains(town2)) 
			return adjMatrix[townList.indexOf(town1)][townList.indexOf(town2)];
		
		else
			return null;
	}

    public Town getVertex(Town v)
	{
		if(containsVertex(v))
			return townList.get(townList.indexOf(v));

		else
			return null;
	}

    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException, NullPointerException
	{
		if(sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();

		if(townSet.contains(sourceVertex) && townSet.contains(destinationVertex)) {

			if(adjMatrix[townList.indexOf(sourceVertex)][townList.indexOf(destinationVertex)] != null)
				return null;
				
			else {
				Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
				roadSet.add(newRoad);
				adjMatrix[townList.indexOf(sourceVertex)][townList.indexOf(destinationVertex)] = newRoad;
				adjMatrix[townList.indexOf(destinationVertex)][townList.indexOf(sourceVertex)] = newRoad;
				return newRoad;
			}

		} else 
			throw new IllegalArgumentException();
	}

    @Override
	public boolean addVertex(Town v) throws NullPointerException {
		if(v == null)
			throw new NullPointerException();

		if(townSet.contains(v))
			return false;

		else {
			townSet.add(v);
			townList.add(v);
			setAdjMatrixAdd();
			return true;
		}
	}

    @Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex)  {
		if(adjMatrix[townList.indexOf(sourceVertex)][townList.indexOf(destinationVertex)] != null)
			return true;

		else
			return false;
	}

    @Override
	public boolean containsVertex(Town v)  {
		if(townSet.contains(v))
			return true;

		else
			return false;
	}

    @Override
	public Set<Road> edgeSet() {
		return roadSet;
	}

    @Override
	public Set<Road> edgesOf(Town vertex) throws IllegalArgumentException, NullPointerException {
		if(vertex == null)
			throw new NullPointerException();

		if(!townSet.contains(vertex))
			throw new IllegalArgumentException();

		Set<Road> roads = new HashSet<Road>();
		for(int i = 0; i < townSet.size(); i++) {

			if(adjMatrix[townList.indexOf(vertex)][i] != null)
				roads.add(adjMatrix[townList.indexOf(vertex)][i]);

		}

		return roads;
	}

    @Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(townSet.contains(sourceVertex) && townSet.contains(destinationVertex)) {

			if(adjMatrix[townList.indexOf(sourceVertex)][townList.indexOf(destinationVertex)] != null) {

				Road removedRoad = adjMatrix[townList.indexOf(sourceVertex)][townList.indexOf(destinationVertex)];
				adjMatrix[townList.indexOf(sourceVertex)][townList.indexOf(destinationVertex)] = null;
				adjMatrix[townList.indexOf(destinationVertex)][townList.indexOf(sourceVertex)] = null;
				return removedRoad;

			} else
				return null;

		} else
			return null;
	}

    @Override
	public boolean removeVertex(Town v) {
		if(!townSet.contains(v))
			return false;

		else {
			setAdjMatrixRemove(v);
			townSet.remove(v);
			townList.remove(v);
			return true;
		}
	}

    @Override
	public Set<Town> vertexSet() {
		return townSet;
	}

    @Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> shortestList = new ArrayList<String>();
		int endIndex = townList.indexOf(destinationVertex);
		int startIndex = dijkstraParentArray[endIndex];

		while(startIndex != -1) {
			Town start = townList.get(startIndex);
			Town end = townList.get(endIndex);
			Road road = getEdge(start, end);

			if(road == null)
				break;

			String path = "" + 
            start.getName() + 
            " via " + road.getName() + 
            " to " + end.getName() + " " + 
            road.getDistance() + " mi";

			shortestList.add(0, path);
			endIndex = startIndex;
			startIndex = dijkstraParentArray[endIndex];
		}
		
		return shortestList;
	}

    @Override
	public void dijkstraShortestPath(Town sourceVertex) {
		int towns = townSet.size();
		dijkstraParentArray = new int[towns];
		int[] distances = new int[towns];
		Boolean shortestPathSet[] = new Boolean[towns];
		
		for(int i = 0; i < towns; i++) {
			distances[i] = Integer.MAX_VALUE;
			shortestPathSet[i] = false;
		}
		
		distances[townList.indexOf(sourceVertex)] = 0;
		dijkstraParentArray[townList.indexOf(sourceVertex)] = -1;
		
		for(int count = 0; count < towns - 1; count++) {
			int minDistance = Integer.MAX_VALUE;
			int minIndex = -1;

			for(int i = 0; i < towns; i++) {
				if(shortestPathSet[i] == false && minDistance >= distances[i]) {
					minDistance = distances[i];
					minIndex = i;
				}
			}
			
			shortestPathSet[minIndex] = true;
		
			for(int k = 0; k < towns; k++) {
				if(!shortestPathSet[k] && 
                adjMatrix[minIndex][k] != null && 
                distances[minIndex] != Integer.MAX_VALUE && 
                distances[minIndex] + adjMatrix[minIndex][k].getDistance() < distances[k]) {
					distances[k] = distances[minIndex] + adjMatrix[minIndex][k].getDistance();
					dijkstraParentArray[k] = minIndex;
				}
			}
			
		}

		dijkstraDistanceArray = distances;
		return;
		
	}
}
