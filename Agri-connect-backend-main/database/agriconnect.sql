drop database agri_connect;
create database agri_connect;
use agri_connect;

drop table if exists plant_food;
CREATE TABLE PLANT_FOOD (
    PFID varchar(45) PRIMARY KEY,
    PFTITLE VARCHAR(255),
    PFDESCRIPTION TEXT,
    PFWEIGHT JSON,
    PFRATING DOUBLE,
    PFPRICE JSON,
    PFSTOCKAVAILABILITY TINYINT CHECK (PFSTOCKAVAILABILITY = 0 OR PFSTOCKAVAILABILITY = 1),
    PFIMAGES JSON,
    CONSTRAINT rating_range_PF CHECK (PFRATING > 0 AND PFRATING <= 5)
);
DELIMITER $$
CREATE TRIGGER Generate_custom_id_PF
BEFORE INSERT ON Plant_food
FOR EACH ROW
BEGIN
    DECLARE custom_id VARCHAR(15);
    -- Generate custom ID based on your logic
    SET custom_id = CONCAT('PFT', LPAD(NEW.PFID, 8, '0'));
    SET NEW.PFID = custom_id;
END$$
DELIMITER ;
select * from plant_food;


drop table if exists artificial_plant;
CREATE TABLE artificial_plant (
    APID Varchar(45) PRIMARY KEY,
    APTITLE VARCHAR(255),
    APDESCRIPTION TEXT,
    APRATING DOUBLE,
    APPRICE JSON,
    APSTOCKAVAILABILITY TINYINT CHECK (APSTOCKAVAILABILITY = 0 OR APSTOCKAVAILABILITY = 1),
    APIMAGES JSON,
    APPRODUCTDETAILS JSON,
    CONSTRAINT rating_range_AP CHECK (APRATING > 0 AND APRATING <= 5)
);

DELIMITER $$
CREATE TRIGGER Generate_custom_id_AP
BEFORE INSERT ON Artificial_plant
FOR EACH ROW
BEGIN
    DECLARE custom_id VARCHAR(15);
    -- Generate custom ID based on your logic
    SET custom_id = CONCAT('AP', LPAD(NEW.APID, 8, '0'));
    SET NEW.APID = custom_id;
END$$
DELIMITER ;

drop table if exists pump_spray;
CREATE TABLE Pump_Spray (
    PSID Varchar(45) PRIMARY KEY,
    PSTITLE VARCHAR(255),
    PSDESCRIPTION TEXT,
    PSRATING DOUBLE,
    PSPRICE JSON,
    PSSTOCKAVAILABILITY TINYINT CHECK (PSSTOCKAVAILABILITY = 0 OR PSSTOCKAVAILABILITY = 1),
    PSIMAGES JSON,
    PSPRODUCTDETAILS JSON,
    CONSTRAINT rating_range_PS CHECK (PSRATING > 0 AND PSRATING <= 5)
);

DELIMITER $$
CREATE TRIGGER Generate_custom_id_PS
BEFORE INSERT ON Pump_Spray
FOR EACH ROW
BEGIN
    DECLARE custom_id VARCHAR(15);
    -- Generate custom ID based on your logic
    SET custom_id = CONCAT('PAS', LPAD(NEW.PSID, 8, '0'));
    SET NEW.PSID = custom_id;
END$$
DELIMITER ;


drop table if exists Plants;
CREATE TABLE PLANTS (
    PID Varchar(45) PRIMARY KEY,
    PTITLE VARCHAR(255),
    PDESCRIPTION TEXT,
    PRATING DOUBLE,
    PPRICE JSON,
    PSTOCKAVAILABILITY TINYINT CHECK (PSTOCKAVAILABILITY = 0 OR PSTOCKAVAILABILITY = 1),
    PIMAGES JSON,
    CONSTRAINT rating_range_P CHECK (PRATING > 0 AND PRATING <= 5)
);

DELIMITER $$
CREATE TRIGGER Generate_custom_id_P
BEFORE INSERT ON Plants
FOR EACH ROW
BEGIN
    DECLARE custom_id VARCHAR(15);
    -- Generate custom ID based on your logic
    SET custom_id = CONCAT('PST', LPAD(NEW.PID, 8, '0'));
    SET NEW.PID = custom_id;
END$$
DELIMITER ;




drop table if exists CONSUMER; 
CREATE TABLE consumer (
    USERID VARCHAR(255) PRIMARY KEY,
    FIRSTNAME VARCHAR(255) CHECK (length(FIRSTNAME)>=3),
    LASTNAME VARCHAR(255) CHECK (length(LASTNAME)>=3),
    EMAILID VARCHAR(255),
    ADDRESS TEXT,
    PINCODE VARCHAR(50),
    STATE VARCHAR(50),
    GENDER VARCHAR(50),
    WhatsApp_Number varchar(50),
    USER_PASSWORD VARCHAR(50)
);







-- call Generate_custom_user_id_CO('hrishi','nikam','hrishinikam1729@gmail.com','pune','422003','maharashtra','male','9373352724','Hrishi@17294s');
    -- select * from consumer;
 

drop procedure if exists Generate_custom_user_id_CO;
delimiter $
create procedure Generate_custom_user_id_CO(
    FIRSTNAME VARCHAR(255),
    LASTNAME VARCHAR(255),
    EMAILID VARCHAR(255),
    ADDRESS TEXT,
    PINCODE VARCHAR(50),
    STATE VARCHAR(50),
    GENDER VARCHAR(50),
    WhatsApp_Number varchar(50),
    USER_PASSWORD VARCHAR(50))
Begin 
DECLARE U_ID VARCHAR(255);
SET U_ID = concat(substring(FIRSTNAME,1,3),substring(LASTNAME,1,3),FLOOR(RAND() * 10000 + 34));
insert into CONSUMER values(U_ID,
    FIRSTNAME,
    LASTNAME,
    EMAILID,
    ADDRESS,
    PINCODE,
    STATE,
    GENDER,
    WhatsApp_Number,
    USER_PASSWORD);
end $
delimiter ;



drop function if exists Forgot_Password_Check_SEND_OTP;
delimiter $

create function Forgot_Password_Check_SEND_OTP(Phone varchar(255), usid varchar(255)) returns varchar(255)
DETERMINISTIC
begin
declare x bool;
select true into x from CONSUMER where WhatsApp_Number = Phone and userid = usid;
if (x = true) then
return floor(rand() * 1000000);
else
return 'Not_A_User';
end if;
end $
delimiter ;


select * from artificial_plant;



DROP TABLE IF EXISTS POT_PLANTERS;
CREATE TABLE POT_PLANTERS(
PPID VARCHAR(255) PRIMARY KEY, 
PPTITLE VARCHAR(255), 
PPDESCRIPTION TEXT, 
PPDIMENSION JSON,
PP_RATING double CHECK (PP_RATING >0 AND PP_RATING<=5),
PPPRICE JSON,
PP_STOCK_AVAILABILITY INT CHECK (PP_STOCK_AVAILABILITY IN (0,1)),
PPIMAGES JSON);


DELIMITER $$
CREATE TRIGGER Generate_Custom_id_PP
BEFORE INSERT ON POT_PLANTERS
FOR EACH ROW
BEGIN
    DECLARE custom_id VARCHAR(255);
    SET custom_id = CONCAT('PPT', LPAD(NEW.PPid, 8, '0'));
    SET NEW.PPid = custom_id;
END$$
DELIMITER ;

DROP TABLE IF EXISTS PLASTIC_POTS;
CREATE TABLE PLASTIC_POTS(
PPOID VARCHAR(255) PRIMARY KEY, 
PPOTITLE VARCHAR(255),
PPODESCRIPTION TEXT, 
PPODIMENSION JSON,
PPO_RATING double CHECK (PPO_RATING >0 AND PPO_RATING<=5),
PPOPRICE JSON,
PPO_STOCK_AVAILABILITY INT CHECK (PPO_STOCK_AVAILABILITY IN (0,1)),
PPOIMAGES JSON);


drop trigger if exists Generate_Custom_id_PPO
DELIMITER $$
CREATE TRIGGER Generate_Custom_id_PPO
BEFORE INSERT ON PLASTIC_POTS
FOR EACH ROW
BEGIN
    DECLARE custom_id VARCHAR(255);
    SET custom_id = CONCAT('PPO', LPAD(NEW.PPOid, 8, '0'));
    SET NEW.PPOid = custom_id;
END$$
DELIMITER ;





DROP TABLE IF EXISTS SEED_BULB;
CREATE TABLE SEED_BULB (
SBID VARCHAR(255) PRIMARY KEY,
SBTITLE VARCHAR (255),
SBDESCRIPTION TEXT,
SBDETAILS text,
SB_RATING double CHECK (SB_RATING >0 AND SB_RATING<=5),
SBPRICE JSON,
SB_STOCK_AVAILABILITY INT CHECK (SB_STOCK_AVAILABILITY IN (0,1)),
SBIMAGES JSON);

DELIMITER $$
CREATE TRIGGER Generate_Custom_id_SB
BEFORE INSERT ON SEED_BULB
FOR EACH ROW
BEGIN
    DECLARE custom_id VARCHAR(255);
    SET custom_id = CONCAT('SBT', LPAD(NEW.SBid, 8, '0'));
    SET NEW.SBid = custom_id;
END$$
DELIMITER ;



DROP TABLE IF EXISTS PEBBLES_AND_STONES;
CREATE TABLE PEBBLES_AND_STONES (
PASID VARCHAR(255) PRIMARY KEY,
PASTITLE VARCHAR (255),
PASDESCRIPTION TEXT,
PASDETAILS text,
PAS_RATING double CHECK (PAS_RATING >0 AND PAS_RATING<=5),
PASPRICE JSON,
PAS_STOCK_AVAILABILITY INT CHECK (PAS_STOCK_AVAILABILITY IN (0,1)),
PASIMAGES JSON);

DELIMITER $$
CREATE TRIGGER Generate_Custom_id_PAS
BEFORE INSERT ON PEBBLES_AND_STONES
FOR EACH ROW
BEGIN
    DECLARE custom_id VARCHAR(255);
    SET custom_id = CONCAT('PAST', LPAD(NEW.PASid, 8, '0'));
    SET NEW.PASid = custom_id;
END$$
DELIMITER ;



Drop table if exists LOGIN;
CREATE TABLE LOGIN(LOGIN_ID VARCHAR(255) PRIMARY KEY,LOGIN_TIME DATETIME,USER_ID VARCHAR(255));

DROP PROCEDURE IF EXISTS InsertUserLogin;
DELIMITER $
CREATE PROCEDURE InsertUserLogin(IN p_user_id VARCHAR(50))
BEGIN
    DECLARE v_login_id VARCHAR(50);
    SET v_login_id = CONCAT(SUBSTRING(p_user_id, 1, 3), FLOOR(RAND() * 1000000) + 1);
    INSERT INTO LOGIN (login_id, login_time, user_id)
    VALUES (v_login_id, NOW(), p_user_id);
END $
DELIMITER ;


Drop table if exists TRANSACTION_DETAILS;
CREATE TABLE TRANSACTION_DETAILS  (TID VARCHAR(255),UID VARCHAR(255), EMAIL VARCHAR(255), CNO BIGINT(12), CVV INT, CNAME VARCHAR(255), EXP_DATE VARCHAR(255),AMOUNT DOUBLE);


DROP PROCEDURE IF EXISTS Generate_and_insert_TID_Tdetails;
delimiter $
create procedure Generate_and_insert_TID_Tdetails(UID VARCHAR(255),
					 EMAIL VARCHAR(255),
					 CNO BIGINT(12),
					 CVV INT, 
					 CNAME VARCHAR(255),
					 EXP_DATE VARCHAR(255),
					 AMOUNT DOUBLE)
begin
declare T_ID varchar(255);
set T_ID = concat('TR',substring(UID,1,3),floor(rand()*10000));
insert into TRANSACTION_DETAILS values(T_ID,UID,EMAIL,CNO,CVV,CNAME,EXP_DATE,AMOUNT);
end $
delimiter ;                     



drop table if exists Orders;
create table Orders(OrderID varchar(30),UserID varchar(30),OrderTotal varchar(30),DateTimeDetails datetime,token varchar(30));



drop table if exists ord_prod;
CREATE TABLE ord_prod (
    OrderId VARCHAR(30),
    productID VARCHAR(30),
    productQuantity VARCHAR(30),
    total varchar(30)
);


SET GLOBAL event_scheduler = ON;

drop event if exists delete_old_orders;
CREATE EVENT delete_old_orders
ON SCHEDULE EVERY 1 MINUTE
STARTS CURRENT_TIMESTAMP
DO
  DELETE FROM your_table
  WHERE DateTimeDetails < NOW() - INTERVAL 2 DAY;


 drop procedure if exists Insert_Order;
DELIMITER //

CREATE PROCEDURE Insert_Order(
    IN p_UserID VARCHAR(30),
    In O_total varchar(30),
    In token varchar(30)
)
BEGIN
    DECLARE v_OrderID VARCHAR(30);
    
    -- Generate OrderID
    SET v_OrderID = CONCAT('OR', FLOOR(RAND() * 1000));
    
    -- Insert into Orders table
    INSERT INTO Orders VALUES (v_OrderID, p_UserID,O_total, NOW(),token);
    insert into ord_prod values(v_OrderID,null,null,null);
	
    
END//

DELIMITER ;

drop procedure if exists Order_products;
Delimiter $$
create procedure Order_products(OrrId varchar(30),PId varchar(30),TotalPrice varchar(30), PQuant varchar(30))
Begin

	insert into ord_prod values(OrrId,PId,PQuant,TotalPrice);

END $$
Delimiter ;

create table tokenOrder(orderid varchar(30),tokenid varchar(30));

DELIMITER $$
CREATE TRIGGER StoreToken
BEFORE INSERT ON Orders
FOR EACH ROW
BEGIN
    INSERT INTO tokenOrder VALUES (NEW.orderid, NEW.token);
END $$
DELIMITER ;

INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '1',
    'Aglaonema Snow White: Lush and Air-Purifying Live Indoor Plant',
    'The Aglaonema Snow White is a lush, air-purifying plant that will bring life and freshness to your indoor space. With its vibrant green leaves, it adds a touch of nature to any room. This plant is easy to care for and thrives in low light conditions.',
    4.5,
    '[{"MP":"1500", "SP":"1200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Purity-Harmony-Aglaonema-Plant_05ab35b2-2395-47f9-9156-fb9ee96e49c9_652x869.jpg?v=1701249273", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/Aglaonema-Snow-White-Plastic-Pot_b7595646-69f8-4e4d-a5c7-d4f626752319_652x869.jpg?v=1701249273", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2022-12-28at10.02.20AM_652x869.jpg?v=1701249273"}]'
);

INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '2',
    'Rare Imported Aglaonema Stardust Plant - Air-Purifying Indoor Foliage',
    'Exotic and rare, the Aglaonema Stardust is a stunning air-purifying indoor plant that adds a touch of magic to any space. With its unique foliage pattern, it brings a sense of wonder and enchantment to your home or office.',
    4.6,
    '[{"MP":"10000", "SP":"5500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210402_171159_650x869.jpg?v=1670241043", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210402_171135_650x869.jpg?v=1670241043", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210402_171221_650x869.jpg?v=1618552473"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '3',
    'Aglaonema White Stem Plant',
    'The Aglaonema White Stem Plant is a classic choice for indoor greenery. With its elegant white stems and vibrant green leaves, it adds a touch of freshness and sophistication to any space. Easy to care for and air-purifying, its perfect for homes and offices alike.',
    4.4,
    '[{"MP":"8000", "SP":"6000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Aglaonema-White-Stem-Green-Leaves_652x869.jpg?v=1701259390", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210328_091809_650x869.jpg?v=1701259390", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Easy-Care-Aglaonema-White-Stem_652x869.jpg?v=1701259390"}]'
);

INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '4',
    'Aloe Black Beauty (Gastrolea Midnight) Small Succulent Plant',
    'The Aloe Black Beauty, also known Gastrolea Midnight, is a striking succulent plant with deep purple foliage. Its compact size and low maintenance make it perfect for adding a touch of elegance to any space. With proper care, it will thrive and delight for years to come.',
    4.8,
    '[{"MP":"9000", "SP":"6000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/img_2396_1_869x847.jpg?v=1676021078", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/img_2399_1_1_652x869.jpg?v=1676021078"}]'
);

INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '5',
    'Aloe Juvenna (Tiger Tooth Aloe) Small Succulent Plant',
    'The Aloe Juvenna, also known as Tiger Tooth Aloe, is a charming succulent with distinctive toothed leaves. Its vibrant green color and compact size make it a perfect addition to any indoor garden or succulent collection. Easy to care for and drought-tolerant, it thrives in bright, indirect light.',
    4.5,
    '[{"MP":"7000", "SP":"5500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/AloeJuvennaTigerToothinSmallTerraCottaPotIndoorSucculent_652x869.jpg?v=1706615954", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/AloeJuvennaSucculentwithDistinctiveToothedLeavesIndoorSucculent_652x869.jpg?v=1706615954", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Close-upofAloeJuvenna_sVibrantGreenLeavesIndoorSucculent_652x869.jpg?v=1706615954"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '6',
    'Aloe Juvenna (Tiger Tooth Aloe) Succulent Plant',
    'The Aloe Juvenna, also known as Tiger Tooth Aloe, is a stunning succulent plant with distinctive toothed leaves. Its unique appearance and low maintenance make it a popular choice for indoor gardens and succulent enthusiasts. With proper care, it will thrive and add beauty to any space.',
    4.7,
    '[{"MP":"10000", "SP":"7500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Aloe-Juvenna-Small-Space-Gardening-Indoor-Succulent_652x869.jpg?v=1707281223", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/Decorative-Aloe-Juvenna-Tiger-Tooth-Indoor-Succulent_652x869.jpg?v=1707281223", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Aloe-Juvenna-Home-Garden-Indoor-Succulent_652x869.jpg?v=1707281223"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '7',
    'Aloe Rauhii Reynolds Succulent Plant',
    'The Aloe Rauhii Reynolds is a unique and eye-catching succulent plant with distinctive spiky leaves. Its compact size and low maintenance make it a perfect choice for adding a touch of greenery to any indoor space. With its striking appearance, its sure to be a conversation starter.',
    4.6,
    '[{"MP":"9500", "SP":"7000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/easy-care-aloe-rauhii-home-garden-indoor-succulent_652x869.jpg?v=1707211483", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/decorative-snowflake-aloe-online-shop-indoor-succulent_652x869.jpg?v=1707211483", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/indoor-aloe-rauhii-succulent-pot_652x869.jpg?v=1707215543", "IMG4":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-01-10at2.43.47PM_1_869x869.jpg?v=1707215543"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '8',
    'Aloe Zambezi Succulent Plant',
    'The Aloe Zambezi is a stunning succulent plant with striking foliage that adds a touch of drama to any space. Its unique appearance and low maintenance make it a popular choice for indoor gardens and succulent enthusiasts. With proper care, it will thrive and delight for years to come.',
    4.8,
    '[{"MP":"8000", "SP":"5500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210407_115007_650x869.jpg?v=1697383133", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210407_114951_650x869.jpg?v=1697383110"}]'
);

INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '9',
    'Aloe Zebrina Dannyz Succulent Plant',
    'The Aloe Zebrina Dannyz is a stunning succulent plant with distinctive zebra-like markings on its leaves. Its unique appearance and low maintenance make it a popular choice for indoor gardens and succulent enthusiasts. With proper care, it will thrive and add beauty to any space.',
    4.7,
    '[{"MP":"8500", "SP":"6500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Vibrant-Aloe-Zebrina-Dannyz-Indoor-Succulent_652x869.jpg?v=1707218223", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/Low-Maintenance-Aloe-Zebrina-Indoor-Plant_652x869.jpg?v=1707218223", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Stunning-Aloe-Zebrina-White-Pot-Indoor-Succulent_652x869.jpg?v=1707218223"}]'
);

INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '10',
    'Anthurium Pink Color Flowering Plant',
    'The Anthurium Pink Color Flowering Plant is a beautiful and exotic addition to any indoor garden. With its vibrant pink flowers and glossy green leaves, it adds a touch of tropical elegance to any space. Easy to care for and long-lasting, its perfect for brightening up your home or office.',
    4.6,
    '[{"MP":"7000", "SP":"5000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/img_1619_729x870.jpg?v=1676191425", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/img_1621_652x869.jpg?v=1676191425", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/img_1620_652x869.jpg?v=1676191425"}]'
);

INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '11',
    'Exotic Anthurium Red Color Flowering Plant',
    'The Exotic Anthurium Red Color Flowering Plant is a stunning addition to any indoor garden. With its vibrant red flowers and glossy green leaves, it adds a touch of tropical beauty to any space. Easy to care for and long-lasting, its perfect for adding a pop of color to your home or office.',
    4.7,
    '[{"MP":"7500", "SP":"5500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/WhatsAppImage2023-03-17at2.21.05PM_1_652x869.jpg?v=1682915855", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/WhatsAppImage2023-03-17at2.21.05PM_652x869.jpg?v=1682916067", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/WhatsAppImage2023-03-17at2.21.05PM_2_714x869.jpg?v=1682916067", "IMG4":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210327_150938_650x869.jpg?v=1682916067"}]'
);

INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '12',
    'Elegant Bamboo Palm Indoor Plant',
    'The Elegant Bamboo Palm is a beautiful and easy-to-care-for indoor plant that adds a touch of tropical elegance to any space. With its graceful fronds and slender stems, it brings a sense of tranquility and serenity to your home or office. Perfect for brightening up any room, its sure to be a favorite.',
    4.8,
    '[{"MP":"6000", "SP":"4500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/bamboo-palm-indoor-greenery_652x869.jpg?v=1706075144", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/small-bamboo-palm-decor-indoor_652x869.jpg?v=1706075144", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Bamboo-palm-Indoor_652x869.jpg?v=1706075144", "IMG4":"https://www.chhajedgarden.com/cdn/shop/files/bamboo-palm-8-5cm-indoor-plant_652x869.jpg?v=1706075144"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '13',
    'Black Moon Cactus Live Plant (Small)',
    'The Black Moon Cactus is a unique and eye-catching addition to any indoor garden. With its striking black coloration and petite size, it adds a touch of drama and intrigue to any space. Easy to care for and low maintenance, its perfect for adding a pop of color to your home or office.',
    4.5,
    '[{"MP":"5500", "SP":"4000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Striking-Black-Indoor-Cactus_652x869.jpg?v=1704715229", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/blackmooncactussmall_684x869.jpg?v=1704715229", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Petite-Ebony-Cactus-Indoor_652x869.jpg?v=1704715229"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '14',
    'Bougainvillea Green Hanging Flower Plant',
    'The Bougainvillea Green Hanging Flower Plant is a beautiful and vibrant addition to any indoor garden. With its lush green foliage and colorful flowers, it adds a touch of tropical beauty to any space. Easy to care for and long-lasting, its perfect for brightening up your home or office.',
    4.7,
    '[{"MP":"8000", "SP":"5500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Lush-Bougainvillea-Pink-Florals_652x869.jpg?v=1703592596", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/Bougainvillea-Indoor-Display-17cm_652x869.jpg?v=1703592596", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Hanging-Bougainvillea-Green-Pot_652x869.jpg?v=1703592596"}]'
);

INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '15',
    'Calathea Amagris Plant',
    'The Calathea Amagris is a stunning indoor plant with beautiful velvet-like leaves. Its unique pattern and texture add a touch of elegance to any space. Easy to care for and low maintenance, its perfect for adding a pop of greenery to your home or office.',
    4.6,
    '[{"MP":"7500", "SP":"5500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Amagris-Calathea-Velvet-Leaves_652x869.jpg?v=1701341323", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/Calathea-Amagris-Indoor-Beauty_652x869.jpg?v=1701341323", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/CalatheaAmagris1_679x679.jpg?v=1701341323"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '16',
    'Calathea Dottie Plant',
    'The Calathea Dottie is a beautiful indoor plant with stunning pink strokes on its dark green leaves. Its unique pattern and coloration add a touch of drama to any space. Easy to care for and low maintenance, its perfect for adding a pop of color to your home or office.',
    4.7,
    '[{"MP":"8500", "SP":"6000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/calathea878_869x757.jpg?v=1651925252", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/Pink-Stroke-Calathea-Indoor-Plant_652x869.jpg?v=1703587617", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/calathea8888_869x869.jpg?v=1703587617", "IMG4":"https://www.chhajedgarden.com/cdn/shop/files/Mood-Enhancing-Indoor-Dottie-Plant_652x869.jpg?v=1703587617"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '17',
    'Gymnocalycium Mihanovichii Varigated Cactus',
    'The Gymnocalycium Mihanovichii Variegated Cactus is a colorful and unique addition to any indoor garden. With its vibrant variegated pattern, it adds a touch of whimsy to any space. Easy to care for and low maintenance, its perfect for adding a pop of color to your home or office.',
    4.6,
    '[{"MP":"9500", "SP":"7500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Colorful-Variegated-Gymnocalycium_57x75_crop_center.jpg?v=1704711705", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/Bright-Space-Gymno-Cactus_57x75_crop_center.jpg?v=1704706866", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Variegated-Gymnocalycium-Ceramic_57x75_crop_center.jpg?v=1704706850"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '18',
    'Notocactus Magnificus Cactus',
    'The Notocactus Magnificus Cactus is a stunning addition to any indoor garden. With its vibrant green color and unique shape, it adds a touch of elegance to any space. Easy to care for and low maintenance, its perfect for adding a pop of greenery to your home or office.',
    4.7,
    '[{"MP":"7500", "SP":"6000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Self-Sufficient-Magnificus-Cactus_57x75_crop_center.jpg?v=1704779745", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/Vibrant-Notocactus-Magnificus-Plant_57x75_crop_center.jpg?v=1704779745", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Air-Purifying-Notocactus-Green_57x75_crop_center.jpg?v=1704779745"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '19',
    'Non Grafted Cactus (Small, 5 Cactus) Any Color',
    'The Non Grafted Cactus set includes five small cactus plants in various colors. These low-maintenance plants are perfect for adding a touch of desert charm to any indoor garden. With their unique shapes and colors, they are sure to be a conversation starter.',
    4.6,
    '[{"MP":"8000", "SP":"6500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Vibrant-Non-Grafted-Cactus-Set_652x869.jpg?v=1704706944", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/5-Pack-Colorful-Cactus-Set_652x869.jpg?v=1704706944", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Colorful-Non-Grafted-Indoor-Cactus_652x869.jpg?v=1704706944"}]'
);


INSERT INTO PLANTS (PID, PTITLE, PDESCRIPTION, PRATING, PPRICE, PSTOCKAVAILABILITY, PIMAGES) VALUES (
    '20',
    'Red Barrel Cactus (Small)',
    'The Red Barrel Cactus is a striking addition to any indoor garden. With its vibrant red color and unique shape, it adds a touch of desert beauty to any space. Easy to care for and low maintenance, its perfect for adding a pop of color to your home or office.',
    4.7,
    '[{"MP":"6000", "SP":"4500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/Vibrant-Red-Barrel-Cactus-Indoor_652x869.jpg?v=1704082040", "IMG2":"https://www.chhajedgarden.com/cdn/shop/files/Unique-Red-Cactus-Indoor-Beauty_652x869.jpg?v=1704082040", "IMG3":"https://www.chhajedgarden.com/cdn/shop/files/Self-Sufficient-Red-Barrel-Indoor_652x869.jpg?v=1704082040"}]');




INSERT INTO POT_PLANTERS (PPID, PPTITLE, PPDESCRIPTION, PPDIMENSION, PP_RATING, PPPRICE, PP_STOCK_AVAILABILITY, PPIMAGES) 
VALUES ('1', 'Pot Holding Tray Thermoformed (6 Holes)', 'This thermoformed pot holding tray is perfect for starting seeds or transplanting seedlings. It has six holes to accommodate plants.', '{"Length":"10 inches", "Width":"6 inches", "Height":"2 inches"}', 4.5, '[{"MP":"1000", "SP":"800"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210502_152518_870x585.jpg?v=1621403090"}]');

INSERT INTO POT_PLANTERS (PPID, PPTITLE, PPDESCRIPTION, PPDIMENSION, PP_RATING, PPPRICE, PP_STOCK_AVAILABILITY, PPIMAGES) 
VALUES ('2', 'Seedling Tray Square 128 Cells (Pack of 12)', 'This pack includes 12 square seedling trays, each with 128 cells for planting. Perfect for starting a large number of seedlings.', '{"Length":"10 inches", "Width":"10 inches", "Height":"2 inches"}', 4.2, '[{"MP":"1200", "SP":"1000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210502_152203_141x75_crop_center.jpg?v=1621403090"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210502_152155_157x75_crop_center.jpg?v=1621403092"}]');

INSERT INTO POT_PLANTERS (PPID, PPTITLE, PPDESCRIPTION, PPDIMENSION, PP_RATING, PPPRICE, PP_STOCK_AVAILABILITY, PPIMAGES) 
VALUES ('3', 'Stacking Pots Black, Vertical Flower Tower Pots', 'Create a stunning vertical garden with these black stacking pots. Each pot is designed to stack securely on top of another, allowing you to maximize vertical space.', '{"Length":"8 inches", "Width":"8 inches", "Height":"16 inches"}', 4.8, '[{"MP":"1500", "SP":"1300"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/blackstacking_65x75_crop_center.jpg?v=1621403073"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210430_160630_57x75_crop_center.jpg?v=1621403076"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210430_160633_57x75_crop_center.jpg?v=1621403079"}]');

INSERT INTO POT_PLANTERS (PPID, PPTITLE, PPDESCRIPTION, PPDIMENSION, PP_RATING, PPPRICE, PP_STOCK_AVAILABILITY, PPIMAGES) 
VALUES ('4', 'Medium Grape Wine Round Ceramic Plant Pot with Bottom Tray - Premium Quality and Drainage Hole', 'Enhance your garden with this premium quality ceramic plant pot. It features a unique grape wine design and comes with a bottom tray for proper drainage.', '{"Diameter":"12 inches", "Height":"10 inches"}', 4.7, '[{"MP":"2000", "SP":"1800"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Medium_14_57x75_crop_center.jpg?v=1619513503"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/Medium_13_57x75_crop_center.jpg?v=1619513508"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/Medium_15_57x75_crop_center.jpg?v=1619513513"}]');

INSERT INTO POT_PLANTERS (PPID, PPTITLE, PPDESCRIPTION, PPDIMENSION, PP_RATING, PPPRICE, PP_STOCK_AVAILABILITY, PPIMAGES)  
VALUES ('5', 'Round Pond', 'Add a charming touch to your garden with this round pond. Perfect for small aquatic plants or as a decorative feature.', '{"Diameter":"24 inches"}', 4.4, '[{"MP":"5000", "SP":"4500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/RoundPond_113x75_crop_center.jpg?v=1618551922"}]');



INSERT INTO POT_PLANTERS (PPID, PPTITLE, PPDESCRIPTION, PPDIMENSION, PP_RATING, PPPRICE, PP_STOCK_AVAILABILITY, PPIMAGES)  
VALUES ('6', 'Elliptical Pond 65 Liters', 'Create a serene atmosphere in your garden with this 65-liter elliptical pond. Ideal for water lilies and other aquatic plants.', '{"Length":"24 inches", "Width":"18 inches", "Height":"10 inches"}', 4.6, '[{"MP":"8000", "SP":"7000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/65_1557b105-5e80-41eb-a0a5-a406d27525af_122x75_crop_center.jpg?v=1618551918"}]');



INSERT INTO POT_PLANTERS (PPID, PPTITLE, PPDESCRIPTION, PPDIMENSION, PP_RATING, PPPRICE, PP_STOCK_AVAILABILITY, PPIMAGES)  
VALUES ('7', 'Spotted Granite Small Sphere', 'Add a touch of elegance to your garden with this small spotted granite sphere. Perfect for use as a standalone decoration or in a fountain.', '{"Diameter":"10 inches"}', 4.3, '[{"MP":"3000", "SP":"2500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/SphereSmallDecorated_113x75_crop_center.jpg?v=1618551911"}]');

INSERT INTO POT_PLANTERS (PPID, PPTITLE, PPDESCRIPTION, PPDIMENSION, PP_RATING, PPPRICE, PP_STOCK_AVAILABILITY, PPIMAGES) 
VALUES ('8', 'Pond Waterfall Fiber Planter', 'Create a soothing ambiance in your garden with this pond waterfall fiber planter. Its cascading design adds elegance to any outdoor space.', '{"Length":"24 inches", "Width":"12 inches", "Height":"18 inches"}', 4.7, '[{"MP":"6000", "SP":"5000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PondWaterfall_49x75_crop_center.jpg?v=1618551877"}]');

INSERT INTO POT_PLANTERS (PPID, PPTITLE, PPDESCRIPTION, PPDIMENSION, PP_RATING, PPPRICE, PP_STOCK_AVAILABILITY, PPIMAGES)  
VALUES ('9', 'Fiora Fiber Planter', 'Enhance your garden with this elegant Fiora fiber planter. Its modern design and durable construction make it perfect for both indoor and outdoor use.', '{"Length":"18 inches", "Width":"18 inches", "Height":"18 inches"}', 4.6, '[{"MP":"3500", "SP":"3000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Fiora_57x75_crop_center.png?v=1618551875"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/21_99x75_crop_center.jpg?v=1618551879"}]');


INSERT INTO POT_PLANTERS  
VALUES ('10', 'Phonixo Junior Fiber Planter', 'This Phonixo Junior fiber planter is perfect for smaller plants and spaces. Its sleek design adds a touch of modernity to any setting.', '{"Length":"12 inches", "Width":"12 inches", "Height":"12 inches"}', 4.4, '[{"MP":"2000", "SP":"1800"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Phonixo_Junior_80x75_crop_center.png?v=1618551867"}]');

INSERT INTO POT_PLANTERS 
VALUES ('11', 'Phonixo Senior Fiber Planter', 'Upgrade your garden with this spacious Phonixo Senior fiber planter. Its generous size allows for the growth of larger plants and root systems.', '{"Length":"18 inches", "Width":"18 inches", "Height":"18 inches"}', 4.8, '[{"MP":"4000", "SP":"3500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Phonixo_Senior_68x75_crop_center.png?v=1618551868"}]');

INSERT INTO POT_PLANTERS 
VALUES ('12', 'Titanic Smooth Finish Fiber Planter', 'Make a statement in your garden with this Titanic Smooth Finish fiber planter. Its sleek design and durable construction ensure years of enjoyment.', '{"Length":"24 inches", "Width":"24 inches", "Height":"24 inches"}', 4.7, '[{"MP":"4500", "SP":"4000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/TitanicSmooth_105x75_crop_center.jpg?v=1618551868"}]');

