Feature: WSSD Grievance Management

Scenario Outline: Register Grievance

Given User navigates to Register Grievance Page through WSSD
When User Enter Grievance related details
And Enter <category>, <subCat>, <Level> , <District>, <Block>, <GP>, <Habitation> , <Village>
Then Grievance is registered sucessfully 

Examples:
|LevelDistrict|Block|GP|Habitation|Village|District|category|subCat|
|Habitation|NANDED|ALEGAON|ALEGAON|ALEGAON|NANDED|IHHL|There is a delay in subsidy|
