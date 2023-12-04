package com.example;

public class Road implements Comparable<Road>{
    private String name;
    private Town town1, town2;
    private int distance;

    public Road(Town town1, Town town2, int distance, String name) {
		this.town1 = town1;
		this.town2 = town2;
		this.distance = distance;
		this.name = name;
	}

    public Road(Town town1, Town town2, String name) {
		this.town1 = town1;
		this.town2 = town2;
		this.name = name;
		this.distance = 1;
	}

    public boolean contains(Town town) {
		if(this.town1.equals(town) || this.town2.equals(town))
			return true;

		else
			return false;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Town getTown1() {
		return this.town1;
	}
	
	public Town getTown2() {
		return this.town2;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public int compareTo(Road road) {
		if(this.hashCode() == road.hashCode())
			return 0;

		else if(this.hashCode() > road.hashCode())
			return 1;

		else
			return -1;
	}
	
	public int getDistance()
	{
		return this.distance;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Road road = (Road) obj;
		if(this.getTown1().equals(road.getTown2())) {

			if(this.getTown2().equals(road.getTown2()))
				return true;

			else
				return false;

		} else if(this.getTown1().equals(road.getTown2())) {

			if(this.getTown2().equals(road.getTown1()))
				return true;

			else
				return false;

		} else
			return false;

	}
}
