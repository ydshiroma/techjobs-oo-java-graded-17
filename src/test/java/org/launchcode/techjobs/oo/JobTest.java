package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void emptyTest() {
        assertEquals(10,10,.001);
    }

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
//        assertSame(String.valueOf(job1String.charAt(0)), lineBreak);
//        assertTrue(String.valueOf(job1String.charAt(0)) == lineBreak);
        assertTrue(job1String.charAt(0) == '\n');
//        assertSame(String.valueOf(job1String.charAt( job1String.length() - 1 )), System.lineSeparator());
        assertTrue( ( job1String.charAt( job1String.length() - 1 ) ) == '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job1String = job1.toString();
        String lineBreak = System.lineSeparator();
        int id = job1.getId();

        String expectedOutput = lineBreak + "ID: " + id + lineBreak + "Name: Product tester" + lineBreak + "Employer: ACME" + lineBreak + "Location: Desert" + lineBreak + "Position Type: Quality control" + lineBreak + "Core Competency: Persistence" + lineBreak;
        assertSame(expectedOutput, job1String);


//        ID:  _______
//        Name: Product tester
//        Employer: ACME
//        Location: Desert
//        Position Type: Quality control
//        Core Competency: Persistence
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("", new Employer(), new Location(), new PositionType(), new CoreCompetency());
        String job1String = job1.toString();
        String lineBreak = System.lineSeparator();
        int id = job1.getId();

        String expectedOutput = lineBreak + "ID: " + id + lineBreak + "Name: Data not available" + lineBreak + "Employer: Data not available" + lineBreak + "Location: Data not available" + lineBreak + "Position Type: Data not available" + lineBreak + "Core Competency: Data not available" + lineBreak;
        assertSame(expectedOutput, job1String);
    }
}
