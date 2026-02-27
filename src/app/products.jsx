"use client"
import { useState, useEffect } from "react";
import Form from "./form.jsx"

export default function Products() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const response = await fetch("http://localhost:8080/api/products");
      const json = await response.json();
      console.log("Products:", json);

      setProducts(json.products);
    }

    fetchData();
  }, [products]);

  const submit = () => { setProducts([]); };

  return (
    <>
      <h1>Products</h1>
      <ul>
        {products.map((product) => {
          return <li key={product.id}>{product.name}</li>
        })}
      </ul>

      <Form onSubmit={submit} />
    </>
  )
}
