<template>
  <router-view />
</template>

<script lang="ts">

import { defineComponent, onErrorCaptured } from "vue";

export default defineComponent({
  name: "App",
  setup() {
    onErrorCaptured((err: any, instance, details) => {
      console.log(err)
      console.log(instance)
      console.log(details)
      alert(err.toString())
    });
  }
});

</script>

<style lang="scss">
body {
  background: #eee;
  margin: 0;
  padding: 0;
}

</style>
