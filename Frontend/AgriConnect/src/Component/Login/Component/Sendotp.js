export const myFunction = async (mobileno, userId) => {
    try {
      console.log("Received data from React - Mobile:", mobileno);
      console.log("Received data from React - User ID:", userId);
  
      const response = await fetch(`http://localhost:8080/Forgot_Password?Phone=${mobileno}&UserID=${userId}`);
      if (!response.ok) {
        throw new Error(`Failed to fetch data: ${response.status} ${response.statusText}`);
      }
      
      const otp = await response.text();
      if (otp.trim() !== "Not_A_User") {
        const options = {
          method: "POST",
          headers: { "Content-Type": "application/json" }, // Updated content type
          body: JSON.stringify({
            token: "j2bxufgynnbky3r1",
            to: mobileno, // Ensure the 'to' field is correctly provided
            body: `Hello !!
            You've requested a password reset for your AgriConnect account. Your One-Time Password (OTP) is:${otp} This code is valid for 5 minutes. If you didn't make this request, please ignore this message.
            For security reasons, do not share this OTP with anyone, including AgriConnect support. 
            Thank you,
            AgriConnect Support Team`
          }),
        };
  
        const smsResponse = await fetch("https://api.ultramsg.com/instance78859/messages/chat?token=j2bxufgynnbky3r1", options);
        if (!smsResponse.ok) {
          throw new Error(`Failed to send SMS: ${smsResponse.status} ${smsResponse.statusText}`);
        }
        
        const smsData = await smsResponse.json();
        console.log("SMS response:", smsData);
      } else {
        console.log("OTP is 'Not_a_user'. Skipping sending.");
      }
    } catch (error) {
      console.error("Error in myFunction:", error);
      throw error; // Rethrow the error for the caller to handle
    }
  };