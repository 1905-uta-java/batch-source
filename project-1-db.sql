-- EMPLOYEE TABLE
CREATE TABLE EMPLOYEE (
    EMPLOYEEID NUMBER(5) CONSTRAINT PK_EMPLOYEE PRIMARY KEY,
    FIRSTNAME VARCHAR2(50),
    LASTNAME VARCHAR2(50),
    EMPUSERNAME VARCHAR2(25) NOT NULL UNIQUE,
    EMPPASSWORD VARCHAR2(18) NOT NULL,
    EMAIL VARCHAR2(60) NOT NULL UNIQUE
);

-- MANAGER TABLE
CREATE TABLE MANAGER_TB(
    MANAGERID NUMBER(5) CONSTRAINT PK_MANAGER PRIMARY KEY,
    FIRSTNAME VARCHAR2(50),
    LASTNAME VARCHAR2(50),
    MANUSERNAME VARCHAR2(25) NOT NULL UNIQUE,
    MANPASSWORD VARCHAR2(18) NOT NULL,
    EMAIL VARCHAR(60) NOT NULL UNIQUE
);

-- REIMBURSEMENT REQUEST TABLE
CREATE TABLE REIMBURSE_REQUEST (
    REIMID NUMBER(5) CONSTRAINT PK_REIMBURSE PRIMARY KEY,
    EMPLOYEEID NUMBER(5) CONSTRAINT FK_EMPLOYEE REFERENCES EMPLOYEE,
    AMOUNT NUMBER(5,2) NOT NULL,
    REASON VARCHAR2(150) NOT NULL,
    APPROVED_BY NUMBER(5) CONSTRAINT FK_MANAGER REFERENCES MANAGER_TB
);

