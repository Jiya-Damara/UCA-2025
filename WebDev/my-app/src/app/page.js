// import Image from "next/image";
// import {DescriptionComponent} from "./components/Description"
// export default function Home() {
//   return (
//     <div><DescriptionComponent name = "Valid name"/></div>
//   );
// }

import Link from "next/link";

/**
 * Rendering Techniques
 */
//CSR - Client side rendering
//SSR - Server Side Rendering
//SSG - Static site generation
//ISR - Incremental Static Generation
// Hybrid - some parts of all
// Some - can part of single page or application

export default function Home() {
  return (
    <div>
      <h1>Welcome to Next.js</h1>
      <p>This is the home page of our Next.js application.</p>
      {/* <a href="/login">Go to Login</a> */}
      <Link href="/login">Go to Login</Link>
    </div>
  );
}