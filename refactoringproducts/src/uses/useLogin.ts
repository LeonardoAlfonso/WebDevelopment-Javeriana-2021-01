import { ref, Ref } from "vue";
import { User } from "@/types/User";
import { apiAuthenticate } from "@/services/apiAuthenticate";
import { useRouter } from "vue-router";

export function useLogin() {
  const user: Ref<User> = ref({ email: "", password: "" });
  const router = useRouter()

  async function login() {
    await apiAuthenticate.authenticate(user.value);
    router.push("/products")
  }

  return {
    user,
    login,
  };
}
