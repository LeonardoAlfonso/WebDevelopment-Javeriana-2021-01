<template>
  <section class="filters">
    <ul class="filters-tags">
      <li
        v-for="filter in colors"
        :key="filter.color"
        class="toggle"
        :class="{ isSelected: filter.selected }"
        @click="changeFilter(filter)"
      >
        <a>{{ filter.name }}</a>
      </li>
    </ul>
    <input
      id="search"
      type="search"
      placeholder="Buscar..."
      class="search"
      @input="handleSearch"
    />
  </section>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { Color } from "../../types/Color";
import { onBeforeMount, Ref, ref } from "vue";
import dataColors from "../../services/color.json";

export default defineComponent({
  name: "Filters",
  setup(props, context) {
    const colors: Ref<Color[]> = ref([]);

    onBeforeMount(async () => {
      colors.value = await loadColors();
      console.log(colors.value )
    });

    function changeFilter(color: Color) {
      colors.value.forEach((filter) => {
        filter.selected = filter.name === color.name;
      });
      context.emit("color", color.name)
    }

    async function loadColors() : Promise<Color[]>{
      return new Promise<Color[]>((resolve) => {
        resolve(dataColors);
      });
    }

    function handleSearch(event: any) {
      context.emit("update:search", event.target.value)
    }

    return {
      colors,
      changeFilter,
      handleSearch
    };
  },
});
</script>

<style scoped>
.filters {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  max-width: 90rem;
  margin: 2rem auto;
}

.filters-tags {
  display: flex;
  flex-grow: 1;
  margin: 0 auto 0 -0.5rem;
  padding: 0.5rem;
  overflow: auto;
  column-gap: 0.2rem;
  list-style: none;
  mask-image: linear-gradient(to left, transparent 1%, black 13%);
}

.toggle {
  display: inline-block;
  padding: 0.5rem 1rem;
  border: 1px solid rgba(0, 0, 0, 0.1);
  border-radius: 1.2rem;
  cursor: pointer;
  transition: background 0.2s, color 0.2s;
}

.toggle:hover {
  background: rgba(0, 0, 0, 0.1);
}

.search {
  flex-basis: 0;
  flex-grow: 1;
  padding: 0.3rem 0.5rem;
  font-size: 1rem;
  border: 1px solid transparent;
}

.isSelected {
  background: #3e4045;
  color: white;
}
</style>
