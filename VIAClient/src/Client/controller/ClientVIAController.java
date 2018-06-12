package Client.controller;

import java.io.IOException;
import java.util.Observable;

import Client.domain.mediator.VIAModel;
import Client.view.VIAView;

public class ClientVIAController {

    private VIAModel model;
    private VIAView view;

    public ClientVIAController(VIAModel model, VIAView view)
    {
        this.model = model;
        this.view = view;
        Observable obs = (Observable) model;
        obs.addObserver(this.view);
    }

    public void execute(int choice) throws IOException
    {
        switch(choice)
        {
            case 1:
                if (model.getMembersWhoHaventPaid().size() == 0) {
                    view.show("NO MEMBERS!");
                }
                else {
                    view.show(model.getMembersWhoHaventPaid().toString());
                }
                break;
            case 2:
                view.show(model.getMembers()+"");break;
            case 3:
                model.addMember(null);
                view.show("ACCESS DENIED!");
                break;
//				String name = view.get("What is the name?");
//				String address = view.get("What is the address?");
//				String email = view.get("What is the email?");
//				String phoneNumber = view.get("What is the phone number?");
//				long phoneNo = -1;
//				try
//				{
//					phoneNo = Long.parseLong(phoneNumber);
//				}
//				catch (NumberFormatException e) {}
//
//				Date birth = null;
//				try
//				{	String birthday = view.get("What is the birthday?");
//					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//					birth = (Date)formatter.parse(birthday);
//				}
//				catch (Exception e) {}
//
//				Date dateMembership = null;
//				try
//				{	String dateForMembership = view.get("What is the date for membership");
//					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//					dateMembership = (Date)formatter.parse(dateForMembership);
//				}
//				catch (Exception e) {}
//
//				String paymentStatus = view.get("What is the payment status (true/false)?");
//				Boolean hasPaidMembership = Boolean.valueOf(paymentStatus);
//				String starSign = view.get("What is the star sign?");
//				Member member = new Member(name, address, email, phoneNo, birth, dateMembership, hasPaidMembership, starSign);
//				proxy.addMember(null); break;

//			case 4:
//				proxy.getLecturers(); break;
//			case 5:
//				proxy.getLecturersByCategory("astrology");break;
//			case 6:
//				proxy.getAllEvents();break;
//			case 7:
//				proxy.getEventsByType("lecture");break;
//			case 8:
//				proxy.getSponsorsByTypeOfSponsorship("some type");break;
            case 0: {
                model.close();
                System.exit(1);
            }

            default: view.show("THERE IS NO SUCH OPTION"); break;
        }
    }

}
