import React from "react";
import style from "../CSS/Footer.module.css";
import { NavLink } from "react-router-dom";
import agriLogo from "../Images/agriLogo.png";
import AgriLogoC from "../Images/AgriLogoC.jpg";
import b from "../Images/b.jpeg";
import { Stack, HStack, Spacer, Image, Text } from "@chakra-ui/react";
const Footer = () => {
  return (
    <footer id={style.parentContainer}>
      <section className={style.sectionOne}>
        <img className={style.image} src={b} alt="webLogo" />
        <p style={{ color: "rgb(105, 99, 99)", textAlign: "justify" }}>
          {" "}
          The love of gardening is a seed once sown that never dies, but never
          grows to the enduring happiness that the love of gardening gives.
        </p>
      </section>

      <section className={style.sectionTwo}>
        <h1
          style={{
            marginBottom: "15px",
            fontSize: "25px",
            color: "rgb(35,87,47)",
          }}
        >
          Product Collection
        </h1>
        <NavLink className={style.NavLink} to="/plant">
          Plants
        </NavLink>
        <NavLink className={style.NavLink} to="/potplants">
          PotPlants
        </NavLink>

        <NavLink className={style.NavLink} to="/plantfood">
          PlantsFood
        </NavLink>

        <NavLink className={style.NavLink} to="/pumpspray">
          Pump&Sprays
        </NavLink>
      </section>

      <section className={style.sectionThree}>
        <h1
          style={{
            marginBottom: "15px",
            fontSize: "25px",
            color: "rgb(35,87,47)",
          }}
        >
          Our Policies
        </h1>
        <NavLink className={style.NavLink} to="/pp">
          PrivacyPolicy
        </NavLink>
        <NavLink className={style.NavLink} to="/rp">
          RefundPolicy
        </NavLink>
        <NavLink className={style.NavLink} to="/tp">
          Terms of Service
        </NavLink>
        <NavLink className={style.NavLink} to="/sp">
          ShippingPolicy
        </NavLink>
      </section>

      <section className={style.sectionFour}>
        <h1
          style={{
            marginBottom: "25px",
            fontSize: "25px",
            color: "rgb(35,87,47)",
          }}
        >
          Contact Us
        </h1>
        <p>
          Manikchand Galleria GRHM+P9C, Swastik Society, Model Colony,
          Wadarvadi, Pune, Maharashtra 411016
        </p>
        &nbsp; &nbsp;
        <p>Call Us: 9175077267</p>
        &nbsp;
        <p>Email: agriconnect20@gmail.com</p>
      </section>

      <section className={style.sectionFive}>
        <h1
          style={{
            marginBottom: "45px",
            fontSize: "25px",
            color: "rgb(35,87,47)",
          }}
        >
          Follow Us
        </h1>
        <Stack marginBottom={"150px"} marginLeft={"70px"}>
          <HStack width={"50%"}>
            <a
              href="https://www.instagram.com/agriconnect20?igsh=MTRrc2JweGFlNmJ0bg=="
              target="_blank"
            >
              <Image
                boxSize="35px"
                w={"2"}
                src="data:image/png;base64,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"
              ></Image>
            </a>
            <Spacer />
            <a href="https://twitter.com/agriconnect20" target="_blank">
              {" "}
              <Image
                boxSize="35px"
                w={"2"}
                src="data:image/jpeg;base64,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"
              ></Image>
            </a>
            <Spacer />

            <a href="https://wa.me/917507767" target="_blank">
              <Image
                cursor={"pointer"}
                boxSize="35px"
                w={"2"}
                src="https://store-images.s-microsoft.com/image/apps.8453.13655054093851568.4a371b72-2ce8-4bdb-9d83-be49894d3fa0.7f3687b9-847d-4f86-bb5c-c73259e2b38e?h=464"
              ></Image>
            </a>
          </HStack>
          <Spacer />
        </Stack>
        <Text
          as={"strong"}
          fontSize={"14"}
          fontWeight={700}
          lineHeight={"21px"}
          mb={"15"}
          color={"black"}
        >
          AgriConnect © 2024. All Rights Reserved
        </Text>
      </section>
    </footer>
  );
};

export default Footer;
