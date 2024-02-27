import React from "react";
// import "../CSS/shippingpolicy.css";
import "./shippingpolicy.css";

const ShippingPolicy = () => {
  return (
    <div className="shipping-policy">
      <h1 style={{ textAlign: "center", marginBottom: "15px" }}>
        Shipping Policy
      </h1>
      <p>
        At AgriConnect, we are committed to providing you with the best shipping
        options possible. We aim to ensure that you receive your order promptly
        and in perfect condition.
      </p>
      <h2>Processing Time</h2>
      <p>
        Orders are typically processed and shipped within [processing time]
        business days. Please note that processing time may vary depending on
        product availability and order volume.
      </p>
      <h2>Shipping Rates</h2>
      <p>
        Shipping rates are calculated based on the weight of your order and the
        destination address. You can view the shipping cost during checkout
        before completing your purchase.
      </p>
      <h2>Delivery Time</h2>
      <p>
        Delivery time varies depending on the shipping method selected at
        checkout and the destination address. Standard shipping usually takes
        [standard delivery time] business days, while expedited shipping options
        are available for faster delivery.
      </p>
      <h2>International Shipping</h2>
      <p>
        We offer international shipping to select countries. International
        orders may be subject to customs duties, taxes, and other fees imposed
        by the destination country. Please note that these additional charges
        are the responsibility of the recipient.
      </p>
      <h2>Order Tracking</h2>
      <p>
        Once your order has been shipped, you will receive a shipping
        confirmation email containing tracking information. You can track the
        status of your order using the provided tracking number.
      </p>
      <h2>Contact Us</h2>
      <p>
        If you have any questions or concerns about our shipping policy, please
        contact us at agriconnect20@gmail.com.
      </p>
    </div>
  );
};

export default ShippingPolicy;
