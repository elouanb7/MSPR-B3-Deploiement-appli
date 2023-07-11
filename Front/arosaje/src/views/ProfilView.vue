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

export default {
  setup() {
    const userStore = useUserStore();
    const logout = () => {
      userStore.resetState();
      router.push("/");
    };
    return {
      userStore,
      logout,
    };
  },
};
</script>
