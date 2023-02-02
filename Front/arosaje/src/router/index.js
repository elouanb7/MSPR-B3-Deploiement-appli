import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "accueil",
      component: () => import("../views/HomeView.vue"),
    },
    {
      path: "/carte",
      name: "carte",
      component: () => import("../views/CarteView.vue"),
    },
    {
      path: "/plantes",
      name: "plantes",
      component: () => import("../views/PlantesView.vue"),
    },
    {
      path: '/ask-list',
      name: 'asklist',
      component: () => import("../views/AskListView.vue"),
    },
    {
      path: '/ask',
      name: 'ask',
      component: () => import("../views/AskView.vue"),
    },
    {
      path: "/inscription",
      name: "inscription",
      component: () => import("../views/InscriptionView.vue"),
    },
    {
      path: "/plante/:id/detail",
      name: "plante",
      component: () => import("../views/DetailPlanteView.vue"),
    },
  ],
});

export default router;
