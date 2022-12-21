package vTiger.ContactsTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
import vtiger.GenericUtilities.BaseClass;


@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)

public class CreateContactWithOrganizationTest extends BaseClass{
	
        @Test(groups="SmokeSuite")
        public void createContactWithOrg() throws IOException
	    {
		String LASTNAME = eutil.readDataFromExcel("contacts", 4, 2);
		String ORGNAME = eutil.readDataFromExcel("contacts", 4, 3)+jutil.getRandomNumber();
		
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.ClickonOrganizationLnk();
	    
		Reporter.log("navigate to organization");
		 
		//step 6 : click on create organization look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.ClickOnOrganizationLookupImg();
		Reporter.log("click on create org look up image");
		
		
		// create organization with mandatory details and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.CreateNewOrganization(ORGNAME);
		Reporter.log("created organization with"+ORGNAME);
		
		// validate the organization
		OrganizationInfoPage oip =new OrganizationInfoPage(driver);
		String OrgHeader=oip.getOrganizationHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		// navigate to contacts link
		hp.ClickonContactsLnk();
		
		
		// create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.ClickonCreateContactImg();
		
		// create contact with mandatory fields
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME, ORGNAME, driver);
		
		// validate for contacts
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		Assert.assertEquals(ContactHeader.contains(LASTNAME), true);
		
	}
        
        @Test(groups="RegressionSuite")
        public void demoTest()
        {
        	System.out.println(" This is demo");
        }
        
}
