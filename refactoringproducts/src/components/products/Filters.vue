<template>
  <section class="filters">
    <ul class="filters-tags">
      <li
        v-for="color in colors"
        :key="color.color"
        class="toggle"
        :class="{ isSelected: color.selected }"
        @click="changeFilter(color)"
      >
        <a>{{ color.color }}</a>
      </li>
    </ul>
    <input
      class="search"
      type="search"
      @input="handleSearch"
      placeholder="Buscar..."
    />
  </section>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { Color } from "@/types/Color";

export default defineComponent({
  name: "Filters",
  props: {
    colors: {
      type: Array as () => Color[],
      required: true,
    },
  },
  setup(props, context) {
    function changeFilter(selectedColor: Color) {
      context.emit("color", selectedColor.color);
    }

    function handleSearch(event: any) {
      context.emit("search", event.target.value);
    }

    return { changeFilter, handleSearch };
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
