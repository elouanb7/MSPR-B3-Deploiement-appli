import { defineStore } from "pinia";

export const useUserStore = defineStore("user", {
  state: () => ({
    isConnected: false,
    id: null,
    username: null,
    email: null,
    firstName: null,
    lastName: null,
    birthDate: null,
    registerDate: null,
    type: "guest",
  }),
  getters: {
    getConnectionState() {
      return this.isConnected;
    },
  },
  actions: {
    updateConnectionState(state) {
      this.isConnected = state;
    },
    refreshConnectionState() {
      //TODO : Check if the token is still valid
      if (this.isConnected == null) {
        this.isConnected = false;
      } else if (this.isConnected === true) {
        this.fetchUserData();
      }
    },
    fetchUserData() {},
  },
  persist: false,
});
