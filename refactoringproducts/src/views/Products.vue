<template>
  <section class="products">
    <h2 class="products-title">Productos Disponibles</h2>
    <Filters @color="setFilterColor" v-model:search="search"></Filters>
    <div class="products-collection">
      <ProductCard
        v-for="product in filteredProducts"
        :key="product.name"
        :product="product"
      ></ProductCard>
    </div>
    <p>{{ search }}</p>
  </section>
  <p>Esta es la vista de productos, en construcción.</p>
</template>

<script lang="ts">
import { defineComponent, Ref, ref, onMounted, computed } from "vue";
import Filters from "@/components/products/Filters.vue";
import ProductCard from "@/components/products/ProductCard.vue";
import { Product } from "@/types/Product";
import productsApi from "@/services/products.json";

export default defineComponent({
  name: "Products",
  components: {
    Filters,
    ProductCard,
  },
  setup() {
    const products: Ref<Product[]> = ref([]);
    const search: Ref<string> = ref("");
    const color: Ref<string> = ref("Todos");

    onMounted(async () => {
      products.value = await getProducts();
    });

    const filteredProducts = computed(() => {
      let finalProducts = products.value
      if (search.value !== "") {
        finalProducts = finalProducts.filter((product) => {
          return product.name.toLowerCase().includes(search.value);
        });
      }

      if (color.value !== "Todos") {
        finalProducts = finalProducts.filter((product) => {
          return product.colors.some(
            (productColor) => productColor.name === color.value
          );
        });
      }

      return finalProducts;
    });

    async function getProducts(): Promise<Product[]> {
      return new Promise((resolve) => {
        resolve(productsApi);
      });
    }

    function setFilterColor(selectedColor: string) {
      color.value = selectedColor;
    }

    return { search, setFilterColor, filteredProducts };
  },
});
</script>

<style scoped>
.products {
  max-width: 90rem;
  margin: 0 auto;
  padding: 4rem 1rem;
}

.products-title {
  font-size: 2rem;
}

.products-collection {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(18rem, 1fr));
  gap: 1.5rem;
}
</style>
