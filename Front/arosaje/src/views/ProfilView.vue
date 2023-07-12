<template>
  <div class="box">
    <div class="background"></div>

    <div class="profiltitle">
      <h1>Profil</h1>
    </div>

    <div v-if="userStore.isConnected">
      <p>Nom d'utilisateur : {{ userStore.username }}</p>
      <p>Email : {{ userStore.email }}</p>
      <p>Prénom : {{ userStore.firstName }}</p>
      <p>Nom : {{ userStore.lastName }}</p>

      <button class="bouton-deconnexion" @click="logout">Se déconnecter</button>
    </div>
    <div v-else>
      <h4>Veuillez vous connecter pour afficher le profil.</h4>
    </div>
  </div>
</template>

<style scoped>
.box {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.background {
  position: relative;
  max-width: 422px;
  width: 100%;
  height: 422px;
  background: #c5ffdc;
  filter: blur(125px);
  opacity: 0.25;
}

.profiltitle {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin-top: 175px;
}

p {
  font-weight: 400;
  font-size: 16px;
  line-height: 24px;
  color: #515151;
  border-bottom: 1px solid #3d3b36;
  padding-bottom: 15px;
  margin-top: 30px;
}

.bouton-deconnexion {
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
  margin: 30px;
}
</style>

<script>
import { useUserStore } from "@/stores/user";
import router from "@/router";
import { onMounted } from "vue";
import axios from "axios";
import { API_BASE_URL } from "@/constants";

export default {
  setup() {
    const userStore = useUserStore();

    if (userStore.isConnected === false) {
      router.push("/");
    }
    const logout = () => {
      userStore.resetState();
      router.push("/");
    };
    const fetchUserData = () => {
      axios
        .get(`${API_BASE_URL}/users/${userStore.id}`, {
          headers: { Authorization: userStore.token },
        })
        .then((response) => {
          const userData = response.data;
          userStore.username = userData.username;
          userStore.email = userData.email;
          userStore.firstName = userData.firstName;
          userStore.lastName = userData.lastName;
          userStore.registerDate = userData.registerDate;
          userStore.birthDate = userData.birthDate;
        })
        .catch((error) => {
          if (
            error.response &&
            (error.response.status === 401 || error.response.status === 403)
          ) {
            logout();
          } else {
            console.error(error);
          }
        });
    };

    onMounted(fetchUserData);
    return {
      userStore,
      logout,
    };
  },
};
</script>