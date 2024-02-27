import React from "react";

const Final = () => {
  return (
    <div
      style={{
        fontFamily: "Arial, sans-serif",
        textAlign: "center",
        marginTop: "70px",
      }}
    >
      <h1 style={{ color: "blue", fontSize: "24px", fontWeight: "bold" }}>
        Thank you for placing your order with Agriconnect eCommerce. Your
        support means the world to us!
      </h1>
      <p
        style={{
          fontSize: "16px",
          lineHeight: "1.5",
          textAlign: "center",
          width: "50%",
          margin: "auto",
          marginTop: "20px",
          textAlign: "justify",
          marginBottom: "50px",
        }}
      >
        We are now processing your order with the utmost care. You will receive
        a confirmation email shortly once your order has been shipped. Should
        you have any questions or concerns regarding your order, feel free to
        reach out to our customer support team at{" "}
        <span style={{ textDecoration: "underline" }}>
          [Customer Support Email/Phone Number]
        </span>
        . We're here to assist you every step of the way. Thank you again for
        choosing Agriconnect eCommerce. We truly appreciate your business and
        look forward to serving you again in the future!
      </p>
    </div>
  );
};

export default Final;
