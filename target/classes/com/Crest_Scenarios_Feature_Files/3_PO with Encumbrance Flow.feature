Feature: PO with Encumbrance Flow

Background: Login to the Application
Given Launch the Application
Then Login with valid Credentials


@Test21	
Scenario: Create PO with Encumbrance

	Given Create New PO with Encumbrance & Enter Organization & Supplier
	And Add Ship Groups for PO with Encumbrance
	And Add Products for PO with Encumbrance
	Then Validate GrandTotal & Tax for PO with Encumbrance
	And Approve PO for PO with Encumbrance  
	
