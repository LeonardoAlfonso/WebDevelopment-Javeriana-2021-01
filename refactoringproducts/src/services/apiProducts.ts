import { Product } from "@/types/Product";
import productsApi from "@/services/products.json";
import { products_all } from "@/config/urls";

export const apiProducts = {
  getProducts(): Promise<Product[]> {
    return new Promise((resolve) => {
      resolve(productsApi);
    });
  },

  getProductApi(): Promise<Product[]> {
    const url = process.env.VUE_APP_BASE_URL.concat(products_all);
    const config = {
      method: "GET",
    };
    return fetch(url, config)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Error al cargar los productos");
        }
        return response.json();
      })
      .catch((error) => {
        throw error;
      });
  },
};