INSERT INTO POT_PLANTERS 
VALUES ('13', 'Wood Point Fiber Planter', 'Add a rustic touch to your garden with this Wood Point fiber planter. Its natural wood finish complements any outdoor decor.', '{"Length":"14 inches", "Width":"14 inches", "Height":"14 inches"}', 4.5, '[{"MP":"3000", "SP":"2500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WoodPoint_113x75_crop_center.jpg?v=1618551869"}]');

INSERT INTO POT_PLANTERS 
VALUES ('14', 'Exquisite Fiber Planter', 'Elevate your garden with this Exquisite fiber planter. Its intricate design and durable construction make it a standout addition to any outdoor space.', '{"Length":"16 inches", "Width":"16 inches", "Height":"16 inches"}', 4.6, '[{"MP":"3500", "SP":"3000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Exquisite_37x75_crop_center.jpg?v=1618551868"}]');

INSERT INTO POT_PLANTERS 
VALUES ('15', 'Wooden Truogh Fiber Planter', 'Bring a touch of rustic charm to your garden with this Wooden Trough fiber planter. Its trough design is perfect for displaying a variety of plants.', '{"Length":"24 inches", "Width":"10 inches", "Height":"10 inches"}', 4.3, '[{"MP":"2500", "SP":"2000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WoodenTrough_125x75_crop_center.jpg?v=1618551868"}]');

INSERT INTO POT_PLANTERS 
VALUES ('16', 'Phoenix Bowl URN Fiber Planter', 'Add a touch of elegance to your garden with this Phoenix Bowl URN fiber planter. Its classic design and durable construction make it a timeless addition to any outdoor space.', '{"Diameter":"18 inches", "Height":"16 inches"}', 4.5, '[{"MP":"2800", "SP":"2500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PhoenixBowlURN_117x75_crop_center.jpg?v=1618551858"}]');

INSERT INTO POT_PLANTERS 
VALUES ('17', 'Small Pebble Fiber Planter', 'Create a tranquil garden setting with this Small Pebble fiber planter. Its pebble-like texture adds a natural touch to any outdoor space.', '{"Diameter":"12 inches", "Height":"10 inches"}', 4.2, '[{"MP":"2000", "SP":"1500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PebbleSmall_79x75_crop_center.jpg?v=1618551845"}]');

INSERT INTO POT_PLANTERS 
VALUES ('18', 'Marvel White Fiber Planter', 'Brighten up your garden with this Marvel White fiber planter. Its crisp white finish adds a contemporary touch to any outdoor space.', '{"Diameter":"20 inches", "Height":"18 inches"}', 4.4, '[{"MP":"3200", "SP":"2800"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Marvel_93x75_crop_center.png?v=1618551844"}]');

INSERT INTO POT_PLANTERS  
VALUES ('19', 'Flora Big Fiber Planter', 'Make a bold statement in your garden with this Flora Big fiber planter. Its generous size allows for the growth of large plants and root systems.', '{"Diameter":"24 inches", "Height":"24 inches"}', 4.7, '[{"MP":"4000", "SP":"3500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/FloraBig_176x75_crop_center.jpg?v=1618551846"}]');

INSERT INTO POT_PLANTERS 
VALUES ('20', 'Yula Matt Brown Fiber Planter', 'Add warmth to your garden with this Yula Matt Brown fiber planter. Its rich brown finish complements a variety of outdoor decor styles.', '{"Diameter":"16 inches", "Height":"14 inches"}', 4.3, '[{"MP":"2500", "SP":"2000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Yula_113x75_crop_center.jpg?v=1618551803"}]');

INSERT INTO POT_PLANTERS 
VALUES ('21', 'Stone Wave Stiff Fiber Planter', 'Create a zen garden oasis with this Stone Wave Stiff fiber planter. Its wave-like design adds a calming element to any outdoor space.', '{"Diameter":"20 inches", "Height":"16 inches"}', 4.6, '[{"MP":"2800", "SP":"2500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/StoneWaveStiff_113x75_crop_center.jpg?v=1618551792"}]');

INSERT INTO POT_PLANTERS 
VALUES ('22', 'Aster Round Fiber Planter', 'Add a pop of color to your garden with this Aster Round fiber planter. Its vibrant hue and classic design make it a versatile addition to any outdoor space.', '{"Diameter":"18 inches", "Height":"14 inches"}', 4.4, '[{"MP":"2500", "SP":"2000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/AsterRoundFiberPlanter_133x75_crop_center.jpg?v=1618551748"}]');

INSERT INTO POT_PLANTERS 
VALUES ('23', 'Flower Pot Black Colour Sunrise Series', 'Enhance your garden with this stylish Flower Pot from the Sunrise Series. Its sleek black color adds a modern touch to any outdoor space.', '{"Diameter":"6 inches", "Height":"6 inches"}', 4.3, '[{"MP":"500", "SP":"400"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/14.5CmBlack_4_9ece763c-7660-408b-9246-f57996c2527e_75x75_crop_center.jpg?v=1641446543"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/me2744e2519_3_3_69x75_crop_center.jpg?v=1641446543"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/14.5CmBlack_3_a7af666a-2bba-4d71-bec7-129c9ef81d77_75x75_crop_center.jpg?v=1641446543"}]');

INSERT INTO POT_PLANTERS 
VALUES ('24', 'Hypoestes Fiber Planter', 'Add a splash of color to your garden with this vibrant Hypoestes fiber planter. Its bold pattern and durable construction make it a standout addition to any outdoor space.', '{"Diameter":"14 inches", "Height":"12 inches"}', 4.5, '[{"MP":"1500", "SP":"1200"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/lavina_61x75_crop_center.jpg?v=1618550121"}]');

INSERT INTO POT_PLANTERS 
VALUES ('25', 'Anemone Square Fiber Planter', 'Create a modern garden oasis with this Anemone Square fiber planter. Its square design and sleek finish make it a versatile addition to any outdoor space.', '{"Length":"14 inches", "Width":"14 inches", "Height":"12 inches"}', 4.4, '[{"MP":"1800", "SP":"1500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/AnemoneSquareFiberPlanter_133x75_crop_center.jpg?v=1618550090"}]');

INSERT INTO POT_PLANTERS 
VALUES ('26', 'Daffodil Round Fiber Planter', 'Bring a touch of elegance to your garden with this Daffodil Round fiber planter. Its classic design and durable construction make it a timeless addition to any outdoor space.', '{"Diameter":"18 inches", "Height":"14 inches"}', 4.6, '[{"MP":"2000", "SP":"1800"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/DaffodilRoundFiberPlanter_133x75_crop_center.jpg?v=1618550087"}]');

INSERT INTO POT_PLANTERS 
VALUES ('27', 'Hyacinth Round Fiber Planter', 'Add a touch of sophistication to your garden with this Hyacinth Round fiber planter. Its timeless design and durable construction make it a versatile addition to any outdoor space.', '{"Diameter":"20 inches", "Height":"16 inches"}', 4.7, '[{"MP":"2500", "SP":"2000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/HyacinthRoundFiberPlanter_133x75_crop_center.jpg?v=1618550082"}]');


INSERT INTO POT_PLANTERS 
VALUES ('28', 'Seedling Tray Round 40 Cells (Disposal) (Pack of 12)', 'Start your gardening journey with this Seedling Tray Round. Its durable construction and ample space for seedlings make it an essential tool for any gardener.', '{"Length":"20 inches", "Width":"12 inches", "Height":"2 inches"}', 4.2, '[{"MP":"500", "SP":"400"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/2_4_1_57x75_crop_center.jpg?v=1618549660"}]');

INSERT INTO POT_PLANTERS 
VALUES ('29', 'Seedling Tray Round 104 Cells (Disposal) (Pack of 12)', 'Nurture your seedlings with this Seedling Tray Round. Its multiple cells provide ample space for individual growth, promoting healthy and strong plants.', '{"Length":"20 inches", "Width":"12 inches", "Height":"2 inches"}', 4.5, '[{"MP":"700", "SP":"600"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/1_8_12_100x75_crop_center.jpg?v=1618549660"}]');

INSERT INTO POT_PLANTERS 
VALUES ('30', 'Square Fiber Planter', 'Add a modern touch to your garden with this Square Fiber Planter. Its sleek design and durable construction make it a versatile choice for any outdoor space.', '{"Length":"16 inches", "Width":"16 inches", "Height":"14 inches"}', 4.3, '[{"MP":"1800", "SP":"1500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/purva-fiber-catalog-and-pricelist-343_70x75_crop_center.jpg?v=1618548386"}]');

INSERT INTO POT_PLANTERS 
VALUES ('31', 'Juhi Oval Fiber Planter', 'Enhance your garden with this elegant Juhi Oval Fiber Planter. Its oval shape and ribbed texture add visual interest to any outdoor space.', '{"Length":"20 inches", "Width":"12 inches", "Height":"14 inches"}', 4.4, '[{"MP":"2000", "SP":"1800"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/oval_rib_123x75_crop_center.jpg?v=1618550082"}]');

INSERT INTO POT_PLANTERS 
VALUES ('32', 'Black Vertical Hook Pot', 'Add a touch of elegance to your outdoor space with this Black Vertical Hook Pot. Its sleek design and sturdy construction make it perfect for hanging plants and flowers.', '{"Length":"10 inches", "Width":"10 inches", "Height":"12 inches"}', 4.6, '[{"MP":"1200", "SP":"1000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/black_hook_pot_3_34ffecfd-2168-4350-a078-f990a7c07d14_792x871.jpg?v=1618551166"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/black1_1_1f7f4f78-1cc8-4122-86f5-726bb55b351f_792x871.jpg?v=1618551169"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/black2_1_b97b3e99-b9bb-4150-92d1-2a8ba8a50597_792x871.jpg?v=1618551170"},{"IMG4":"https://www.chhajedgarden.com/cdn/shop/products/black3_1_6932ba4f-8c7b-4686-ac1e-9faf98d06db5_792x871.jpg?v=1618551172"}]');

INSERT INTO POT_PLANTERS 
VALUES ('33', '4.5" Flower Pot White Colour Sunrise Series (11 cm)', 'Brighten up your garden with this Flower Pot from the Sunrise Series. Its crisp white color and elegant design make it a versatile addition to any outdoor space.', '{"Diameter":"4.5 inches", "Height":"4.5 inches"}', 4.5, '[{"MP":"500", "SP":"400"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2022-01-04at11.11.30AM_1_44cc88b0-877c-4c6a-b5af-095994329839_869x869.jpg?v=1641276449"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2022-01-04at11.11.30AM_8e476580-05b6-4d83-b3c8-79dfa58a852a_869x869.jpg?v=1641276477"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/sunrise_pot_white_1_792x871.jpg?v=1641276418"}]');



INSERT INTO POT_PLANTERS 
VALUES ('34', 'Terracotta Vertical Hook Pot', 'Enhance your garden with this Terracotta Vertical Hook Pot. Its traditional terracotta color and unique design make it a charming addition to any outdoor space.', '{"Length":"8 inches", "Width":"8 inches", "Height":"10 inches"}', 4.4, '[{"MP":"1000", "SP":"800"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/18_1_2_8197ff85-6bd7-4cae-be5c-5692b6270634_849x870.jpg?v=1618551300"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/18_2_2_e8ee536f-5aeb-482d-97b4-5ba83f101902_685x870.jpg?v=1618551305"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/18_5_1_18b6aa43-771b-441a-9016-a8ce383433b7_840x869.jpg?v=1618551310"},{"IMG4":"https://www.chhajedgarden.com/cdn/shop/products/18_4_1_d94c2026-b673-4ea2-a917-11dfb5583bed_694x871.jpg?v=1618551315"}]');


INSERT INTO POT_PLANTERS 
VALUES ('35', 'Violet Vertical Hook Pot', 'Add a pop of color to your garden with this Violet Vertical Hook Pot. Its vibrant hue and sleek design make it a stylish choice for showcasing your favorite plants.', '{"Length":"8 inches", "Width":"8 inches", "Height":"10 inches"}', 4.3, '[{"MP":"1200", "SP":"1000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/violet_hook_pot_3_69fb9b36-a30e-4155-9583-f224132ab7e2_792x871.jpg?v=1618551184"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/voilet_2_15a06880-37e9-4e9c-bc7c-6a6c37b448ff_69x75_crop_center.jpg?v=1618551189"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/voilet_3_311f4ea7-60e9-4511-abaa-205a38b5cbec_69x75_crop_center.jpg?v=1618551194"}]');


INSERT INTO POT_PLANTERS 
VALUES ('36', '14 cm White Paris Square Pot', 'Bring a touch of Parisian elegance to your garden with this White Paris Square Pot. Its classic design and durable construction make it a timeless choice for any outdoor space.', '{"Length":"5.5 inches", "Width":"5.5 inches", "Height":"5.5 inches"}', 4.6, '[{"MP":"800", "SP":"600"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Product_-MNHWSJ31o12daVayQhP_75x75_crop_center.jpg?v=1641705508"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/Product_-MNHe9ZQRamadBZEUhdk_75x75_crop_center.jpg?v=1641705523"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/Product_-MNHe9ZZtczZZof_5GyL_75x75_crop_center.jpg?v=1641705536"}]');


INSERT INTO POT_PLANTERS 
VALUES ('37', '4.5" Flower Pot Terracotta Colour Sunrise Series (11 cm)', 'Add a touch of warmth to your garden with this Flower Pot from the Sunrise Series. Its terracotta color and classic design make it a versatile choice for any outdoor space.', '{"Diameter":"4.5 inches", "Height":"4.5 inches"}', 4.4, '[{"MP":"700", "SP":"500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2022-01-04at11.11.28AM_75x75_crop_center.jpg?v=1641276816"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/2_1b6e6762-73d9-48a2-a81f-055c4a9afba5_69x75_crop_center.png?v=1641276816"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2022-01-04at11.11.27AM_75x75_crop_center.jpg?v=1641276816"}]');


INSERT INTO POT_PLANTERS 
VALUES ('38', 'Red Vertical Hook Pot', 'Make a bold statement in your garden with this Red Vertical Hook Pot. Its vibrant color and sleek design make it a striking addition to any outdoor space.', '{"Length":"8 inches", "Width":"8 inches", "Height":"10 inches"}', 4.5, '[{"MP":"1100", "SP":"900"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/red_hook_pot_3_f86b12a3-d7b8-4447-8cac-26e7ce4a9bd8_69x75_crop_center.jpg?v=1618551165"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/red4_a6b32635-af40-4c5c-8b97-fdaab82a5285_69x75_crop_center.jpg?v=1618551174"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/red1_e0b61bc5-7d25-41e6-b670-0bc1f064b130_69x75_crop_center.jpg?v=1618551170"}]');


INSERT INTO POT_PLANTERS 
VALUES ('39', '5.5" Vertical Hook Pot Terracotta Color', 'Add a touch of rustic charm to your garden with this Vertical Hook Pot in Terracotta color. Its classic design and durable construction make it perfect for hanging plants and flowers.', '{"Diameter":"5.5 inches", "Height":"5.5 inches"}', 4.3, '[{"MP":"900", "SP":"700"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/hqdefault_1ff90624-0f76-4614-891a-cbbadf6b9c53_394x295.jpg?v=1619593572"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/teracotta_hook_pot_1_83x75_crop_center.jpg?v=1616707610"}]');



INSERT INTO SEED_BULB VALUES (
    '1',
    'Gerbera Mega Revolution Select Mix Flower Seeds',
    'Gerbera Mega Revolution Select Mix Flower Seeds are a vibrant mix of colors, perfect for adding beauty to any garden or floral arrangement. These seeds produce large, striking blooms that are sure to impress.',
    'Gerbera Mega Revolution Select Mix Flower Seeds produce blooms in a variety of colors including red, yellow, orange, and more. These flowers are perfect for brightening up any space and adding a pop of color to your garden or home.',
    4.5,
    '[{"MP":"1500", "SP":"1200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/GerberaMegaRevolutionSelectMix_600x600.jpg?v=1624949028"}]'
);

INSERT INTO SEED_BULB VALUES (
    '2',
    'Gerbera Mega Revolution Select Mix Flower Seeds',
    'The Gerbera Mega Revolution Select Mix Flower Seeds produce vibrant blooms in various colors, making them an excellent choice for gardeners looking to add a splash of color to their landscapes. With proper care, these seeds will flourish and bring joy to any garden.',
    'These seeds produce large, colorful blooms that are perfect for bouquets, floral arrangements, or adding visual interest to any outdoor space.',
    4.4,
    '[{"MP":"1600", "SP":"1250"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/GerberaMegaRevolutionSelectMix_fb98b902-d6e3-41de-8d16-8a09fcf42d8d_600x600.jpg?v=1624949031"}]'
);

INSERT INTO SEED_BULB VALUES (
    '3',
    'Gerbera ColorBloom Mix Flower Seeds',
    'Gerbera ColorBloom Mix Flower Seeds produce stunning blooms in a variety of vibrant colors, adding beauty and elegance to any garden or landscape. These seeds are easy to grow and will thrive in both garden beds and containers.',
    'The Gerbera ColorBloom Mix Flower Seeds are known for their large, daisy-like blooms that come in shades of pink, red, yellow, orange, and more. These flowers are perfect for adding a pop of color to any garden or floral arrangement.',
    4.6,
    '[{"MP":"1700", "SP":"1300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/GerberaColorBloomMixFlowerSeeds_600x600.jpg?v=1618552713"}]'
);

