<template>
  <section class="products">
    <h2 class="products-title">Productos Disponibles</h2>
<!--    @color="alertColor"-->
    <Filters  v-model:search="search"></Filters>
    <div class="products-collection">
      <ProductCard
        v-for="product in products"
        :key="product.name"
        :product="product"
      />
    </div>
  </section>
</template>

<script lang="ts">
import { defineComponent, Ref, ref, onMounted  } from "vue";
import Filters from "../components/Products/Filters.vue";
import ProductCard from "../components/Products/ProductCard.vue";
import dataProducts from "../services/products.json";
import { Product } from "@/types/Product";

export default defineComponent({
  name: "Products",
  components: {
    Filters,
    ProductCard,
  },
  setup() {
    const products : Ref<Product[]> = ref([]);
    const search: Ref<string> = ref("")


    onMounted(async () => {
      products.value = await getProducts();
    })

    async function getProducts() : Promise<Product[]>{
      return new Promise((resolve) => {
        resolve(dataProducts);
      });
    }




    return { products, search }
  },
//
//
//
//   data() {
//     return {
//       products: [],
//       productSearch: "",
//       filter: "Todos",
//     };
//   },
//   async created() {
//     this.products = await this.getProducts();
//   },
//   methods: {
//     applyFilter(event : string) {
//       this.filter = event;
//     },
//     searcher(event) {
//       this.productSearch = event;
//     },
//   }
//     getProducts() {
//       return new Promise((resolve) => {
//         resolve(dataProducts);
//       });
//     },
//   },
//   computed: {
//     filteredProducts() {
//       let filterProducts = this.products;
//
//       if (this.productSearch !== null || this.productSearch !== "") {
//         filterProducts = filterProducts.filter((product) => {
//           return product.name
//             .toLowerCase()
//             .includes(this.productSearch.toLowerCase());
//         });
//       }
//
//       if (this.filter !== "Todos") {
//         filterProducts = filterProducts.filter((product) => {
//           return product.colors.some((color) => color.name === this.filter);
//         });
//       }
//       return filterProducts;
//     },
//   },
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
