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
}
