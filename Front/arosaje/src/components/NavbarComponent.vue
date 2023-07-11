<template>
  <nav>
    <div id="left">
      <RouterLink to="/">A'rosa-je</RouterLink>
    </div>
    <div id="center">
      <RouterLink to="/">Accueil</RouterLink>
      <RouterLink to="/carte">Carte</RouterLink>
      <RouterLink to="/plantes">Plantes</RouterLink>
    </div>
    <div id="right">
      <i class="fa-light fa-bell"></i>
      <RouterLink
        v-if="userStore.isConnected === true && userStore.id !== null"
        :to="{ name: 'profil', params: { id: userStore.id } }"
        ><i class="fa-light fa-user"></i
      ></RouterLink>
      <RouterLink v-else to="/connexion"
        ><i class="fa-light fa-user"></i
      ></RouterLink>
    </div>
  </nav>
</template>

<script>
import { useUserStore } from "@/stores/user";

export default {
  name: "NavBar",
  setup() {
    const userStore = useUserStore();
    return {
      userStore,
    };
  },
};
</script>

<style scoped>
/* styles for larger screens */
@media (min-width: 768px) {
  nav {
    width: 100%;
    text-align: center;
    margin-top: 2rem;
    font-size: 18px;
    display: flex;
    justify-content: space-around;
  }

  #left {
    font-size: 25px;
    width: 10rem;
    display: flex;
    align-items: center;
    font-weight: bold;
  }

  #right {
    width: 10rem;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
  }

  #center {
    display: flex;
    align-items: center;
  }
}

/* styles for smaller screens */
@media (max-width: 767px) {
  nav {
    flex-wrap: wrap;
  }

  #left,
  #right,
  #center {
    width: 100%;
    text-align: center;
    margin-bottom: 1rem;
  }

  #left {
    font-size: 20px;
  }

  #center {
    margin-top: 1rem;
  }
}

nav a.router-link-exact-active {
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  text-decoration: none;
  color: var(--main-color);
}

nav a:first-of-type {
  border: 0;
}
</style>
