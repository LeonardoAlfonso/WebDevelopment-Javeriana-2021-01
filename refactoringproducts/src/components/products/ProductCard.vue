<template>
  <article class="card">
    <a href="#">
      <img :src="actualProduct.image" alt="" class="card-img" />
      <div class="card-info">
        <h3>{{ actualProduct.name }}</h3>
        <p class="card-lead">{{ actualProduct.description }}</p>
      </div>
    </a>
  </article>
</template>

<script lang="ts">
import { defineComponent, Ref, ref, onBeforeMount } from "vue";
import { Product } from "@/types/Product";

export default defineComponent({
  name: "ProductCard",
  props: {
    product: {
      type: Object as () => Product,
      required: true,
    },
  },
  setup(props) {
    const productCard: Ref<Product | null> = ref(null);

    onBeforeMount(() => {
      productCard.value = Object.assign({}, props.product);
      productCard.value.image = require(`@/assets/${productCard.value.image}`);
    });

    return { actualProduct: productCard };
  },
});
</script>

<style scoped>
.card {
  min-height: 10rem;
  background: #fff;
  box-shadow: 0 0.2rem 1rem rgba(0, 0, 0, 0.05);
  cursor: pointer;
  transition: transform 0.3s, box-shadow 0.3s;
}
.card a {
  color: #333;
  text-decoration: none;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  padding: 0.5rem;
  height: 100%;
}
.card:hover,
.card:focus {
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
  transform: translateY(-0.5rem);
}
.card:focus {
  outline: 5px solid black;
}
.card-img {
  width: 50%;
}
.card-info {
  padding: 0 1rem 1rem;
  text-align: justify;
}
</style>
