package main.grade.model;

import java.util.ArrayList;

public class BoundaryValueTestingInput {

    private ArrayList<TestingInput> boundaryValueList;

    public BoundaryValueTestingInput() {
        boundaryValueList = new ArrayList<>();
    }

    public void addInput(TestingInput input) {
        boundaryValueList.add(input);
    }

    public ArrayList<TestingInput> getBoundaryValueList() {
        return boundaryValueList;
    }

    public void setPassOrFail() {
        for(TestingInput input: this.boundaryValueList){
            input.setPassOrFail();
        }
    }

    public String toCSV() {
        String result = "";
        for(TestingInput input: this.boundaryValueList){
            result = input.toCSV() + "\n";
        }
        return result;
    }
}
