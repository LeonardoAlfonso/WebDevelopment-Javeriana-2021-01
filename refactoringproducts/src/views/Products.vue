<template>
  <section class="products">
    <h2 class="products-title">Productos Disponibles</h2>
    <Filters
      @color="setFilterColor"
      @search="setSearchQuery"
      :colors="colorsFilters"
    ></Filters>
    <div class="products-collection">
      <ProductCard
        v-for="product in filteredProducts"
        :key="product.name"
        :product="product"
      ></ProductCard>
    </div>
  </section>
  <p>Esta es la vista de productos, en construcción.</p>
</template>

<script lang="ts">
import { defineComponent, Ref, ref, computed } from "vue";
import Filters from "@/components/products/Filters.vue";
import ProductCard from "@/components/products/ProductCard.vue";
import { Product } from "@/types/Product";
import { Color } from "@/types/Color";
import { ProductColor } from "@/types/ProductColor";
import { useProducts } from "@/uses/useProducts";
import { useSearch } from "@/uses/useSearch";

export default defineComponent({
  name: "Products",
  components: {
    Filters,
    ProductCard,
  },
  setup() {
    const { products } = useProducts();
    const { setSearchQuery, searchByName } = useSearch();

    const color: Ref<string> = ref("Todos");
    const colors: Ref<Color[]> = ref([]);

    let colorsFilters = computed({
      get() {
        return colors.value.length === 0
          ? getColorsFilters(products.value)
          : colors.value;
      },
      set(newValue: Color[]) {
        colors.value = newValue;
      },
    });

    const filteredProducts = computed(() => {
      let finalProducts = searchByName(products.value);

      if (color.value !== "Todos") {
        finalProducts = finalProducts.filter((product) => {
          return product.colors.some(
            (productColor) => productColor.name === color.value
          );
        });
      }

      return finalProducts;
    });

    function getColorsFilters(products: Product[]): Color[] {
      let initialProductColors: ProductColor[] = [];
      let colors: Color[] = products
        .flatMap((product) => product.colors)
        .reduce((unique, productColor) => {
          if (!unique.some((item) => item.name === productColor.name)) {
            unique.push(productColor);
          }
          return unique;
        }, initialProductColors)
        .map((productColor) => {
          return {
            color: productColor.name,
            selected: false,
          };
        });

      colors.push({ color: "Todos", selected: true });
      return colors;
    }

    function setFilterColor(selectedColor: string) {
      color.value = selectedColor;
      colors.value = colorsFilters.value;
      colors.value.forEach((color) => {
        color.selected = color.color === selectedColor;
      });
      colorsFilters.value = colors.value;
    }

    return { setSearchQuery, setFilterColor, filteredProducts, colorsFilters };
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
