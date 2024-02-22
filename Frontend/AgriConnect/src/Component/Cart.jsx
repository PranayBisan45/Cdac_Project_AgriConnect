import React, { useContext, useEffect, useState } from "react";
import { ContextApi } from "../Context/AgriConnectContext";
import style from "../CSS/Cart.module.css";
import { Breadcrumb, BreadcrumbItem, BreadcrumbLink } from "@chakra-ui/react";
import { ChevronRightIcon } from "@chakra-ui/icons";
import { Link, useNavigate } from "react-router-dom";
import { FaPlus } from "react-icons/fa";
import { FaMinus } from "react-icons/fa";
import { NavLink } from "react-router-dom";

const Cart = () => {
  const [price, setPrice] = useState(0);
  const [tax, setTax] = useState(0);
  const [productCart, setProductCart] = useState([]);
  const [subTotal, setSubTotal] = useState(0);
  let { auth } = useContext(ContextApi);
  let { setCart } = useContext(ContextApi);
  let navigate = useNavigate();

  const getProductFromCart = async () => {
    try {
      const data = await fetch(`http://localhost:8080/ShowCart`);
      if (data.ok) {
        const cart = await data.json();
        setProductCart(cart);
        calculateSubTotal(cart);
      } else {
        console.error("Failed to fetch product cart");
      }
    } catch (error) {
      console.error("Error fetching product cart:", error);
    }
  };

  const getProductFromCart1 = async () => {
    try {
      const data = await fetch(`http://localhost:8080/ShowCart`);
      if (data.ok) {
        const cart = await data.json();
        const mappedProducts = cart.map((item) => ({
          pid: item.pid,
          ptitle: item.ptitle,
          pprice: item.pprice,
          qty: item.qty,
        }));
        setProductCart(mappedProducts);
        calculateSubTotal(mappedProducts);
      } else {
        console.error("Failed to fetch product cart");
      }
    } catch (error) {
      console.error("Error fetching product cart:", error);
    }
  };

  const handleTotal = () => {
    const total = price + tax + 100;
    setSubTotal(total);
  };

  const calculateSubTotal = (productCart) => {
    let total = 0;
    productCart.forEach((product) => {
      const Price = product.pprice ? JSON.parse(product.pprice) : null;
      if (Price) {
        total += product.qty * Price;
      }
    });
    setPrice(total);
    setTax(total * 0.18);
    const shippingCost = 100;
    const subTotal = total + total * 0.18 + shippingCost;
    setSubTotal(subTotal);
  };
  const handleRemove = async (pid) => {
    try {
      const data = await fetch(`http://localhost:8080/DeleteProduct/${pid}`);
      if (data.ok) {
        await getProductFromCart();
      } else {
        console.error("Failed to remove product from cart");
      }
    } catch (error) {
      console.error("Error removing product:", error);
    }
  };

  const handleQuantity = async (product, change) => {
    const updatedQuantity = product.qty + change;

    if (updatedQuantity < 1) return;

    try {
      const response = await fetch(
        `http://localhost:8080/ChangeQuantity/${product.pid}/${updatedQuantity}`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      if (response.ok) {
        await getProductFromCart();
      } else {
        console.error("Failed to update quantity of product");
      }
    } catch (error) {
      console.error("Error updating quantity:", error);
    }
  };

  const handleCheckout = async () => {
    if (!auth) {
      // If user is not authenticated, navigate to the login page
      navigate("/login");
      return;
    }

    if (!productCart || productCart.length === 0) {
      // If the cart is empty, display an alert
      alert("Your cart is empty");
      return;
    }

    try {
      // Call getProductFromCart1 to update productCart state
      await getProductFromCart1();

      // Prepare data for the query parameters
      const queryParams = new URLSearchParams();
      productCart.forEach((item) => {
        queryParams.append("PID", item.pid);
        queryParams.append("UPrice", item.pprice);
        queryParams.append("UQuantity", item.qty);
      });
      queryParams.append(
        "subtotal",
        productCart
          .reduce(
            (total, item) => total + parseFloat(item.pprice) * item.qty,
            0
          )
          .toFixed(2)
      );
      queryParams.append("uid", localStorage.getItem("userid"));
      queryParams.append("token", generateRandomCode(7));

      // Make GET request with the constructed URL
      const response = await fetch(
        `http://localhost:8080/OrderInsert?${queryParams.toString()}`
      );

      if (response.ok) {
        // If the order insertion was successful, navigate to the payment gateway
        navigate("/paymentgateway");
      } else {
        console.error("Failed to insert order");
        // Handle error, display message to the user, etc.
      }
    } catch (error) {
      console.error("Failed to add items to cart or navigate:", error);
      // Handle error, display message to the user, etc.
    }
  };

  const generateRandomCode = (length) => {
    const characters =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    let result = "";
    for (let i = 0; i < length; i++) {
      result += characters.charAt(
        Math.floor(Math.random() * characters.length)
      );
    }
    return result;
  };

  useEffect(() => {
    getProductFromCart();
  }, []);

  useEffect(() => {
    handleTotal();
    setCart(productCart);
  }, [price, tax]);

  return (
    <div id={style.CartParent}>
      <Breadcrumb
        spacing="2px"
        size={"lg"}
        separator={<ChevronRightIcon color="grey" />}
      >
        <BreadcrumbItem>
          <BreadcrumbLink
            fontWeight="500"
            fontSize="23px"
            color="rgb(116,193,20)"
            textDecoration={"none"}
            as={Link}
            to="/"
          >
            Home
          </BreadcrumbLink>
        </BreadcrumbItem>

        <BreadcrumbItem>
          <BreadcrumbLink
            as={Link}
            to="/plant"
            fontWeight="500"
            fontSize="23px"
            color="grey"
            textDecoration={"none"}
            isCurrentPage
          >
            Cart
          </BreadcrumbLink>
        </BreadcrumbItem>
      </Breadcrumb>

      <h1>Your Shopping Cart</h1>
      <div className={style.CartChild}>
        {productCart.length === 0 ? (
          <h1 style={{ color: " rgb(116,193,20)" }}>
            Cart is Empty please Add Plants
          </h1>
        ) : (
          <div className={style.LeftSection}>
            {productCart.map((ele, ind) => {
              const images = ele.ppimages;
              const Price = ele.pprice ? JSON.parse(ele.pprice) : null;

              return (
                <div className={style.ProductContainer} key={ind}>
                  {images && images.length > 0 && (
                    <img src={images} alt="error" />
                  )}
                  <div className={style.PriceTitle}>
                    <h4>{ele.ptitle}</h4>
                    <h3 style={{ margin: "auto" }}>
                      {" "}
                      Price Rs.<span>{Price}</span>
                    </h3>
                  </div>
                  <div style={{ marginTop: "35px" }}>
                    <h5 style={{ color: "grey" }}>Quantity</h5>
                    <div className={style.Quantity}>
                      <button
                        disabled={ele.qty === 1}
                        onClick={() => {
                          handleQuantity(ele, -1);
                        }}
                      >
                        <FaMinus />
                      </button>
                      <button>{ele.qty}</button>
                      <button
                        onClick={() => {
                          handleQuantity(ele, +1);
                        }}
                      >
                        <FaPlus />
                      </button>
                    </div>
                  </div>
                  <h4>Rs. {ele.qty * Price}</h4>
                  <button
                    onClick={() => {
                      handleRemove(ele.pid);
                    }}
                    className={style.DeleteButton}
                  >
                    Remove
                  </button>
                </div>
              );
            })}
          </div>
        )}
        {productCart.length === 0 ? (
          ""
        ) : (
          <div className={style.RightSection}>
            <h2>Summary</h2>
            <h4>Estimating Shoping and tax</h4>
            <hr />
            <div>
              <div className={style.SummaryChild}>
                <h5>Sub-Total:</h5>
                <h5>Rs. {price}</h5>
              </div>
              <div className={style.SummaryChild}>
                <h5>GST Taxes @ (18%):</h5>
                <h5>Rs. {tax}</h5>
              </div>
              <div className={style.SummaryChild}>
                <h5>Shipping:</h5>
                <h5>Rs. 100</h5>
              </div>
              <hr />
              <div className={style.SummaryChild}>
                <h5>Order Total:</h5>
                <h5>Rs. {subTotal}</h5>
              </div>
              <div className={style.SummaryChild}>
                <h5>Payable Now :</h5>
                <h5>Rs. {subTotal}</h5>
              </div>
              <hr />

              <button className={style.Checkoutbutton} onClick={handleCheckout}>
                Checkout
              </button>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default Cart;
