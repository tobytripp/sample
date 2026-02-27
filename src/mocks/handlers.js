import { http, HttpResponse } from "msw";

export const handlers = [
  http.get("http://localhost:8080/api/products", () => {
    return HttpResponse.json({ products: [{id: 1, name: "Product 1"}] });
  })
];
