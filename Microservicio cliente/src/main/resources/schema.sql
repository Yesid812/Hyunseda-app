DROP TABLE  IF EXISTS Client;
CREATE TABLE IF NOT EXISTS Client (
                                      client_id INT AUTO_INCREMENT PRIMARY KEY,
                                      first_name VARCHAR2(255) ,
                                      last_name VARCHAR2(255)
    );
