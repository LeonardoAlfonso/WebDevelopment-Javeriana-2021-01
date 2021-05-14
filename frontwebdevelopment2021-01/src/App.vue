<template>
  <label>{{ word }}</label>
  <p>{{ counter }}</p>
  <button @click="cambiar()">Cambiar</button>
  <button @click="increment()">Incrementar Contador</button>

  <p>-----------------------------------------------------------</p>

  <div class="wrapper-input">
    <label>Nombre : {{ mayus }} </label>
    <input type="text" v-model="user.name">
    <!-- <label>Edad : {{ user.age }} </label>
    <input type="text" v-model="user.age">
    <label>Documento : {{ user.document }} </label>
    <input type="text" v-model="user.document">
    <label>Tipo Sangre : {{ user.bloodType }} </label>
    <input type="text" v-model="user.bloodType">
    <button @click="showObject()">Mostrar Objeto</button> -->
  </div>
<!--   
  <p>-----------------------------------------------------------</p>

  <ul>
    <li v-for="(product, index) in products" :key="index">
      <p>{{ product.name }}</p>
      <img :src=product.image class="productImage">
    </li>
  </ul>-->

  <p>-----------------------------------------------------------</p>
    <!-- <div v-if="panelEnable" class="blue">

    </div>
    <div v-else class="red"></div>  -->

    <!-- <div :class="{ blue : panelColor}"></div> -->
    <div :class="[panelColor ? 'red' : 'blue' , 'size']"></div> 


</template>

<script>

export default {
  name: 'App',

  data() {
    return {
      word: "Saludo2",
      counter: 0,
      user: {
        name: null,
        age: null,
        document: null,
        bloodType: null,
      },
      products : [
        {
            name: "Apple",
            image: require('./assets/apple.png')
        },
        {
            name: "Orange",
            image: require('./assets/orange.jpg')
        },
        {
            name: "Banana",
            image: require('./assets/banana.jpg')
        },
      ],
      panelEnable: false,
      panelColor: true
    }
  },

  computed: {
    mayus: function() {
      return (this.user.name == null) ? "" : this.user.name.toUpperCase()
    }
  },

  // created() {
  //   alert("Bienvenidos")
  // },

  // mounted() {
  //   alert("Mounted Component")
  // },

  methods : {
    alerta() {
      alert("Di Click")
    },
    cambiar() {
      this.word = "Adios"
    },
    increment() {
      this.counter++
    },
    showObject() {
      console.log(this.user)
    }
  }



}
</script>

<style lang="css">
.wrapper-input {
  display: flex;
  flex-direction: column;
}

.productImage {
  height: 5rem;
}

.size {
    height: 2rem;
  width: 2rem;
  border: 1px solid black;
}

.blue {
  background-color: blue;

}

.red {
  background-color: red;
}
</style>
