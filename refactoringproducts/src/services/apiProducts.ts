import { Product } from "@/types/Product";
import productsApi from "@/services/products.json";

export const apiProducts = {
  getProducts(): Promise<Product[]> {
    return new Promise((resolve) => {
      resolve(productsApi);
    });
  },
};
