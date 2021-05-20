<template>
<section class="filters">
  <ul class="filters-tags">
    <li v-for="filter in filters" :key="filter.color" class="toggle"
        :class="{ 'isSelected' : filter.selected }">
      <a @click="activeFilter(filter)">{{ filter.color }}</a>
    </li>
  </ul>
  <input id="search" type="search" placeholder="Buscar..." class="search" @input="handleSearch">
</section>
</template>

<script>
export default {
  name: "Filters",
  data() {
    return {
      filters: [
        {
          color: "Azul",
          selected: false
        },
        {
          color: "Verde",
          selected: false
        },
        {
          color: "Rojo",
          selected: false
        },
        {
          color: "Amarillo",
          selected: false
        },
        {
          color: "Morado",
          selected: false
        },
        {
          color: "Todos",
          selected: true
        }
      ]
    }
  },
  methods: {
    activeFilter(activeFilter){
      this.filters.forEach(filter => {
        filter.selected = (filter.color === activeFilter.color);
      });
      this.$emit("filter", activeFilter.color)
    },
    handleSearch(event) {
      this.$emit("search", event.target.value)
    },
    isSelected(filter) {
      return filter.selected
    }
  }
}
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