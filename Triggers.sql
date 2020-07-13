USE business;
-- -----------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------
-- ------------------------product----------------------------------------------------

-- -----------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------

drop trigger if exists product_BU;
DELIMITER $$
CREATE trigger product_BU BEFORE UPDATE  on product for each row
BEGIN
	IF NEW.pro_amount IS NOT NULL then
    
		SET NEW.pro_rotationMonth=(OLD.pro_rotationMonth+(OLD.pro_amount+NEW.pro_amount));
    
    END IF; 
     
    IF  NEW.pro_initialAmount IS NOT NULL THEN 
    
		SET NEW.pro_amount=NEW.pro_initialAmount ;

    END IF;

END;
$$
DELIMITER ;
