<template>
  <div>
    <h1>Profil</h1>
    <div v-if="userStore.isConnected">
      <p>Nom d'utilisateur : {{ userStore.username }}</p>
      <p>Email : {{ userStore.email }}</p>
      <p>Prénom : {{ userStore.firstName }}</p>
      <p>Nom : {{ userStore.lastName }}</p>
      <button @click="logout">Se déconnecter</button>
    </div>
    <div v-else>
      <p>Veuillez vous connecter pour afficher le profil.</p>
    </div>
  </div>
</template>

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
