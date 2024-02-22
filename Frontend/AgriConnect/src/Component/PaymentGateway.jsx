import React, { useState } from "react";
import "../CSS/Payment.css";
import payment from "../Images/payment.jpg";
import chip from "../Images/chip.png";
import visa from "../Images/visa.png";
import { NavLink, useNavigate } from "react-router-dom";
 
function PaymentGateway() {
  const [cardNumber, setCardNumber] = useState("");
  const [cardHolder, setCardHolder] = useState("");
  const [expiryMonth, setExpiryMonth] = useState("month");
  const [expiryYear, setExpiryYear] = useState("year");
  const [cvv, setCvv] = useState("");
  const [warnings, setWarnings] = useState({
    cardNumber: "",
    expiry: "",
    cvv: "",
  });
  let navigate = useNavigate();
  const handleCardNumberChange = (e) => {
    setCardNumber(e.target.value);
  };

  const handleCardHolderChange = (e) => {
    setCardHolder(e.target.value);
  };

  const handleExpiryMonthChange = (e) => {
    setExpiryMonth(e.target.value);
  };

  const handleExpiryYearChange = (e) => {
    setExpiryYear(e.target.value);
  };

  const handleCvvChange = (e) => {
    setCvv(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const newWarnings = validateForm();

    if (isFormValid(newWarnings)) {
      // Redirect or perform action
      navigate("/final");
      
    }
    console.log(cardNumber);
    console.log(cardHolder);
    console.log(expiryMonth);
    console.log(expiryYear);
    console.log(cvv);
    setWarnings(newWarnings);
  };

  const validateForm = () => {
    const newWarnings = { ...warnings };

    if (cardNumber.length < 12) {
      newWarnings.cardNumber = "Enter a 12-digit card number.";
    } else {
      newWarnings.cardNumber = "";
    }

    if (
      expiryYear === "2021" ||
      expiryYear === "2022" ||
      expiryYear === "2023"
    ) {
      newWarnings.expiry = "Your card has expired.";
    } else {
      newWarnings.expiry = "";
    }

    if (cvv.length < 3) {
      newWarnings.cvv = "Enter a 3-digit CVV.";
    } else {
      newWarnings.cvv = "";
    }

    return newWarnings;
  };

  const isFormValid = (warnings) => {
    return (
      cardNumber.length >= 12 &&
      expiryYear !== "2021" &&
      expiryYear !== "2022" &&
      expiryYear !== "2023" &&
      cvv.length === 3 &&
      expiryMonth !== "month"
    );
  };

  return (
    <div style={{ width: "100%", margin: "auto", marginTop: "30px" }}>
      <div className="container">
        {/* Card container */}
        <div className="card-container">
          {/* Card front */}
          <div className="front">
            <div className="image">
              <img src={chip} alt="" />
              <img src={visa} alt="" />
            </div>
            <div className="card-number-box">{cardNumber.padEnd(12, "#")}</div>
            <div className="flexbox">
              <div className="box">
                <span>Card Holder Name</span>
                <div className="card-holder-name">
                  {cardHolder || "Full Name"}
                </div>
              </div>
              <div className="box">
                <span>Expires</span>
                <div className="expiration">
                  <span className="exp-month">{expiryMonth}/</span>
                  <span className="exp-year">{expiryYear}</span>
                </div>
              </div>
            </div>
          </div>

          {/* Card back */}
          <div className="back">
            <div className="stripe"></div>
            <div className="box">
              <span>cvv</span>
              <div className="cvv-box">{cvv}</div>
              <img src={visa} alt="" />
            </div>
          </div>
        </div>

        {/* Form */}
        <form onSubmit={handleSubmit}>
          {/* Card number input */}
          <div className="inputBox">
            <span>card number</span>
            <input
              type="text"
              maxLength="12"
              className="card-number-input"
              value={cardNumber}
              onChange={handleCardNumberChange}
            />
            <span id="warning1">{warnings.cardNumber}</span>
          </div>

          {/* Card holder input */}
          <div className="inputBox">
            <span>card holder</span>
            <input
              type="text"
              className="card-holder-input"
              value={cardHolder}
              onChange={handleCardHolderChange}
            />
          </div>

          {/* Expiry and CVV inputs */}
          <div className="flexbox">
            <div class="inputBox">
              <span>expiration mm</span>
              <select
                name=""
                id=""
                class="month-input"
                onChange={handleExpiryMonthChange}
              >
                <option value="month">month</option>
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
              </select>
            </div>
            <div class="inputBox">
              <span>expiration yy</span>
              <select
                name=""
                id=""
                class="year-input"
                onChange={handleExpiryYearChange}
              >
                <option value="year">year</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                <option value="2027">2027</option>
                <option value="2028">2028</option>
                <option value="2029">2029</option>
                <option value="2030">2030</option>
              </select>
              <span id="warning2"></span>
            </div>
            <div className="inputBox">
              <span>cvv</span>
              <input
                type="text"
                maxLength="3"
                className="cvv-input"
                value={cvv}
                onChange={handleCvvChange}
              />
              <span id="warning3">{warnings.cvv}</span>
            </div>
          </div>

          <button className="submit-btn">Submit</button>
        </form>
      </div>
      <div class="img">
        <img src={payment} alt="" />
      </div>
    </div>
  );
}

export default PaymentGateway;
