import Link from "next/link";

export default function Login() {   
  return (
    <div>
      <h1>Login Page</h1>
      <p>Please enter your credentials to log in.</p>
        {/* <a href="/">Go to Home</a> */}
        <Link href="/">Go to Home</Link>
    </div>
  );
}
