package vTiger.OrganizationsTests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
import vtiger.GenericUtilities.BaseClass;

public class CreateOrganizationTest extends BaseClass {

        @Test
        public void createOrganizationTest() throws IOException
         {
				/* excel file - test data */
				String ORGNAME = eutil.readDataFromExcel("organizations", 1, 2)+jutil.getRandomNumber();
				    		
						//click on organization link
				        HomePage hp = new HomePage(driver);
						hp.ClickonOrganizationLnk();
						
						// click on create organization lookup image
						OrganizationsPage op = new OrganizationsPage(driver);
						op.ClickOnOrganizationLookupImg();
						
						//create new organization with mandatory fields and click on save button
						CreateNewOrganizationPage cnop =new CreateNewOrganizationPage(driver);
						cnop.CreateNewOrganization(ORGNAME);
				       
						//validation
						OrganizationInfoPage oip = new OrganizationInfoPage(driver);
						String OrgHeader = oip.getOrganizationHeaderText();
						Assert.assertTrue(OrgHeader.contains(ORGNAME));		

	}

}
