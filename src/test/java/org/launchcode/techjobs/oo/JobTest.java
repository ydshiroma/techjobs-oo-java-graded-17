package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job roadRunner = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", roadRunner.getName());
        assertEquals("ACME", roadRunner.getEmployer().getValue());
        assertEquals("Desert", roadRunner.getLocation().getValue());
        assertEquals("Quality control", roadRunner.getPositionType().getValue());
        assertEquals("Persistence", roadRunner.getCoreCompetency().getValue());

        assertTrue(roadRunner.getName() instanceof String);
        assertTrue(roadRunner.getEmployer() instanceof Employer);
        assertTrue(roadRunner.getLocation() instanceof Location);
        assertTrue(roadRunner.getPositionType() instanceof PositionType);
        assertTrue(roadRunner.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job cat1 = new Job("Beloved housecat", new Employer("Shiroma Household"), new Location("West Philadelphia"), new PositionType("Pet"), new CoreCompetency("Cuteness"));
        Job cat2 = new Job("Beloved housecat", new Employer("Shiroma Household"), new Location("West Philadelphia"), new PositionType("Pet"), new CoreCompetency("Cuteness"));
        assertNotEquals(cat1, cat2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job1String = job1.toString();
        String lineBreak = System.lineSeparator();

        assertEquals("String starts with newline", lineBreak, String.valueOf(job1String.charAt(0)));
        assertEquals("String ends with newline", lineBreak, String.valueOf(job1String.charAt( job1String.length() - 1 )));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job1String = job1.toString();
        String lineBreak = System.lineSeparator();
        int id = job1.getId();

        String expectedOutput = lineBreak + "ID: " + id + lineBreak + "Name: Product tester" + lineBreak + "Employer: ACME" + lineBreak + "Location: Desert" + lineBreak + "Position Type: Quality control" + lineBreak + "Core Competency: Persistence" + lineBreak;
        assertEquals(expectedOutput, job1String);


//        ID:  _______
//        Name: Product tester
//        Employer: ACME
//        Location: Desert
//        Position Type: Quality control
//        Core Competency: Persistence
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String lineBreak = System.lineSeparator();

        Job job1 = new Job("Front End Developer", new Employer(""), new Location(""), new PositionType("Developer"), new CoreCompetency(""));
        String job1String = job1.toString();
        int id1 = job1.getId();

        String expectedOutput1 = lineBreak + "ID: " + id1 + lineBreak + "Name: Front End Developer" + lineBreak + "Employer: Data not available" + lineBreak + "Location: Data not available" + lineBreak + "Position Type: Developer" + lineBreak + "Core Competency: Data not available" + lineBreak;
        assertEquals("Data missing for employer, location, and core competency", expectedOutput1, job1String);

        Job job2 = new Job("", new Employer("Waystar Royco"), new Location("New York"), new PositionType(""), new CoreCompetency("Deviousness"));
        String job2String = job2.toString();
        int id2 = job2.getId();
        String expectedOutput2 = lineBreak + "ID: " + id2 + lineBreak + "Name: Data not available" + lineBreak + "Employer: Waystar Royco" + lineBreak + "Location: New York" + lineBreak + "Position Type: Data not available" + lineBreak + "Core Competency: Deviousness" + lineBreak;
        assertEquals("Data missing for name and position type", expectedOutput2, job2String);

        Job job3 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String job3String = job3.toString();
        String expectedOutput3 = "OOPS! This job does not seem to exist";
        assertEquals("Data missing for all fields except ID", expectedOutput3, job3String);
    }
}
