import React, { useEffect, useState, useContext } from "react";
import style from "../CSS/Plants.module.css";
import { Breadcrumb, BreadcrumbItem, BreadcrumbLink } from "@chakra-ui/react";
import { ChevronRightIcon } from "@chakra-ui/icons";
import { Link, NavLink } from "react-router-dom";
import { GoListUnordered } from "react-icons/go";
import { MdOutlineGridView } from "react-icons/md";
import Pagination from "../Component/Pagination";
import PriceRangeSlider from "./PriceRangeSlider";
import FilterImage from "../Images/FilterImage.png";
import { ContextApi } from "../Context/AgriConnectContext";

const MIN = 0;
const MAX = 2000;

const PumpSpray = () => {
  const { cart, setCart } = useContext(ContextApi);
  const [data, setData] = useState([]);
  const [page, setPage] = useState(1);
  const [warning, setWarning] = useState(false);
  const [minPrice, setMinPrice] = useState(MIN);
  const [maxPrice, setMaxPrice] = useState(MAX);

  const handleRangeChange = async (newRange) => {
    const [newMinPrice, newMaxPrice] = newRange;
    setMinPrice(newMinPrice);
    setMaxPrice(newMaxPrice);

    try {
      const response = await fetch(
        `http://localhost:8080/pump_spray/load/by_price?offset=${page}&limit=12&from=${newMinPrice}&to=${newMaxPrice}`
      );
      if (!response.ok) {
        throw new Error("Failed to fetch data");
      }
      const responseData = await response.json();
      setData(responseData);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const handleClick = (element) => {
    const isPresent = cart.some((ele) => ele.pid === element.pid);
    if (isPresent) {
      setWarning(true);
      setTimeout(() => {
        setWarning(false);
      }, 2000);
    } else {
      setCart([element, ...cart]);
    }
  };

  const handleChangeStock = async (e) => {
    let url = "http://localhost:8080/pump_spray";
    if (e.target.checked) {
      if (e.target.value === "instock") {
        url += `/Availability?offset=${page}&limit=12`;
      } else if (e.target.value === "outstock") {
        url += `/StockNotAvailability?offset=${page}&limit=12`;
      }
      const res = await fetch(url);
      const responseData = await res.json();
      setData(responseData);
    }
  };

  const handleChangeRating = async (e) => {
    let url = "http://localhost:8080/pump_spray/load";
    if (e.target.checked) {
      const ratingValue = parseFloat(e.target.value);
      url += `/by_rating?&rating=${ratingValue}&offset=${page}&limit=12`;
      const res = await fetch(url);
      const responseData = await res.json();
      setData(responseData);
    }
  };

  const handleSortChange = async (event) => {
    let url = "http://localhost:8080/pump_spray";
    const sortValue = event.target.value;
    if (sortValue === "Alphabetically, A-Z") {
      url += `/load/SORTBYTITLE_A-Z?offset=${page}&limit=12`;
    } else if (sortValue === "Alphabetically, Z-A") {
      url += `/load/SORTBYTITLE_Z-A?offset=${page}&limit=12`;
    } else if (sortValue === "Price, Low-High") {
      url += `/SORTBYPRICE_Low_TO_High?offset=${page}&limit=12`;
    } else if (sortValue === "Price, High-Low") {
      url += `/SORTBYPRICE_High_TO_Low?offset=${page}&limit=12`;
    } else if (sortValue === "Featured") {
      url += `?offset=${page}&limit=12`;
    }

    const res = await fetch(url);
    const responseData = await res.json();
    setData(responseData);
  };

  const getAllData = async (pageno) => {
    let res = await fetch(
      `http://localhost:8080/pump_spray/load?offset=${pageno}&limit=12`
    );
    let response = await res.json();
    setData(response);
  };

  const HandleIncrement = () => {
    setPage(page + 1);
  };

  const HandleDecrement = () => {
    setPage(page - 1);
  };

  const handleRemoveFilter = async () => {
    getAllData(page);
  };

  useEffect(() => {
    getAllData(page);
  }, [page]);

  return (
    <div id={style.PlantParent}>
      {/* Breadcrumb and other elements */}
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
            to="/pumpspray"
            fontWeight="500"
            fontSize="23px"
            color="grey"
            textDecoration={"none"}
            isCurrentPage
          >
            Pump&Sprays
          </BreadcrumbLink>
        </BreadcrumbItem>
      </Breadcrumb>
      <h1 className={style.PlantsHeading}>Pump&Spray</h1>
      <section id={style.childContainerPlants}>
        {/* Left Child Section */}
        <div className={style.leftChildSection}>
          <h1 className={style.FiltersHead}>Filters</h1>
          <div className={style.FilterChild}>
            <h4
              style={{
                fontSize: "25px",
                color: "rgb(105,190,99)",
                marginBottom: "10px",
              }}
            >
              Price
            </h4>
            <div style={{ margintop: "20px" }}>
              {" "}
              <PriceRangeSlider
                minPrice={MIN}
                maxPrice={MAX}
                onRangeChange={handleRangeChange}
              />
              <h4
                style={{
                  fontSize: "25px",
                  color: "rgb(105,190,99)",
                  marginBottom: "10px",
                }}
              >
                Stock Availability
              </h4>
              <div style={{ margintop: "20px" }}>
                {" "}
                <div>
                  <div className={style.StockBox}>
                    <input
                      id="instock"
                      type="checkbox"
                      value="instock"
                      onChange={handleChangeStock}
                    />
                    <label for="instock">In Stock</label>
                  </div>
                  <div className={style.StockBox}>
                    <input
                      value="outstock"
                      onChange={handleChangeStock}
                      type="checkbox"
                      id="outstock"
                    />
                    <label for="outstock">Out of Stock</label>
                  </div>
                </div>
              </div>
              <h4
                style={{
                  fontSize: "25px",
                  color: "rgb(105,190,99)",
                  marginBottom: "10px",
                  marginTop: "30px",
                }}
              >
                Rating
              </h4>
              <div className={style.StockBox}>
                <input
                  type="checkbox"
                  id="Above4.4"
                  value="4.4"
                  onChange={handleChangeRating}
                />
                <label for="4.4">Rating 4.4</label>
              </div>
              <div className={style.StockBox}>
                <input
                  type="checkbox"
                  id="Above4.5"
                  value="4.5"
                  onChange={handleChangeRating}
                />
                <label for="4.5">Rating 4.5</label>
              </div>
              <div className={style.StockBox}>
                <input
                  type="checkbox"
                  id="Above4.6"
                  value="4.6"
                  onChange={handleChangeRating}
                />
                <label for="4.6">Rating 4.6</label>
              </div>
              <div className={style.StockBox}>
                <input
                  type="checkbox"
                  id="Above4.7"
                  value="4.7"
                  onChange={handleChangeRating}
                />
                <label for="4.7">Rating 4.7</label>
              </div>
              <button
                style={{
                  marginTop: "20px",
                  marginRight: "20px",
                  cursor: "pointer",
                }}
                className={style.QuickShop}
                onClick={handleRemoveFilter}
              >
                Remove Filter
              </button>
              <div className={style.posterFilter}>
                <img src={FilterImage} alt="error" />
              </div>
            </div>
          </div>
        </div>
        {/* Right Child Section */}
        <div className={style.rightChildSection}>
          {warning && (
            <div style={{ color: "red" }}>Item already available in cart</div>
          )}
          {/* SortView and other elements */}
          <div>
            {data.length === 0 ? (
              <h1 className={style.NoPlants}>No Plants available</h1>
            ) : (
              <div className={style.PlantContainer}>
                {data.map((ele, ind) => {
                  const images = JSON.parse(ele.psimages);
                  const price = JSON.parse(ele.psprice);
                  return (
                    <div className={style.PlantCard} key={ind}>
                      <img src={images[0].IMG1} alt="Plant" />
                      <h5>Rs. {price[0].MP}</h5>
                      <h3>Rs. {price[0].SP}</h3>
                      <p>{ele.pstitle}</p>
                      <div className={style.ButtonBox}>
                        <NavLink to={`/plantsdetails/${ele.psid}`}>
                          <button className={style.QuickShop}>
                            Quick Shop
                          </button>
                        </NavLink>
                        <button
                          onClick={() => handleClick(ele)}
                          className={style.CartButton}
                        >
                          Add To Cart
                        </button>
                      </div>
                    </div>
                  );
                })}
              </div>
            )}

            {data.length >= 12 && (
              <Pagination
                page={page}
                HandleDecrement={HandleDecrement}
                HandleIncrement={HandleIncrement}
              />
            )}
          </div>
        </div>
      </section>
    </div>
  );
};

export default PumpSpray;
