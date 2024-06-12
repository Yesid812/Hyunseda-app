-- noinspection SqlNoDataSourceInspectionForFile

-- Insertar datos en la tabla Category
INSERT INTO Category (category_id, name) VALUES
                                            (1, 'Aretes'),
                                            (2, 'Bufandas'),
                                            (3, 'Chales'),
                                            (4, 'Pañoletas'),
                                            (5, 'Ponchos'),
                                            (6, 'Ruanas');

-- Insertar datos en la tabla Product
INSERT INTO Product (name, description, cantidad, price, product_photo, category_id) VALUES
                                                                         ('Aretes margarita azul y blanco', 'Aretes con hilos y cortezas de capullos de seda 100% natural', 1, 35000, 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/IMG_20240222_143637-f43403d8-2023-44fd-9cc6-d366bceb629f.jpg', 1),
                                                                         ('Aretes hilo negro', 'Aretes con hilos y cortezas de capullos de seda 100% natural', 1, 35000, 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/IMG_20240222_143637-f43403d8-2023-44fd-9cc6-d366bceb629f.jpg', 1),
                                                                         ('Aretes rosas blancas', 'Aretes con hilos y cortezas de capullos de seda 100% natural', 1, 35000, 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/IMG_20240221_143739-981e14bd-38ef-4197-8c26-c7258b79cdba.jpg',1),
                                                                         ('Bufanda rosa y marrón', 'Medidas: 174 x 25 cm.', 1, 140000, 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-1-image-1-a79b0892-5fb8-4b1d-aeba-5592a2be7446.jpg' ,2),
                                                                         ('Bufanda hueso', 'Medidas: 174 x 25 cm.', 1, 140000, 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_039_20221206_194939_compressed-6fe52f2b-fc12-4376-a13e-45baea264cc1.jpg', 2),
                                                                         ('Chal azul y beige', '', 1, 220000, 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-13-image-1-2cb03936-a076-4c88-b086-aa3bc2d38c76.jpg', 3),
                                                                         ('Pañoleta dorado y naranja', '', 1, 90000, 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-11-image-1-38430385-f8fa-49b5-971e-1bec2bfdec33.jpg', 4),
                                                                         ('Poncho gris con dorado ABA9', 'Medidas: 130 x 89.', 1, 330000,'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_016_20221206_194939_compressed-853599e3-207c-4eaa-a06a-c65654d13414.jpg', 5),
                                                                         ('Aretes margarita naranja y amarillo', 'Aretes con hilos y cortezas de capullos de seda 100% natural', 1, 35000, 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/IMG_20240225_101247-a03e6696-d870-4004-a9bc-0ecaddee4c21.jpg',1),
                                                                         ('Ruana negro y verde 66E2', 'Medidas: 128 x 128 cm.', 1, 330000, 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_011_20221206_194939_compressed-e02f34d9-6211-4ee4-a74d-f86c2b5b9114.jpg',6);
