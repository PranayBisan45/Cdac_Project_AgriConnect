import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import style from "./OrderProduct.module.css";

const OrderProducts = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);

  // Get orderId from URL params
  const { orderId } = useParams();

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/OrderRare/${orderId}`
        );
        if (!response.ok) {
          throw new Error("Failed to fetch products");
        }
        const data = await response.json();
        // Modify the data to include only the first image URL (IMG1) per product
        const modifiedData = data.map((product) => {
          // Check if the product array is not empty and the first object is not empty before accessing its elements
          const productImage =
            product.length > 0 && Object.keys(product[0]).length > 0
              ? product[0].IMG1
              : null;
          return { ...product, productImage };
        });
        setProducts(modifiedData);
        setLoading(false);
      } catch (error) {
        console.error("Error fetching products:", error);
      }
    };

    fetchProducts();
  }, [orderId]);

  // Render nothing if products array is empty
  if (loading || products.length === 0) {
    return <p>Loading products...</p>;
  }

  return (
    <div className={style.ParentOrderProduct}>
      <div className={style.ChildOrderProduct}>
        <h2>Order Products</h2>
        <ul>
          {products.map(
            (product) =>
              // Skip rendering if product quantity is 0 or if description and title are empty
              product.productQuantity !== 0 &&
              product.productDescription &&
              product.productTitle && (
                <li key={product.productID}>
                  {/* Render other product details */}
                  <p>Product Quantity: {product.productQuantity}</p>
                  <p>Product Description: {product.productDescription}</p>
                  <p>Product Title: {product.productTitle}</p>
                  {/* Render the first image URL (IMG1) if it exists */}
                  {product.productImage && (
                    <img src={product.productImage} alt="Product" />
                  )}
                </li>
              )
          )}
        </ul>
      </div>
    </div>
  );
};

export default OrderProducts;
