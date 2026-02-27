"use client"
import { useState } from "react";

export default function Form({ onSubmit }) {
  const [name, setName] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();
    const postData = { product: { name: name } };

    const response = await fetch("http://localhost:8080/api/products", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(postData)
    });
    const data = await response.json();

    console.log(data);

    onSubmit();
  }

  return (
    <form role="form" onSubmit={handleSubmit}>
      <label>Name:
        <input type="text" name="name" maxLength="80"
               value={name}
               onChange={(e) => setName(e.target.value)} required
        />
      </label>
      <input type="submit" value="Create Product" />
    </form>
  );
}
