
drop database DBLminiproject;

create database DBLminiproject;
use DBLminiproject;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE `login` (
  `userId` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
 
) ;

INSERT INTO `login` (`userId`, `password`) VALUES ('p01', 'p01'),
('e', 'e');
select * from login;

CREATE TABLE `employee` (
  `userId` varchar(12) NOT NULL,
  `employeeName` varchar(50) NOT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `role` varchar(8) NOT NULL,
  `salary` double(8,2) NOT NULL
) ;

 INSERT INTO `employee` (`userId`, `employeeName`, `phoneNumber`, `role`, `salary`) VALUES
 ('p01', 'Shreya', '+911234567890', 'Manager', 50000.00),
 ('e', 'Pallavi', '+917756777890', 'General', 3000.00);

  select  * from `employee`;

CREATE TABLE `product` (
  `productId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `productName` varchar(50) NOT NULL,
  `price` double(8,2) NOT NULL,
  `quantity` int(8) NOT NULL
) ;

CREATE TABLE `product_deleted` (
  `productId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `productName` varchar(50) NOT NULL,
  `price` double(8,2) NOT NULL,
  `quantity` int(8) NOT NULL
) ;


delimiter //
create trigger after_delete
after delete on `product` for each row
begin 
insert into `product_deleted`  values (old.productId, old.productName, old.price, old.quantity);
end;
//

INSERT INTO `product` (`productId`, `productName`, `price`, `quantity`) VALUES
(00001, 'Sonata M', 466.00, 7),
(00002, 'Titan M',2000.00, 5),
(00003, 'Ajanta Wall clock',555.00, 21),
(00004, 'Titan F', 899.00, 5),
(00005, 'Fastrack', 2500.00, 6);


select * from Product;
select * from  product_deleted;

CREATE TABLE `purchaseinfo` (
  `purchaseId` int(5) UNSIGNED ZEROFILL NOT NULL,
  `userId` varchar(12) NOT NULL,
  `productId` varchar(12) NOT NULL,
  `cost` double(12,2) UNSIGNED NOT NULL,
  `amount` int(8) UNSIGNED NOT NULL,
  `date` varchar(18) NOT NULL
) ;

select * from purchaseinfo;


ALTER TABLE `login`
  ADD UNIQUE KEY `userId` (`userId`),
  ADD UNIQUE KEY `userId_2` (`userId`);

ALTER TABLE `product`
  ADD PRIMARY KEY (`productId`);

ALTER TABLE `purchaseinfo`
  ADD PRIMARY KEY (`purchaseId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `userId_2` (`userId`);

ALTER TABLE `product`
  MODIFY `productId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
ALTER TABLE `purchaseinfo`
  MODIFY `purchaseId` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
ALTER TABLE `purchaseinfo`
  ADD CONSTRAINT `FK_PUR_CUS` FOREIGN KEY (`userId`) REFERENCES `purchaseinfo` (`userId`);
