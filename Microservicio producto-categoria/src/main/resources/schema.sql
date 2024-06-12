CREATE TABLE IF NOT EXISTS Category (
                                        category_id INT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL
    );
CREATE TABLE IF NOT EXISTS Product (
                                       product_id INT PRIMARY KEY AUTO_INCREMENT,
                                       name VARCHAR(255) NOT NULL,
                                       description TEXT,
                                       cantidad INT NOT NULL,
                                       price DOUBLE NOT NULL,
                                        product_photo VARCHAR(255),
                                       categoryID INT,
                                       FOREIGN KEY (categoryID) REFERENCES Category(categoryId)
    );
