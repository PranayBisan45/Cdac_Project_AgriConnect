import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import style from "./Orders.module.css";
const Orders = () => {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchOrders = async () => {
      try {
        const userId = localStorage.getItem("userid");
        const response = await fetch(
          `http://localhost:8080/OrderFront/${userId}`
        );
        if (!response.ok) {
          throw new Error("Failed to fetch orders");
        }
        const data = await response.json();
        setOrders(data);
        setLoading(false);
      } catch (error) {
        console.error("Error fetching orders:", error);
      }
    };

    fetchOrders();
  }, []);

  const cancelOrder = async (orderId) => {
    try {
      const response = await fetch(
        `http://localhost:8080/CancelOrder/${orderId}`,
        {
          method: "GET", // Assuming you're using a GET request to cancel the order
        }
      );
      if (!response) {
        throw new Error("Failed to cancel order");
      }
      // Remove the canceled order from the orders state
      setOrders(orders.filter((order) => order.orderID !== orderId));
    } catch (error) {
      console.error("Error canceling order:", error);
    }
  };

  return (
    <div className={style.ParentOrder}>
      <div className={style.ChildOrder}>
        {loading ? (
          <p>Loading orders...</p>
        ) : (
          <div>
            <h2>All Orders</h2>
            <ul>
              {orders.map((order) => (
                <li
                  style={{ liststyletype: "none", padding: "20px" }}
                  key={order.orderID}
                >
                  <p>Order ID: {order.orderID}</p>
                  <p>Total Price: {order.orderPrice}</p>
                  <p>Ordered On: {order.orderedOn}</p>
                  <div
                    style={{
                      display: "flex",
                      justifyContent: "space-between",
                      marginTop: "20px",
                    }}
                  >
                    <button onClick={() => cancelOrder(order.orderID)}>
                      Cancel Order
                    </button>
                    {/* Link to the '/OrderProducts' route with the order ID as a URL parameter */}
                    <Link to={`/OrderProducts/${order.orderID}`}>
                      View Order Details
                    </Link>
                  </div>
                </li>
              ))}
            </ul>
          </div>
        )}
      </div>
    </div>
  );
};

export default Orders;
