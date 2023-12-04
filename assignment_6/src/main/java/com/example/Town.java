package com.example;

import java.util.ArrayList;

public class Town implements Comparable<Town>{
    private String name;
    private ArrayList<Town> adjacentTowns;

    public Town(String name) {
		this.name = name;
		this.adjacentTowns = new ArrayList<Town>();
	}

    public Town(Town town) {
		this.name = new String(town.getName());
		this.adjacentTowns = new ArrayList<Town>(town.getAdjacent());
	}

    public String getName() {
		return this.name;
	}

    public ArrayList<Town> getAdjacent() {
		return this.adjacentTowns;
	}

    @Override
	public int compareTo(Town town) {
		if(this.hashCode() == town.hashCode())
			return 0;

		else if(this.hashCode() > town.hashCode())
			return 1;

		else
			return -1;
	}

    @Override
	public int hashCode() {
		return this.name.hashCode();
	}

    @Override
	public boolean equals(Object obj) {
		Town town = (Town) obj;

		if(this.getName().equals(town.getName()))
			return true;

		else
			return false;
	}

    public String toString() {
		return this.name;
	}
}