-- MAKE A WHOLE BUNCH OF EMPLOYEES AND STUFF
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10001, 'Hedvig', 'Gregoriou', 'hgregoriou0', 'zvAvGfONOQ8', 'hgregoriou0@livejournal.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10002, 'Jacquetta', 'Langer', 'jlanger1', 'iPVb2L', 'jlanger1@tinypic.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10003, 'Reggi', 'Dee', 'rdee2', 'VmmevorMA6W', 'rdee2@about.me');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10004, 'Gerome', 'Bortolomei', 'gbortolomei3', 'fbf8tJJ', 'gbortolomei3@ftc.gov');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10005, 'Suzie', 'Webbe', 'swebbe4', 'XSIuZZKKLVr5', 'swebbe4@uol.com.br');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10006, 'Muriel', 'Pfeifer', 'mpfeifer5', 'Iqx7NIIH', 'mpfeifer5@earthlink.net');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10007, 'Sibbie', 'Pavlovic', 'spavlovic6', 'iJ60PzS', 'spavlovic6@typepad.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10008, 'Micah', 'Delahunt', 'mdelahunt7', 'Xcu6TG6loFr2', 'mdelahunt7@reuters.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10009, 'Maryjo', 'Wimbush', 'mwimbush8', 'C6yW9dAmMv09', 'mwimbush8@army.mil');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10010, 'Modestine', 'Saynor', 'msaynor9', 'gIeKwT', 'msaynor9@ca.gov');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10011, 'Kendell', 'Kierans', 'kkieransa', 'l23nqB0D', 'kkieransa@cmu.edu');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10012, 'Carlie', 'Synder', 'csynderb', 'fvCbZJM', 'csynderb@hubpages.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10013, 'Angelique', 'Braiden', 'abraidenc', 'Y4C4VngcyM', 'abraidenc@lulu.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10014, 'Carny', 'Blodgett', 'cblodgettd', 'bpOnpxDgL', 'cblodgettd@dell.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10015, 'Clerissa', 'Gillinghams', 'cgillinghamse', 'EqsflTPmsJ', 'cgillinghamse@4shared.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10016, 'Ruthanne', 'Cantillion', 'rcantillionf', 'lEr4F83', 'rcantillionf@jigsy.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10017, 'Aime', 'Di Biagi', 'adibiagig', '5GKk2hQh', 'adibiagig@accuweather.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10018, 'Zak', 'Healeas', 'zhealeash', 'u6HWgPC', 'zhealeash@alibaba.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10019, 'Curt', 'Gibbeson', 'cgibbesoni', 'JAl8oRahUWa', 'cgibbesoni@desdev.cn');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10020, 'Gerry', 'Foyle', 'gfoylej', 'BV6cB8dVMwz', 'gfoylej@narod.ru');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10021, 'Arni', 'Masurel', 'amasurelk', 'ajjiQKg1umml', 'amasurelk@tinyurl.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10022, 'Meagan', 'Woodrup', 'mwoodrupl', 'tQR2fSe6DBrA', 'mwoodrupl@cdbaby.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10023, 'Juliana', 'O''Malley', 'jomalleym', 'YfroMlVA', 'jomalleym@berkeley.edu');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10024, 'Miltie', 'Meadowcraft', 'mmeadowcraftn', 'TZEUfj', 'mmeadowcraftn@flavors.me');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10025, 'Lyssa', 'Wadman', 'lwadmano', 'I9Pu7U', 'lwadmano@paginegialle.it');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10026, 'Noami', 'Pridham', 'npridhamp', 'HWLJNC', 'npridhamp@blogtalkradio.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10027, 'Leese', 'Aslett', 'laslettq', 'BzJ7z0A5', 'laslettq@multiply.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10028, 'Yank', 'Novik', 'ynovikr', 'GhDTNAdihV', 'ynovikr@usa.gov');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10029, 'Florri', 'MacFarlane', 'fmacfarlanes', 'E4iQ9j8rU', 'fmacfarlanes@pinterest.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10030, 'Wilmette', 'Iacovides', 'wiacovidest', 'P6sYqaE2LchX', 'wiacovidest@samsung.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10031, 'Patty', 'Pietasch', 'ppietaschu', 'H9QV78', 'ppietaschu@upenn.edu');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10032, 'Abigale', 'Jiracek', 'ajiracekv', 'UquXqH2CYM9', 'ajiracekv@indiatimes.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10033, 'Tawnya', 'Arnaudon', 'tarnaudonw', 'xaf95QHiVOI', 'tarnaudonw@answers.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10034, 'Cora', 'Dixcee', 'cdixceex', 'EE02kDT', 'cdixceex@live.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10035, 'Kariotta', 'Kellie', 'kkelliey', 'I5G7SF2e', 'kkelliey@jimdo.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10036, 'Lavena', 'Holme', 'lholmez', 'd4fN5hR', 'lholmez@dmoz.org');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10037, 'Doralynn', 'O''Noland', 'donoland10', 'KaKiv8qpp', 'donoland10@npr.org');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10038, 'Carly', 'Danaher', 'cdanaher11', 'peZqYC2O', 'cdanaher11@cisco.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10039, 'Nowell', 'O''Dea', 'nodea12', 'DHXxDCaH', 'nodea12@simplemachines.org');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10040, 'Doroteya', 'Duffrie', 'dduffrie13', 'r5owrtAPJ', 'dduffrie13@archive.org');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10041, 'Deirdre', 'Glitherow', 'dglitherow14', 'fstqFZsX5S9g', 'dglitherow14@forbes.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10042, 'Aubree', 'Colson', 'acolson15', 'XRVXZoa08mH', 'acolson15@rambler.ru');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10043, 'Madelin', 'Syrie', 'msyrie16', 'I4wmrmVY', 'msyrie16@studiopress.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10044, 'Gabriella', 'Wickenden', 'gwickenden17', 'amCBkzdRxbj', 'gwickenden17@yahoo.co.jp');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10045, 'Zandra', 'Caherny', 'zcaherny18', '2sUmIQSWAAo', 'zcaherny18@bing.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10046, 'Zitella', 'Lippitt', 'zlippitt19', 'XQrivI', 'zlippitt19@zdnet.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10047, 'Tracy', 'Radmer', 'tradmer1a', '6Niq4HGZu7bD', 'tradmer1a@liveinternet.ru');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10048, 'Megen', 'Berryann', 'mberryann1b', 'kZnrp8', 'mberryann1b@army.mil');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10049, 'Vinson', 'Glasser', 'vglasser1c', '8iAIbKyWS', 'vglasser1c@pagesperso-orange.fr');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10050, 'Garvey', 'Bosward', 'gbosward1d', 'IbC0jbW', 'gbosward1d@indiatimes.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10051, 'Pedro', 'Easun', 'peasun1e', 'qdazX3r2HSg', 'peasun1e@webmd.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10052, 'Shoshana', 'Krzysztof', 'skrzysztof1f', 't35PXZli', 'skrzysztof1f@uol.com.br');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10053, 'Carolyn', 'Goddert.sf', 'cgoddertsf1g', 'Z8uIyH3i2bcd', 'cgoddertsf1g@wikispaces.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10054, 'Allie', 'Skellion', 'askellion1h', 'GyZ867S', 'askellion1h@nhs.uk');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10055, 'Mendie', 'Clemitt', 'mclemitt1i', 'RPRRWFxQe83', 'mclemitt1i@wp.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10056, 'Dixie', 'Quinnell', 'dquinnell1j', 'ecCWGF', 'dquinnell1j@creativecommons.org');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10057, 'Betsey', 'Baker', 'bbaker1k', 'rXLfxfGOtF', 'bbaker1k@go.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10058, 'Vidovic', 'Caswell', 'vcaswell1l', 'eAi6FJ9', 'vcaswell1l@friendfeed.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10059, 'Aloise', 'Jukubczak', 'ajukubczak1m', 'Cv6TmK7b4YgR', 'ajukubczak1m@wp.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10060, 'Ethe', 'Wigin', 'ewigin1n', 'viZSOjhTUg7Y', 'ewigin1n@salon.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10061, 'Livvie', 'Fidilis', 'lfidilis1o', 'bEPerVR7', 'lfidilis1o@edublogs.org');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10062, 'Gabi', 'Ingraham', 'gingraham1p', 'qjB4rJ0BYs1', 'gingraham1p@sun.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10063, 'Edgar', 'Gonzalez', 'egonzalez1q', 'k34svbA', 'egonzalez1q@google.com.au');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10064, 'Lindy', 'Muddimer', 'lmuddimer1r', 'MzFpEHOU4HL', 'lmuddimer1r@xinhuanet.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10065, 'Stillmann', 'Fowley', 'sfowley1s', 'oz3tzfTTeem', 'sfowley1s@smugmug.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10066, 'Farlay', 'Blakeslee', 'fblakeslee1t', 'CLhTxUuqP83', 'fblakeslee1t@mail.ru');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10067, 'Faye', 'Matantsev', 'fmatantsev1u', 'a2H8KQ', 'fmatantsev1u@yolasite.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10068, 'Dukey', 'Scarlan', 'dscarlan1v', 'iRf5mi6', 'dscarlan1v@cdbaby.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10069, 'Jodie', 'Cheke', 'jcheke1w', 'qEMvGi8vzM', 'jcheke1w@noaa.gov');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10070, 'Oralla', 'Tussaine', 'otussaine1x', 'N2QCRqTh', 'otussaine1x@mlb.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10071, 'Annemarie', 'Caffery', 'acaffery1y', 'jp6urE', 'acaffery1y@amazonaws.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10072, 'Ichabod', 'Eronie', 'ieronie1z', 'eeVAiB', 'ieronie1z@miitbeian.gov.cn');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10073, 'Paxton', 'Gothrup', 'pgothrup20', 'S03iYidA1ia', 'pgothrup20@patch.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10074, 'Helyn', 'Hollyar', 'hhollyar21', 'jzQXbluHA', 'hhollyar21@goodreads.com');
insert into EMPLOYEE (employeeid, firstname, lastname, empusername, emppassword, email) values (10075, 'Stirling', 'Trevaskis', 'strevaskis22', 'pFNhmenM', 'strevaskis22@dmoz.org');

