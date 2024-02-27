import React from "react";
import "./aboutus.css"; // Assuming you have your CSS styles imported here
// import { Pranay } from "../../Images/Pranay.png";
// import { BhaPhoto } from "../../Images/BhaPhoto.jpeg";
// import { IMG_1252 } from "../../Images/IMG_1252.jpg";
// import { Hrishi } from "../../Images/Hrishi.png";
// import { Rishit } from "../../Images/Rishit.jpg";
import AboutUSBG from "../../Images/AboutUSBG.jpeg";

const AboutUs = () => {
  return (
    <div>
      <div className="about-info">
        <div className="para">
          <h1 style={{ textAlign: "center", marginBottom: "15px" }}>
            ABOUT US
          </h1>
          <p style={{ fontSize: "20px" }}>
            Nurturing nature's beauty – that's what drives us at AgriConnect. As
            a leading online nursery marketplace, we are dedicated to connecting
            plant lovers with premium quality greens and garden essentials. With
            over two decades of combined industry expertise, our team brings
            together a passion for horticulture and a commitment to delivering
            outstanding customer experiences.
          </p>
          <br />
          <p style={{ fontSize: "20px" }}>
            At AgriConnect, we believe that everyone deserves access to fresh,
            healthy, and sustainable food. That's why we're committed to
            providing you with the best selection of plants, seeds, and
            gardening essentials, along with expert advice and exceptional
            customer service. Our team of plant enthusiasts is dedicated to
            helping you cultivate your green thumb. We carefully curate our
            collection of plants to ensure that they are healthy, vibrant, and
            easy to care for. Whether you're looking for a vegetable garden for
            your backyard, a herb garden for your kitchen, or a succulent to
            brighten up your desk, we have something for everyone. We also offer
            a wide range of pots, planters, and gardening tools to help you
            create the perfect environment for your plants to thrive.
          </p>
          <br />
          <p style={{ fontSize: "20px" }}>
            Agri-Connect is your one-stop-shop for all your nursery needs. We
            are a team of passionate horticulturists and gardening enthusiasts
            who believe that everyone should have access to high-quality plants
            and gardening supplies. Our mission is to provide our customers with
            a wide selection of plants, tools, and accessories at affordable
            prices, while also offering expert advice and exceptional customer
            service. Whether you're a seasoned gardener or just starting out,
            we're here to help you grow your green thumb and create a beautiful
            outdoor space. Thank you for choosing AgriConnect!
          </p>
          <div
            style={{
              display: "flex",
              justifyContent: "center",
              marginTop: "40px",
            }}
          >
            <img
              style={{ borderRadius: "10px" }}
              width={"52%"}
              src={AboutUSBG}
              alt="error"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default AboutUs;