INSERT INTO SEED_BULB VALUES (
    '4',
    'Gerbera ColorBloom Yellow Dark Eye Flower Seeds',
    'Gerbera ColorBloom Yellow Dark Eye Flower Seeds produce beautiful yellow blooms with dark centers, adding a touch of elegance to any garden or floral arrangement. These seeds are easy to grow and will thrive in various climates.',
    'These seeds produce stunning yellow blooms with dark centers, making them perfect for adding contrast and visual interest to any garden or landscape.',
    4.3,
    '[{"MP":"1800", "SP":"1400"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/GerberaColorBloomYellowDarkEyeFlowerSeeds_600x600.jpg?v=1618552703"}]'
);

INSERT INTO SEED_BULB VALUES (
    '5',
    'Gerbera ColorBloom Bicolor Yellow Orange Flower Seeds',
    'Gerbera ColorBloom Bicolor Yellow Orange Flower Seeds produce stunning blooms in shades of yellow and orange, adding warmth and vibrancy to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Gerbera ColorBloom Bicolor Yellow Orange Flower Seeds produce vibrant blooms with a stunning combination of yellow and orange hues. These flowers are perfect for adding a pop of color to any outdoor space.',
    4.8,
    '[{"MP":"1900", "SP":"1500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/GerberaColorBloomBicolorYellowOrangeFlowerSeeds2_600x600.jpg?v=1618552703"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/GerberaColorBloomBicolorYellowOrangeFlowerSeeds_600x600.jpg?v=1618552706"}]'
);

INSERT INTO SEED_BULB VALUES (
    '6',
    'Gerbera ColorBloom Red Light Eye Flower Seeds',
    'Gerbera ColorBloom Red Light Eye Flower Seeds produce striking red blooms with light centers, adding drama and beauty to any garden or floral arrangement. These seeds are easy to grow and will thrive in various soil types.',
    'These seeds produce vibrant red blooms with light centers, making them perfect for adding a bold pop of color to any outdoor space. The flowers are also great for attracting pollinators like butterflies and bees.',
    4.7,
    '[{"MP":"2000", "SP":"1600"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/GerberaColorBloomRedLightEyeFlowerSeeds_600x600.jpg?v=1618552701"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/GerberaColorBloomRedLightEyeFlowerSeeds2_600x600.jpg?v=1618552704"}]'
);

INSERT INTO SEED_BULB VALUES (
    '7',
    'Gerbera ColorBloom Deep Rose Light Eye Flower Seeds',
    'Gerbera ColorBloom Deep Rose Light Eye Flower Seeds produce stunning deep rose blooms with light centers, adding elegance and beauty to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Gerbera ColorBloom Deep Rose Light Eye Flower Seeds produce beautiful blooms in shades of deep rose with light centers, creating a striking contrast that is sure to impress. These flowers are perfect for adding a touch of romance to any outdoor space.',
    4.9,
    '[{"MP":"2100", "SP":"1700"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/GerberaColorBloomDeepRoseLightEyeFlowerSeeds2_600x600.jpg?v=1618552701"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/GerberaColorBloomCherryLightEyeFlowerSeeds2_c9dd528e-a0da-4ddd-ad58-5942a0df1507_600x600.jpg?v=1618552706"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/GerberaColorBloomDeepRoseLightEyeFlowerSeeds_600x600.jpg?v=1618552708"}]'
);

INSERT INTO SEED_BULB VALUES (
    '8',
    'Gerbera Mega Revolution Champagne Flower Seeds',
    'Gerbera Mega Revolution Champagne Flower Seeds produce delicate champagne-colored blooms, adding elegance and sophistication to any garden or floral arrangement. These seeds are easy to grow and will thrive in various soil types.',
    'The Gerbera Mega Revolution Champagne Flower Seeds produce beautiful champagne-colored blooms that are perfect for weddings, special occasions, or adding a touch of elegance to any outdoor space. These flowers are also great for attracting pollinators like butterflies and bees.',
    4.6,
    '[{"MP":"2200", "SP":"1800"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/gerbera_mega_revolution_champagne_1_300x300.jpg?v=1618549464"}]'
);

INSERT INTO SEED_BULB VALUES (
    '9',
    'Petunia Success 360° Red Flower Seeds',
    'Petunia Success 360° Red Flower Seeds produce vibrant red blooms, adding a splash of color to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Petunia Success 360° Red Flower Seeds produce stunning red blooms that are perfect for adding color and beauty to any outdoor space. These flowers are also great for attracting pollinators like butterflies and hummingbirds.',
    4.7,
    '[{"MP":"2300", "SP":"1900"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/success-360-red-t3017-1_869x652.jpg?v=1697383149"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/PetuniaSuccess360_RedFlowerSeeds_869x652.jpg?v=1697383157"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/PetuniaSuccess360_RedFlowerSeeds3_869x652.jpg?v=1697383141"}]'
);

INSERT INTO SEED_BULB VALUES (
    '10',
    'Petunia Success 360° White Flower Seeds',
    'Petunia Success 360° White Flower Seeds produce elegant white blooms, adding a touch of sophistication to any garden or floral arrangement. These seeds are easy to grow and will thrive in various soil types.',
    'The Petunia Success 360° White Flower Seeds produce stunning white blooms that are perfect for weddings, special occasions, or adding a touch of elegance to any outdoor space. These flowers are also great for attracting pollinators like butterflies and bees.',
    4.8,
    '[{"MP":"2400", "SP":"2000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/success-360-white-t3011-1_869x652.jpg?v=1697383139"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/PetuniaSuccess360_WhiteFlowerSeeds_869x652.jpg?v=1697383156"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/PetuniaSuccess360_WhiteFlowerSeeds3_869x652.jpg?v=1697383156"}]'
);

INSERT INTO SEED_BULB VALUES (
    '11',
    'Petunia Single Mf. Celebrity Red Morn Flower Seeds',
    'Petunia Single Mf. Celebrity Red Morn Flower Seeds produce vibrant red blooms with a white star pattern, adding a touch of whimsy to any garden or floral arrangement. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Petunia Single Mf. Celebrity Red Morn Flower Seeds produce stunning red blooms with a unique white star pattern, making them perfect for adding visual interest to any outdoor space. These flowers are also great for attracting pollinators like butterflies and hummingbirds.',
    4.9,
    '[{"MP":"2500", "SP":"2100"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/petunia-hybrida-celebrity-red-morn-_1_579x871.jpg?v=1618550500"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/petunia-hybrida-celebrity-red-morn-t1532-1_869x866.jpg?v=1618550505"}]'
);

INSERT INTO SEED_BULB VALUES (
    '12',
    'Petunia Single Gf. Daddy Mix Flower Seeds',
    'Petunia Single Gf. Daddy Mix Flower Seeds produce a mix of vibrant blooms in various colors, adding beauty and elegance to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Petunia Single Gf. Daddy Mix Flower Seeds produce a mix of colorful blooms that are perfect for adding visual interest to any outdoor space. These flowers are also great for attracting pollinators like butterflies and bees.',
    4.7,
    '[{"MP":"2600", "SP":"2200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/petunia_grandiflora_single_daddy_mix_300x300.jpg?v=1618549650"}]'
);

INSERT INTO SEED_BULB VALUES (
    '13',
    'Statice QIS Dark Blue Flower Seeds',
    'Statice QIS Dark Blue Flower Seeds produce stunning dark blue blooms, adding drama and elegance to any garden or floral arrangement. These seeds are easy to grow and will thrive in various soil types.',
    'The Statice QIS Dark Blue Flower Seeds produce beautiful dark blue blooms that are perfect for adding color and beauty to any outdoor space. These flowers are also great for drying and using in floral arrangements.',
    4.6,
    '[{"MP":"2700", "SP":"2300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/dark_blue_600x600.jpg?v=1618549396"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/StaticeQISDarkBlueFlowerSeeds_600x600.jpg?v=1618549401"}]'
);

INSERT INTO SEED_BULB VALUES (
    '14',
    'Statice QIS Rose Flower Seeds',
    'Statice QIS Rose Flower Seeds produce beautiful rose-colored blooms, adding romance and elegance to any garden or floral arrangement. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Statice QIS Rose Flower Seeds produce stunning rose-colored blooms that are perfect for adding a touch of romance to any outdoor space. These flowers are also great for drying and using in floral arrangements.',
    4.8,
    '[{"MP":"2800", "SP":"2400"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/rose_4_600x600.jpg?v=1618549411"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/StaticeQISRoseFlowerSeeds_600x600.jpg?v=1618549416"}]'
);

INSERT INTO SEED_BULB VALUES (
    '15',
    'Statice QIS Mix Flower Seeds',
    'Statice QIS Mix Flower Seeds produce a mix of colorful blooms, adding vibrancy and beauty to any garden or landscape. These seeds are easy to grow and will thrive in various soil types.',
    'The Statice QIS Mix Flower Seeds produce a mix of colorful blooms in shades of pink, purple, blue, and more. These flowers are perfect for adding a pop of color to any outdoor space and are also great for drying and using in floral arrangements.',
    4.7,
    '[{"MP":"2900", "SP":"2500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/mix_6_600x600.jpg?v=1697383103"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/StaticeQISMixFlowerSeeds2_600x600.jpg?v=1697383101"}]'
);

INSERT INTO SEED_BULB VALUES (
    '16',
    'Statice QIS Pastel Flower Seeds',
    'Statice QIS Pastel Flower Seeds produce delicate pastel-colored blooms, adding softness and elegance to any garden or floral arrangement. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Statice QIS Pastel Flower Seeds produce beautiful pastel-colored blooms that are perfect for adding a touch of softness to any outdoor space. These flowers are also great for drying and using in floral arrangements.',
    4.5,
    '[{"MP":"3000", "SP":"2600"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/static_qis_pastel_1_600x600.jpg?v=1618548736"}]'
);

INSERT INTO SEED_BULB VALUES (
    '17',
    'Aster Standy Carmine Red Flower Seeds',
    'Aster Standy Carmine Red Flower Seeds produce vibrant red blooms, adding a splash of color to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Aster Standy Carmine Red Flower Seeds produce stunning red blooms that are perfect for adding color and beauty to any outdoor space. These flowers are also great for attracting pollinators like butterflies and bees.',
    4.6,
    '[{"MP":"3100", "SP":"2700"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/AsterStandyCarmineRedFlowerSeeds_400x400.png?v=1706166321"}]'
);

INSERT INTO SEED_BULB VALUES (
    '18',
    'Aster Standy Carmine & White Flower Seeds',
    'Aster Standy Carmine & White Flower Seeds produce blooms in shades of carmine and white, adding elegance and beauty to any garden or landscape. These seeds are easy to grow and will thrive in various soil types.',
    'The Aster Standy Carmine & White Flower Seeds produce beautiful blooms in shades of carmine and white, creating a stunning contrast that is sure to impress. These flowers are perfect for adding a touch of sophistication to any outdoor space.',
    4.8,
    '[{"MP":"3200", "SP":"2800"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/AsterStandyCarmine_WhiteFlowerSeeds_51x75_crop_center.png?v=1706166456"}]'
);

INSERT INTO SEED_BULB VALUES (
    '19',
    'Aster Matador Fiery Red Flower Seeds',
    'Aster Matador Fiery Red Flower Seeds produce vibrant red blooms, adding a splash of color to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Aster Matador Fiery Red Flower Seeds produce stunning red blooms that are perfect for adding color and beauty to any outdoor space. These flowers are also great for attracting pollinators like butterflies and bees.',
    4.7,
    '[{"MP":"3300", "SP":"2900"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/AsterMatadorFieryRed_75x75_crop_center.png?v=1706183401"}]'
);

INSERT INTO SEED_BULB VALUES (
    '20',
    'Antirrhinum Palette Bronze Flower Seeds',
    'Antirrhinum Palette Bronze Flower Seeds produce blooms in a rich bronze color, adding warmth and elegance to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Antirrhinum Palette Bronze Flower Seeds produce beautiful bronze blooms that are perfect for adding a touch of warmth to any outdoor space. These flowers are also great for attracting pollinators like butterflies and bees.',
    4.6,
    '[{"MP":"3400", "SP":"3000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/AntirrhinumPaletteBronze_94x75_crop_center.jpg?v=1706521876"}]'
);

INSERT INTO SEED_BULB VALUES (
    '21',
    'Antirrhinum Palette Red Flower Seeds',
    'Antirrhinum Palette Red Flower Seeds produce vibrant red blooms, adding a splash of color to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Antirrhinum Palette Red Flower Seeds produce stunning red blooms that are perfect for adding color and beauty to any outdoor space. These flowers are also great for attracting pollinators like butterflies and bees.',
    4.7,
    '[{"MP":"3500", "SP":"3100"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/AntirrhinumPaletteRedFlowerSeeds_65x75_crop_center.jpg?v=1706524196"}]'
);

INSERT INTO SEED_BULB VALUES (
    '22',
    'Amaranthus Early Splendor Seeds',
    'Amaranthus Early Splendor Seeds produce vibrant blooms in shades of red, purple, and green, adding a pop of color to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Amaranthus Early Splendor Seeds produce stunning blooms in shades of red, purple, and green, creating a vibrant display that is sure to impress. These flowers are perfect for adding visual interest to any outdoor space.',
    4.8,
    '[{"MP":"3600", "SP":"3200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/AmaranthusEarlySplendorSeeds_75x75_crop_center.jpg?v=1706873094"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/files/AmaranthusEarlySplendorSeeds_f8ad2730-332b-497d-8a31-08939475e248_75x75_crop_center.jpg?v=1706873116"}]'
);

INSERT INTO SEED_BULB VALUES (
    '23',
    'Celosia Plumosa Sunday Bright Pink Flower Seeds',
    'Celosia Plumosa Sunday Bright Pink Flower Seeds produce bright pink blooms, adding a burst of color to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Celosia Plumosa Sunday Bright Pink Flower Seeds produce stunning bright pink blooms that are perfect for adding color and beauty to any outdoor space. These flowers are also great for attracting pollinators like butterflies and bees.',
    4.7,
    '[{"MP":"3700", "SP":"3300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/CelosiaPlumosaSundayBrightPinkFlowerSeeds1_75x75_crop_center.webp?v=1706960034"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/files/CelosiaPlumosaSundayBrightPinkFlowerSeeds2_75x75_crop_center.webp?v=1706960034"}]'
);

INSERT INTO SEED_BULB VALUES (
    '24',
    'Coleus Premium Sun Coral Candy Seeds',
    'Coleus Premium Sun Coral Candy Seeds produce vibrant blooms in shades of coral, adding warmth and elegance to any garden or landscape. These seeds are easy to grow and will thrive in both sun and partial shade.',
    'The Coleus Premium Sun Coral Candy Seeds produce stunning blooms in shades of coral, creating a warm and inviting display that is sure to impress. These flowers are perfect for adding a touch of color to any outdoor space.',
    4.6,
    '[{"MP":"3800", "SP":"3400"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/files/ColeusPremiumSunCoralCandySeeds_96x75_crop_center.webp?v=1707028477"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/files/ColeusPremiumSunCoralCandySeeds1_87x75_crop_center.webp?v=1707028517"}]'
);

INSERT INTO SEED_BULB VALUES (
    '25',
    'Petunia Success 360° White Flower Seeds',
    'Petunia Success 360° White Flower Seeds produce elegant white blooms, adding a touch of sophistication to any garden or floral arrangement. These seeds are easy to grow and will thrive in various soil types.',
    'The Petunia Success 360° White Flower Seeds produce stunning white blooms that are perfect for weddings, special occasions, or adding a touch of elegance to any outdoor space. These flowers are also great for attracting pollinators like butterflies and bees.',
    4.8,
    '[{"MP":"3900", "SP":"3500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/success-360-white-t3011-1_100x75_crop_center.jpg?v=1697383139"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/PetuniaSuccess360_WhiteFlowerSeeds3_100x75_crop_center.jpg?v=1697383156"}]'
);




INSERT INTO Pebbles_and_stones VALUES (
    '1',
    'Brown Pebble Chips, 1 kg',
    'Brown pebble chips are a natural and decorative choice for enhancing your garden or landscaping. Create a beautiful and earthy atmosphere with these versatile pebbles.',
    'Ideal for garden pathways and decorative features.',
    4.5,
    '[{"MP":"1200", "SP":"1000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210424_152728_101x75_crop_center.jpg?v=1624949322", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210424_152848_101x75_crop_center.jpg?v=1624949323", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210424_153145_57x75_crop_center.jpg?v=1624949323"}]'
);

INSERT INTO Pebbles_and_stones VALUES (
    '2',
    'Decorative Medium Pebble Stone White Colour',
    'Enhance the aesthetics of your garden with these white decorative medium pebble stones. Versatile and elegant, these pebbles add a touch of sophistication to any landscaping project.',
    'Suitable for use in flower beds, around trees, and as ground cover.',
    4.8,
    '[{"MP":"1500", "SP":"1300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210425_142042_57x75_crop_center.jpg?v=1624949281", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210425_142123_101x75_crop_center.jpg?v=1624949288", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210425_142153_57x75_crop_center.jpg?v=1624949291"}]'
);

INSERT INTO Pebbles_and_stones VALUES (
    '3',
    'Pebbles Chips Brown',
    'Add a natural and rustic look to your outdoor spaces with brown pebble chips. These pebbles are perfect for various landscaping projects, offering both beauty and functionality.',
    'Great for pathways, garden borders, and decorative elements.',
    4.2,
    '[{"MP":"1100", "SP":"900"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PebblesChipsBrown01_57x75_crop_center.jpg?v=1697383077", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/PebblesChipsBrown02_57x75_crop_center.jpg?v=1697383078"}]'
);



