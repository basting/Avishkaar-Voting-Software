# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 
# Database:             avishkar_voting
# Server version:       5.0.41-community-nt
# Server OS:            Win32
# Target-Compatibility: MySQL 4.0
# Extended INSERTs:     Y
# max_allowed_packet:   1048576
# HeidiSQL version:     3.0 Revision: 572
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1*/;


#
# Database structure for database 'avishkar_voting'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `avishkar_voting` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `avishkar_voting`;


#
# Table structure for table 'table_idea'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `table_idea` (
  `idea_no` bigint(20) NOT NULL COMMENT 'The idea number.',
  `innovator` varchar(200) default NULL COMMENT 'The name of innovators.',
  `site` varchar(20) default NULL COMMENT 'The site.',
  `idea_title` varchar(600) default NULL COMMENT 'The title of the idea.',
  `idea_description` blob COMMENT 'The description about the idea.',
  PRIMARY KEY  (`idea_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'table_idea'
#

/*!40000 ALTER TABLE `table_idea` DISABLE KEYS*/;
LOCK TABLES `table_idea` WRITE;
REPLACE INTO `table_idea` (`idea_no`, `innovator`, `site`, `idea_title`, `idea_description`) VALUES ('11200','Mustensir Lehri, Gaurav Virdy','Pune','Automate the CRM DEVELOPMENT environment setup on windows','The setup of Amdocs CRM DEVELOPMENT environment involves lot of tasks, each task being painstaking and time consuming. Moreover even after the setup is done manually the CRM application has issues and problems related to environment settings (human errors) which again take time in resolving. The idea is to create a tool to automate the entire setup process right from the point of syncing the source code (CBO) from Perforce to starting the weblogic server. The various tasks that will be done by the tool are listed below:  - Sync source code (CBO) from Perforce  - Remove Read-only attribute from source code (CBO) folder  - Map required drives etc.'),
	('13106','Mustensir Lehri, Gaurav Virdy','Pune','Creating cases or getting resolution to problems via ''chat'' messenger','The idea is that we should be having a small messenger window in the current Smart Desktop Agent where by CSPs end users can chat with CSR and get resolution to their problems.  Applicability:  This is applicable for those end users who don?t want to dedicate themselves by calling a call center. Rather they would just like to sit back and continue doing their work and in parallel can chat with the CSR agent.  For e.g. I want to get my billing plan changed. I don?t really want to call the toll free number and then continue to wait for some time then I talk to someone and resolve my doubt. Instead I would prefer to chat with someone and request him to change the billing plan. On the messenger itself he confirms that he has changed my billing plan'),
	('13423','Vihan Srivastava, Kaushik Kaul','GGN + Pune','Smart Migration Tool - UI Converter','Amdocs has over 200 customers for its Clarify CRM suite of products, including both Telecom and enterprise customers. Currently we have around 100 customers (mostly enterprise) that are still using the Classic version of our CRM. Its high time for us that the Classic suite of CRM product goes out of support and all our custmomers migrate to Smart Version of CRM, generating license revenues and allowing us to have a central support for all customers, independent of the variant of CRM. Now the biggest challenge in this migration process is the amount of manual effort needed to carry forward all the custmoizations that customers have done in the past n number of years it has been using the Classic version. On an average each customer has 5 Resource Configurations (RC) to hold the customized forms, and each RC has around 200 forms on an average, meaning that manually we have to migrate 1000 forms per customer to the smart architecture and then re code them in Smart architecture. This manual effort is the major cost component for each customer, and mostly because of this high numbers most of them back out from upgrading to Smart. The Smart Migration Tool (SMT) addresses exactly this situation, it is a UI converter tool that works as an independent JAVA program on the Classic DB, and converts each and every form (New as well as customized) to the Smart version with an average rate of 50 forms per minute.'),
	('13517','Prashant Jadhav, Vasudeva Reddy','Pune','Mr. FIXIT','Our idea is to automate the Hot-Fix creation and deployment in AMSS. In old process, HF creation and deployment will be done by manually. It will take more time, error prone and tedious. In new process we will eliminate human errors. In new process HF will be created by automatically with the help of Perforce Issue Id/Job id. After changing the code by dev team for corresponding defect raised by PQA team, they will update the code in perforce.  Once updation is done successfully dev team will get the Issue id/job id. With the help of Issue Id/Job id, we will search for the files, and we will get build and pack them as .zip file.  In old process of HF deployment, it will take more time, error prone. In new process we will deploy automatically. It will reduce time and free from errors.  With this new process, we will save 43 person days per year in both Dev and AE teams'),
	('13707','Vinith Pillai','Pune','RSS Feeds in CRM Application','I have been onsite at different places, and have quite observed the working behavior of CSRs closely. Amongst the various applications they have open, one is the portal of the client to look for recent updates (just like our kmportal).  The way we can proceed is by incorporating an RSS reader in CRM. RSS is a way by which the server (hosting the website) releases updates as combination of headings + links in the form of xml and the RSS reader displays this to the user. Thus the user can see the updates of any site (to which the user has pointed his RSS reader) without actually having to open the site thus saving the user time.'),
	('13912','Swapnil Deshpande, Vikas Nalwar','Pune','Adding web-service functionality to AMC for enabling consolidated view across multiple installations','With more and more focus in reducing the costs of infrastucture across Amdocs, one of the action point we can look at implementing is to develop the Web service functionality in AMC (Amdocs monitoring) server. Basically the idea is to enable the AMC server to expose web service functionality which could be consumed by clients and get the latest status updates. Consider the scenario where you have one single dashboard (or client) from where you are accessing the web services exposed by multiple AMC installations across sites (Sprint, Metro, TMUK etc.) and give a consolidated view in single dashboard. This will help prepare ourselves in case we have to move to a Unified CCC solution where one screen will show a consolidated status report across accounts. This would also mean that you do not require additional hardware deployments in CCC for doing a consolidation of the dashboard updates and additional accounts could simply be added in the existing dashboard by adding one more consumer of the web service.'),
	('14115','Rahul Bakale (34671), Tomer Merkado (69246)','Pune','Java Monitor and Controller using Java Instrumentation, JMX and byte code engineering','Tomer''s Idea - 1. Create a tool which will allow programmers to modify Java classes (byte code) in order to add monitoring and control capabilities to the application. For example Add timer to a method (without modifying the source code) at runtime to find how much time the method execution took.  2. The tool can use Java Instrumentation and JMX technology for its implementation. Rahul''s Idea - 1. In addition to monitoring and control capabilities, add features such as - a. Class introspection  b. Class disassembly  c. Connecting to an already running JVM without restart  d. Support for custom clients  e. Bundled GUI  f. Saving transformations as XML for persistent storage  g. Allow  ransformation of even the bootstrap classes  h. Capability to revert back the changes made to a class.'),
	('14117','Santoshi Mitra Mustafi, Narendra Pote','Pune','PreUpgrade Database Check Tool','This tool aims at verify discripancies in the CRM database.  The customers need to alter the database schema/data based on their customization needs.  It is observerd quite often that these changes do not conform to the Guidelines mentioned in the Upgrade guides, or sometimes OOB data gets corrupted. This tool will aims to do the following.  1. Report the changes made in customer schema as compared to OOB schema.  2. Report the changes made externally to the database  3. Report OOB Application data that has been modified.'),
	('14316','Abhishek Chauhan (68071)','GGN','A generalised Apply Back Solution to minimise Downtime during Release roll out','Problem:  Accross all ERPs, release roll outs require a database outage for a considerable amount of time for the client''s system. This disrupts the client''s business and many a times leads to losses in notional/real terms. Solution:  A software that will enable the changes done in database during release roll out to be applied to the database containing new release upgrades.  This will reduce the downtime to only the time needed to point the new release onlines to the new database. Earlier Implementation:  Sprint Ensemble project has an Apply Back solution developed in-house fro Sprint project only. it has been a useful tool for reducing downtime during release to a few minutes as opposed to 10-12 huors earlier.'),
	('14323','Tarachand Ola (7368)','Pune','Actionable and meaningful alerts in production environments','In production environments we have many warnings and alerts generated and sent to users. More often the volume of alerts is very high which results in lack of focus and impact and leading to increased probability of missing an alert and not addressing production event in time.  There is need to standardize the alerts across applications at product/tool level so that each alert convey same message, impact and needed action. A mechanism should be devised where each alert is linked to a specific code. There should be a lookup table where relation between event, alert code, alert description, alert category, action to be taken and team/person contact details are defined.'),
	('14344','Vipul Bahuguna (60177)','GGN','Speech Enabled CRM','To add Speech Recognition capability to our CRM product and make it more user friendly and fast. I used Sphinx4 ? Java based speech recognition open source technology created by Carneige Mellon University.  I have created small java programs that recognize my voice like Find Caller, Create Contact etc.  We can explore and research in depth as to how feasible it would be to integrate this solution with our application to have something called \"Speech enabled CRM\".'),
	('14391','Deepanjan Paul (73574)','GGN','Automate RBMS installation','The idea is to automate the installion of Rules Based Management System. The main idea is to develop a WEB based tool which will automate the installation.The user simply has to fill in the prerequite details like the platform and the Oracle details and finally the RBMS version.Once it is done an installtion would be just a click away.');
UNLOCK TABLES;
/*!40000 ALTER TABLE `table_idea` ENABLE KEYS*/;


#
# Table structure for table 'table_user'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `table_user` (
  `username` varchar(200) NOT NULL default '',
  PRIMARY KEY  (`username`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='ntnet users';



#
# Dumping data for table 'table_user'
#

/*!40000 ALTER TABLE `table_user` DISABLE KEYS*/;
LOCK TABLES `table_user` WRITE;
REPLACE INTO `table_user` (`username`) VALUES ('sdfasdf'),
	('sdafdsf'),
	('adfasdfsadf');
REPLACE INTO `table_user` (`username`) VALUES ('sadfdsaf'),
	('sdafdsf'),
	('adfasdfsadf');
UNLOCK TABLES;
/*!40000 ALTER TABLE `table_user` ENABLE KEYS*/;


#
# Table structure for table 'table_vote'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ `table_vote` (
  `timestamp` datetime default NULL COMMENT 'The update time stamp.',
  `ntnet_username` varchar(100) NOT NULL COMMENT 'The ntnet username of the voter.',
  `rank1_idea_no` bigint(20) default NULL COMMENT 'The rank 1 idea casted by the voter.',
  `rank2_idea_no` bigint(20) default NULL COMMENT 'The rank 2 idea casted by the voter.',
  `rank3_idea_no` bigint(20) default NULL,
  `host_addr` varchar(200) default NULL,
  PRIMARY KEY  (`ntnet_username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



#
# Dumping data for table 'table_vote'
#

/*!40000 ALTER TABLE `table_vote` DISABLE KEYS*/;
LOCK TABLES `table_vote` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `table_vote` ENABLE KEYS*/;
