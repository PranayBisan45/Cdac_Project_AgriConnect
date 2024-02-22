import React, { useEffect, useState, useContext } from "react";
import style from "../CSS/Plants.module.css";
import {
  Breadcrumb,
  BreadcrumbItem,
  BreadcrumbLink,
  flexbox,
} from "@chakra-ui/react";
import { ChevronRightIcon } from "@chakra-ui/icons";
import { Link, NavLink } from "react-router-dom";
import { GoListUnordered } from "react-icons/go";
import { MdOutlineGridView } from "react-icons/md";
import { ContextApi } from "../Context/AgriConnectContext";
import Pagination from "../Component/Pagination";
import PriceRangeSlider from "./PriceRangeSlider";
import FilterImage from "../Images/FilterImage.png";
const MIN = 0;
const MAX = 2000;
const PlantsFood = () => {
  let { cart, setCart } = useContext(ContextApi);
  let [data, setData] = useState([]);
  let [page, setPage] = useState(1);
  let [warning, setWarning] = useState(false);
  const [minPrice, setMinPrice] = useState(MIN);
  const [maxPrice, setMaxPrice] = useState(MAX);

  const handleRangeChange = async (newRange) => {
    const [newMinPrice, newMaxPrice] = newRange;
    setMinPrice(newMinPrice);
    setMaxPrice(newMaxPrice);

    try {
      const response = await fetch(
        `http://localhost:8080/PlantFood/load/by_price?offset=0&limit=12&from=${newMinPrice}&to=${newMaxPrice}`
      );
      if (!response.ok) {
        throw new Error("Failed to fetch data");
      }
      const data = await response.json();
      setData(data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const handleClick = (element) => {
    const productAlreadyInCart = cart.find((item) => item.pid === element.pfid);

    if (productAlreadyInCart) {
      setWarning(true);
      setTimeout(() => {
        setWarning(false);
      }, 2000);
    } else {
      // If the product is not in the cart, proceed to add it
      const images = JSON.parse(element.pfimages);
      const price = JSON.parse(element.pfprice);
      const productToAdd = {
        pid: element.pfid,
        ptitle: element.pftitle,
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

  const getAllData = async (pageno) => {
    let res = await fetch(
      `http://localhost:8080/PlantFood/load?offset=${pageno}&limit=12`
    );
    let response = await res.json();
    setData(response);
    console.log(response);
  };

  const handleChangeStock = async (e) => {
    let url = "http://localhost:8080/PlantFood";
    if (e.target.checked) {
      console.log("checked");
      if (e.target.value === "instock") {
        console.log(e.target.value);
        url = url + `/Availability?offset=1&limit=12`;
      } else if (e.target.value === "outstock") {
        console.log(e.target.value);
        url = url + `/StockNotAvailability?offset=1&limit=12`;
      }
      let res = await fetch(url);
      let response = await res.json();
      setData(response);
      console.log(response);
    } else {
      console.log("⛔️ Checkbox is NOT checked", e.target.value);
    }
  };

  const handleChangeRating = async (e) => {
    let url = "http://localhost:8080/PlantFood/load";
    if (e.target.checked) {
      console.log("checked");
      if (e.target.value === "4.4") {
        console.log(e.target.value);
        url = url + `/by_rating?&rating=${4.4}&offset=1&limit=12`;
      } else if (e.target.value === "4.5") {
        console.log(e.target.value);
        url = url + `/by_rating?&rating=${4.5}&offset=1&limit=12`;
      } else if (e.target.value === "4.6") {
        console.log(e.target.value);
        url = url + `/by_rating?&rating=${4.6}&offset=1&limit=12`;
      } else if (e.target.value === "4.7") {
        console.log(e.target.value);
        url = url + `/by_rating?&rating=${4.7}&offset=1&limit=12`;
      }
      let res = await fetch(url);
      let response = await res.json();
      setData(response);
      console.log(response);
    } else {
      console.log("⛔️ Checkbox is NOT checked", e.target.value);
    }
  };
  const handleSortChange = async (event) => {
    let url = "http://localhost:8080/PlantFood";
    //console.log("change");
    console.log(event.target.value);
    let SortValue = event.target.value;
    if (SortValue === "Alphabetically, A-Z") {
      url = url + `/A-Z?offset=1&limit=12`;
      console.log(url);
    } else if (SortValue === "Alphabetically, Z-A") {
      url = url + `/Z-A?offset=1&limit=12`;
      console.log(url);
    } else if (SortValue === "Price, Low-High") {
      url = url + `/Low_to_High?offset=1&limit=12`;
      console.log(url);
    } else if (SortValue === "Price, High-Low") {
      url = url + `/High_to_Low?offset=1&limit=12`;
      console.log(url);
    } else if (SortValue === "Featured") {
      url = url + `/load?offset=1&limit=12`;
      console.log(url);
    }

    let res = await fetch(url);
    let response = await res.json();
    setData(response);
    console.log(response);
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
    handleSortChange();
    handleChangeStock();
    handleChangeRating();
  }, [page]);
  return (
    <div id={style.PlantParent}>
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
            to="/plantfood"
            fontWeight="500"
            fontSize="23px"
            color="grey"
            textDecoration={"none"}
            isCurrentPage
          >
            PlantsFood
          </BreadcrumbLink>
        </BreadcrumbItem>
      </Breadcrumb>
      <h1 className={style.PlantsHeading}>Plants</h1>
      <section id={style.childContainerPlants}>
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
        <div className={style.rightChildSection}>
          {warning && (
            <div style={{ color: "red" }}>Item already available in cart</div>
          )}
          <div className={style.SortView}>
            <div>
              <label>Sort By</label>
              <select onChange={handleSortChange}>
                <option>Featured</option>
                <option>Alphabetically, A-Z</option>
                <option>Alphabetically, Z-A</option>
                <option>Price, Low-High</option>
                <option>Price, High-Low</option>
              </select>
            </div>
            <div style={{ display: "flex", flexDirection: "row", gap: "15px" }}>
              <p>View as</p>
              <button>
                <GoListUnordered size={25} />
              </button>
              <button>
                <MdOutlineGridView size={25} />
              </button>
            </div>
          </div>
          <div>
            {data.length === 0 ? (
              <h1
                style={{
                  color: "red",
                  textAlign: "center",
                  marginTop: "150px",
                  fontSize: "40px",
                  fontFamily: "700",
                }}
              >
                No Plants available
              </h1>
            ) : (
              <div className={style.PlantContainer}>
                {data.map((ele, ind) => {
                  const images = JSON.parse(ele.pfimages);
                  const Price = JSON.parse(ele.pfprice);
                  return (
                    <div className={style.PlantCard} key={ind}>
                      <img src={images[0].IMG1} alt="error" />
                      <h5>Rs. {Price[0].MP}</h5>
                      <h3>Rs. {Price[0].SP}</h3>
                      <p>{ele.pftitle}</p>
                      <div className={style.ButtonBox}>
                        <NavLink to={`/plantsfooddetails/${ele.pfid}`}>
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

            {data.length >= 12 ? (
              <Pagination
                page={page}
                HandleDecrement={HandleDecrement}
                HandleIncrement={HandleIncrement}
              />
            ) : null}
          </div>
        </div>
      </section>
    </div>
  );
};

export default PlantsFood;
