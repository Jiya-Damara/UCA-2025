function Layout ({ children }) {
  return (
    <html lang="en">
      <body>
        {children}
      </body>
    </html>
  )
}

export default Layout;

// Next.js compiles this files and creates an html file with this layout

// renders html and then children
// Layout takes in component and renders it inside body