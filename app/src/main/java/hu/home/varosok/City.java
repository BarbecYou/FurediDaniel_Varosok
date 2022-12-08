package hu.home.varosok;

public class City {
    private int id;
    private String name;
    private String country;
    private int population;

    public City(int id, String name, String country, int population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public City(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("%s, %s (%d)", this.getName(), this.getCountry(), this.getPopulation());
    }
}
