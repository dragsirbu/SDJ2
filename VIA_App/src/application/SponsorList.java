package application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.StringTokenizer;

public class SponsorList {
    private ObservableList<Sponsor> sponsorList;

    public SponsorList() {
        try {
            sponsorList = getSponsorsForTable();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private  ObservableList<Sponsor> getSponsorsForTable() throws IOException {
        ObservableList<Sponsor> sponsors = FXCollections.observableArrayList();
        String name,phoneNumber,email,address,typeOfSponsorship;
        Boolean endOfFile = false;
        DataInputStream inputFile = new DataInputStream(
                new FileInputStream("src\\InfoFiles\\sponsors.dat"));
        while (!endOfFile) {
            try{
                String sponsorInfo = inputFile.readUTF();
                StringTokenizer stringTokenizer = new StringTokenizer(sponsorInfo, ";");
                name = stringTokenizer.nextToken();
                phoneNumber = stringTokenizer.nextToken();
                email = stringTokenizer.nextToken();
                address = stringTokenizer.nextToken();
                typeOfSponsorship = stringTokenizer.nextToken();
                sponsors.add(new Sponsor(name, phoneNumber, email, address, typeOfSponsorship));
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
        }
        inputFile.close();
        return sponsors;
    }
    public void updateDataFile(ObservableList<Sponsor> sponsorList) throws IOException {
        DataOutputStream outputFile = new DataOutputStream(
                new FileOutputStream("src\\InfoFiles\\sponsors.dat"));
        for (int i = 0; i < sponsorList.size(); i++) {
            outputFile.writeUTF(sponsorList.get(i).toString());
        }
    }
    public ObservableList<Sponsor> getSponsors(){
        return sponsorList;
    }
}