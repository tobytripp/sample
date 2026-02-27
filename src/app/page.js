import styles from "./page.module.css";
import Products from "./products.jsx";

export default async function Page() {
  return (
    <div className={styles.page}>
      <main className={styles.main}>
        <Products />
      </main>
    </div>
  );
}
