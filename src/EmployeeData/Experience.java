package EmployeeData;

public class Experience {
    private String techName;
    private String position;
    private int experienceYears;

    // Setters
    public void setTechName(String techName) {
        this.techName = techName;
    }
    public String getTechName() {
        return techName;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    // Getters
    public String getPosition() {
        return position;
    }
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
}
