<template>
  <div id="connexion" @submit="validateAndSubmit">
    <h1>Connexion</h1>
    <form>
      <input class="saisie-texte" placeholder="Email" v-model="email" />
      <input
        class="saisie-texte"
        placeholder="Mot de passe"
        v-model="password"
      />

      <a href="">
        <button class="bouton-connexion" type="submit">Se connecter</button>
      </a>
      <p>
        <router-link to="/inscription" class="link-to-inscription"
          >Vous n'avez pas de compte ?</router-link
        >
      </p>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import { API_BASE_URL } from "@/constants.js";
import { useUserStore } from "@/stores/user";
import router from "@/router";

export default {
  name: "ConnexionView",
  data() {
    return {
      email: null,
      password: null,
    };
  },
  methods: {
    validateAndSubmit(event) {
      event.preventDefault();

      let credentials = {
        email: this.email,
        password: this.password,
      };
      this.postLogin(credentials);
    },
    postLogin(credentials) {
      axios
        .post(`${API_BASE_URL}/login`, credentials)
        .then((response) => {
          const token = response.data;
          this.handleSuccessfulLogin(token);
        })
        .catch((error) => {
          console.error(error);
        });
    },
    handleSuccessfulLogin(token) {
      const userStore = useUserStore();
      userStore.setToken(token);
      userStore.updateConnectionState(true);
      router.push("/");
    },
  },
};
</script>

<style scoped>
form {
  display: flex;
  flex-direction: column;
}
.saisie-texte {
  width: 210px;
  height: 60px;
  background: #fafafa;
  border: 1px solid #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 30px;
  font-weight: 500;
  font-size: 12px;
  line-height: 15px;
  text-align: center;
  color: rgba(6, 8, 37, 0.5);
  margin: 15px;
}

.bouton-connexion {
  width: 210px;
  height: 60px;
  background: #060825;
  box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
  border-radius: 30px;
  font-weight: 500;
  font-size: 16px;
  line-height: 20px;
  text-align: center;
  color: #fafafa;
  cursor: pointer;
  margin: 15px;
}

.link-to-inscription {
  font-weight: 400;
  font-size: 14px;
  line-height: 17px;
  text-align: center;
  color: #060825;
  text-decoration: none;
  margin: 15px;
}

#connexion {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 120px;
}
</style>