-- Entry 4
INSERT INTO Pebbles_and_stones VALUES (
    '4',
    'Orange Pebble Chips, 1 kg',
    'Enhance your garden with vibrant orange pebble chips. These chips add a pop of color to your landscaping, creating a visually appealing and lively outdoor space.',
    'Perfect for garden pathways, flower beds, and decorative features.',
    4.4,
    '[{"MP":"1300", "SP":"1100"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/OrangePebbleChips_1kg01_57x75_crop_center.jpg?v=1624949318", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/OrangePebbleChips_1kg03_57x75_crop_center.jpg?v=1624949319", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/OrangePebbleChips_1kg04_57x75_crop_center.jpg?v=1624949320"}]'
);

-- Entry 5
INSERT INTO Pebbles_and_stones VALUES (
    '5',
    'Onex Light Blue Round Pebbles, 900 GM',
    'Create a serene and calming atmosphere in your garden with light blue round pebbles. These onex pebbles add a touch of elegance and charm to your outdoor spaces.',
    'Ideal for water features, garden borders, and decorative arrangements.',
    4.7,
    '[{"MP":"1400", "SP":"1200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-01-20at5.11.56PM_75x75_crop_center.jpg?v=1674283081", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-01-20at5.11.59PM_1_107x75_crop_center.jpg?v=1674283081", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/OnexLightBlueRoundPebbles_900GM03_57x75_crop_center.jpg?v=1674283081"}]'
);

-- Entry 6
INSERT INTO Pebbles_and_stones VALUES (
    '6',
    'Onex Blue Pebbles, 900 GM',
    'Add a touch of sophistication to your garden with blue onex pebbles. These pebbles are perfect for creating a tranquil and visually appealing outdoor environment.',
    'Suitable for use in planters, pathways, and decorative features.',
    4.6,
    '[{"MP":"1500", "SP":"1300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-01-20at5.09.13PM_57x75_crop_center.jpg?v=1674283126", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-01-20at5.10.59PM_75x75_crop_center.jpg?v=1674283126", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-01-20at5.09.11PM_1_75x75_crop_center.jpg?v=1674283126"}]'
);

-- Entry 7
INSERT INTO Pebbles_and_stones VALUES (
    '7',
    'Black Pebble Chips, 1 kg',
    'Create a bold and striking contrast in your garden with black pebble chips. These chips add a modern and sophisticated touch to your landscaping.',
    'Ideal for creating pathways, borders, and decorative elements.',
    4.3,
    '[{"MP":"1400", "SP":"1200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210424_162041_57x75_crop_center.jpg?v=1624949318", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210424_161913_57x75_crop_center.jpg?v=1624949319"}]'
);

-- Entry 8
INSERT INTO Pebbles_and_stones VALUES (
    '8',
    'Pebbles Onex Offwhite',
    'Add a touch of elegance to your garden with off-white onex pebbles. These pebbles are versatile and can be used to enhance various landscaping projects.',
    'Suitable for use in flower beds, planters, and decorative arrangements.',
    4.9,
    '[{"MP":"1600", "SP":"1400"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/91tu41eklgl._sl1500_100x75_crop_center.jpg?v=1618548143", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/njlh7084_100x75_crop_center.jpg?v=161854814500"}]'
);

-- Entry 9
INSERT INTO Pebbles_and_stones VALUES (
    '9',
    'Pebbles Chips Mix',
    'Add a splash of color to your garden with a mix of pebble chips. These versatile pebbles are perfect for creating vibrant and eye-catching landscaping designs.',
    'Great for use in pathways, garden borders, and decorative features.',
    4.2,
    '[{"MP":"1200", "SP":"1000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/dscn8744_134x75_crop_center.jpg?v=1697383077"}]'
);

-- Entry 10
INSERT INTO Pebbles_and_stones VALUES (
    '10',
    'Pebbles Chips Gray',
    'Create a modern and sleek look in your garden with gray pebble chips. These chips add a contemporary touch to your landscaping, enhancing the overall aesthetics.',
    'Ideal for creating pathways, borders, and decorative elements.',
    4.4,
    '[{"MP":"1300", "SP":"1100"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PebblesChipsGray01_101x75_crop_center.jpg?v=1697383077", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/PebblesChipsGray02_57x75_crop_center.jpg?v=1697383076"}]'
);

-- Entry 11
INSERT INTO Pebbles_and_stones VALUES (
    '11',
    'Onex White Round Pebbles, 900 GM',
    'Create a pristine and elegant garden with white round onex pebbles. These pebbles add a touch of sophistication to your landscaping, creating a serene outdoor space.',
    'Perfect for use in water features, garden borders, and decorative arrangements.',
    4.7,
    '[{"MP":"1400", "SP":"1200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210425_141222_57x75_crop_center.jpg?v=1624949303", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210425_141156_101x75_crop_center.jpg?v=1624949296", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210425_141158_101x75_crop_center.jpg?v=1624949300"}]'
);

-- Entry 12
INSERT INTO Pebbles_and_stones VALUES (
    '12',
    'Onex Brown Pebbles, 900 GM',
    'Add warmth and character to your garden with brown onex pebbles. These pebbles bring a natural and earthy element to your landscaping, creating a cozy outdoor atmosphere.',
    'Suitable for use in planters, pathways, and decorative features.',
    4.6,
    '[{"MP":"1500", "SP":"1300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/OnexBrownPebbles_900GM04_101x75_crop_center.jpg?v=1624949295", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/OnexBrownPebbles_900GM01_101x75_crop_center.jpg?v=1624949298", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/OnexBrownPebbles_900GM02_57x75_crop_center.jpg?v=1624949301"}]'
);

-- Entry 13
INSERT INTO Pebbles_and_stones VALUES (
    '13',
    'Pebbles Green Big - 5 Kg',
    'Create a lush and vibrant garden with green big pebbles. These large pebbles add a bold and refreshing touch to your landscaping, enhancing the overall greenery.',
    'Perfect for use in garden beds, around trees, and as ground cover.',
    4.3,
    '[{"MP":"1300", "SP":"1100"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PebblesGreenBig01_57x75_crop_center.jpg?v=1624949296", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/PebblesGreenBig02_57x75_crop_center.jpg?v=1624949300", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/PebblesGreenBig03_57x75_crop_center.jpg?v=1624949303"}]'
);

-- Entry 14
INSERT INTO Pebbles_and_stones VALUES (
    '14',
    'Green Onex Pebbles',
    'Add a touch of nature to your garden with green onex pebbles. These pebbles bring a refreshing and calming element to your landscaping, creating a peaceful outdoor retreat.',
    'Ideal for use in planters, water features, and decorative arrangements.',
    4.5,
    '[{"MP":"1400", "SP":"1200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/cgkpog10_79x75_crop_center.jpg?v=1618548152"}]'
);

-- Entry 15
INSERT INTO Pebbles_and_stones VALUES (
    '15',
    'Pebbles Brown',
    'Enhance the natural beauty of your garden with brown pebbles. These versatile pebbles add a rustic and earthy element to your landscaping, creating a warm outdoor atmosphere.',
    'Suitable for use in garden beds, pathways, and decorative features.',
    4.2,
    '[{"MP":"1200", "SP":"1000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/uyhr8496_100x75_crop_center.jpg?v=1618548154"}]'
);

-- Entry 16
INSERT INTO Pebbles_and_stones VALUES (
    '16',
    'Mix Color Onex Pebbles',
    'Create a vibrant and colorful garden with mix color onex pebbles. These pebbles add an energetic and playful touch to your landscaping, enhancing the overall visual appeal.',
    'Ideal for use in flower beds, around trees, and as ground cover.',
    4.6,
    '[{"MP":"1300", "SP":"1100"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/91fgicknial._sl1500_82x75_crop_center.jpg?v=1618548142"}]'
);

-- Entry 17
INSERT INTO Pebbles_and_stones VALUES (
    '17',
    'Red Chips Pebble',
    'Enhance the boldness of your garden with red chips pebbles. These pebbles add a vibrant and striking element to your landscaping, creating a visually dynamic outdoor space.',
    'Perfect for use in garden beds, pathways, and decorative arrangements.',
    4.4,
    '[{"MP":"1200", "SP":"1000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/cgjpcr1_350x272.jpg?v=1618548214"}]'
);

-- Entry 18
INSERT INTO Pebbles_and_stones VALUES (
    '18',
    'Pink Pebbles',
    'Add a touch of elegance to your garden with pink pebbles. These pebbles bring a soft and feminine element to your landscaping, creating a charming and delightful outdoor space.',
    'Ideal for use in flower beds, around trees, and as ground cover.',
    4.3,
    '[{"MP":"1100", "SP":"900"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/cgjpp03_300x250.jpg?v=1618548217"}]'
);

-- Entry 19
INSERT INTO Pebbles_and_stones VALUES (
    '19',
    'Pebbles Black Big - 5 Kg',
    'Create a bold and dramatic garden with black big pebbles. These large pebbles add a modern and sophisticated touch to your landscaping, enhancing the overall visual impact.',
    'Perfect for use in garden beds, pathways, and decorative arrangements.',
    4.5,
    '[{"MP":"1300", "SP":"1100"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PebblesBlackBig01_650x869.jpg?v=1624949296", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/PebblesBlackBig02_650x869.jpg?v=1624949299", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/PebblesBlackBig03_650x869.jpg?v=1624949302"}]'
);

-- Entry 20
INSERT INTO Pebbles_and_stones VALUES (
    '20',
    'Pebbles Orange Big - 5 Kg',
    'Add warmth and vibrancy to your garden with orange big pebbles. These large pebbles bring a bold and energetic element to your landscaping, creating a lively outdoor space.',
    'Ideal for use in garden beds, around trees, and as ground cover.',
    4.4,
    '[{"MP":"1200", "SP":"1000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PebblesOrangeBig01_650x869.jpg?v=1624949295"}]'
);


INSERT INTO PLANT_FOOD VALUES (
    '1',
    '1 Kg Sphagnum Moss Online in India',
    '1 Kg Sphagnum Moss Online in India is perfect for maintaining moisture in soil and promoting healthy plant growth. It provides excellent aeration and drainage, making it ideal for various gardening applications.',
    '{"unit":"kg", "value":1}',
    4.9,
    '[{"MP":"1500", "SP":"1200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/1-kg-sphagnum-moss-online-in-india-chhajedgarden-com-1_869x869.jpg?v=1700543727"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/1-kg-sphagnum-moss-online-in-india-chhajedgarden-com-2_652x869.jpg?v=1700543751"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/1-kg-sphagnum-moss-online-in-india-chhajedgarden-com-3_869x869.jpg?v=1700543755"},{"IMG4":"https://www.chhajedgarden.com/cdn/shop/products/1-kg-sphagnum-moss-online-in-india-chhajedgarden-com-6_869x650.jpg?v=1700543766"}]'
);


INSERT INTO PLANT_FOOD VALUES (
    '2',
    'Exfoilated vermiculite for Gardening and Hydroponics',
    'Exfoilated vermiculite is essential for improving soil structure, retaining moisture, and promoting root growth in gardening and hydroponic systems. It enhances soil aeration and nutrient uptake for healthy plant development.',
    '{"unit":"grams", "value":1000}',
    4.8,
    '[{"MP":"2000", "SP":"1800"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/d5c32d64-84b9-404f-9c92-6ea5bfb9bdfc_869x650.jpg?v=1624949244"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/cdep2248_338x314.png?v=1619250651"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/42806931-8ba5-4e9a-9221-3e8051519519_650x870.jpg?v=1624949248"},{"IMG4":"https://www.chhajedgarden.com/cdn/shop/products/2c504a73-42bb-4906-9953-0b60223760dc_650x870.jpg?v=1624949252"}]'
);


INSERT INTO PLANT_FOOD VALUES (
    '3',
    'Green Garden Food for Plants, 1 kg',
    'Green Garden Food for Plants is a high-quality fertilizer formulated to provide essential nutrients for plant growth and development. It promotes lush foliage, vibrant blooms, and overall plant health.',
    '{"unit":"kg", "value":1}',
    4.7,
    '[{"MP":"2500", "SP":"2000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20200618_121742_652x869.jpg?v=1618551013"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20200618_121814_652x869.jpg?v=1618551017"}]'
);


