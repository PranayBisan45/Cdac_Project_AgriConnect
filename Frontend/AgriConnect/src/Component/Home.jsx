import React, { useState, useEffect, useContext } from "react";
import Slideshow from "./Slideshow";
import style from "../CSS/Home.module.css";
import f2 from "../Images/Feature/f2.png";
import f6 from "../Images/Feature/f6.png";
import { NavLink, useNavigate } from "react-router-dom";
import { FaCartPlus } from "react-icons/fa";
import { ContextApi } from "../Context/AgriConnectContext";

const Home = () => {
  let [data, setData] = useState([]);
  let [warning, setWarning] = useState(false);
  let { cart, setCart } = useContext(ContextApi);

  const handleClick = (element) => {
    // Check if the product is already in the cart
    const productAlreadyInCart = cart.find((item) => item.pid === element.pid);

    if (productAlreadyInCart) {
      setWarning(true);
      setTimeout(() => {
        setWarning(false);
      }, 2000);
    } else {
      // If the product is not in the cart, proceed to add it
      const images = JSON.parse(element.pimages);
      const price = JSON.parse(element.pprice);
      const productToAdd = {
        pid: element.pid,
        ptitle: element.ptitle,
        pimage: images[0].IMG1,
        pprice: price[0].SP,
        qty: 1,
      };
      addProductToCart(productToAdd);
      setWarning(false); // Reset warning state
    }
  };

  const addProductToCart = async (product) => {
    try {
      const queryString = `?pid=${product.pid}&ptitle=${product.ptitle}&pprice=${product.pprice}&pimage=${product.pimage}&qty=${product.qty}`;
      const response = await fetch(
        `http://localhost:8080/Add_TO_Cart${queryString}`
      );

      if (response.ok) {
        console.log("Product added to cart successfully");
        setCart([...cart, product]);
      } else {
        console.error("Failed to add product to cart");
      }
    } catch (error) {
      console.error("Error adding product to cart:", error);
    }
  };

  const getAllData = async () => {
    try {
      const res = await fetch(
        "http://localhost:8080/plants/load?offset=6&limit=5"
      );
      if (res.ok) {
        const response = await res.json();
        setData(response);
      } else {
        throw new Error("Failed to fetch data");
      }
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  useEffect(() => {
    getAllData();
  }, []);

  return (
    <div style={{ marginTop: "0px" }}>
      <Slideshow />
      {/* Features Section */}
      <div>
        {" "}
        <h2 className={style.sectionHeading}>What Sets Us Apart !</h2>
        <section id={style.featuresParent}>
          <div className={style.featureBox}>
            <img
              src="https://mybageecha.com/cdn/shop/files/cash_on_delivery_60x.png?v=1614291109"
              alt="https://mybageecha.com/cdn/shop/files/cash_on_delivery_60x.png?v=1614291109"
            />
            <h5>Cash on Delivery</h5>
          </div>
          <div className={style.featureBox}>
            <img src={f2} alt="f2-img" />
            <h5>Online Order</h5>
          </div>
          <div className={style.featureBox}>
            <img
              src="https://kumaunplants.com/cdn/shop/files/high_quality-01.svg?v=1677842047&width=710"
              alt="f3-img"
            />
            <h5>Quality Assurance</h5>
          </div>
          <div className={style.featureBox}>
            <img
              src="https://kumaunplants.com/cdn/shop/files/price_a2651f3a-329f-4182-898d-f61b90581a57.svg?v=1677903733&width=710"
              alt="f4-img"
            />
            <h5>Best Price</h5>
          </div>
          <div className={style.featureBox}>
            <img
              src="https://kumaunplants.com/cdn/shop/files/packed_15bb90be-3837-42f4-9820-5b4d996eb655.svg?v=1677568686&width=710"
              alt="f5-img"
            />
            <h5>Secured Packaging</h5>
          </div>
          <div className={style.featureBox}>
            <img src={f6} alt="f6-img" />
            <h5>24/7 Support</h5>
          </div>
        </section>
        <section id={style.sectionBanner}>
          <div
            style={{ display: "flex", gap: "10px", flexDirection: "column" }}
          >
            <NavLink to="/plantfood">
              {" "}
              <button className={style.PlantFoodPoster}>
                <h1>Plant Food</h1>
                <p>
                  Choose from a wide range of organic, chemical fertilizers and
                  other growing media
                </p>
              </button>
            </NavLink>
            <NavLink to="/plant">
              {" "}
              <button className={style.PlantFoodPoster5}>
                <h1>Plants</h1>
                <p>
                  Synthetic foliage adds a touch of nature to contemporary
                  living spaces.
                </p>
              </button>
            </NavLink>
          </div>
          <div
            style={{
              display: "flex",
              gap: "5px",
              flexDirection: "column",
              position: "relative",
            }}
          >
            <NavLink to="/pebbles">
              <button className={style.PlantFoodPoster2}>
                <h1>Pebbles</h1>
                <p>Choose from a wide collection.Various color and sizes</p>
              </button>
            </NavLink>
            <NavLink to="/potplants">
              {" "}
              <button className={style.PlantFoodPoster3}>
                <h1>Pumps and Sprays</h1>
                <p>Elevate your plants with daily Spray Pumping</p>
              </button>
            </NavLink>
            <NavLink to="/pumpspray">
              {" "}
              <button className={style.PlantFoodPoster4}>
                <h1>Plastic Pots</h1>
                <p>
                  Durable plastic pots ensure lasting support for delicate
                  nursery plants.
                </p>
              </button>
            </NavLink>
          </div>
        </section>
        <section id={style.featureCollection}>
          <h1>Featured collection</h1>
          <div className={style.featureCollectionChild}>
            {data.map((ele, ind) => {
              const images = JSON.parse(ele.pimages);
              const Price = JSON.parse(ele.pprice);
              return (
                <div className={style.PlantCard}>
                  <img src={images[0].IMG1} alt="error" />
                  <h5>Rs. {Price[0].MP}</h5>
                  <h3>Rs. {Price[0].SP}</h3>
                  <p>{ele.ptitle}</p>
                  <div className={style.ButtonBox}>
                    <NavLink to={`/plantsdetails/${ele.pid}`}>
                      <button className={style.QuickShop}>Quick Shop</button>
                    </NavLink>

                    <button
                      className={style.CartButton}
                      onClick={() => handleClick(ele)}
                    >
                      <FaCartPlus />
                    </button>
                  </div>
                </div>
              );
            })}
          </div>
          {warning && (
            <div style={{ color: "red" }}>Item already available in cart</div>
          )}
          <NavLink to="/plant">
            <button className={style.ViewAllButton}>View All</button>
          </NavLink>
        </section>
      </div>
    </div>
  );
};

export default Home;
