import { onMounted, ref, Ref } from "vue";
import { Product } from "@/types/Product";
import { apiProducts } from "@/services/apiProducts";

export function useProducts() {
  const products: Ref<Product[]> = ref([]);

  onMounted(async () => {
    products.value = await apiProducts.getProducts();
  });

  return { products };
}
