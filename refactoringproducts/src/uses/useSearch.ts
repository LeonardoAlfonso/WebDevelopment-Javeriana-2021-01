import { ref, Ref } from "vue";
import { Product } from "@/types/Product";

export function useSearch() {
  const searchQuery: Ref<string> = ref("");

  function setSearchQuery(search: string) {
    searchQuery.value = search;
  }

  function searchByName(product: Product[]): Product[] {
    if (searchQuery.value) {
      return product.filter((product) => {
        return product.name
          .toLowerCase()
          .includes(searchQuery.value.toLowerCase());
      });
    }

    return product;
  }

  return { setSearchQuery, searchByName };
}