INSERT INTO PLANT_FOOD VALUES (
    '4',
    'Spagnum Moss',
    'Spagnum Moss is a natural soil amendment that improves moisture retention, promotes root growth, and enhances overall soil structure. It is ideal for use in potting mixes, hanging baskets, and terrariums.',
    '{"unit":"kg", "value":1}',
    4.6,
    '[{"MP":"2200", "SP":"1800"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-02-11at12.07.24PM-Copy-Copy-Copy_869x869.jpg?v=1676106100"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-02-10at2.36.13PM_869x869.jpg?v=1676106076"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-02-10at2.36.11PM_869x869.jpg?v=1676106075"},{"IMG4":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2023-02-10at2.36.11PM_1_652x869.jpg?v=1676106075"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '5',
    'Clay Soil, Pop Balls, Hydroponic Leki balls Small - 2.8 mm size - 20 Liter (Approx-8.2 Kg)',
    'The Clay Soil, Pop Balls, Hydroponic Leki balls are specially designed for hydroponic systems. With a 2.8 mm size, they provide excellent aeration and water retention, promoting healthy root growth and plant development.',
    '{"unit":"liters", "value":20}',
    4.9,
    '[{"MP":"1800", "SP":"1500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/02a70c31-c6b7-4c34-bfed-4920502ff938_650x870.jpg?v=1624949671"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/3b9eb579-bba5-4248-97eb-35b96beb6b64_650x870.jpg?v=1624949673"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/6a55e9fb-1347-4d84-83b0-a350791a593f_650x870.jpg?v=1624949675"},{"IMG4":"https://www.chhajedgarden.com/cdn/shop/products/e0601e57-cc4b-44dc-a55e-8f4e4349fd5e_650x870.jpg?v=1624949678"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '6',
    'Seed Sowing Coco Plugs 50 mm (Pack of 25)',
    'Seed Sowing Coco Plugs are convenient and biodegradable plugs perfect for starting seeds or rooting cuttings. These 50 mm plugs come in a pack of 25, providing ample planting material for your gardening needs.',
    '{"unit":"pieces", "value":25}',
    4.7,
    '[{"MP":"1200", "SP":"1000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_092401_650x869.jpg?v=1618551014"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_092320_650x869.jpg?v=1618551017"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '7',
    '1 Kg Perlite Potting Medium (Premium Horticulture Grade)',
    'Perlite Potting Medium is a lightweight, porous material perfect for improving soil drainage and aeration. This premium horticulture grade perlite promotes healthy root development and overall plant growth.',
    '{"unit":"kg", "value":1}',
    4.8,
    '[{"MP":"1800", "SP":"1500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/1-kg-perlite-potting-medium-premium-horticulture-grade-chhajedgarden-com-1_650x870.jpg?v=1700543199"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/1-kg-perlite-potting-medium-premium-horticulture-grade-chhajedgarden-com-2_869x650.jpg?v=1700542524"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/1-kg-perlite-potting-medium-premium-horticulture-grade-chhajedgarden-com-5_650x870.jpg?v=1700543183"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '8',
    'Pro Neem, 300 GM',
    'Pro Neem is a natural insecticide and fungicide derived from neem seeds. It effectively controls pests and diseases while promoting overall plant health. This 300 GM pack provides ample protection for your garden plants.',
    '{"unit":"grams", "value":300}',
    4.6,
    '[{"MP":"700", "SP":"600"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20200618_122217_652x869.jpg?v=1618551014"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20200618_122230_652x869.jpg?v=1618551017"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '9',
    'Root Star (Humacid-Humic Acid) For Root Growth 100 ml',
    'Root Star is a potent humic acid-based root growth stimulant that enhances nutrient uptake and promotes vigorous root development. This 100 ml bottle provides concentrated formula for optimal results.',
    '{"unit":"ml", "value":100}',
    4.7,
    '[{"MP":"400", "SP":"300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/root_star_humacid-humic_acid_for_root_growth_100_ml_158x227.jpg?v=1697383083"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '10',
    'Plantonic Organic Liquid Fertilizer, 250 ml',
    'Plantonic Organic Liquid Fertilizer is a balanced blend of organic nutrients essential for plant growth and development. This 250 ml bottle provides a convenient and effective way to nourish your plants naturally.',
    '{"unit":"ml", "value":250}',
    4.9,
    '[{"MP":"500", "SP":"400"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091844_650x869.jpg?v=1618551013"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091852_650x869.jpg?v=1618551017"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091914_650x869.jpg?v=1618551020"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '11',
    'Neem Care, 500 ml - Ready to Use Neem Oil Solution (naturally occurring pesticide)',
    'Neem Care is a ready-to-use neem oil solution that acts as a natural pesticide, controlling pests and diseases on your plants. This 500 ml bottle provides convenient and effective protection for your garden plants.',
    '{"unit":"ml", "value":500}',
    4.8,
    '[{"MP":"600", "SP":"500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091506_650x869.jpg?v=1618550936"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091513_650x869.jpg?v=1618550940"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_092047_650x869.jpg?v=1618550944"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '12',
    '5 Kg Perlite Growing Medium for Gardening, Hydroponics Premium Horticulture Grade',
    'Perlite Growing Medium is a lightweight and porous material ideal for gardening and hydroponic systems. This premium horticulture grade perlite improves soil drainage and aeration, promoting healthy plant growth.',
    '{"unit":"kg", "value":5}',
    4.7,
    '[{"MP":"1500", "SP":"1200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/feeb6a14-e443-4662-bd51-7c121d86d1a9_94c697d8-41be-4224-87ef-0d87b7df95d7_869x650.jpg?v=1619513113"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/3a3c3168-cd0c-461f-a13d-e2985301978b_895148a1-67e0-4e92-a07b-f97c8699da41_650x870.jpg?v=1619513115"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/15655376-193e-4fbb-8de8-90ae9015dfbf_464aa43f-fc2c-4ed6-8a28-774c678bcc03_650x870.jpg?v=1619513118"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '13',
    'Chhajed Garden Perlite for Container Gardening Hydroponics - 400 gms',
    'Chhajed Garden Perlite is a lightweight and sterile growing medium perfect for container gardening and hydroponic systems. This 400 gms pack provides ample perlite for your gardening needs.',
    '{"unit":"grams", "value":400}',
    4.8,
    '[{"MP":"800", "SP":"600"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/6138333d-2656-4cda-906e-e923bd93ad4d_755915cb-9411-4a85-a816-e2d2ab596cdf_101x75_crop_center.jpg?v=1624948871"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/3a3c3168-cd0c-461f-a13d-e2985301978b_c9326cd5-fca3-4b1f-b4cf-fd7e844c72a3_57x75_crop_center.jpg?v=1624948873"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/3a38f808-0fb7-471b-98da-4dca16abc787_d6eab2ba-4d46-47d8-8e0c-88f486a00075_57x75_crop_center.jpg?v=1624948875"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '14',
    'G-5 Granules Soil Enricher Patented Product (25gms) - Pack of 5',
    'G-5 Granules Soil Enricher is a patented product designed to enhance soil fertility and promote healthy plant growth. This pack contains 25gms of granules, perfect for enriching your garden soil.',
    '{"unit":"grams", "value":25}',
    4.7,
    '[{"MP":"500", "SP":"400"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/g5_pouch_56x75_crop_center.jpg?v=1697383080"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '15',
    'Plant Shampoo (Insecticidal soap) 100 ml',
    'Plant Shampoo is an insecticidal soap designed to control pests on your plants. This 100 ml bottle provides an effective and environmentally friendly solution for pest management in your garden.',
    '{"unit":"ml", "value":100}',
    4.6,
    '[{"MP":"300", "SP":"250"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/plant_shampoo_i-soap_100ml_77x75_crop_center.jpg?v=1697383087"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '16',
    'Seed Sowing Plugs (Coco Plugs) 25mm',
    'Seed Sowing Plugs (Coco Plugs) are perfect for starting seeds or rooting cuttings. These 25mm plugs provide a convenient and biodegradable planting medium for your gardening needs.',
    '{"unit":"pieces", "value":25}',
    4.7,
    '[{"MP":"400", "SP":"300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Screenshot2021-03-27at6.18.22PM_84x75_crop_center.png?v=1618552246"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/Screenshot2021-03-27at6.18.31PM_80x75_crop_center.png?v=1618552250"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/Screenshot2021-03-27at6.18.40PM_112x75_crop_center.png?v=1618552255"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '17',
    'Nutricote (Controlled Release Product from Japan) (100gm)',
    'Nutricote is a controlled-release fertilizer from Japan designed to provide long-lasting nutrition for your plants. This 100gm pack ensures steady and continuous nutrient supply for optimal plant growth.',
    '{"unit":"grams", "value":100}',
    4.8,
    '[{"MP":"700", "SP":"600"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/f77382ae-ac08-46f6-b3b3-f5dd5bb4c0a5_57x75_crop_center.jpg?v=1618551466"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/b6c6d983-d6a2-4d48-a425-9ef8e97a6af0_2_57x75_crop_center.jpg?v=1618551468"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '18',
    'Orgo Spray, 575 ml for Ornamental Trees, Bushes, Plants and Vines Vegetable Plants Fruiting Trees and Plants',
    'Orgo Spray is a versatile herbal product suitable for various types of plants, including ornamental trees, bushes, vegetables, and fruiting trees. This 575 ml spray bottle effectively kills bugs on contact, ensuring healthy plant growth.',
    '{"unit":"ml", "value":575}',
    4.9,
    '[{"MP":"1100", "SP":"900"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091244_650x869.jpg?v=1618551023"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091251_650x869.jpg?v=1618551027"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091314_650x869.jpg?v=1618551031"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '19',
    'Neem Care 250 ml - Ready to Use Neem Oil Solution (naturally occurring pesticide)',
    'Neem Care is a ready-to-use neem oil solution that acts as a natural pesticide, controlling pests and diseases on your plants. This 250 ml bottle provides convenient and effective protection for your garden plants.',
    '{"unit":"ml", "value":250}',
    4.7,
    '[{"MP":"500", "SP":"400"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091506_650x869.jpg?v=1618550936"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_091513_650x869.jpg?v=1618550940"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210226_092047_650x869.jpg?v=1618550944"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '20',
    'Orgo Care (Organic Soil Conditioner) - 100 gms',
    'Orgo Care is an organic soil conditioner that improves soil structure, enhances nutrient retention, and promotes beneficial microbial activity. This 100 gms pack provides natural nourishment for your plants.',
    '{"unit":"grams", "value":100}',
    4.8,
    '[{"MP":"300", "SP":"250"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/orgo-care-organic-soil-conditioner-100-gms-chhajedgarden-com-1_869x869.jpg?v=1700543727"},{"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/orgo-care-organic-soil-conditioner-100-gms-chhajedgarden-com-2_652x869.jpg?v=1700543751"},{"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/orgo-care-organic-soil-conditioner-100-gms-chhajedgarden-com-3_869x869.jpg?v=1700543755"},{"IMG4":"https://www.chhajedgarden.com/cdn/shop/products/orgo-care-organic-soil-conditioner-100-gms-chhajedgarden-com-6_869x650.jpg?v=1700543766"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '21',
    'Neemastra Neem Oil Based Bio-Pesticide 100ml',
    'Neemastra is a neem oil-based bio-pesticide that effectively controls pests and diseases in your garden. This 100ml bottle provides a natural and eco-friendly solution for pest management.',
    '{"unit":"ml", "value":100}',
    4.9,
    '[{"MP":"350", "SP":"300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/neemastra_neem_oil_based_bio-pesticide_64x75_crop_center.jpg?v=1697383088"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '22',
    'Swa-Urja-P Super Plant Tonic 5 ml',
    'Swa-Urja-P Super Plant Tonic is a potent formula designed to boost plant growth and vitality. This 5 ml tonic provides essential nutrients and energy for healthy and vigorous plants.',
    '{"unit":"ml", "value":5}',
    4.8,
    '[{"MP":"150", "SP":"120"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/swa_urja_2__1_80x75_crop_center.jpg?v=1697383079"}]'
);
INSERT INTO PLANT_FOOD VALUES (
    '23',
    'Bio Green Plant Tonic 100 ml',
    'Bio Green Plant Tonic is a powerful blend of nutrients and bio-stimulants that promote robust plant growth. This 100 ml tonic enhances plant health and vitality, resulting in lush and vibrant foliage.',
    '{"unit":"ml", "value":100}',
    4.9,
    '[{"MP":"300", "SP":"250"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/bio_green_plant_tonic_54x75_crop_center.jpg?v=1697383086"}]'
);

