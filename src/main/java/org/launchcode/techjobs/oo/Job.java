package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        StringBuilder jobToString = new StringBuilder();
        String lineBreak = System.lineSeparator();
        String dataNotAvailable = "Data not available";

        jobToString.append(lineBreak);

        jobToString.append("ID: " + id);
        jobToString.append(lineBreak);

        jobToString.append("Name: ");
        jobToString.append(name.isEmpty() ? dataNotAvailable : name);
        jobToString.append(lineBreak);

//        String employer = getEmployer();
        jobToString.append("Employer: ");
        jobToString.append(getEmployer().getValue().isEmpty() || getEmployer().getValue() == null ? dataNotAvailable : getEmployer());
        jobToString.append(lineBreak);

        jobToString.append("Location: ");
        jobToString.append(getLocation().getValue().isEmpty() || getLocation().getValue() == null ? dataNotAvailable : getLocation());
        jobToString.append(lineBreak);

        jobToString.append("Position Type: ");
        jobToString.append(getPositionType().getValue().isEmpty() || getPositionType().getValue() == null ? dataNotAvailable : getPositionType());
        jobToString.append(lineBreak);

        jobToString.append("Core Competency: ");
        jobToString.append(getCoreCompetency().getValue().isEmpty() || getCoreCompetency().getValue() == null ? dataNotAvailable : getCoreCompetency());
        jobToString.append(lineBreak);

        return jobToString.toString();

//        return lineBreak +
//                "ID: " + id + lineBreak +
//                "Name: " + name + lineBreak +
//                "Employer: " + getEmployer() + lineBreak +
//                "Location: " + getLocation() + lineBreak +
//                "Position Type: " + getPositionType() + lineBreak +
//                "Core Competency: " + getCoreCompetency() +
//                lineBreak;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
