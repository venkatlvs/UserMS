DROP DATABASE `loginssdb` ;
CREATE DATABASE `loginssdb` ;
USE `loginssdb`;

--
-- Table structure for table `login`
--
CREATE TABLE `account` (
  `CUSTOMER_ID` bigint(12) NOT NULL,
  `IFSC_CODE` varchar(10) NOT NULL,
  `BRANCH` varchar(100) NOT NULL,
  `BRANCH_ADDRESS` varchar(40) NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)

);
CREATE TABLE `login` (
  `CUSTOMER_ID` bigint(12) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `PHONE_NUMBER` bigint(10) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `ADDRESS` varchar(150) NOT NULL,
  `DOB` date NOT NULL,
  `DATE_OF_OPENING` date NOT NULL,
  `AADHAR_NO` bigint(20) NOT NULL,  
  PRIMARY KEY (`PHONE_NUMBER`),
  FOREIGN KEY (`CUSTOMER_ID`) REFERENCES account(`CUSTOMER_ID`)
);

CREATE TABLE `userlogs` (
  `CUSTOMER_ID` bigint(12) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `LOGGED_DATE` timestamp NOT NULL,
  `LOGGED_DATE_ACCOUNT` varchar(50) NOT NULL,
  PRIMARY KEY (`LOGGED_DATE_ACCOUNT`)
);





--
-- Dumping data for table `login`
--
insert into account values('63215479','BKID0000','EDGE VERVE BANK','502 SANCHAR NAGAR');
insert into account values('63265874','BKID0001','EDGE VERVE BANK','502 SANCHAR NAGAR');
insert into account values('63214578','BKID0002','EDGE VERVE BANK','502 SANCHAR NAGAR');
insert into account values('63298798','BKID0003','EDGE VERVE BANK','502 SANCHAR NAGAR');
insert into account values('63256786','BKID0004','EDGE VERVE BANK','502 SANCHAR NAGAR');

insert into login values('63215479','saurabh kumar','saurabh@gmail.com','7777766666','kumar@w*3996','102 alok nagar indore','1998-04-06','2015-07-12','109345879234');
insert into login values('63265874','Akash kumar','akash@gmail.com','7777766665','akash@w*3996','103 bijli nagar indore','1999-04-06','2016-07-12','109345879239');
insert into login values('63214578','Suraj kumar','suraj@gmail.com','7777766655','suraj@w*3996','104 saket nagar indore','1997-04-06','2017-07-12','109345879231');
insert into login values('63298798','Jatin kumar','jatin@gmail.com','7777766555','jatin@w*3996','105 sudama nagar indore','1995-04-06','2014-07-12','109345879235');
insert into login values('63256786','Abhinav kumar','abhinav@gmail.com','7777765555','abhinav@w*3996','102 usha nagar indore','1993-04-06','2012-07-12','109345879236');


