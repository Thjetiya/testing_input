package main.grade.model;

public class TestingInput {

    private int credit;
    private int grade;

    private String result;

    public TestingInput(int grade, int credit) {
        this.credit = credit;
        this.grade = grade;
        this.result = "N";
    }

    public int getCredit() {
        return credit;
    }

    public int getGrade() {
        return grade;
    }

    public String getResult() {
        return result;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setPassOrFail() {
        if (this.credit >= 0 && this.credit <= 134 && this.grade >= 0 && this.grade <= 4) {
            this.result = "P";
        }
        else {
            this.result = "F";
        }
    }

    public String toCSV() {
        return grade + "," + credit + "," + result;
    }

}