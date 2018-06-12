package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ClubMemberList {
    private ObservableList<ClubMember> clubMemberList;
    DatabaseAdapter adapter= new DatabaseAdapter();

    LocalDate date= LocalDate.of(1998,03,04);
    public ClubMemberList() {
        clubMemberList = adapter.loadClubMembers();

    }

    public ObservableList<ClubMember> getClubMembers() {
        return clubMemberList;
    }
    public void addClubMember(String name, String address, String id, LocalDate birthday, int phoneNumber, String email, LocalDate membershipDate, boolean subscription){
        clubMemberList.add(new ClubMember(name, id, birthday, phoneNumber, email,address, membershipDate, subscription));
    }


    public void updateList(ObservableList <ClubMember> clubMembers) {
        clubMemberList= clubMembers;
    }
}
