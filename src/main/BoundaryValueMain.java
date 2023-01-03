package main;

import main.grade.model.BoundaryValueTestingInput;
import main.service.BoundaryValueDataSource;
import main.service.DataSource;

public class BoundaryValueMain {
    public static void main(String[] args) {
        DataSource<BoundaryValueTestingInput> dataSource = new BoundaryValueDataSource();
        BoundaryValueTestingInput inputs = dataSource.readData();

        inputs.setPassOrFail();
        dataSource.writeData(inputs);
    }
}
