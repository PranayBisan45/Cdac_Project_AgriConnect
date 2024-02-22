import React, { useEffect, useState, useContext } from "react";
import { useParams } from "react-router";
import style from "../CSS/PlantDetail.module.css"; // Assuming CSS styles are shared
import { Breadcrumb, BreadcrumbItem, BreadcrumbLink } from "@chakra-ui/react";
import { ChevronRightIcon } from "@chakra-ui/icons";
import { Link, useNavigate } from "react-router-dom";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from "react-responsive-carousel";
import { FaStar, FaStarHalfAlt, FaPlus, FaMinus } from "react-icons/fa";
import { ContextApi } from "../Context/AgriConnectContext";

const PotPlantsDetail = () => {
  let { pid } = useParams();
  let [data, setData] = useState({});
  let [quantity, setQuantity] = useState(1);
  let [cartObj, setCartObj] = useState(false);
  let { auth } = useContext(ContextApi);
  let { cart, setCart } = useContext(ContextApi);
  let navigate = useNavigate();
  const handleCart = () => {
    let isPresent = false;
    cart.forEach((ele) => {
      if (ele.ppid === data.ppid) {
        // assuming the identifier is ppid
        isPresent = true;
      }
    });
    if (isPresent) {
      console.log("Product is already present");
      setCartObj(true);
      setTimeout(() => {
        setCartObj(false);
      }, 2000);
    } else {
      let newData = { ...data }; // create a copy of data object
      newData.quantity = quantity; // add quantity property
      setCart([newData, ...cart]); // update cart
      console.log(cart);
    }
  };

  const getSingleData = async () => {
    let res = await fetch(`http://localhost:8080/pot_planters/${pid}`);
    let response = await res.json();
    setData(response);
    console.log(response);
  };

  useEffect(() => {
    getSingleData();
  }, []);

  const handleIncrement = () => {
    setQuantity(quantity + 1);
  };

  const handleDecrement = () => {
    setQuantity(quantity - 1);
  };
  const handleBuyItNow = () => {
    console.log("cliclked");
    if (auth) {
      navigate("/paymentgateway");
    } else {
      navigate("/login");
    }
  };

  return (
    <div id={style.ProductDetailParent}>
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
            to="/potplants"
            fontWeight="500"
            fontSize="23px"
            color="rgb(116,193,20)"
            textDecoration={"none"}
          >
            PotPlants
          </BreadcrumbLink>
        </BreadcrumbItem>

        <BreadcrumbItem>
          <BreadcrumbLink
            as={Link}
            to={`/potplantsdetails/${pid}`} // corrected interpolation
            fontWeight="500"
            fontSize="23px"
            color="grey"
            textDecoration={"none"}
            isCurrentPage
          >
            PotPlantsDetail
          </BreadcrumbLink>
        </BreadcrumbItem>
      </Breadcrumb>

      <div className={style.ProductDetailChild}>
        <div className={style.LeftSection}>
          <Carousel className={style.Carousel}>
            {data.ppimages &&
              data.ppimages.length > 0 &&
              JSON.parse(data.ppimages).map((image, index) => (
                <div key={index}>
                  {Object.values(image).map((src, i) => (
                    <img key={i} src={src} alt={`Product ${index + 1}`} />
                  ))}
                </div>
              ))}
          </Carousel>
        </div>

        <div className={style.RightSection}>
          <h2>{data.pptitle}</h2>
          <div className={style.Sale}>
            <p>sale</p>
            <h2 className={style.Saleh2}>
              Rs. {data.ppprice && JSON.parse(data.ppprice)[0].MP}
            </h2>
            <h2 style={{ color: "rgb(77,169,71)" }}>
              Rs. {data.ppprice && JSON.parse(data.ppprice)[0].SP}
            </h2>
          </div>
          <div className={style.Rating}>
            <FaStar color="rgb(246,195,71)" />
            <FaStar color="rgb(246,195,71)" />
            <FaStar color="rgb(246,195,71)" />
            <FaStar color="rgb(246,195,71)" />
            <FaStarHalfAlt color="rgb(246,195,71)" />
            <p>{data.pp_RATING}</p>
          </div>
          <p>{data.ppdescription}</p>

          <div className={style.QuantityCart}>
            <div className={style.Quantity}>
              <p>Quantity</p>
              <div>
                <button disabled={quantity === 1} onClick={handleDecrement}>
                  <FaMinus />
                </button>
                <button>{quantity}</button>
                <button onClick={handleIncrement}>
                  <FaPlus />
                </button>
              </div>
            </div>

            <div className={style.Cart}>
              <button onClick={handleCart}>Add to Cart</button>
            </div>
          </div>
          {cartObj && (
            <div style={{ color: "red" }}>Item already available in cart</div>
          )}

          <button onClick={handleBuyItNow} className={style.BuyNow}>
            <h2>Buy It Now</h2>
          </button>

          <div className={style.PlantInformation}>
            <div className={style.Infocontainer}>
              <img
                src="https://img.icons8.com/444444/emoji/2x/house-emoji.png"
                alt="error"
              />
              <p>Indoor Plants</p>
            </div>
            <div className={style.Infocontainer}>
              <img
                src="https://img.icons8.com/444444/cute-clipart/2x/water.png"
                alt="error"
              />
              <p>Needs Minimal Watering</p>
            </div>

            <div className={style.Infocontainer}>
              <img
                src="https://img.icons8.com/444444/office/2x/soil.png"
                alt="error"
              />
              <p>Moist Soil</p>
            </div>
            <div className={style.Infocontainer}>
              <img
                src="https://img.icons8.com/444444/color/3x/smiling-face-with-heart.png"
                alt="error"
              />
              <p>Low Maintenance</p>
            </div>

            <div className={style.Infocontainer}>
              <img
                src="https://img.icons8.com/444444/plasticine/2x/soil.png"
                alt="error"
              />
              <p>Well Drained Soil</p>
            </div>
            <div className={style.Infocontainer}>
              <img
                src="https://img.icons8.com/444444/color/3x/air-element.png"
                alt="error"
              />
              <p>Air Purifying</p>
            </div>

            <div className={style.Infocontainer}>
              <img
                src="https://img.icons8.com/444444/color/3x/no-animals.png"
                alt="error"
              />
              <p>Do not eat me!</p>
            </div>

            <div className={style.Infocontainer}>
              <img
                src="https://img.icons8.com/444444/color/3x/grass.png"
                alt="error"
              />
              <p>Ornamental Plant</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PotPlantsDetail;