-- MAKE SOME MANAGERS AND WHAT NOT
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20001, 'Nadya', 'Ailsbury', 'nailsbury0', 'tXwjBmg', 'nailsbury0@cornell.edu');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20002, 'Sheffield', 'Shillington', 'sshillington1', 'qvRBWBdz', 'sshillington1@europa.eu');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20003, 'Willi', 'Wallwork', 'wwallwork2', 'btz0FU9p', 'wwallwork2@washington.edu');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20004, 'Klaus', 'St Ange', 'kstange3', 'X7hO9Y', 'kstange3@wikimedia.org');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20005, 'Mitchel', 'Sindell', 'msindell4', 'Ob4vBEV', 'msindell4@epa.gov');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20006, 'Kaleena', 'Lovegrove', 'klovegrove5', 'fQkIlFApBla', 'klovegrove5@csmonitor.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20007, 'Gallard', 'Mawhinney', 'gmawhinney6', 'B5NpmlC6W', 'gmawhinney6@wikipedia.org');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20008, 'Pam', 'Bellard', 'pbellard7', '1untzPHWO', 'pbellard7@sfgate.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20009, 'Malory', 'Billett', 'mbillett8', '3FUZW9wDE', 'mbillett8@pbs.org');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20010, 'Nero', 'Finding', 'nfinding9', 'f7cLJzIoI', 'nfinding9@zdnet.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20011, 'Karlen', 'Flockhart', 'kflockharta', 'o1rHhp5dpV', 'kflockharta@nih.gov');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20012, 'Ermengarde', 'Sysland', 'esyslandb', 'S5ldopAVAYZ5', 'esyslandb@yahoo.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20013, 'Gamaliel', 'Capstick', 'gcapstickc', 'nAroLi1Yv', 'gcapstickc@phoca.cz');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20014, 'Xylia', 'Holsall', 'xholsalld', '36gbpHcv', 'xholsalld@phoca.cz');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20015, 'Dale', 'Widdows', 'dwiddowse', 'Tdy3P88TWu', 'dwiddowse@parallels.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20016, 'Nikita', 'Limmer', 'nlimmerf', 'oGrT1LwST', 'nlimmerf@dailymail.co.uk');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20017, 'Hogan', 'Whacket', 'hwhacketg', 'LY2lVKRwkkMu', 'hwhacketg@merriam-webster.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20018, 'Guillermo', 'Herrieven', 'gherrievenh', 'jivRtXWC', 'gherrievenh@va.gov');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20019, 'Zena', 'Endacott', 'zendacotti', 'zUerHCwaAg', 'zendacotti@vinaora.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20020, 'Hyman', 'Dalgarnowch', 'hdalgarnowchj', 'E3GzAiNiK3Ya', 'hdalgarnowchj@springer.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20021, 'Ashley', 'Marten', 'amartenk', 'QdIgBZgiX', 'amartenk@mozilla.org');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20022, 'Darelle', 'Giriardelli', 'dgiriardellil', 'eJiO91r', 'dgiriardellil@facebook.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20023, 'Annaliese', 'Trays', 'atraysm', 'VyqsnvI68', 'atraysm@ucoz.com');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20024, 'Yul', 'Oakland', 'yoaklandn', 'ESWPDANjdO', 'yoaklandn@rambler.ru');
insert into MANAGER_TB (managerid, firstname, lastname, manusername, manpassword, email) values (20025, 'Hamnet', 'Blundon', 'hblundono', 'NF99SA', 'hblundono@arizona.edu');

