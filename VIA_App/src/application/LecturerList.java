package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class LecturerList {
    private ObservableList<Lecturer> lecturerList;


    public LecturerList() {
        lecturerList = FXCollections.observableArrayList();
        try {
            lecturerList = getLecturersForTable();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void addLecturer(Lecturer lecturer){
        lecturerList.add(lecturer);
    }

    private  ObservableList<Lecturer> getLecturersForTable() throws IOException {
        ObservableList<Lecturer> lecturers = FXCollections.observableArrayList();
        String name,phoneNumber,email,address,category,typeOfReward;
        LocalDate birthdate;
        Boolean endOfFile = false;
        DataInputStream inputFile = new DataInputStream(
                new FileInputStream("src\\InfoFiles\\lecturers.dat"));
        while (!endOfFile) {
            try{
                String lecturerInfo = inputFile.readUTF();
                StringTokenizer stringTokenizer = new StringTokenizer(lecturerInfo, ";");
                name = stringTokenizer.nextToken();
                birthdate = MemberList.getDate(stringTokenizer.nextToken());
                category = stringTokenizer.nextToken();
                phoneNumber = stringTokenizer.nextToken();
                email = stringTokenizer.nextToken();
                address = stringTokenizer.nextToken();
                typeOfReward = stringTokenizer.nextToken();
                lecturers.add(new Lecturer(name, birthdate, category, phoneNumber, email,address,typeOfReward));
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
        }
        inputFile.close();
        return lecturers;
    }
    public void updateDataFile(ObservableList<Lecturer> lecturerList) throws IOException {
        DataOutputStream outputFile = new DataOutputStream(
                new FileOutputStream("src\\InfoFiles\\lecturers.dat"));
        for (int i = 0; i < lecturerList.size(); i++) {
            outputFile.writeUTF(lecturerList.get(i).toString());
        }
    }
    public ObservableList<Lecturer> getLecturers(){
        return lecturerList;
    }
}