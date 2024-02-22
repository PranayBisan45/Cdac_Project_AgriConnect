import React from "react";
import "./aboutus.css"; // Assuming you have your CSS styles imported here
// import { Pranay } from "../../Images/Pranay.png";
// import { BhaPhoto } from "../../Images/BhaPhoto.jpeg";
// import { IMG_1252 } from "../../Images/IMG_1252.jpg";
// import { Hrishi } from "../../Images/Hrishi.png";
// import { Rishit } from "../../Images/Rishit.jpg";

const AboutUs = () => {
  return (
    <div>
      <div className="about-info">
        <div className="para">
          <p>
            Nurturing nature's beauty – that's what drives us at AgriConnect. As
            a leading online nursery marketplace, we are dedicated to connecting
            plant lovers with premium quality greens and garden essentials. With
            over two decades of combined industry expertise, our team brings
            together a passion for horticulture and a commitment to delivering
            outstanding customer experiences.
          </p>
          <br />
          <p>
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
        </div>
      </div>

      <section className="team">
        <h1>Meet Our Team</h1>
        <div className="team-cards">
          {/* Cards here */}
          {/* Card 1 */}
          <div className="card">
            <div className="card-img">
              <img src="/Images/Rishit.jpg" alt="User 1" />
            </div>
            <div className="card-info">
              <h2 className="card-name">Rishit Ambalia</h2>
              <p className="card-role">Web Developer</p>
              <p className="card-email">rishitb00@gmail.com</p>
            </div>
          </div>

          {/* Card 2 */}
          <div className="card">
            <div className="card-img">
              <img
                src="Cdac_Project_AgriConnect\Frontend\AgriConnect\src\Images\IMG_1252.jpg"
                alt="User 2"
              />
            </div>
            <div className="card-info">
              <h2 className="card-name">Ankit Gadhwe</h2>
              <p className="card-role">Web Developer</p>
              <p className="card-email">ankitgadhwe3830@gmail.com</p>
            </div>
          </div>

          {/* Card 3 */}
          <div className="card">
            <div className="card-img">
              <img
                src="Cdac_Project_AgriConnect\Frontend\AgriConnect\src\Images\Hrishi.PNG"
                alt="User 3"
              />
            </div>
            <div className="card-info">
              <h2 className="card-name">Hrishi Nikam</h2>
              <p className="card-role">Web Developer</p>
              <p className="card-email">hrishi.ns25@gmail.com</p>
            </div>
          </div>

          {/* Card 4 */}
          <div className="card">
            <div className="card-img">
              <img
                src="Cdac_Project_AgriConnect\Frontend\AgriConnect\src\Images\Pranay.png"
                alt="User 2"
              />
            </div>
            <div className="card-info">
              <h2 className="card-name">Pranay Bisan</h2>
              <p className="card-role">Web Developer</p>
              <p className="card-email">pranaybisan45@gmail.com</p>
            </div>
          </div>

          {/* Card 5 */}
          <div className="card">
            <div className="card-img">
              <img src="" alt="User 5" />
            </div>
            <div className="card-info">
              <h2 className="card-name">Bhagyashri S</h2>
              <p className="card-role">Web Developer</p>
              <p className="card-email">
                bhagyashri.suryawanshi6342
                <br />
                @gmail.com
              </p>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default AboutUs;
