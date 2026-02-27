import { expect, test } from "vitest";
import { render, screen, waitFor } from "@testing-library/react";

import Products from "../app/products.jsx";

test("Products renders a heading", () => {
  render(<Products />);

  const heading = screen.getByRole("heading", { level: 1 });

  expect(heading).toBeDefined();
});

test("Products renders a list of fetched products", async () => {
  render(<Products />);

  await waitFor(() => {
    const li = screen.getByText(/Product 1/i);
    expect(li).toBeDefined();
  });
});

test("Products renders a form for new products", () => {
  render(<Products />);

  const form = screen.getByRole("form");

  expect(form).toBeDefined();
});
