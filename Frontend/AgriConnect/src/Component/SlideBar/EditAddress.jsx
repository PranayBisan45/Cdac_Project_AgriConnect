import React, { useState, useEffect } from "react";
import style from "../../CSS/Edit.module.css";
const EditAddress = () => {
  const [formData, setFormData] = useState({
    Address: "",
    State: "",
    Pincode: "",
  });
  const [editable, setEditable] = useState(false); // State to manage edit mode
  const [message, setMessage] = useState("");

  useEffect(() => {
    // Fetch user's address data when the component mounts
    const fetchAddress = async () => {
      try {
        let Userid = localStorage.getItem("userid");
        const response = await fetch(
          `http://localhost:8080/viewAddress/${Userid}`
        );
        if (!response.ok) {
          throw new Error("Failed to fetch address");
        }
        const data = await response.json();
        // Populate form data with fetched address data
        setFormData({
          Address: data.address,
          State: data.state,
          Pincode: data.pincode,
        });
      } catch (error) {
        console.error("Error fetching address:", error);
        setMessage("Failed to fetch address");
      }
    };

    fetchAddress();
  }, []); // Run only once when the component mounts

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      let Userid = localStorage.getItem("userid");
      const response = await fetch(
        `http://localhost:8080/editAddress/${Userid}`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: new URLSearchParams(formData).toString(),
        }
      );
      if (!response.ok) {
        throw new Error("Failed to edit address");
      }
      const data = await response.json();
      console.log(data);
      setMessage("Address updated successfully");
      setEditable(false); // Disable editing after submission
    } catch (error) {
      console.error("Error editing address:", error);
      setMessage("Failed to update address");
    }
  };

  return (
    <div className={style.ParentAddress}>
      <div className={style.ChildEdit}>
        <h1 style={{ marginBottom: "10px" }}>Addresss Page</h1>
        <form onSubmit={handleSubmit}>
          <div className={style.FormLabelInput}>
            <label>Address:</label>
            <input
              type="text"
              name="Address"
              value={formData.Address}
              onChange={handleChange}
              readOnly={!editable} // Disable editing if not in edit mode
            />
          </div>

          <div className={style.FormLabelInput}>
            <label>State:</label>
            <input
              type="text"
              name="Pincode"
              value={formData.Pincode}
              onChange={handleChange}
              readOnly={!editable} // Disable editing if not in edit mode
            />
          </div>

          <div className={style.FormLabelInput}>
            <label>Pincode:</label>
            <input
              type="text"
              name="State"
              pattern="^\d{6}$"
              value={formData.State}
              onChange={handleChange}
              readOnly={!editable} // Disable editing if not in edit mode
            />
          </div>

          {editable && <button type="submit">Submit</button>}
        </form>
        <div>
          <button className={style.button} onClick={() => setEditable(true)}>
            Edit
          </button>
        </div>
        {message && <div>{message}</div>}
      </div>
    </div>
  );
};

export default EditAddress;
