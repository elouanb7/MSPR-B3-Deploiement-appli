import { defineStore } from "pinia";
import jwt_decode from "jwt-decode";

export const useUserStore = defineStore("user", {
  state: () => ({
    isConnected: false,
    token: null,
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
    setToken(token) {
      this.token = token;
      this.decodeToken();
    },
    decodeToken() {
      const userInfos = jwt_decode(this.token);
      this.id = userInfos.userId;
    },
    resetState() {
      this.isConnected = false;
      this.token = null;
      this.id = null;
      this.username = null;
      this.email = null;
      this.firstName = null;
      this.lastName = null;
      this.birthDate = null;
      this.registerDate = null;
      this.type = "guest";
    },
  },
  persist: true,
});
