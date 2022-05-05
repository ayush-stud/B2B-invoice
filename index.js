import React from 'react'
import img1 from '../images/abc_product.svg';
import img2 from '../images/hrclogo.svg';


export const Header = () => {
  return(
    <div style={{margin:"0.5rem"}}>
        <img  src={img1} />
        <img  style={{marginLeft:"10rem"}} src={img2}/>
    </div>
   )
 }