INSERT INTO artificial_plant VALUES (
    '1',
    'Artificial Raphis Graci Palm 24 Leaves - 4 Feet Approx',
    'Add a touch of tropical elegance to your space with this lifelike artificial Raphis Graci Palm. With 24 leaves and standing approximately 4 feet tall, this plant brings lush greenery without the hassle of maintenance.',
    4.8,
    '[{"MP":"20000", "SP":"18000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/RAPHISGRACIPALMPLANT24LVS4FEETApproxB_652x869.jpg?v=1618552983", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/RAPHISGRACIPALMPLANT24LVS4FEETApproxA_568x625.jpg?v=1618552985", "IMG3":"https://www.chhajedgarden.com/cdn/shop/products/RAPHISGRACIPALMPLANT24LVS4FEETApprox_614x872.jpg?v=1618552988"}]',
    '{"height":"4ft"}'
);
INSERT INTO artificial_plant VALUES (
    '2',
    'Artificial Jasmine Plant Topiary Natural Coffee wood Stick - 4 Feet',
    'Bring the charm of a jasmine garden into your home with this lifelike artificial jasmine plant. Standing 4 feet tall, it features a natural coffee wood stick for added authenticity.',
    4.7,
    '[{"MP":"18000", "SP":"16000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/JasminePlantTopieryNaturalCoffeewoodStick4Feet_600x870.png?v=1618552970"}]',
    '{"height":"4ft"}'
);
INSERT INTO artificial_plant VALUES (
    '3',
    'Artificial Bamboo Tree Green Color Stick -5 feet',
    'Enhance your space with the natural beauty of bamboo with this lifelike artificial bamboo tree. Standing 5 feet tall with a realistic green color stick, it brings a touch of nature indoors.',
    4.6,
    '[{"MP":"25000", "SP":"22000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/BambooTreeN.StickGreenColorStick-5FEET_652x869.png?v=1618549846"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '4',
    'Artificial Areca Palm Plant Exotic - 5 feet (Dense Look)',
    'Create a tropical oasis in your home with this exotic artificial Areca palm plant. With a dense, lifelike appearance and standing 5 feet tall, it adds a touch of lush greenery to any space.',
    4.9,
    '[{"MP":"22000", "SP":"20000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/ARECAPALMEXOTIC5FEET_580x870.png?v=1618548203"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '5',
    'Artificial Banana Plant - 5 Feet',
    'Bring the tropical vibes into your home with this lifelike artificial banana plant. Standing 5 feet tall, it features vibrant green foliage and realistic details for an authentic look.',
    4.8,
    '[{"MP":"19000", "SP":"17000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/BANANAPLANT5FEET_652x869.png?v=1618552997"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '6',
    'Artificial Azeliya Plant in Coffee Wood - 4 ft',
    'Add a touch of elegance to your space with this lifelike artificial Azeliya plant. Standing 4 feet tall and nestled in a coffee wood base, it brings beauty and sophistication to any room.',
    4.7,
    '[{"MP":"17000", "SP":"15000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/AZELIYAFLOWERPLANTINCOFFEWOOD4FEET_657x870.jpg?v=1618552960"}]',
    '{"height":"4ft"}'
);
INSERT INTO artificial_plant VALUES (
    '7',
    'Artificial Jasmine Plant Topiary Natural Coffeee wood Plant - 3 Feet',
    'Bring the beauty of a jasmine garden into your home with this lifelike artificial jasmine plant. Standing 3 feet tall and nestled in a natural coffee wood plant, it adds a touch of elegance to any space.',
    4.6,
    '[{"MP":"15000", "SP":"13000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/JasminePlantTopiaryNaturalCoffeeewoodStick3Feet_652x869.png?v=1618549732"}]',
    '{"height":"3ft"}'
);
INSERT INTO artificial_plant VALUES (
    '8',
    'Artificial Jasmine Plant Natural Coffee wood Stick- 4 Feet',
    'Add a touch of natural beauty to your space with this lifelike artificial jasmine plant. Standing 4 feet tall and featuring a natural coffee wood stick, it brings elegance and charm to any room.',
    4.8,
    '[{"MP":"18000", "SP":"16000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/JasminePlantNaturalCoffeewoodStick4Feet_575x870.png?v=1618552972"}]',
    '{"height":"4ft"}'
);
INSERT INTO artificial_plant VALUES (
    '9',
    'Artificial Anthurium in Grey Pot , Height -1.5 ft ( Pack of 6 Plants)',
    'Enhance your indoor decor with this pack of 6 lifelike artificial Anthurium plants. Each plant is nestled in a grey pot and stands approximately 1.5 feet tall, adding a touch of elegance to any space.',
    4.7,
    '[{"MP":"22000", "SP":"20000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG-20200726-WA0009_580x871.jpg?v=1618551711"}]',
    '{"height":"1.5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '10',
    'Artificial Real Touch 48 Dracenna in Pot , Height -3 ft (Pack of 2 Plants)',
    'Bring nature indoors with this pack of 2 lifelike artificial Dracenna plants. Each plant is meticulously crafted for a real touch feel and comes in a pot, standing approximately 3 feet tall.',
    4.9,
    '[{"MP":"28000", "SP":"25000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG-20200726-WA0029_580x871.jpg?v=1618551683"}]',
    '{"height":"3ft"}'
);
INSERT INTO artificial_plant VALUES (
    '11',
    'Artificial 2 Tea Leaf Ball Plant in Pot , Height -4 ft',
    'Add a touch of greenery to your space with this lifelike artificial tea leaf ball plant. Featuring two plants in a pot and standing 4 feet tall, it brings natural beauty without the hassle of maintenance.',
    4.8,
    '[{"MP":"20000", "SP":"18000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/8017_258x592.jpg?v=1616707373"}]',
    '{"height":"4ft"}'
);
INSERT INTO artificial_plant VALUES (
    '12',
    'Artificial Yellow Birch Plant - 5 Feet',
    'Enhance your space with the vibrant beauty of this lifelike artificial yellow birch plant. Standing 5 feet tall, it features realistic foliage and adds a pop of color to any room.',
    4.7,
    '[{"MP":"19000", "SP":"17000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/YELLOWBIRCHPLANT5FEET_552x871.png?v=1618553023"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '13',
    'Artificial Cherry Plant- 5 feet',
    'Bring the beauty of spring into your home all year round with this lifelike artificial cherry plant. Standing 5 feet tall, it features delicate pink blossoms and adds a touch of elegance to any space.',
    4.8,
    '[{"MP":"20000", "SP":"18000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/CHERRYPLANT5FEET_418x640.jpg?v=1618553013", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/CHERRYPLANT5FEETA_388x583.png?v=1618553017"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '14',
    'Artificial Autumn Plant with Natural Stick - 5 feet',
    'Add a touch of autumnal charm to your space with this lifelike artificial autumn plant. Standing 5 feet tall and featuring a natural stick, it brings warmth and coziness to any room.',
    4.6,
    '[{"MP":"18000", "SP":"16000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/AUTUMNPLANTINN.STICK-5FEET_435x640.jpg?v=1618553003"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '15',
    'Artificial Maple Green Plant with Natural Stick - 5 feet',
    'Bring the beauty of nature into your home with this lifelike artificial maple green plant. Standing 5 feet tall and featuring a natural stick, it adds a touch of freshness to any space.',
    4.7,
    '[{"MP":"19000", "SP":"17000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/MapleGreenPlantN.Stick5FEET_416x640.jpg?v=1618553001"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '16',
    'Artificial Maple Orange Plant with Natural Stick - 5 feet',
    'Enhance your space with the vibrant beauty of this lifelike artificial maple orange plant. Standing 5 feet tall and featuring a natural stick, it adds a pop of color to any room.',
    4.8,
    '[{"MP":"20000", "SP":"18000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/MaplePlantOrangeN.Stick5FEET_444x640.jpg?v=1618553005"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '17',
    'Artificial Palm tree with nuts Plant 12 Feet',
    'Create a tropical paradise in your space with this lifelike artificial palm tree. Standing 12 feet tall and featuring realistic nuts, it brings the beauty of nature indoors with ease.',
    4.9,
    '[{"MP":"30000", "SP":"27000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/5_1_53x75_crop_center.png?v=1618548197"}]',
    '{"height":"12ft"}'
);
INSERT INTO artificial_plant VALUES (
    '18',
    'Artificial Banana Tree Real Touch x 3 - 10 Feet',
    'Add a tropical vibe to your space with this lifelike artificial banana tree. Sold in a set of 3, each standing 10 feet tall, they feature a real touch feel for a more authentic look and feel.',
    4.9,
    '[{"MP":"28000", "SP":"25000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/banana_tree_47x75_crop_center.jpg?v=1618549835"}]',
    '{"height":"10ft"}'
);
INSERT INTO artificial_plant VALUES (
    '19',
    'Spiral Peanut Boxwood With Crown in pot, Height - 4 ft (Pack of 2 plants)',
    'Enhance your outdoor decor with this pack of 2 lifelike artificial spiral peanut boxwood plants. Each plant features a crown in a pot and stands approximately 4 feet tall, adding elegance to any garden.',
    4.8,
    '[{"MP":"25000", "SP":"22000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG-20200726-WA0017_50x75_crop_center.jpg?v=1618551718"}]',
    '{"height":"4ft"}'
);
INSERT INTO artificial_plant VALUES (
    '20',
    'Artificial Blossom Flower Plant in Coffee Wood Pink - 6 feet',
    'Add a pop of color to your space with this lifelike artificial blossom flower plant. Standing 6 feet tall and nestled in a coffee wood base, it brings beauty and vibrancy to any room.',
    4.7,
    '[{"MP":"22000", "SP":"20000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/BLOSSOMFLOWERPLANTINCOFFEWOODPINK-6FEET_50x75_crop_center.jpg?v=1618553064"}]',
    '{"height":"6ft"}'
);
INSERT INTO artificial_plant VALUES (
    '21',
    'Artificial Mini Varigated Ficus Real Touch in Coffee wood - 5 feet',
    'Bring the beauty of nature into your home with this lifelike artificial mini variegated ficus plant. Standing 5 feet tall and featuring real touch foliage, it adds a touch of elegance to any space.',
    4.8,
    '[{"MP":"20000", "SP":"18000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/MINIV_50x75_crop_center.png?v=1618549867"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '22',
    'Artificial Varigated Ficus Double Topiary in Coffee Wood-2 X 1 -5 feet',
    'Add a touch of sophistication to your space with this lifelike artificial variegated ficus double topiary. Standing 5 feet tall and featuring a double topiary design, it brings elegance and charm to any room.',
    4.7,
    '[{"MP":"19000", "SP":"17000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/FicusDoubleToperyPlantinCoffewood-2X1-5FEET_57x75_crop_center.png?v=1618549852"}]',
    '{"height":"5ft"}'
);
INSERT INTO artificial_plant VALUES (
    '23',
    'Artificial Maple Red Tree in Coffee Wood with Branches - 4 Feet',
    'Bring the beauty of autumn into your home with this lifelike artificial maple red tree. Standing 4 feet tall and featuring branches, it adds warmth and coziness to any space.',
    4.6,
    '[{"MP":"18000", "SP":"16000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/MAPLETREEINCOFFEEWOODWITHBRANCHS4FEET_54x75_crop_center.jpg?v=1618552984"}]',
    '{"height":"4ft"}'
);
INSERT INTO artificial_plant VALUES (
    '24',
    'Artificial Pink Camelia Flower Plant - 6 feet',
    'Add a touch of elegance to your space with this lifelike artificial pink camellia flower plant. Standing 6 feet tall, it features delicate pink blossoms and adds beauty to any room.',
    4.8,
    '[{"MP":"22000", "SP":"20000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PINKCAMELIAFLOWERPLANT6FEET_57x75_crop_center.png?v=1618553057"}]',
    '{"height":"6ft"}'
);

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('1', 'Pot Holding Tray Thermoformed (6 Holes)', 'This thermoformed pot holding tray has six holes for holding pots. It is durable and suitable for gardening purposes.', '{"Length":"50 cm", "Width":"30 cm", "Height":"5 cm"}', 4.5, '[{"MP":"500", "SP":"400"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210502_152518_870x585.jpg?v=1621403090"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('2', 'Seedling Tray Square 128 Cells (Pack of 12)', 'This pack includes 12 square seedling trays, each with 128 cells for planting seeds. Ideal for starting seedlings indoors.', '{"Length":"20 cm", "Width":"20 cm", "Height":"5 cm"}', 4.2, '[{"MP":"1000", "SP":"800"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210502_152203_141x75_crop_center.jpg?v=1621403090"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210502_152155_157x75_crop_center.jpg?v=1621403092"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('3', 'Stacking Pots Black, Vertical Flower Tower Pots', 'These black stacking pots create a vertical flower tower, maximizing space for planting flowers or herbs. Sturdy construction ensures durability.', '{"Length":"40 cm", "Width":"40 cm", "Height":"100 cm"}', 4.8, '[{"MP":"1500", "SP":"1200"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/blackstacking_65x75_crop_center.jpg?v=1621403073"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210430_160630_57x75_crop_center.jpg?v=1621403076"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210430_160633_57x75_crop_center.jpg?v=1621403079"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('4', 'Medium Grape Wine Round Ceramic Plant Pot with Bottom Tray - Premium Quality and Drainage Hole', 'This premium quality medium-sized ceramic plant pot features a grape wine design and comes with a bottom tray. It has a drainage hole for proper water drainage.', '{"Diameter":"30 cm", "Height":"25 cm"}', 4.7, '[{"MP":"2000", "SP":"1600"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Medium_14_57x75_crop_center.jpg?v=1619513503"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/Medium_13_57x75_crop_center.jpg?v=1619513508"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/Medium_15_57x75_crop_center.jpg?v=1619513513"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('5', 'Round Pond', 'This round pond is ideal for creating a small water feature in your garden or outdoor space. Made of durable materials, it adds a touch of elegance to any setting.', '{"Diameter":"60 cm", "Depth":"30 cm"}', 4.6, '[{"MP":"1200", "SP":"900"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/RoundPond_113x75_crop_center.jpg?v=1618551922"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('6', 'Elliptical Pond 65 Liters', 'This elliptical pond has a capacity of 65 liters, making it suitable for small aquatic plants or fish. Its unique shape adds visual interest to any outdoor space.', '{"Length":"100 cm", "Width":"50 cm", "Depth":"40 cm"}', 4.5, '[{"MP":"2500", "SP":"2000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/65_1557b105-5e80-41eb-a0a5-a406d27525af_122x75_crop_center.jpg?v=1618551918"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('7', 'Spotted Granite Small Sphere', 'This small sphere planter features a spotted granite design, adding a touch of elegance to your garden or indoor space. Its compact size makes it ideal for small plants or succulents.', '{"Diameter":"30 cm"}', 4.8, '[{"MP":"800", "SP":"600"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/SphereSmallDecorated_113x75_crop_center.jpg?v=1618551911"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('8', 'Pond Waterfall Fiber Planter', 'This pond waterfall planter adds a decorative touch to your outdoor pond or garden. Its cascading design creates a soothing water feature while providing a habitat for aquatic plants.', '{"Dimensions":"80 cm x 50 cm x 40 cm"}', 4.7, '[{"MP":"3000", "SP":"2500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PondWaterfall_49x75_crop_center.jpg?v=1618551877"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('9', 'Fiora Fiber Planter', 'The Fiora fiber planter is a stylish addition to any garden or outdoor space. Its modern design and durable construction make it ideal for showcasing your favorite plants or flowers.', '{"Dimensions":"60 cm x 40 cm x 30 cm"}', 4.6, '[{"MP":"1800", "SP":"1500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Fiora_57x75_crop_center.png?v=1618551875"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/21_99x75_crop_center.jpg?v=1618551879"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('10', 'Phonixo Junior Fiber Planter', 'The Phonixo Junior fiber planter is perfect for small plants or herbs. Its compact size makes it suitable for balconies, patios, or indoor spaces.', '{"Dimensions":"40 cm x 30 cm x 25 cm"}', 4.2, '[{"MP":"1200", "SP":"1000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Phonixo_Junior_80x75_crop_center.png?v=1618551867"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('11', 'Phonixo Senior Fiber Planter', 'The Phonixo Senior fiber planter is suitable for larger plants or shrubs. Its sturdy construction and spacious design make it perfect for outdoor gardens or landscaping projects.', '{"Dimensions":"60 cm x 40 cm x 35 cm"}', 4.4, '[{"MP":"2000", "SP":"1600"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Phonixo_Senior_68x75_crop_center.png?v=1618551868"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('12', 'Titanic Smooth Finish Fiber Planter', 'The Titanic smooth finish fiber planter features a classic design with a smooth surface. Its large size makes it ideal for planting trees or large bushes.', '{"Dimensions":"80 cm x 60 cm x 50 cm"}', 4.6, '[{"MP":"3000", "SP":"2500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/TitanicSmooth_105x75_crop_center.jpg?v=1618551868"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('13', 'Wood Point Fiber Planter', 'The Wood Point fiber planter features a natural wood-like texture, adding rustic charm to your garden or outdoor space. Its versatile design complements a variety of plant styles.', '{"Dimensions":"50 cm x 40 cm x 30 cm"}', 4.3, '[{"MP":"1500", "SP":"1200"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WoodPoint_113x75_crop_center.jpg?v=1618551869"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('14', 'Exquisite Fiber Planter', 'The Exquisite fiber planter boasts an elegant design with intricate details, perfect for adding a touch of sophistication to any garden or outdoor area. Its durable construction ensures long-lasting beauty.', '{"Dimensions":"60 cm x 50 cm x 40 cm"}', 4.5, '[{"MP":"2500", "SP":"2000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Exquisite_37x75_crop_center.jpg?v=1618551868"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('15', 'Wooden Truogh Fiber Planter', 'The Wooden Trough fiber planter features a rustic trough design, perfect for showcasing your favorite flowers or herbs. Its weather-resistant construction makes it suitable for both indoor and outdoor use.', '{"Dimensions":"70 cm x 30 cm x 25 cm"}', 4.4, '[{"MP":"1800", "SP":"1500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WoodenTrough_125x75_crop_center.jpg?v=1618551868"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('16', 'Phoenix Bowl URN Fiber Planter', 'The Phoenix Bowl URN fiber planter features a classic urn shape with a modern twist. Its sleek design and spacious interior make it perfect for planting large flowers or small trees.', '{"Dimensions":"90 cm x 70 cm x 60 cm"}', 4.7, '[{"MP":"3500", "SP":"3000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PhoenixBowlURN_117x75_crop_center.jpg?v=1618551858"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('17', 'Small Pebble Fiber Planter', 'The Small Pebble fiber planter features a textured pebble design, adding visual interest to your garden or patio. Its compact size makes it ideal for small plants or succulents.', '{"Dimensions":"30 cm x 20 cm x 15 cm"}', 4.0, '[{"MP":"800", "SP":"600"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/PebbleSmall_79x75_crop_center.jpg?v=1618551845"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('18', 'Marvel White Fiber Planter', 'The Marvel White fiber planter features a sleek and modern design, perfect for contemporary outdoor spaces. Its glossy finish adds a touch of elegance to any garden or patio setting.', '{"Dimensions":"40 cm x 30 cm x 25 cm"}', 4.3, '[{"MP":"1200", "SP":"900"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Marvel_93x75_crop_center.png?v=1618551844"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('19', 'Flora Big Fiber Planter', 'The Flora Big fiber planter offers ample space for planting a variety of flowers or shrubs. Its sturdy construction and classic design make it a timeless addition to any garden or outdoor space.', '{"Dimensions":"50 cm x 40 cm x 35 cm"}', 4.6, '[{"MP":"1800", "SP":"1500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/FloraBig_176x75_crop_center.jpg?v=1618551846"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('20', 'Yula Matt Brown Fiber Planter', 'The Yula Matt Brown fiber planter features a rustic matte finish, adding warmth and character to any outdoor space. Its versatile design makes it suitable for a variety of plants and decorative arrangements.', '{"Dimensions":"60 cm x 50 cm x 45 cm"}', 4.4, '[{"MP":"2000", "SP":"1700"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Yula_113x75_crop_center.jpg?v=1618551803"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('21', 'Stone Wave Stiff Fiber Planter', 'The Stone Wave Stiff fiber planter features a unique textured surface resembling natural stone. Its durable construction and weather-resistant design make it suitable for outdoor use in any climate.', '{"Dimensions":"70 cm x 60 cm x 50 cm"}', 4.2, '[{"MP":"1500", "SP":"1200"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/StoneWaveStiff_113x75_crop_center.jpg?v=1618551792"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('22', 'Aster Round Fiber Planter', 'The Aster Round fiber planter features a simple yet elegant design, perfect for showcasing your favorite flowers or greenery. Its round shape and versatile size make it suitable for both indoor and outdoor use.', '{"Dimensions":"45 cm x 40 cm x 35 cm"}', 4.3, '[{"MP":"1300", "SP":"1000"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/AsterRoundFiberPlanter_133x75_crop_center.jpg?v=1618551748"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('23', 'Flower Pot Black Colour Sunrise Series', 'The Flower Pot Black Color Sunrise Series features a sleek and modern design, perfect for contemporary outdoor spaces. Its durable construction and drainage hole ensure healthy plant growth.', '{"Dimensions":"14 cm x 14 cm x 11 cm"}', 4.5, '[{"MP":"500", "SP":"400"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/14.5CmBlack_4_9ece763c-7660-408b-9246-f57996c2527e_75x75_crop_center.jpg?v=1641446543"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/me2744e2519_3_3_69x75_crop_center.jpg?v=1641446543"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/14.5CmBlack_3_a7af666a-2bba-4d71-bec7-129c9ef81d77_75x75_crop_center.jpg?v=1641446543"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('24', 'Hypoestes Fiber Planter', 'The Hypoestes fiber planter features a vibrant and colorful design, perfect for adding a pop of color to any garden or outdoor space. Its sturdy construction and drainage hole ensure healthy plant growth.', '{"Dimensions":"30 cm x 25 cm x 20 cm"}', 4.1, '[{"MP":"700", "SP":"500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/lavina_61x75_crop_center.jpg?v=1618550121"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('25', 'Anemone Square Fiber Planter', 'The Anemone Square fiber planter features a modern and stylish design, perfect for contemporary outdoor spaces. Its square shape and versatile size make it suitable for a variety of plants and decorative arrangements.', '{"Dimensions":"40 cm x 30 cm x 25 cm"}', 4.4, '[{"MP":"900", "SP":"700"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/AnemoneSquareFiberPlanter_133x75_crop_center.jpg?v=1618550090"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('26', 'Daffodil Round Fiber Planter', 'The Daffodil Round fiber planter features a classic and timeless design, perfect for traditional outdoor settings. Its round shape and sturdy construction make it suitable for a variety of plants and decorative arrangements.', '{"Dimensions":"45 cm x 40 cm x 35 cm"}', 4.3, '[{"MP":"1000", "SP":"800"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/DaffodilRoundFiberPlanter_133x75_crop_center.jpg?v=1618550084"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('27', 'Seedling Tray Round 40 Cells (Disposal) (Pack of 12)', 'The Seedling Tray Round 40 Cells is perfect for starting seeds or propagating cuttings. This pack includes 12 trays, each with 40 individual cells for growing healthy seedlings.', '{"Dimensions":"60 cm x 40 cm x 5 cm"}', 4.2, '[{"MP":"300", "SP":"250"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/2_4_1_57x75_crop_center.jpg?v=1618549660"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('28', 'Seedling Tray Round 104 Cells (Disposal) (Pack of 12)', 'The Seedling Tray Round 104 Cells is perfect for starting seeds or propagating cuttings. This pack includes 12 trays, each with 104 individual cells for growing healthy seedlings.', '{"Dimensions":"60 cm x 40 cm x 5 cm"}', 4.5, '[{"MP":"400", "SP":"350"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/1_8_12_100x75_crop_center.jpg?v=1618549660"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('29', 'Square Fiber Planter', 'The Square fiber planter features a modern and minimalist design, perfect for contemporary outdoor spaces. Its square shape and clean lines make it a versatile choice for a variety of plants and decorative arrangements.', '{"Dimensions":"50 cm x 50 cm x 40 cm"}', 4.3, '[{"MP":"1500", "SP":"1200"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/purva-fiber-catalog-and-pricelist-343_70x75_crop_center.jpg?v=1618548386"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('30', 'Juhi Oval Fiber Planter', 'The Juhi Oval fiber planter features an elegant and sophisticated design, perfect for adding a touch of luxury to any garden or outdoor space. Its oval shape and textured surface make it a stylish choice for showcasing your favorite plants.', '{"Dimensions":"60 cm x 40 cm x 30 cm"}', 4.4, '[{"MP":"1800", "SP":"1500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/oval_rib_123x75_crop_center.jpg?v=1618550082"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('31', 'Black Vertical Hook Pot', 'The Black Vertical Hook Pot features a sleek and modern design, perfect for hanging plants or creating vertical gardens. Its versatile size and sturdy construction make it suitable for both indoor and outdoor use.', '{"Dimensions":"20 cm x 20 cm x 20 cm"}', 4.6, '[{"MP":"800", "SP":"600"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/black_hook_pot_3_34ffecfd-2168-4350-a078-f990a7c07d14_792x871.jpg?v=1618551166"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/black1_1_1f7f4f78-1cc8-4122-86f5-726bb55b351f_792x871.jpg?v=1618551169"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/black2_1_b97b3e99-b9bb-4150-92d1-2a8ba8a50597_792x871.jpg?v=1618551170"}, {"IMG4":"https://www.chhajedgarden.com/cdn/shop/products/black3_1_6932ba4f-8c7b-4686-ac1e-9faf98d06db5_792x871.jpg?v=1618551172"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('32', '4.5" Flower Pot White Colour Sunrise Series (11 cm)', 'The 4.5" Flower Pot White Colour Sunrise Series features a classic and elegant design, perfect for showcasing your favorite flowers or plants. Its durable construction and glossy finish make it a stylish addition to any garden or outdoor space.', '{"Dimensions":"11 cm x 11 cm x 9 cm"}', 4.7, '[{"MP":"600", "SP":"500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2022-01-04at11.11.30AM_1_44cc88b0-877c-4c6a-b5af-095994329839_869x869.jpg?v=1641276449"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2022-01-04at11.11.30AM_8e476580-05b6-4d83-b3c8-79dfa58a852a_869x869.jpg?v=1641276477"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/sunrise_pot_white_1_792x871.jpg?v=1641276418"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('33', 'Terracotta Vertical Hook Pot', 'The Terracotta Vertical Hook Pot features a rustic and natural design, perfect for adding a touch of warmth to any outdoor space. Its vertical orientation and sturdy construction make it suitable for hanging plants or creating vertical gardens.', '{"Dimensions":"30 cm x 20 cm x 20 cm"}', 4.3, '[{"MP":"700", "SP":"550"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/18_1_2_8197ff85-6bd7-4cae-be5c-5692b6270634_849x870.jpg?v=1618551300"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/18_2_2_e8ee536f-5aeb-482d-97b4-5ba83f101902_685x870.jpg?v=1618551305"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/18_5_1_18b6aa43-771b-441a-9016-a8ce383433b7_840x869.jpg?v=1618551310"}, {"IMG4":"https://www.chhajedgarden.com/cdn/shop/products/18_4_1_d94c2026-b673-4ea2-a917-11dfb5583bed_694x871.jpg?v=1618551315"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('34', 'Violet Vertical Hook Pot', 'The Violet Vertical Hook Pot features a vibrant and colorful design, perfect for adding a pop of color to any outdoor space. Its vertical orientation and sturdy construction make it suitable for hanging plants or creating vertical gardens.', '{"Dimensions":"25 cm x 15 cm x 15 cm"}', 4.5, '[{"MP":"750", "SP":"600"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/violet_hook_pot_3_69fb9b36-a30e-4155-9583-f224132ab7e2_792x871.jpg?v=1618551184"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/voilet_2_15a06880-37e9-4e9c-bc7c-6a6c37b448ff_69x75_crop_center.jpg?v=1618551189"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/voilet_3_311f4ea7-60e9-4511-abaa-205a38b5cbec_69x75_crop_center.jpg?v=1618551194"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('35', '14 cm White Paris Square Pot', 'The 14 cm White Paris Square Pot features a modern and stylish design, perfect for showcasing your favorite plants or flowers. Its square shape and glossy finish make it a versatile choice for both indoor and outdoor use.', '{"Dimensions":"14 cm x 14 cm x 12 cm"}', 4.6, '[{"MP":"400", "SP":"300"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/Product_-MNHWSJ31o12daVayQhP_75x75_crop_center.jpg?v=1641705508"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/Product_-MNHe9ZQRamadBZEUhdk_75x75_crop_center.jpg?v=1641705523"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/Product_-MNHe9ZZtczZZof_5GyL_75x75_crop_center.jpg?v=1641705536"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('36', '4.5" Flower Pot Terracotta Colour Sunrise Series (11 cm)', 'The 4.5" Flower Pot Terracotta Colour Sunrise Series features a classic and timeless design, perfect for adding a rustic touch to any garden or outdoor space. Its durable construction and earthy tone make it a versatile choice for showcasing your favorite flowers or plants.', '{"Dimensions":"11 cm x 11 cm x 9 cm"}', 4.5, '[{"MP":"500", "SP":"400"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2022-01-04at11.11.28AM_75x75_crop_center.jpg?v=1641276816"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/2_1b6e6762-73d9-48a2-a81f-055c4a9afba5_69x75_crop_center.png?v=1641276816"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/WhatsAppImage2022-01-04at11.11.27AM_75x75_crop_center.jpg?v=1641276816"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('37', 'Red Vertical Hook Pot', 'The Red Vertical Hook Pot features a bold and striking design, perfect for adding a pop of color to any outdoor space. Its vertical orientation and sturdy construction make it suitable for hanging plants or creating vertical gardens.', '{"Dimensions":"25 cm x 15 cm x 15 cm"}', 4.4, '[{"MP":"650", "SP":"500"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/red_hook_pot_3_f86b12a3-d7b8-4447-8cac-26e7ce4a9bd8_69x75_crop_center.jpg?v=1618551165"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/red4_a6b32635-af40-4c5c-8b97-fdaab82a5285_69x75_crop_center.jpg?v=1618551174"}, {"IMG3":"https://www.chhajedgarden.com/cdn/shop/products/red1_e0b61bc5-7d25-41e6-b670-0bc1f064b130_69x75_crop_center.jpg?v=1618551170"}]');

INSERT INTO PLASTIC_POTS (PPOID, PPOTITLE, PPODESCRIPTION, PPODIMENSION, PPO_RATING, PPOPRICE, PPO_STOCK_AVAILABILITY, PPOIMAGES) 
VALUES ('38', '5.5" Vertical Hook Pot Terracotta Color', 'The 5.5" Vertical Hook Pot in Terracotta Color features a classic design with a rustic twist, perfect for adding warmth and charm to any outdoor space. Its vertical orientation and sturdy construction make it suitable for hanging plants or creating vertical gardens.', '{"Dimensions":"14 cm x 14 cm x 13 cm"}', 4.3, '[{"MP":"800", "SP":"600"}]', 1, '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/hqdefault_1ff90624-0f76-4614-891a-cbbadf6b9c53_394x295.jpg?v=1619593572"}, {"IMG2":"https://www.chhajedgarden.com/cdn/shop/products/teracotta_hook_pot_1_83x75_crop_center.jpg?v=1616707610"}]');


-- Entry 1
INSERT INTO Pump_Spray VALUES (
    '1',
    'Hand Sprayer C305 - 1.2 Litre',
    'High-quality hand sprayer with a capacity of 1.2 liters. Ideal for various gardening applications. Durable and easy to use.',
    4.5,
    '[{"MP":"1200", "SP":"1000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/1.2_56x75_crop_center.jpg?v=1629542110"}]',
    '{"Capacity": "1.2 Litres", "Material": "High-quality plastic", "Nozzle": "Adjustable brass nozzle"}'
);

-- Entry 2
INSERT INTO Pump_Spray VALUES (
    '2',
    'Water Sprinkling Can 1.5L (Color May Vary)',
    'Colorful water sprinkling can with a capacity of 1.5 liters. Perfect for watering your plants with style. Color may vary.',
    4.2,
    '[{"MP":"800", "SP":"600"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/WaterSprinklingCan1.5L_ColorMayVary_63x75_crop_center.jpg?v=1618551930", "IMG2":"https://www.chhajedgarden.com/cdn/shop/products/WaterSprinklingCan1.5L_ColorMayVary_1_63x75_crop_center.png?v=1618551933"}]',
    '{"Capacity": "1.5 Litres", "Material": "Durable plastic", "Color": "May vary"}'
);

-- Continue with entries 3 to 20 following the same format
-- ...

-- Entry 3
INSERT INTO Pump_Spray VALUES (
    '3',
    'Watering Can W4038, 1.5 Liter',
    'Premium quality watering can with a capacity of 1.5 liters. Perfect for precise and efficient watering in your garden.',
    4.0,
    '[{"MP":"550", "SP":"450"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210301_150333_57x75_crop_center.jpg?v=1618551726"}]',
    '{"Capacity": "1.5 Litres", "Material": "Premium plastic", "Design": "Efficient and user-friendly"}'
);

-- Entry 4
INSERT INTO Pump_Spray VALUES (
    '4',
    'Hand Sprayer M680, 500 ml with Brass Nozzle',
    'Compact hand sprayer with a 500 ml capacity. Features a durable brass nozzle for precise spraying. Ideal for small gardening tasks.',
    4.3,
    '[{"MP":"380", "SP":"300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210301_092618_57x75_crop_center.jpg?v=1618551069"}]',
    '{"Capacity": "500 ml", "Nozzle": "Brass nozzle", "Compact Design": "Easy to handle"}'
);

-- Continue with entries 5 to 20 following the same format
-- ...
-- Entry 5
INSERT INTO Pump_Spray VALUES (
    '5',
    'Hand Sprayer A-4, 250 ml',
    'Compact and efficient hand sprayer with a capacity of 250 ml. Perfect for indoor plants and small gardening tasks.',
    4.1,
    '[{"MP":"280", "SP":"200"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210301_112020_54x75_crop_center.jpg?v=1618551067"}]',
    '{"Capacity": "250 ml", "Design": "Compact and efficient", "Suitable for": "Indoor plants"}'
);

-- Entry 6
INSERT INTO Pump_Spray VALUES (
    '6',
    'Hand Sprayer X11-2, 2 Liter',
    'Large capacity hand sprayer with 2 liters. X11-2 model with a comfortable grip and adjustable nozzle. Suitable for various applications.',
    4.4,
    '[{"MP":"780", "SP":"650"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/CAPPLX11-2_2Liter_-MAVMxVA-DpwdFGZL7Pi_57x75_crop_center.jpg?v=1618551069"}]',
    '{"Capacity": "2 Liters", "Nozzle": "Adjustable", "Comfortable grip": "Yes"}'
);

-- Entry 7
INSERT INTO Pump_Spray VALUES (
    '7',
    'Sprayers for Agriculture Use Hand Operated 2L (Color May Vary)',
    'Hand-operated sprayers designed for agricultural use with a 2-liter capacity. Colors may vary. Ideal for crop protection and fertilization.',
    3.9,
    '[{"MP":"580", "SP":"500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/a9020_58x75_crop_center.jpg?v=1618550685"}]',
    '{"Capacity": "2 Liters", "Use": "Agricultural", "Color": "May vary"}'
);

-- Entry 8
INSERT INTO Pump_Spray VALUES (
    '8',
    'Sprayers for Agriculture Use Hand Operated 16L (Color May Vary)',
    'Hand-operated sprayers with a large 16-liter capacity, suitable for agricultural use. Colors may vary. Efficient and easy to use.',
    4.2,
    '[{"MP":"1100", "SP":"900"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/kn16a_54x75_crop_center.jpg?v=1618550684"}]',
    '{"Capacity": "16 Liters", "Use": "Agricultural", "Color": "May vary"}'
);

-- Entry 9
INSERT INTO Pump_Spray VALUES (
    '9',
    'Water Sprinkling Can 6L (Color May Vary)',
    'Large 6-liter water sprinkling can with a colorful design. Perfect for watering your garden or plants. Colors may vary.',
    4.1,
    '[{"MP":"850", "SP":"700"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/w5060_109x75_crop_center.jpg?v=1618550668"}]',
    '{"Capacity": "6 Liters", "Material": "Durable plastic", "Color": "May vary"}'
);

-- Entry 10
INSERT INTO Pump_Spray VALUES (
    '10',
    'Sprayers for Agriculture Use Hand Operated 5L (Color May Vary)',
    'Hand-operated sprayers designed for agricultural use with a 5-liter capacity. Colors may vary. Suitable for crop protection and fertilization.',
    4.0,
    '[{"MP":"900", "SP":"750"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/sh5f_48x75_crop_center.jpg?v=1618550685"}]',
    '{"Capacity": "5 Liters", "Use": "Agricultural", "Color": "May vary"}'
);

-- Entry 11
INSERT INTO Pump_Spray VALUES (
    '11',
    'Li-on Battery Sprayer T-1203 - 2 Liter',
    'Battery-operated sprayer with a 2-liter capacity. T-1203 model with a rechargeable Li-on battery. Suitable for various spraying applications.',
    4.3,
    '[{"MP":"1200", "SP":"1000"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/t_-_1203_54x75_crop_center.png?v=1618548091"}]',
    '{"Capacity": "2 Liters", "Power": "Li-on Battery", "Model": "T-1203"}'
);

-- Entry 12
INSERT INTO Pump_Spray VALUES (
    '12',
    'Hand Sprayer Q601 - 1800 ml',
    'Q601 model hand sprayer with a capacity of 1800 ml. Durable and efficient for various gardening tasks. Easy to handle and use.',
    4.2,
    '[{"MP":"950", "SP":"800"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/601_56x75_crop_center.png?v=1618548070"}]',
    '{"Capacity": "1800 ml", "Model": "Q601", "Durable": "Yes"}'
);

-- Entry 13
INSERT INTO Pump_Spray VALUES (
    '13',
    'Hand Sprayer L-703 - 2000 ml (2 Liter)',
    'Large capacity hand sprayer L-703 model with 2000 ml. Suitable for various applications. Easy to carry and use.',
    4.4,
    '[{"MP":"1100", "SP":"900"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/l_703_50x75_crop_center.png?v=1618548070"}]',
    '{"Capacity": "2000 ml", "Model": "L-703", "Easy to carry": "Yes"}'
);

-- Entry 14
INSERT INTO Pump_Spray VALUES (
    '14',
    'Hand Sprayer G102 - 1.8 Litre',
    'G102 model hand sprayer with a capacity of 1.8 liters. Ideal for various gardening tasks. Durable and efficient design.',
    4.3,
    '[{"MP":"980", "SP":"850"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/g-102_75x75_crop_center.jpg?v=1618548081"}]',
    '{"Capacity": "1.8 Liters", "Model": "G102", "Efficient design": "Yes"}'
);

-- Entry 15
INSERT INTO Pump_Spray VALUES (
    '15',
    'Hand Sprayer - C307 - 1 Litre',
    'Compact hand sprayer C307 model with a capacity of 1 liter. Suitable for small gardening tasks and indoor plants.',
    4.1,
    '[{"MP":"650", "SP":"500"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/c-307_75x75_crop_center.jpg?v=1618548058"}]',
    '{"Capacity": "1 Liter", "Model": "C307", "Compact": "Yes"}'
);

-- Entry 16
INSERT INTO Pump_Spray VALUES (
    '16',
    '1000 ml Finger Trigger Sprayer',
    'Finger trigger sprayer with a 1000 ml capacity. Easy to use and suitable for various spraying applications.',
    3.8,
    '[{"MP":"750", "SP":"600"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210301_175702_50x75_crop_center.jpg?v=1616707290"}]',
    '{"Capacity": "1000 ml", "Trigger type": "Finger trigger"}'
);

-- Entry 17
INSERT INTO Pump_Spray VALUES (
    '17',
    'Industrial Grade Hand Sprayer A10, 750 ml for Acids, Base and Industrial Solvents',
    'Industrial-grade hand sprayer A10 model with a capacity of 750 ml. Suitable for acids, bases, and industrial solvents.',
    4.5,
    '[{"MP":"900", "SP":"750"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/A-10_100x75_crop_center.jpg?v=1618551025"}]',
    '{"Capacity": "750 ml", "Industrial grade": "Yes", "Suitable for": "Acids, bases, solvents"}'
);

-- Entry 18
INSERT INTO Pump_Spray VALUES (
    '18',
    'Hand Sprayer Q602 - 1.5 Litres',
    'Q602 model hand sprayer with a capacity of 1.5 liters. Durable and efficient design. Suitable for various gardening tasks.',
    4.2,
    '[{"MP":"850", "SP":"700"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/123_8154f4fe-e569-423d-a44e-4e58442591d5_57x75_crop_center.jpg?v=1626066001"}]',
    '{"Capacity": "1.5 Liters", "Model": "Q602", "Efficient design": "Yes"}'
);

-- Entry 19
INSERT INTO Pump_Spray VALUES (
    '19',
    'Hand Sprayer M680, 500 ml with Brass Nozzle',
    'Compact hand sprayer M680 model with a 500 ml capacity. Features a durable brass nozzle for precise spraying. Ideal for small gardening tasks.',
    4.3,
    '[{"MP":"380", "SP":"300"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210301_092618_57x75_crop_center.jpg?v=1618551069"}]',
    '{"Capacity": "500 ml", "Nozzle": "Brass nozzle", "Compact Design": "Easy to handle"}'
);

-- Entry 20
INSERT INTO Pump_Spray VALUES (
    '20',
    'Trigger Sprayer A-13, 500 ml',
    'A-13 model trigger sprayer with a 500 ml capacity. Easy to use and suitable for various spraying applications.',
    4.0,
    '[{"MP":"420", "SP":"350"}]',
    1,
    '[{"IMG1":"https://www.chhajedgarden.com/cdn/shop/products/IMG_20210301_092404_57x75_crop_center.jpg?v=1618548061"}]',
    '{"Capacity": "500 ml", "Trigger type": "A-13 model"}'
);

use agri_connect;
ALTER TABLE plants
ADD COLUMN Quantity INT DEFAULT 1;

ALTER TABLE pot_planters
ADD COLUMN Quantity INT DEFAULT 1;

ALTER TABLE artificial_plant
ADD COLUMN Quantity INT DEFAULT 1;

ALTER TABLE plastic_pots
ADD COLUMN Quantity INT DEFAULT 1;

ALTER TABLE pump_spray
ADD COLUMN Quantity INT DEFAULT 1;

ALTER TABLE seed_bulb
ADD COLUMN Quantity INT DEFAULT 1;

ALTER TABLE pebbles_and_stones
ADD COLUMN Quantity INT DEFAULT 1;

ALTER TABLE plant_food
ADD COLUMN Quantity INT DEFAULT 1;




use agri_connect;


drop function if exists GetTableName
DELIMITER $$

CREATE FUNCTION GetTableName(input_string VARCHAR(255))
RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    DECLARE table_list VARCHAR(255);
    
    SET table_list = '';
    
    IF EXISTS (SELECT 1 FROM artificial_plant WHERE aptitle = input_string) THEN
        SET table_list = CONCAT(table_list, 'artificial_plant,');
    END IF;
    
    IF EXISTS (SELECT 1 FROM pebbles_and_stones WHERE pastitle = input_string) THEN
        SET table_list = CONCAT(table_list, 'pebbles_and_stones,');
    END IF;
    
    IF EXISTS (SELECT 1 FROM plant_food WHERE pftitle = input_string) THEN
        SET table_list = CONCAT(table_list, 'plant_food,');
    END IF;
    
    IF EXISTS (SELECT 1 FROM plants WHERE ptitle = input_string) THEN
        SET table_list = CONCAT(table_list, 'plants,');
    END IF;
    
    IF EXISTS (SELECT 1 FROM plastic_pots WHERE ppotitle = input_string) THEN
        SET table_list = CONCAT(table_list, 'plastic_pots,');
    END IF;
    
    IF EXISTS (SELECT 1 FROM pot_planters WHERE pptitle = input_string) THEN
        SET table_list = CONCAT(table_list, 'pot_planters,');
    END IF;
    
    IF EXISTS (SELECT 1 FROM pump_spray WHERE pstitle = input_string) THEN
        SET table_list = CONCAT(table_list, 'pump_spray,');
    END IF;
    
    IF EXISTS (SELECT 1 FROM seed_bulb WHERE sbtitle = input_string) THEN
        SET table_list = CONCAT(table_list, 'seed_bulb,');
    END IF;
    
    IF LENGTH(table_list) > 0 THEN
        SET result = SUBSTRING(table_list, 1, LENGTH(table_list) - 1); -- Remove the last comma
    ELSE
        SET result = 'No match found';
    END IF;
    
    RETURN result;
END$$

DELIMITER ;






