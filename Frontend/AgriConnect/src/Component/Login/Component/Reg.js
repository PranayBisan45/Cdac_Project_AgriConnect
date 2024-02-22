import axios from 'axios'; // Import Axios

export const myFunction = async (userId, mobileNumber) => {
  try {
    const response = await axios.post("https://api.ultramsg.com/instance78387/messages/chat", {
      token: "o0i02ea0mew4qrch",
      to: mobileNumber,
      body: `User ID: ${userId}`
    });
    
    console.log(response.data); // Log the response data
  } catch (error) {
    console.error('Error:', error);
  }
};