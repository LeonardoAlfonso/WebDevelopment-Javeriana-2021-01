<template>
  <article class="card">
    <a href="#">
      <img :src="pathImage(product.image)" alt="" class="card-img">
      <div class="card-info">
        <h3>{{ product.name }}</h3>
        <p class="card-lead">{{ product.description }}</p>
      </div>
    </a>
  </article>
</template>

<script>
export default {
  name: "ProductCard",
  props: {
    product: {
      type: Object
    },
  },
  methods: {
    pathImage(img) {
      return require(`@/assets/${img}`)
    }
  }
}
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