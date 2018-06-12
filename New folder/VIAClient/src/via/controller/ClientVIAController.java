package via.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import via.domain.mediator.Proxy;
import via.domain.mediator.VIAModel;
import via.domain.model.Event;
import via.domain.model.Lecturer;
import via.domain.model.Member;
import via.domain.model.Sponsor;
import via.view.VIAView;

public class ClientVIAController {
	
	private VIAModel model;
	private VIAView view;
	private Proxy proxy;
	
	public ClientVIAController(VIAModel model, VIAView view)
	{
		this.model = model;
		this.view = view;
		proxy = new Proxy(this.model);
		Observable obs = (Observable)this.model;
		obs.addObserver(this.view);
	}
	
	public void execute(int choice) throws IOException
	{
		switch(choice)
		{
			case 1:
//				ArrayList<Member> members = proxy.getMembersWhoHaventPaid();
//				view.show(members.toString()); break;
				proxy.getMembersWhoHaventPaid(); break;
			case 2:
				proxy.getMembers();break;
			case 3: 
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
				proxy.addMember(null);
		
			case 4: 
				proxy.getLecturers(); break;
			case 5: 
				proxy.getLecturersByCategory("astrology");break;
			case 6: 
				proxy.getAllEvents();break;
			case 7: 
				proxy.getEventsByType("lecture");break;
			case 8: 
				proxy.getSponsorsByTypeOfSponsorship("some type");break;
			case 0:
                proxy.close();
                System.exit(1);
                break;
			default: view.show("THERE IS NO SUCH OPTION"); break;
		}
	}

}
