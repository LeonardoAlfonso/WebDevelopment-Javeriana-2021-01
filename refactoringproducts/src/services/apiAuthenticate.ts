import { User } from "@/types/User";
import { login_path } from "@/config/urls";

export const apiAuthenticate = {

  authenticate(user: User) {
    const url = process.env.VUE_APP_BASE_URL.concat(login_path)
    const config = {
      method: "POST",
      body: JSON.stringify(user)
    };

    return fetch(url, config)
      .then((response) => {
        if(!response.ok) {
          throw new Error("Ha fallado sus credenciales")
        }
      })
      .catch((error) => {
        throw error
      });
  }
}