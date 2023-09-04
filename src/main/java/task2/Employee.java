package task2;

public class Employee{
    private String name;
    private String surname;
    private Gender gender;
    private String jobTitle;
    private int wage;

    public Employee(){

    }
    public Employee(String name, String surname, Gender gender, String jobTitle, int wage) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.jobTitle = jobTitle;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", jobTitle='" + jobTitle + '\'' +
                ", wage=" + wage +
                '}';
    }
}


