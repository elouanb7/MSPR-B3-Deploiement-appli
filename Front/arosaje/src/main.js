import { createApp } from "vue";
import { createPinia } from "pinia";
import { hydrateStores } from "@/stores";
import piniaPluginPersistedState from "pinia-plugin-persistedstate";

import App from "./App.vue";
import router from "./router";

import "./assets/main.css";

const app = createApp(App);

const pinia = createPinia();

pinia.use(piniaPluginPersistedState);

app.use(pinia);
app.use(router);
hydrateStores();
// Use your store
app.mount("#app");
