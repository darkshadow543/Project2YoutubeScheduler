/*
 * Youtube scheduling system 
 */

/********************************Create Tables*********************************/
CREATE TABLE Viewer
(
    UserId NUMBER NOT NULL, 
    userName VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) NOT NULL, 
	password VARCHAR2(255) NOT NULL,
	isYoutuber NUMBER,
    CONSTRAINT PK_VIEWER PRIMARY KEY  (UserId)
);

CREATE TABLE Channel
(
    ChannelId NUMBER NOT NULL, 
  	OwnerId NUMBER NOT NULL,
	ChannelName VARCHAR2(255) NOT NULL,
    CONSTRAINT PK_CHANNEL PRIMARY KEY  (ChannelId)
);

CREATE TABLE Subscription 
(
    SubscriptionId NUMBER NOT NULL, 
  	UserId NUMBER NOT NULL,
  	ChannelId NUMBER NOT NULL,
    CONSTRAINT PK_SUBSCRIPTION PRIMARY KEY  (SubscriptionId)
);

CREATE TABLE Video
(
   	VideoId NUMBER NOT NULL, 
	VideoName VARCHAR2(255) NOT NULL,
	ChannelId NUMBER NOT NULL, 
	Description VARCHAR2(255),
	releaseDate DATE,
    CONSTRAINT PK_VIDEO PRIMARY KEY  (VideoId)
);
/***********************************************************************************/
/********************************ADD THE FOREIGN KEYS*********************************/
ALTER TABLE CHANNEL ADD CONSTRAINT FK_OWNERID 
	FOREIGN KEY (OWNERID) REFERENCES VIEWER (USERID) 
	ON DELETE CASCADE;

ALTER TABLE SUBSCRIPTION ADD CONSTRAINT FK_CHANNELID
	FOREIGN KEY (ChannelId) REFERENCES CHANNEL (ChannelId)
	ON DELETE CASCADE;

ALTER TABLE SUBSCRIPTION ADD CONSTRAINT FK_SUBSCRIBERID
	FOREIGN KEY (UserId) REFERENCES VIEWER (USERID)
	ON DELETE CASCADE;

ALTER TABLE VIDEO ADD CONSTRAINT FK_VIDEOID
	FOREIGN KEY (ChannelId) REFERENCES CHANNEL (ChannelId)
	ON DELETE CASCADE;

/***********************************************************************************/
/********************************Create Sequences*********************************/
DROP SEQUENCE viewerIdSeq
CREATE SEQUENCE ViewerIdSeq
	start with 1
	increment by 1;

CREATE SEQUENCE ChannelIdSeq
	start with 1
	increment by 1;

CREATE SEQUENCE SubscriptionIdSeq
	start with 1
	increment by 1;

CREATE SEQUENCE VideoIdSeq
	start with 1
	increment by 1;

