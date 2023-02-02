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
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/CarteView.vue"),
    },
    {
      path: "/plantes",
      name: "plantes",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/PlantesView.vue"),
    },
    {
      path: '/ask-list',
      name: 'asklist',
      component: () => import("../views/AskListView.vue"),
    },
    {
      path: "/inscription",
      name: "inscription",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/InscriptionView.vue"),
    },
  ],
});

export default router;
