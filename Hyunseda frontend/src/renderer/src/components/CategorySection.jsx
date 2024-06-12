import React from 'react';

const CategoryContainer = () => {
  const categories = [
    {
      name: 'Aretes',
      image: 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_001_20230327_113018-bfc1ec6f-629b-4651-a94d-223fd4c8971d.jpg'
    },
    {
      name: 'Bufandas',
      image: 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_027_20221206_194939_compressed-4d424654-5f18-4a9a-a031-32e68f125189.jpg'
    },
    {
      name: 'Chales',
      image: 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_038_20230109_101421_compressed-70e60e81-a59e-4cb1-a4e8-f77557f0807c.jpg'
    },
    {
      name: 'Pañoletas',
      image: 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-11-image-5-e5eb2750-b1cf-41f9-ab47-63fb3af110f1.jpg'
    },
    {
      name: 'Ponchos',
      image: 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_009_20221206_194939_compressed-0beb416b-fbec-4bdc-b34e-6149fa4b9f24.jpg'
    },
    {
      name: 'Ruanas',
      image: 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_004_20221206_194939_compressed-a195494f-2107-4dd2-b8a5-78cebbc95c7d.jpg'
    }
  ];

  return (
    <div className="category-container">
      <div className="background-primary">
        <div className="element-category">
          <div className="swiper-category-container">
            <div className="wrapper-swipper-category-container">
              {categories.map((category, index) => (
                <div className="swiper-item-category-slide" key={index}>
                  <a href="#">
                    <div className="product-category-container">
                      <div className="category-info-container">
                        <img src={category.image} alt={category.name} />
                      </div>
                      <span className="category-element-container">{category.name}</span>
                    </div>
                  </a>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CategoryContainer;
