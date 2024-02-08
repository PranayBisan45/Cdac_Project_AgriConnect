import React from "react";
import Slideshow from "./Slideshow";
import style from "../CSS/Home.module.css";
import f1 from "../Images/Feature/f1.png";
import f2 from "../Images/Feature/f2.png";
import f3 from "../Images/Feature/f3.png";
import f4 from "../Images/Feature/f4.png";
import f5 from "../Images/Feature/f5.png";
import f6 from "../Images/Feature/f6.png";

const Home = () => {
  return (
    <div style={{ marginTop: "0px" }}>
      <Slideshow />
      {/* Features Section */}
      <div>
        {" "}
        <h2 className={style.sectionHeading}>What Sets Us Apart !</h2>
        <section id={style.featuresParent}>
          <div className={style.featureBox}>
            <img src={f1} alt="f1-img" />
            <h5>Free Shipping</h5>
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
      </div>
    </div>
  );
};

export default Home;
