<template>
  <article class="login-form">
    <form action="" @submit.prevent class="form">
      <div class="login-fields">
        <label for="email">Email</label>
        <input type="text" name="email" id="email" v-model="user.email" />
      </div>
      <div class="login-fields">
        <label for="password">Password</label>
        <input
          type="password"
          name="password"
          id="password"
          v-model="user.password"
        />
      </div>
      <input
        type="button"
        value="Login"
        :disabled="submitEnabled"
        class="login-button"
        :class="[submitEnabled ? 'disabled' : 'enabled']"
        @click="login"
      />
    </form>
  </article>
</template>

<script>
import { useLogin } from "@/uses/useLogin";
import { computed, defineComponent } from "vue";

export default defineComponent({
  name: "Login",
  setup() {
    const { user, login } = useLogin();

    const submitEnabled = computed(() => {
      let emailValidate = user.value.email !== null && user.value.email !== "";
      let passwordValidate =
        user.value.password !== null && user.value.password !== "";
      return !(emailValidate && passwordValidate);
    });

    return { user, login, submitEnabled };
  },
});
</script>

<style lang="scss" scoped>
.login-form {
  height: 100vh;
  overflow-y: hidden;
  display: flex;
  justify-content: center;
  align-items: center;

  .form {
    background: cornflowerblue;
    width: 40%;
    text-align: center;
    border-radius: 0.5rem;
    padding: 0.5rem;

    .login-fields {
      margin: 0.5rem 0;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      align-items: center;

      label {
        font-size: 1.5rem;
      }

      input {
        width: 80%;
        margin-top: 0.2rem;
        font-size: 1.2rem;
        outline: none;
        border: none;
        border-radius: 0.2rem;
        padding: 0.3rem;
      }
    }
  }
}

.login-button {
  border: none;
  font-size: 1.2rem;
  margin-top: 2rem;
  padding: 0.5rem 2rem;
  border-radius: 0.5rem;
  background: lightslategrey;
  color: white;

  &.enabled {
    cursor: pointer;
    &:hover {
      background: #091f52;
    }
  }

  &.disabled {
    cursor: auto;
  }
}
</style>
