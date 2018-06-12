package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.util.StringTokenizer;

public  class MemberList {

    private ObservableList<Member> memberList;

    public MemberList() {
        //BECAUSE OF THIS SHIT SEARCH FOR SPONSOR DIDNT WORK XD : memberList = FXCollections.observableArrayList();
        try {
            memberList = getMembersForTable();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  ObservableList<Member> getMembersForTable() throws IOException {
        ObservableList<Member> members = FXCollections.observableArrayList();
        String name,phoneNumber,email,address;
        LocalDate birthdate;
        Boolean endOfFile = false;
        DataInputStream inputFile = new DataInputStream(
                new FileInputStream("src\\InfoFiles\\members.dat"));
        while (!endOfFile) {
            try{
                String memberInfo = inputFile.readUTF();
                StringTokenizer stringTokenizer = new StringTokenizer(memberInfo, ";");
                name = stringTokenizer.nextToken();
                birthdate = getDate(stringTokenizer.nextToken());
                phoneNumber = stringTokenizer.nextToken();
                address = stringTokenizer.nextToken();
                email = stringTokenizer.nextToken();
                members.add(new Member(name, birthdate, address, email, phoneNumber));
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
        }
        inputFile.close();
        return members;
    }
    public void updateDataFile(ObservableList<Member> memberList) throws IOException {
        DataOutputStream outputFile = new DataOutputStream(
                new FileOutputStream("src\\InfoFiles\\members.dat"));
        for (int i = 0; i < memberList.size(); i++) {
             outputFile.writeUTF(memberList.get(i).toString());
        }
    }
    public ObservableList<Member> getMembers(){
       return memberList;
    }

    public static LocalDate getDate(String date) {
        StringTokenizer dateTokenizer = new StringTokenizer(date.trim(),"-");
        int year = Integer.parseInt(dateTokenizer.nextToken());
        int month = Integer.parseInt(dateTokenizer.nextToken());
        int day = Integer.parseInt(dateTokenizer.nextToken());
        return LocalDate.of(year,month,day);
    }
}