commit;

-- EDIT THE EMPLOYEE TABLE TO HAVE A MANAGERID
ALTER TABLE EMPLOYEE ADD ( MANAGERID NUMBER(5) );
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_EMPMANAGER FOREIGN KEY (MANAGERID) REFERENCES MANAGER_TB(MANAGERID);

ALTER TABLE REIMBURSE_REQUEST ADD (DENIED_BY NUMBER(5));
ALTER TABLE REIMBURSE_REQUEST ADD CONSTRAINT FK_DENYMANAGER FOREIGN KEY (DENIED_BY) REFERENCES MANAGER_TB(MANAGERID); 

UPDATE EMPLOYEE SET MANAGERID = 20001 WHERE EMPLOYEEID = 10001;
UPDATE EMPLOYEE SET MANAGERID = 20001 WHERE EMPLOYEEID = 10002;
UPDATE EMPLOYEE SET MANAGERID = 20001 WHERE EMPLOYEEID = 10003;
UPDATE EMPLOYEE SET MANAGERID = 20002 WHERE EMPLOYEEID = 10004;
UPDATE EMPLOYEE SET MANAGERID = 20002 WHERE EMPLOYEEID = 10005;
UPDATE EMPLOYEE SET MANAGERID = 20002 WHERE EMPLOYEEID = 10006;
UPDATE EMPLOYEE SET MANAGERID = 20003 WHERE EMPLOYEEID = 10007;
UPDATE EMPLOYEE SET MANAGERID = 20003 WHERE EMPLOYEEID = 10008;
UPDATE EMPLOYEE SET MANAGERID = 20003 WHERE EMPLOYEEID = 10009;
UPDATE EMPLOYEE SET MANAGERID = 20004 WHERE EMPLOYEEID = 10010;
UPDATE EMPLOYEE SET MANAGERID = 20004 WHERE EMPLOYEEID = 10011;
UPDATE EMPLOYEE SET MANAGERID = 20004 WHERE EMPLOYEEID = 10012;
UPDATE EMPLOYEE SET MANAGERID = 20005 WHERE EMPLOYEEID = 10013;
UPDATE EMPLOYEE SET MANAGERID = 20005 WHERE EMPLOYEEID = 10014;
UPDATE EMPLOYEE SET MANAGERID = 20005 WHERE EMPLOYEEID = 10015;
UPDATE EMPLOYEE SET MANAGERID = 20006 WHERE EMPLOYEEID = 10016;
UPDATE EMPLOYEE SET MANAGERID = 20006 WHERE EMPLOYEEID = 10017;
UPDATE EMPLOYEE SET MANAGERID = 20006 WHERE EMPLOYEEID = 10018;
UPDATE EMPLOYEE SET MANAGERID = 20007 WHERE EMPLOYEEID = 10019;
UPDATE EMPLOYEE SET MANAGERID = 20007 WHERE EMPLOYEEID = 10020;
UPDATE EMPLOYEE SET MANAGERID = 20007 WHERE EMPLOYEEID = 10021;
UPDATE EMPLOYEE SET MANAGERID = 20008 WHERE EMPLOYEEID = 10022;
UPDATE EMPLOYEE SET MANAGERID = 20008 WHERE EMPLOYEEID = 10023;
UPDATE EMPLOYEE SET MANAGERID = 20008 WHERE EMPLOYEEID = 10024;
UPDATE EMPLOYEE SET MANAGERID = 20009 WHERE EMPLOYEEID = 10025;
UPDATE EMPLOYEE SET MANAGERID = 20009 WHERE EMPLOYEEID = 10026;
UPDATE EMPLOYEE SET MANAGERID = 20009 WHERE EMPLOYEEID = 10027;
UPDATE EMPLOYEE SET MANAGERID = 20010 WHERE EMPLOYEEID = 10028;
UPDATE EMPLOYEE SET MANAGERID = 20010 WHERE EMPLOYEEID = 10029;
UPDATE EMPLOYEE SET MANAGERID = 20010 WHERE EMPLOYEEID = 10030;
UPDATE EMPLOYEE SET MANAGERID = 20011 WHERE EMPLOYEEID = 10031;
UPDATE EMPLOYEE SET MANAGERID = 20011 WHERE EMPLOYEEID = 10032;
UPDATE EMPLOYEE SET MANAGERID = 20011 WHERE EMPLOYEEID = 10033;
UPDATE EMPLOYEE SET MANAGERID = 20012 WHERE EMPLOYEEID = 10034;
UPDATE EMPLOYEE SET MANAGERID = 20012 WHERE EMPLOYEEID = 10035;
UPDATE EMPLOYEE SET MANAGERID = 20012 WHERE EMPLOYEEID = 10036;
UPDATE EMPLOYEE SET MANAGERID = 20013 WHERE EMPLOYEEID = 10037;
UPDATE EMPLOYEE SET MANAGERID = 20013 WHERE EMPLOYEEID = 10038;
UPDATE EMPLOYEE SET MANAGERID = 20013 WHERE EMPLOYEEID = 10039;
UPDATE EMPLOYEE SET MANAGERID = 20014 WHERE EMPLOYEEID = 10040;
UPDATE EMPLOYEE SET MANAGERID = 20014 WHERE EMPLOYEEID = 10041;
UPDATE EMPLOYEE SET MANAGERID = 20014 WHERE EMPLOYEEID = 10042;
UPDATE EMPLOYEE SET MANAGERID = 20015 WHERE EMPLOYEEID = 10043;
UPDATE EMPLOYEE SET MANAGERID = 20015 WHERE EMPLOYEEID = 10044;
UPDATE EMPLOYEE SET MANAGERID = 20015 WHERE EMPLOYEEID = 10045;
UPDATE EMPLOYEE SET MANAGERID = 20016 WHERE EMPLOYEEID = 10046;
UPDATE EMPLOYEE SET MANAGERID = 20016 WHERE EMPLOYEEID = 10047;
UPDATE EMPLOYEE SET MANAGERID = 20016 WHERE EMPLOYEEID = 10048;
UPDATE EMPLOYEE SET MANAGERID = 20017 WHERE EMPLOYEEID = 10049;
UPDATE EMPLOYEE SET MANAGERID = 20017 WHERE EMPLOYEEID = 10050;
UPDATE EMPLOYEE SET MANAGERID = 20017 WHERE EMPLOYEEID = 10051;
UPDATE EMPLOYEE SET MANAGERID = 20018 WHERE EMPLOYEEID = 10052;
UPDATE EMPLOYEE SET MANAGERID = 20018 WHERE EMPLOYEEID = 10053;
UPDATE EMPLOYEE SET MANAGERID = 20018 WHERE EMPLOYEEID = 10054;
UPDATE EMPLOYEE SET MANAGERID = 20019 WHERE EMPLOYEEID = 10055;
UPDATE EMPLOYEE SET MANAGERID = 20019 WHERE EMPLOYEEID = 10056;
UPDATE EMPLOYEE SET MANAGERID = 20019 WHERE EMPLOYEEID = 10057;
UPDATE EMPLOYEE SET MANAGERID = 20020 WHERE EMPLOYEEID = 10058;
UPDATE EMPLOYEE SET MANAGERID = 20020 WHERE EMPLOYEEID = 10059;
UPDATE EMPLOYEE SET MANAGERID = 20020 WHERE EMPLOYEEID = 10060;
UPDATE EMPLOYEE SET MANAGERID = 20021 WHERE EMPLOYEEID = 10061;
UPDATE EMPLOYEE SET MANAGERID = 20021 WHERE EMPLOYEEID = 10062;
UPDATE EMPLOYEE SET MANAGERID = 20021 WHERE EMPLOYEEID = 10063;
UPDATE EMPLOYEE SET MANAGERID = 20022 WHERE EMPLOYEEID = 10064;
UPDATE EMPLOYEE SET MANAGERID = 20022 WHERE EMPLOYEEID = 10065;
UPDATE EMPLOYEE SET MANAGERID = 20022 WHERE EMPLOYEEID = 10066;
UPDATE EMPLOYEE SET MANAGERID = 20023 WHERE EMPLOYEEID = 10067;
UPDATE EMPLOYEE SET MANAGERID = 20023 WHERE EMPLOYEEID = 10068;
UPDATE EMPLOYEE SET MANAGERID = 20023 WHERE EMPLOYEEID = 10069;
UPDATE EMPLOYEE SET MANAGERID = 20024 WHERE EMPLOYEEID = 10070;
UPDATE EMPLOYEE SET MANAGERID = 20024 WHERE EMPLOYEEID = 10071;
UPDATE EMPLOYEE SET MANAGERID = 20024 WHERE EMPLOYEEID = 10072;
UPDATE EMPLOYEE SET MANAGERID = 20025 WHERE EMPLOYEEID = 10073;
UPDATE EMPLOYEE SET MANAGERID = 20025 WHERE EMPLOYEEID = 10074;
UPDATE EMPLOYEE SET MANAGERID = 20025 WHERE EMPLOYEEID = 10075;

-- PROCEDURES TO BE USED WITH CALLABLE STATEMENTS IF NEEDED
