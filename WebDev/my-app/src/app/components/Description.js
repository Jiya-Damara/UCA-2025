"use client"; //directive to ensure client side render
import { useEffect } from "react"

export function DescriptionComponent(props) { 
  //used when we want client side render
  useEffect(() => {
    //side effects
    console.log("Initial Component Mounted");
  }, []);

  return (
    <>
    <h1>React managed code {props.name ?? "Guest User"}</h1>
    <p>Website description</p>
    </>
  )
}