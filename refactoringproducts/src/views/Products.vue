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
import { Color } from "@/types/Color";
import { useProducts } from "@/uses/useProducts";
import { useSearch } from "@/uses/useSearch";
import { useFilters } from "@/uses/useFilters";

export default defineComponent({
  name: "Products",
  components: {
    Filters,
    ProductCard,
  },
  setup() {
    const { products } = useProducts();
    const { setSearchQuery, searchByName } = useSearch();
    const { setColorSelected, searchByColor, getColorsFilters, modifyFilters } = useFilters();
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
      return searchByColor(searchByName(products.value));
    });

    function setFilterColor(selectedColor: string) {
      setColorSelected(selectedColor);
      colorsFilters.value = modifyFilters(colorsFilters.value)
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
