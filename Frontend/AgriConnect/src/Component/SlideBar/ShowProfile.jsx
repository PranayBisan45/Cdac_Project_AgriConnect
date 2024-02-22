import React, { useState, useEffect, useContext } from "react";

import style from "./ShowProfile.module.css";

const ShowProfile = () => {
  const [consumer, setConsumer] = useState(null);
  const fetchProfile = async () => {
    try {
      let uid = localStorage.getItem("userid");
      console.log(uid);
      let response = await fetch(
        `http://localhost:8080/showProfile?userid=${uid}`
      );

      if (!response.ok) {
        throw new Error("Failed to fetch profile data");
      }
      console.log(response);
      let text = await response.text(); // Get response as text
      const data = text ? JSON.parse(text) : null; // Parse JSON if response is not empty
      setConsumer(data);
      console.log(data);
    } catch (error) {
      console.error("Error fetching profile:", error);
    }
  };
  useEffect(() => {
    fetchProfile();
  }, []);

  return (
    <div className={style.GParentProfile}>
      <div className={style.ParentProfile}>
        {consumer ? (
          <div>
            <h2>Profile</h2>
            <p>User ID: {consumer.userid}</p>
            <p>First Name: {consumer.firstname}</p>
            <p>Last Name: {consumer.lastname}</p>
            <p>Email: {consumer.emailId}</p>
            <p>Address: {consumer.address}</p>
            <p>Pincode: {consumer.pincode}</p>
            <p>State: {consumer.state}</p>
            <p>Gender: {consumer.gender}</p>
            <p>WhatsApp Number: {consumer.whatsApp_Number}</p>
            {/* Add other profile details here */}
          </div>
        ) : (
          <p>Loading profile...</p>
        )}
      </div>
    </div>
  );
};

export default ShowProfile;
