package main.service;

import main.grade.model.BoundaryValueTestingInput;
import main.grade.model.TestingInput;

import java.io.*;

public class BoundaryValueDataSource implements DataSource<BoundaryValueTestingInput> {

    private String directoryName;
    private String filename;

    private BoundaryValueTestingInput boundaryValueTestingInputs = new BoundaryValueTestingInput();

    public BoundaryValueDataSource(String directoryName, String filename) {
        this.directoryName = directoryName;
        this.filename = filename;
        initialFileNotExist();
    }

    //Production
    public BoundaryValueDataSource() {
        this("Data", "BoundaryValues.csv");
    }

    private void initialFileNotExist() {
        File file = new File(directoryName);

        if(!file.exists()){ //ถ้าdirectory ไม่มีอยู่ให้สร้าง
            file.mkdir();
        }
        //check file --> ต้องการ path
        String path = directoryName+File.separator+filename;

        file = new File(path); //ชื่อ file.csv

        //ถ้าไม่มี file ให้สร้าง file
        if(!file.exists()){
            try {
                file.createNewFile();

            } catch (IOException e) { e.printStackTrace(); }
        }
    }

    @Override
    public BoundaryValueTestingInput readData() {
        String path = "Data"+File.separator+"BoundaryValues.csv";
        File file = new File(path);

        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);

            String line = "";

            while( (line = buffer.readLine()) != null){

                String[] data = line.split(",");
                if(data.length == 2) {
                    boundaryValueTestingInputs.addInput(new TestingInput(
                            Integer.parseInt(data[0]),
                            Integer.parseInt(data[1])
                    ));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boundaryValueTestingInputs;
    }

    @Override
    public void writeData(BoundaryValueTestingInput boundaryValueTestingInput) {
        String path = directoryName + File.separator + "BoundaryValueTestingOutput.csv";
        File file = new File(path);

        FileWriter writer = null;
        BufferedWriter buffer = null;
        // ป้องกันการเกิด Exception
        try {
            writer = new FileWriter(file);
            buffer = new BufferedWriter(writer);

            buffer.write(boundaryValueTestingInput.toCSV());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
