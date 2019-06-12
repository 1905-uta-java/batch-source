--------------------------------------------------------------------------------------------------------------------------------
-- PROJECT 0 BANKING APP -- TABLES AND DATA
--------------------------------------------------------------------------------------------------------------------------------
-- USER TABLE
CREATE TABLE USER_TABLE (
    USERID NUMBER(5) CONSTRAINT PK_USER PRIMARY KEY,
    USERNAME VARCHAR2(50) NOT NULL UNIQUE,
    USERPASSWORD VARCHAR2(12) NOT NULL,
    EMAIL VARCHAR(60) NOT NULL UNIQUE
);

-- ACCOUNT TABLE
CREATE TABLE ACCOUNT_TABLE (
    ACCOUNTID NUMBER(7) CONSTRAINT PK_ACCOUNT PRIMARY KEY,
    USERID NUMBER(5) CONSTRAINT FK_ACC_USER REFERENCES USER_TABLE,
    PIN NUMBER(4) NOT NULL,
    BALANCE NUMBER(10,2) NOT NULL
);

-- CREATE RANDOM USERS
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (1, 'bmuslim0', 'rzQcaE', 'ghulme0@examiner.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (2, 'dingree1', 'VOKwv9S', 'cdoers1@timesonline.co.uk');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (3, 'rmayte2', 'JbbxNk2iq', 'mcasazza2@hhs.gov');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (4, 'dmixhel3', 'BzwYohDGYTVT', 'jlayne3@mysql.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (5, 'tmonkley4', '5gIf9S', 'vbrakewell4@webmd.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (6, 'mcorday5', 'HGNvQhKvo', 'bbiskup5@ow.ly');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (7, 'jmarsy6', '7WgC7JKAKAjZ', 'mfrancis6@hud.gov');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (8, 'lmanifield7', 'ox6i2rIkH', 'cmorrill7@businesswire.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (9, 'kdeknevet8', 'YtfM7gs5N4', 'ebessant8@marriott.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (10, 'mwesley9', '3BbXz8Gb', 'dmaddison9@scientificamerican.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (11, 'gblibena', '9Ld0NPm', 'ecrutchfielda@yelp.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (12, 'cchaceb', 'VH6RRZ', 'tmullyb@wikimedia.org');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (13, 'skrzyzanowskic', 'B8xLfCsgF', 'cgirardezc@cnn.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (14, 'jmacpaiked', '1Rw9LpH5OMu', 'slasselled@illinois.edu');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (15, 'pkermannese', 'vmHYbW7', 'pwardele@gmpg.org');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (16, 'cclemersonf', 'zHbFPh', 'mbintonf@mashable.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (17, 'jmccaigg', 'f09uDsmdRnk', 'mprettejohnsg@mozilla.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (18, 'edickonh', 'CpSj9nNGH', 'enorvellh@php.net');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (19, 'ereedi', '9SVUYEdAYVd', 'lgarmenti@shop-pro.jp');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (20, 'crojj', 'aJF1ecn', 'brobillardj@smh.com.au');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (21, 'rseniork', 'Fe1Bc3ocYM', 'sbarnwallk@etsy.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (22, 'ahuygel', 'G1EbIr1iSR9', 'kskippingl@oracle.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (23, 'cbendixenm', 'A71EvFQQbIA', 'ngilsonm@aboutads.info');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (24, 'fdincken', 'CnCX41Urb3', 'akroinn@facebook.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (25, 'nolczyko', 'fdIVfK2YYm', 'gmarymano@xrea.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (26, 'ghavocp', 'qo4ADGtiDYD', 'jcarrodusp@nyu.edu');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (27, 'aleyreq', 'XPObfEF', 'gjakemanq@ifeng.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (28, 'tneller', 'PXvitufKP', 'kgounardr@netscape.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (29, 'fcruickshanks', 'u2zerOZ3v', 'hbrechers@photobucket.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (30, 'jealest', 'g5zea2siR', 'dwoloschint@technorati.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (31, 'lblucheru', 'eKybsD1E', 'kdominguezu@craigslist.org');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (32, 'dleadv', '942eRieEZuE', 'mgoninv@oakley.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (33, 'atattamw', 'ILLhvXUS3SQ', 'sstubbleyw@free.fr');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (34, 'heliasenx', 'mm3lzEaFM', 'cbarhimsx@dailymail.co.uk');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (35, 'abottjery', 'v2RzRtt1', 'scawthryy@weibo.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (36, 'ieastridgez', 'D2NiNmlaNH', 'mtirreyz@php.net');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (37, 'abridgett10', 'Dq4l5hriMvRW', 'vsherrum10@amazon.co.uk');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (38, 'rduffield11', 'FkVRUg', 'rsporgeon11@harvard.edu');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (39, 'tvouls12', 'MFfjkpmJK', 'jwitten12@theguardian.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (40, 'bobee13', 'BtV6MCgJ', 'mbatt13@seesaa.net');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (41, 'djorry14', '8n23rRLWd', 'sdjurisic14@nytimes.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (42, 'mlewens15', 'gnjuf8h', 'tswarbrigg15@aboutads.info');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (43, 'awoodhall16', 'QTwoCKnVjvP', 'spellitt16@amazonaws.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (44, 'kjosilowski17', 'BStBa1TQ9C1v', 'mstroulger17@scientificamerican.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (45, 'agaymar18', 'IkyoYEQ9p', 'thaws18@ed.gov');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (46, 'rholdey19', 'XLD3pMZI', 'atortis19@icq.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (47, 'jbulman1a', 'Mh7LzN', 'sible1a@cdc.gov');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (48, 'gbendik1b', 'jU8NZ1EykY9', 'fogorman1b@posterous.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (49, 'sidiens1c', '5mnz0RERinWp', 'pabbe1c@samsung.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (50, 'banthoney1d', 'a3FXcuIu8El', 'ewilkerson1d@ycombinator.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (51, 'kvonasek1e', 'rdUOg1fYhzr', 'jfarley1e@163.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (52, 'sbruty1f', 'Htk4sA', 'wbardwall1f@unicef.org');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (53, 'alimon1g', 'ig52m75Il7XN', 'szmitrovich1g@ow.ly');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (54, 'mkeeble1h', '5T7rdlgEP', 'hfreddi1h@paginegialle.it');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (55, 'khunnawill1i', '6j6t683xCZ', 'dscheu1i@shinystat.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (56, 'crutley1j', 'bp8jc1', 'eabramowitz1j@github.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (57, 'awinship1k', 'BCTQfakAdRtU', 'mklaiser1k@ucla.edu');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (58, 'clewer1l', 'P32gIZO7', 'nwrightson1l@ucsd.edu');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (59, 'dburdekin1m', 'xQlCEY', 'astockdale1m@mail.ru');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (60, 'rmielnik1n', 'yOY6ML4vqhlB', 'kvischi1n@creativecommons.org');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (61, 'lriddles1o', 'K2wQwWu', 'dsweynson1o@mozilla.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (62, 'gmarcombe1p', 'GcDNTvfEw', 'rgussin1p@google.co.uk');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (63, 'smarsie1q', 'wjwkbe1uJvL', 'eshepland1q@networksolutions.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (64, 'cjosofovitz1r', 'ELwYSo5f', 'rhartigan1r@histats.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (65, 'ldibb1s', 'HDvvu27qYt', 'dgyngell1s@shinystat.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (66, 'hcolquitt1t', 'UP2r9Mdhs', 'cminget1t@google.es');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (67, 'nfidilis1u', 'oMG4lROh', 'ckerrod1u@odnoklassniki.ru');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (68, 'tstoite1v', 'WYnBz9E3LYlo', 'mfortun1v@xinhuanet.com');
insert into USER_TABLE (USERID, USERNAME, USERPASSWORD, EMAIL) values (69, 'ehamman1w', 'LDz0zAxuIls', 'gmines1w@stanford.edu');
commit;

CREATE OR REPLACE PROCEDURE GET_BALANCE (A_ID IN NUMBER, B OUT NUMBER) AS
BEGIN
    SELECT BALANCE INTO B
    FROM ACCOUNT_TABLE
    WHERE ACCOUNTID = A_ID;
END;