/***********************************************************************************/
/********************************Create insert data*********************************/
INSERT INTO Viewer (UserId, userName, email, password, isYoutuber) VALUES (1, 'Test', 'test@test.com','test', 0);
INSERT INTO Viewer (UserId, userName, email, password, isYoutuber) VALUES (2, 'Bob', 'bob@farm.com','oops', 0);
INSERT INTO Viewer (UserId, userName, email, password, isYoutuber) VALUES (ViewerIdSeq.nextval, 'Markiplier', 'Mark@hotmail.com','BigDumbDoofyDoo', 1);
INSERT INTO Viewer (UserId, userName, email, password, isYoutuber) VALUES (ViewerIdSeq.nextval, 'joshFitz', 'joshfitz@gmail.com','123', 0);
INSERT INTO Viewer (UserId, userName, email, password, isYoutuber) VALUES (ViewerIdSeq.nextval, 'DarkShadow', 'darkShadow@hotmail.com','20Dodger15', 1);
INSERT INTO Viewer (UserId, userName, email, password, isYoutuber) VALUES (ViewerIdSeq.nextval, 'RoePansiano', 'NerdyNummies@gmail.com','Cookies!', 1);
INSERT INTO Viewer (UserId, userName, email, password, isYoutuber) VALUES (ViewerIdSeq.nextval, 'RonaldLee', 'ForThought@yahoo.com','ronald', 0);
INSERT INTO Channel (channelId, OwnerId, ChannelName) VALUES (ChannelIdSeq.nextval, 3, 'Markiplier');/*2*/
INSERT INTO Channel (channelId, OwnerId, ChannelName) VALUES (ChannelIdSeq.nextval, 5, 'NerdyNummies');/*3*/
INSERT INTO Channel (channelId, OwnerId, ChannelName) VALUES (ChannelIdSeq.nextval, 6, 'DarkShadow');/*4*/
INSERT INTO Channel (channelId, OwnerId, ChannelName) VALUES (ChannelIdSeq.nextval, 1, 'test');/*5*/
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 3, 2);
/*mark subscribed to markiplier */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 3, 3);
/*mark subscribed to nerdynummies */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 1, 3);
/*test subscribed to nerdynummies */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 1, 4);
/*test subscribed to darkshadow */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 4, 2);
/*josh subscribed to markiplier */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 4, 3);
/*josh subscribed to nerdynummies */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 6, 5);
/*Roe subscribed to test */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 6, 2);
/*Roe subscribed to markiplier */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 7, 4);
/*ronald subscribed to drakshadow */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 7, 5);
/*ronald subscribed to test */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 5, 2);
/*shannon subscribed to markiplier */
INSERT INTO Subscription (SubscriptionId, UserId, ChannelId) VALUES (SubscriptionIdSeq.nextval, 5, 5);
/*shannon subscribed to test */
INSERT INTO Video (VideoId, VideoName, ChannelId, Description, releaseDate) VALUES (VideoIdSeq.nextval, 'Try Not To Laugh 25', 2, 'A video where Mark fails to contain his giggles', TO_DATE('2019-7-15 1:35:40','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO Video (VideoId, VideoName, ChannelId, Description, releaseDate) VALUES (VideoIdSeq.nextval, 'Scary Game Lets Play', 2, 'A spoopy video of goofiplier scaring himself', TO_DATE('2017-6-5 9:05:20','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO Video (VideoId, VideoName, ChannelId, Description, releaseDate) VALUES (VideoIdSeq.nextval, 'Making a cake', 3, 'Making a chocolate cake with Roe', TO_DATE('2015-7-19 12:30:40','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO Video (VideoId, VideoName, ChannelId, Description, releaseDate) VALUES (VideoIdSeq.nextval, 'Making BomberMan With Rhet&Link', 3, 'Giant Man Children in a kitchen with a Disney Princess', TO_DATE('2016-1-12 05:25:45','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO Video (VideoId, VideoName, ChannelId, Description, releaseDate) VALUES (VideoIdSeq.nextval, 'Mincraft Bug Report', 4, 'Someone put a potato in a text box ', TO_DATE('2012-11-11 9:21:18','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO Video (VideoId, VideoName, ChannelId, Description, releaseDate) VALUES (VideoIdSeq.nextval, 'Ultimate Fail Compilation', 5, 'People doing dumb stuff that gets them hurt', TO_DATE('2017-9-18 8:20:36','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO Video (VideoId, VideoName, ChannelId, Description, releaseDate) VALUES (VideoIdSeq.nextval, 'sillyCat', 5, 'A video about a silly cat', TO_DATE('2015-7-19 12:30:40','yyyy-mm-dd hh24:mi:ss'));
INSERT INTO Video (VideoId, VideoName, ChannelId, Description, releaseDate) VALUES (VideoIdSeq.nextval, 'Baskin Robbins Conspiracy', 5, 'Theres 34 flavers! DONT BE DECEIVED!', TO_DATE('2018-2-1 4:00:17','yyyy-mm-dd hh24:mi:ss'));

/***********************************************************************************/

