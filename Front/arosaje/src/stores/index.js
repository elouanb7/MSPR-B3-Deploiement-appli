import { useUserStore } from "@/stores/user";

export function hydrateStores() {
  const userStore = useUserStore();
  const user = JSON.parse(localStorage.getItem("user"));

  if (user && user.token) {
    userStore.isConnected = user.isConnected;
    userStore.token = user.token;
    userStore.id = user.id;
    userStore.username = user.username;
    userStore.email = user.email;
    userStore.firstName = user.firstName;
    userStore.lastName = user.lastName;
    userStore.birthDate = user.birthDate;
    userStore.registerDate = user.registerDate;
    userStore.type = user.type;
  }
}
